package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zavrsni.devopstrk.model.Projekt;

public interface ProjektRepository extends JpaRepository<Projekt, Long> {

}
