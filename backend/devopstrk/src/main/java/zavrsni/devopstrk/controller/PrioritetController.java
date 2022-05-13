package zavrsni.devopstrk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zavrsni.devopstrk.controller.dto.IdDTO;
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
}
