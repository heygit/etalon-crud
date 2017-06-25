package project.dao.stub;

import org.springframework.stereotype.Service;
import project.dao.OperationDao;
import project.dao.stub.util.IdGenerator;
import project.entity.Operation;

import java.math.BigInteger;

@Service
public class OperationDaoStub extends CustomDaoStub<Operation, BigInteger> implements OperationDao {

    @Override
    protected <S extends Operation> BigInteger getId(S entity) {
        if (entity.getId() != null) {
            return entity.getId();
        }
        BigInteger id = IdGenerator.BIG_INTEGER.generateId();
        entity.setId(id);
        return id;
    }
}
