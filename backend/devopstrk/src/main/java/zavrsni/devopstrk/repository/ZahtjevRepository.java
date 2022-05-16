package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zavrsni.devopstrk.model.Zahtjev;
import zavrsni.devopstrk.model.util.ZahtjevKljuc;

public interface ZahtjevRepository extends JpaRepository<Zahtjev, ZahtjevKljuc> {

}
