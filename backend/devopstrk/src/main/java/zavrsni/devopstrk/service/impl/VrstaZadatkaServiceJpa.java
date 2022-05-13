package zavrsni.devopstrk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zavrsni.devopstrk.model.VrstaZadatka;
import zavrsni.devopstrk.repository.VrstaZadatkaRepository;
import zavrsni.devopstrk.service.VrstaZadatkaService;

import java.util.List;
import java.util.Optional;

@Service
public class VrstaZadatkaServiceJpa implements VrstaZadatkaService {

    @Autowired
    private VrstaZadatkaRepository vrstaZadatkaRepository;

    @Override
    public List<VrstaZadatka> listAll() {
        return vrstaZadatkaRepository.findAll();
    }

    @Override
    public Optional<VrstaZadatka> findById(Long idVrsteZadatka) {
        return vrstaZadatkaRepository.findById(idVrsteZadatka);
    }
}
