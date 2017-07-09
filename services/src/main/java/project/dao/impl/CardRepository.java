package project.dao.impl;

import org.springframework.stereotype.Repository;
import project.dao.CardDao;
import project.entity.Card;

@Repository
public interface CardRepository extends CustomRepository<Card, String>, CardDao {
}
