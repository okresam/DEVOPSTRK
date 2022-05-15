package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zavrsni.devopstrk.model.Projekt;
import zavrsni.devopstrk.model.SudjelujeNa;
import zavrsni.devopstrk.model.util.SudjelujeNaKljuc;

import java.util.List;

public interface SudjelujeNaRepository extends JpaRepository<SudjelujeNa, SudjelujeNaKljuc> {

    List<SudjelujeNa> findById_IdKorisnika(Long idKorisnika);
}
