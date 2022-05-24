package zavrsni.devopstrk.service;

import zavrsni.devopstrk.model.Zadatak;

import java.util.List;

public interface ZadatakService {

    List<Zadatak> listAll();

    Zadatak createZadatak(Zadatak zadatak);

    List<Zadatak> zahtjevZadaci(String idZahtjeva);

    List<Zadatak> projektZadaci(Long idProjekta);

    List<Zadatak> projektZadaciTrazi(Long idProjekta, String trazi);

    void deleteZadatak(Long idZadatka);

    Zadatak fetch(Long idZadatka);

    void updateZadatak(Zadatak zadatak);

    int getBrojZavrsenih(String idZahtjeva);

    int getBrojNezavrsenih(String idZahtjeva);
}
