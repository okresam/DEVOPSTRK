package zavrsni.devopstrk.service;

import zavrsni.devopstrk.model.VrstaZadatka;

import java.util.List;
import java.util.Optional;

public interface VrstaZadatkaService {

    List<VrstaZadatka> listAll();

    Optional<VrstaZadatka> findById(Long idVrsteZadatka);
}
