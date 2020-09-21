package my.rodo.repository;

import my.rodo.model.ProgramZasob;
import my.rodo.model.Zbior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramZasobRepo extends JpaRepository<ProgramZasob,Long> {
}
