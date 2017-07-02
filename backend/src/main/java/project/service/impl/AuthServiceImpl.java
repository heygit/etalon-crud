package project.service.impl;

import com.lambdaworks.crypto.SCryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.CardDao;
import project.entity.Card;
import project.service.AuthService;
import project.service.model.CardStatus;
import project.service.model.CheckPinStatus;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class AuthServiceImpl implements AuthService {

    private final CardDao cardDao;

    @Value("${local.salt}")
    private String localSalt;
    @Value("${scrypt.cpu.cost}")
    private int scryptСpuСost;
    @Value("${scrypt.memory.cost}")
    private int scryptMemoryСost;
    @Value("${scrypt.parallelization}")
    private int scryptParallelization;
    @Value("${wrong.pass.times}")
    private int wrongPassTimes;

    @Autowired
    public AuthServiceImpl(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    @Override
    public CardStatus checkCard(String cardNumber) {
        checkIfNull(cardNumber);
        Card card = cardDao.findOne(cardNumber);
        if (card == null) {
            return CardStatus.NOT_FOUND;
        } else if (card.isLocked()) {
            return CardStatus.LOCKED;
        } else {
            return CardStatus.OK;
        }
    }

    @Override
    @Transactional
    public CheckPinStatus checkPin(String cardNumber, String pin) {
        checkIfNull(cardNumber);
        checkIfNull(pin);
        Card card = cardDao.findOneForUpdate(cardNumber);
        int failTimes = card.getFailTimes();
        if (card.isLocked() || failTimes >= wrongPassTimes) {
            return CheckPinStatus.CARD_LOCKED;
        }
        if (getHash(pin, card.getSalt(), localSalt).equals(card.getHashedPin())) {
            return CheckPinStatus.OK;
        }
        failTimes++;
        card.setFailTimes(failTimes);
        if (failTimes < wrongPassTimes) {
            cardDao.save(card);
            return CheckPinStatus.WRONG_PIN;
        }
        card.setLocked(true);
        cardDao.save(card);
        return CheckPinStatus.CARD_LOCKED;
    }

    private void checkIfNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Return hash(hash(hash(input)+salt)+localSalt)
     *
     * @param input
     * @param salt
     * @param localSalt
     * @return
     */
    private String getHash(String input, String salt, String localSalt) {
        return getHash(getHash(getHash(input) + salt) + localSalt);
    }

    private String getHash(String input) {
        return SCryptUtil.scrypt(input, scryptСpuСost, scryptMemoryСost, scryptParallelization);
    }

    private String makeSalt() {
        final Random random = new SecureRandom();
        byte[] salt = new byte[32];
        random.nextBytes(salt);
        return new String(salt);
    }
}
