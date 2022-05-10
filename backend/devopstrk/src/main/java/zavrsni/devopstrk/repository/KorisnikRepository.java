package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zavrsni.devopstrk.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

}
