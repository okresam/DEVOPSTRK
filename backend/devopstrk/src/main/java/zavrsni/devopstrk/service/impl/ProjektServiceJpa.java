package zavrsni.devopstrk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zavrsni.devopstrk.model.Projekt;
import zavrsni.devopstrk.repository.ProjektRepository;
import zavrsni.devopstrk.service.KorisnikService;
import zavrsni.devopstrk.service.ProjektService;
import zavrsni.devopstrk.service.StanjeService;

import java.util.List;

@Service
public class ProjektServiceJpa implements ProjektService {

    @Autowired
    private ProjektRepository projektRepository;


    @Override
    public List<Projekt> listAll() {
        return projektRepository.findAll();
    }

    @Override
    public Projekt createProjekt(Projekt projekt) {
        return projektRepository.save(projekt);
    }
}
