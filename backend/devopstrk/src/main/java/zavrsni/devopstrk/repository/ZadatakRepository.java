package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zavrsni.devopstrk.model.Zadatak;

public interface ZadatakRepository extends JpaRepository<Zadatak, Long> {

}
