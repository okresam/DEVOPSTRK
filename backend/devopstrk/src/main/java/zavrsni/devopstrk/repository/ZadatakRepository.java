package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import zavrsni.devopstrk.model.Zadatak;

import java.util.List;

@Transactional
public interface ZadatakRepository extends JpaRepository<Zadatak, Long> {

    List<Zadatak> findByIdZahtjeva(String idZahtjeva);

    List<Zadatak> findByProjekt_IdProjekta(Long idProjekta);

    void deleteZadatakByIdZahtjeva(String idZahtjeva);
}
