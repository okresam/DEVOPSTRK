package zavrsni.devopstrk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zavrsni.devopstrk.model.SudjelujeNa;
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
}
