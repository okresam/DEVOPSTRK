package zavrsni.devopstrk.service;

import zavrsni.devopstrk.model.Zahtjev;

import java.util.List;

public interface ZahtjevService {

    List<Zahtjev> listAll();

    Zahtjev createZahtjev(Zahtjev zahtjev);

    List<Zahtjev> findChangeHistory(String idZahtjeva);
}
