package project.utils;

import com.lambdaworks.crypto.SCryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import project.dao.CardDao;
import project.entity.Card;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.Random;

@Service
public class Helper {

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
    private CardDao cardDao;

//    @PostConstruct
    private void init() {
        Card card = new Card();
        card.setBalance(new BigDecimal("1000000"));
        card.setNumber("1111111111111111");
        card.setSalt(makeSalt());
        card.setHashedPin(getHash("1111", card.getSalt(), localSalt));

        cardDao.save(card);
    }

    private String getHash(String input) {
        return SCryptUtil.scrypt(input, scryptСpuСost, scryptMemoryСost, scryptParallelization);
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

    private String makeSalt() {
        final Random random = new Random();
        byte[] salt = new byte[32];
        random.nextBytes(salt);
        String result = Base64.getEncoder().encodeToString(salt);
        return result;
    }
}
