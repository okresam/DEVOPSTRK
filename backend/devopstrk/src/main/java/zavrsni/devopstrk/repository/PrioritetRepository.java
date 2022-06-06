package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import zavrsni.devopstrk.model.Prioritet;

import java.util.Optional;

@Transactional
public interface PrioritetRepository extends JpaRepository<Prioritet, Long> {

    Optional<Prioritet> findByIdPrioriteta(Long idPrioriteta);

    void deleteByIdPrioriteta(Long idPrioriteta);
}
