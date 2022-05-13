package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zavrsni.devopstrk.model.VrstaZahtjeva;

import java.util.Optional;

public interface VrstaZahtjevaRepository extends JpaRepository<VrstaZahtjeva, Long> {

    Optional<VrstaZahtjeva> findByIdVrsteZahtjeva(Long idVrsteZahtjeva);
}
