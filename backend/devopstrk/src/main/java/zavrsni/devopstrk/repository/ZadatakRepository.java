package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zavrsni.devopstrk.model.Zadatak;

import java.util.List;

public interface ZadatakRepository extends JpaRepository<Zadatak, Long> {

    List<Zadatak> findByIdZahtjeva(String idZahtjeva);

    List<Zadatak> findByProjekt_IdProjekta(Long idProjekta);
}
