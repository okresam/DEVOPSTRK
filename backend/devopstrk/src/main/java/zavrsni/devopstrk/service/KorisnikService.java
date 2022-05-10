package zavrsni.devopstrk.service;

import zavrsni.devopstrk.model.Korisnik;

import java.util.List;

public interface KorisnikService {
    List<Korisnik> listAll();

    Korisnik createKorisnik(Korisnik korisnik);
}
