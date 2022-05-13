package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zavrsni.devopstrk.model.Prioritet;

import java.util.Optional;

public interface PrioritetRepository extends JpaRepository<Prioritet, Long> {

    Optional<Prioritet> findByIdPrioriteta(Long idPrioriteta);
}
