package zavrsni.devopstrk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zavrsni.devopstrk.controller.dto.IdDTO;
import zavrsni.devopstrk.controller.dto.MessageResponse;
import zavrsni.devopstrk.controller.dto.TraziDTO;
import zavrsni.devopstrk.model.Prioritet;
import zavrsni.devopstrk.service.PrioritetService;

@RestController
@RequestMapping("/prioritet")
public class PrioritetController {

    @Autowired
    private PrioritetService prioritetService;

    @CrossOrigin("*")
    @PostMapping("/get")
    public ResponseEntity<?> getPrioritet(@RequestBody IdDTO dto) {
        return ResponseEntity.ok(prioritetService.findById(Long.parseLong(dto.getId())).get());
    }

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<?> getAllVrstaZahtjeva() {
        return ResponseEntity.ok(prioritetService.listAll());
    }


    @CrossOrigin("*")
    @PostMapping("/delete")
    public ResponseEntity<?> deletePrioritet(@RequestBody IdDTO dto) {
        prioritetService.deleteById(Long.parseLong(dto.getId()));
        return ResponseEntity.ok(new MessageResponse("Prioritet obrisan!"));
    }

    @CrossOrigin("*")
    @PostMapping("/edit")
    public ResponseEntity<?> editPrioritet(@RequestBody TraziDTO dto) {
        Prioritet prioritet = prioritetService.findById(Long.parseLong(dto.getId())).get();
        prioritet.setNazivPrioriteta(dto.getSearch());
        prioritetService.updatePrioritet(prioritet);
        return ResponseEntity.ok(new MessageResponse("Prioritet izmjenjen!"));
    }

    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<?> addPrioritet(@RequestBody IdDTO dto) {
        Prioritet noviPrioritet = new Prioritet(dto.getId());
        prioritetService.createPrioritet(noviPrioritet);
        return ResponseEntity.ok(new MessageResponse("Prioritet dodan!"));
    }
}
