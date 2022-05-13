package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zavrsni.devopstrk.model.Stanje;

import java.util.Optional;

public interface StanjeRepository extends JpaRepository<Stanje, Long> {

    Optional<Stanje> findByIdStanja(Long idStanja);
}
