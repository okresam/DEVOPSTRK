package zavrsni.devopstrk.service;

import zavrsni.devopstrk.model.VrstaZahtjeva;

import java.util.List;
import java.util.Optional;

public interface VrstaZahtjevaService {

    List<VrstaZahtjeva> listAll();

    Optional<VrstaZahtjeva> findById(Long idVrsteZahtjeva);
}
