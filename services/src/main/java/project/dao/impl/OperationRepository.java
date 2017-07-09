package project.dao.impl;


import org.springframework.stereotype.Repository;
import project.dao.OperationDao;
import project.entity.Operation;

import java.math.BigInteger;

@Repository
public interface OperationRepository extends CustomRepository<Operation, BigInteger>, OperationDao {
}
