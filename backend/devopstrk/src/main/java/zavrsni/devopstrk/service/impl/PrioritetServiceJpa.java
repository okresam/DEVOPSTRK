package zavrsni.devopstrk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zavrsni.devopstrk.model.Prioritet;
import zavrsni.devopstrk.repository.PrioritetRepository;
import zavrsni.devopstrk.service.PrioritetService;

import java.util.List;
import java.util.Optional;

@Service
public class PrioritetServiceJpa implements PrioritetService {

    @Autowired
    private PrioritetRepository prioritetRepository;

    @Override
    public List<Prioritet> listAll() {
        return prioritetRepository.findAll();
    }

    @Override
    public Optional<Prioritet> findById(Long idPrioriteta) {
        return prioritetRepository.findById(idPrioriteta);
    }
}
