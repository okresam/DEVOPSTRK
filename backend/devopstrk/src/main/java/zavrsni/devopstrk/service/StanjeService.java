package zavrsni.devopstrk.service;

import zavrsni.devopstrk.model.Stanje;

import java.util.List;
import java.util.Optional;

public interface StanjeService {
    List<Stanje> listAll();

    Optional<Stanje> findById(Long idStanja);
}
