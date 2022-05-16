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
}
