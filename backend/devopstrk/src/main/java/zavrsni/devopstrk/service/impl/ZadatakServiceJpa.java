package zavrsni.devopstrk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zavrsni.devopstrk.model.Zadatak;
import zavrsni.devopstrk.repository.ZadatakRepository;
import zavrsni.devopstrk.service.ZadatakService;

import java.util.List;

@Service
public class ZadatakServiceJpa implements ZadatakService {

    @Autowired
    private ZadatakRepository zadatakRepository;

    @Override
    public List<Zadatak> listAll() {
        return zadatakRepository.findAll();
    }

    @Override
    public Zadatak createZadatak(Zadatak zadatak) {
        return zadatakRepository.save(zadatak);
    }

    @Override
    public List<Zadatak> zahtjevZadaci(String idZahtjeva) {
        return zadatakRepository.findByIdZahtjeva(idZahtjeva);
    }

    @Override
    public List<Zadatak> projektZadaci(Long idProjekta) {
        return zadatakRepository.findByProjekt_IdProjekta(idProjekta);
    }

    @Override
    public List<Zadatak> projektZadaciTrazi(Long idProjekta, String trazi) {
        return zadatakRepository.findProjektZadaciTrazi(idProjekta, trazi);
    }

    @Override
    public void deleteZadatak(Long idZadatka) {
        zadatakRepository.deleteZadatakByIdZadatka(idZadatka);
    }

    @Override
    public Zadatak fetch(Long idZadatka) {
        return zadatakRepository.findByIdZadatka(idZadatka);
    }

    @Override
    public void updateZadatak(Zadatak zadatak) {
        zadatakRepository.save(zadatak);
    }

    @Override
    public int getBrojZavrsenih(String idZahtjeva) {
        return zadatakRepository.findBrojZavrsenih(idZahtjeva);
    }

    @Override
    public int getBrojNezavrsenih(String idZahtjeva) {
        return zadatakRepository.findBrojNezavrsenih(idZahtjeva);
    }
}
