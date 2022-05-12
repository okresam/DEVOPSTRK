package zavrsni.devopstrk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import zavrsni.devopstrk.model.Korisnik;
import zavrsni.devopstrk.repository.KorisnikRepository;
import zavrsni.devopstrk.service.KorisnikService;

import java.util.List;
import java.util.Optional;

@Service
public class KorisnikServiceJpa implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepo;

    @Override
    public List<Korisnik> listAll() {
        return korisnikRepo.findAll();
    }

    @Override
    public Korisnik createKorisnik(Korisnik korisnik) {
        Assert.notNull(korisnik, "Mora se predati korisnik!");
        Assert.isNull(korisnik.getIdKorisnika(), "Id korisnika mora biti null!");
        return korisnikRepo.save(korisnik);
    }

    @Override
    public Optional<Korisnik> fetch(String email) {
        return korisnikRepo.findByEmail(email);
    }
}
