package zavrsni.devopstrk.service;

import zavrsni.devopstrk.model.Zadatak;

import java.util.List;

public interface ZadatakService {

    List<Zadatak> listAll();

    Zadatak createZadatak(Zadatak zadatak);
}
