package zavrsni.devopstrk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zavrsni.devopstrk.model.Stanje;
import zavrsni.devopstrk.repository.StanjeRepository;
import zavrsni.devopstrk.service.StanjeService;

import java.util.List;
import java.util.Optional;

@Service
public class StanjeServiceJpa implements StanjeService {

    @Autowired
    private StanjeRepository stanjeRepository;


    @Override
    public List<Stanje> listAll() {
        return stanjeRepository.findAll();
    }

    @Override
    public Optional<Stanje> findById(Long idStanja) {
        return stanjeRepository.findById(idStanja);
    }
}
