package zavrsni.devopstrk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zavrsni.devopstrk.model.SudjelujeNa;
import zavrsni.devopstrk.model.Uloga;
import zavrsni.devopstrk.repository.SudjelujeNaRepository;
import zavrsni.devopstrk.service.SudjelujeNaService;

import java.util.List;

@Service
public class SudjelujeNaServiceJpa implements SudjelujeNaService {

    @Autowired
    private SudjelujeNaRepository sudjelujeNaRepository;

    @Override
    public List<SudjelujeNa> listAll() {
        return sudjelujeNaRepository.findAll();
    }

    @Override
    public SudjelujeNa createSudjelujeNa(SudjelujeNa sudjelujeNa) {
        return sudjelujeNaRepository.save(sudjelujeNa);
    }

    @Override
    public List<SudjelujeNa> findByIdKorisnika(Long idKorisnika) {
        return sudjelujeNaRepository.findById_IdKorisnika(idKorisnika);
    }

    @Override
    public List<SudjelujeNa> findByIdProjekta(Long idProjekta) {
        return sudjelujeNaRepository.findById_IdProjekta(idProjekta);
    }

    @Override
    public Uloga findUloga(Long idKorisnika, Long idProjekta) {
        return sudjelujeNaRepository.findById_IdKorisnikaAndId_IdProjekta(idKorisnika, idProjekta).getUloga();
    }


}
