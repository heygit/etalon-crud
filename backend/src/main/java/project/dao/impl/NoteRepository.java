package project.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.dao.NoteDao;
import project.entity.Note;

import java.math.BigInteger;

@Repository
public interface NoteRepository extends JpaRepository<Note, BigInteger>, NoteDao {
}
