package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zavrsni.devopstrk.model.VrstaZadatka;

import java.util.Optional;

public interface VrstaZadatkaRepository extends JpaRepository<VrstaZadatka, Long> {

    Optional<VrstaZadatka> findByIdVrsteZadatka(Long idVrsteZadatka);
}
