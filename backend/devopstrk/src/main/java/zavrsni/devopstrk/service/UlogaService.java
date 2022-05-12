package zavrsni.devopstrk.service;

import zavrsni.devopstrk.model.Korisnik;
import zavrsni.devopstrk.model.Uloga;

import java.util.List;
import java.util.Optional;

public interface UlogaService {
    List<Uloga> listAll();

    Optional<Uloga> findById(Long idUloge);
}
