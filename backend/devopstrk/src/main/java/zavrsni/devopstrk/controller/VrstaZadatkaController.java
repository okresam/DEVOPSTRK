package zavrsni.devopstrk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zavrsni.devopstrk.controller.dto.IdDTO;
import zavrsni.devopstrk.service.VrstaZadatkaService;

@RestController
@RequestMapping("/vrstazadatka")
public class VrstaZadatkaController {

    @Autowired
    private VrstaZadatkaService vrstaZadatkaService;

    @CrossOrigin("*")
    @PostMapping("/get")
    public ResponseEntity<?> getVrstaZadatka(@RequestBody IdDTO dto) {
        return ResponseEntity.ok(vrstaZadatkaService.findById(Long.parseLong(dto.getId())).get());
    }

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<?> getAllVrstaZahtjeva() {
        return ResponseEntity.ok(vrstaZadatkaService.listAll());
    }
}
