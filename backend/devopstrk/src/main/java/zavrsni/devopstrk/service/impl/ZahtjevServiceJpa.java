package zavrsni.devopstrk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zavrsni.devopstrk.model.Zahtjev;
import zavrsni.devopstrk.repository.ZahtjevRepository;
import zavrsni.devopstrk.service.ZahtjevService;

import java.util.List;

@Service
public class ZahtjevServiceJpa implements ZahtjevService {

    @Autowired
    private ZahtjevRepository zahtjevRepository;

    @Override
    public List<Zahtjev> listAll() {
        return zahtjevRepository.findAll();
    }

    @Override
    public Zahtjev createZahtjev(Zahtjev zahtjev) {
        return zahtjevRepository.save(zahtjev);
    }

    @Override
    public List<Zahtjev> findChangeHistory(String idZahtjeva) {
        return zahtjevRepository.findByIdZahtjeva_IdZahtjeva(idZahtjeva);
    }
}
