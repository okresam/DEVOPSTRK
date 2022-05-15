package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import zavrsni.devopstrk.model.Projekt;

@Transactional
public interface ProjektRepository extends JpaRepository<Projekt, Long> {
    void deleteProjektByIdProjekta(Long idProjekta);
}
