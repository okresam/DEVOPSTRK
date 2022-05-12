package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zavrsni.devopstrk.model.Uloga;

import java.util.Optional;

public interface UlogaRepository extends JpaRepository<Uloga, Long> {

    Optional<Uloga> findByIdUloge(Long idUloge);
}
