package zavrsni.devopstrk.service;

import zavrsni.devopstrk.model.Prioritet;

import java.util.List;
import java.util.Optional;

public interface PrioritetService {

    List<Prioritet> listAll();

    Optional<Prioritet> findById(Long idPrioriteta);
}
