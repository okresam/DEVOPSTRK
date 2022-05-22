package zavrsni.devopstrk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zavrsni.devopstrk.model.Zahtjev;
import zavrsni.devopstrk.repository.ZadatakRepository;
import zavrsni.devopstrk.repository.ZahtjevRepository;
import zavrsni.devopstrk.service.ZahtjevService;

import java.util.List;

@Service
public class ZahtjevServiceJpa implements ZahtjevService {

    @Autowired
    private ZahtjevRepository zahtjevRepository;

    @Autowired
    private ZadatakRepository zadatakRepository;

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

    @Override
    public void deleteByIdZahtjeva(String idZahtjeva) {
        zahtjevRepository.deleteZahtjevByIdZahtjeva_IdZahtjeva(idZahtjeva);
        zadatakRepository.deleteZadatakByIdZahtjeva(idZahtjeva);
    }
}
