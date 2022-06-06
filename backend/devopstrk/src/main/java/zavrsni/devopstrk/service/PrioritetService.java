package zavrsni.devopstrk.service;

import zavrsni.devopstrk.model.Prioritet;

import java.util.List;
import java.util.Optional;

public interface PrioritetService {

    List<Prioritet> listAll();

    Optional<Prioritet> findById(Long idPrioriteta);

    void deleteById(Long idPrioriteta);

    void updatePrioritet(Prioritet prioritet);

    Prioritet createPrioritet(Prioritet prioritet);
}
