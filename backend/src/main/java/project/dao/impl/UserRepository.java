package project.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.dao.UserDao;
import project.entity.Note;
import project.entity.User;

import java.math.BigInteger;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger>, UserDao {
}
