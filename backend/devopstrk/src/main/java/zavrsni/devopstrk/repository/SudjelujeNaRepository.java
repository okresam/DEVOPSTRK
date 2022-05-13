package zavrsni.devopstrk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zavrsni.devopstrk.model.SudjelujeNa;
import zavrsni.devopstrk.model.util.SudjelujeNaKljuc;

public interface SudjelujeNaRepository extends JpaRepository<SudjelujeNa, SudjelujeNaKljuc> {

}
