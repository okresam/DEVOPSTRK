package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import zavrsni.devopstrk.model.Uloga;

import java.util.Optional;

@Transactional
public interface UlogaRepository extends JpaRepository<Uloga, Long> {

    Optional<Uloga> findByIdUloge(Long idUloge);

    void deleteByIdUloge(Long idUloge);
}
