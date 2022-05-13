package zavrsni.devopstrk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zavrsni.devopstrk.model.VrstaZahtjeva;
import zavrsni.devopstrk.repository.VrstaZahtjevaRepository;
import zavrsni.devopstrk.service.VrstaZahtjevaService;

import java.util.List;
import java.util.Optional;

@Service
public class VrstaZahtjevaServiceJpa implements VrstaZahtjevaService {

    @Autowired
    private VrstaZahtjevaRepository vrstaZahtjevaRepository;

    @Override
    public List<VrstaZahtjeva> listAll() {
        return vrstaZahtjevaRepository.findAll();
    }

    @Override
    public Optional<VrstaZahtjeva> findById(Long idVrsteZahtjeva) {
        return vrstaZahtjevaRepository.findById(idVrsteZahtjeva);
    }
}
