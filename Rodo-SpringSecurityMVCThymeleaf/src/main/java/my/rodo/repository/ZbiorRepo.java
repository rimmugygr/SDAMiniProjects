package my.rodo.repository;

import my.rodo.model.Document;
import my.rodo.model.Zbior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZbiorRepo extends JpaRepository<Zbior,Long> {
}
