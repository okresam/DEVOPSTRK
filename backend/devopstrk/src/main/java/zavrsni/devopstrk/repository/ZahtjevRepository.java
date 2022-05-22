package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import zavrsni.devopstrk.model.Zahtjev;
import zavrsni.devopstrk.model.util.ZahtjevKljuc;

import java.util.List;

@Transactional
public interface ZahtjevRepository extends JpaRepository<Zahtjev, ZahtjevKljuc> {

    List<Zahtjev> findByIdZahtjeva_IdZahtjeva(String idZahtjeva);

    void deleteZahtjevByIdZahtjeva_IdZahtjeva(String idZahtjeva);
}
