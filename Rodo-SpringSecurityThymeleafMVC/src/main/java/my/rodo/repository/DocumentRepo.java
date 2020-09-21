package my.rodo.repository;

import my.rodo.model.Document;
import my.rodo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepo extends JpaRepository<Document,Long> {
}
