package project.dao.stub;

import org.springframework.stereotype.Service;
import project.dao.CardDao;
import project.entity.Card;

@Service
public class CardDaoStub extends CustomDaoStub<Card, String> implements CardDao {

    @Override
    protected <S extends Card> String getId(S entity) {
        return entity.getNumber();
    }
}
