package zavrsni.devopstrk.service;

import zavrsni.devopstrk.model.SudjelujeNa;

import java.util.List;

public interface SudjelujeNaService {

    List<SudjelujeNa> listAll();

    SudjelujeNa createSudjelujeNa(SudjelujeNa sudjelujeNa);

    List<SudjelujeNa> findByIdKorisnika(Long idKorisnika);

    List<SudjelujeNa> findByIdProjekta(Long idProjekta);
}
