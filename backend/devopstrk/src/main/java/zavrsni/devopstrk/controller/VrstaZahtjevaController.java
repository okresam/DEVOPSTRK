package zavrsni.devopstrk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zavrsni.devopstrk.controller.dto.IdDTO;
import zavrsni.devopstrk.service.VrstaZahtjevaService;

@RestController
@RequestMapping("/vrstazahtjeva")
public class VrstaZahtjevaController {

    @Autowired
    private VrstaZahtjevaService vrstaZahtjevaService;

    @CrossOrigin("*")
    @PostMapping("/get")
    public ResponseEntity<?> getVrstaZahtjeva(@RequestBody IdDTO dto) {
        return ResponseEntity.ok(vrstaZahtjevaService.findById(Long.parseLong(dto.getId())).get());
    }

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<?> getAllVrstaZahtjeva() {
        return ResponseEntity.ok(vrstaZahtjevaService.listAll());
    }
}
