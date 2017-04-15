package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entities.Tak;

@Repository
public interface TakRepository extends JpaRepository<Tak, String>, TakDao {
}
