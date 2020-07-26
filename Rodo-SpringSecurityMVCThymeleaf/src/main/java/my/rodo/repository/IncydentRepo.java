package my.rodo.repository;


import my.rodo.model.Incydent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncydentRepo extends JpaRepository<Incydent,Long> {
}
