package zavrsni.devopstrk.service;

import zavrsni.devopstrk.model.SudjelujeNa;
import zavrsni.devopstrk.model.Uloga;

import java.util.List;

public interface SudjelujeNaService {

    List<SudjelujeNa> listAll();

    SudjelujeNa createSudjelujeNa(SudjelujeNa sudjelujeNa);

    List<SudjelujeNa> findByIdKorisnika(Long idKorisnika);

    List<SudjelujeNa> findByIdProjekta(Long idProjekta);

    Uloga findUloga(Long idKorisnika, Long idProjekta);
}
