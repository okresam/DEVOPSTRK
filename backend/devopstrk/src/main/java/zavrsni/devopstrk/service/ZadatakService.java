package zavrsni.devopstrk.service;

import zavrsni.devopstrk.model.Zadatak;

import java.util.List;

public interface ZadatakService {

    List<Zadatak> listAll();

    Zadatak createZadatak(Zadatak zadatak);

    List<Zadatak> zahtjevZadaci(String idZahtjeva);

    List<Zadatak> projektZadaci(Long idProjekta);
}
