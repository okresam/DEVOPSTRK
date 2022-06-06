package zavrsni.devopstrk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zavrsni.devopstrk.controller.dto.IdDTO;
import zavrsni.devopstrk.controller.dto.MessageResponse;
import zavrsni.devopstrk.controller.dto.TraziDTO;
import zavrsni.devopstrk.model.Uloga;
import zavrsni.devopstrk.service.UlogaService;

import java.util.List;

@RestController
@RequestMapping("/uloga")
public class UlogaController {

    @Autowired
    private UlogaService ulogaService;

    @CrossOrigin("*")
    @GetMapping("/all")
    public List<Uloga> listUloge() {
        List<Uloga> uloge = ulogaService.listAll();
        uloge.remove(0);
        return uloge;
    }

    @CrossOrigin("*")
    @PostMapping("/delete")
    public ResponseEntity<?> deleteUloga(@RequestBody IdDTO dto) {
        ulogaService.deleteById(Long.parseLong(dto.getId()));
        return ResponseEntity.ok(new MessageResponse("Uloga obrisana!"));
    }

    @CrossOrigin("*")
    @PostMapping("/edit")
    public ResponseEntity<?> editUloga(@RequestBody TraziDTO dto) {
        Uloga uloga = ulogaService.findById(Long.parseLong(dto.getId())).get();
        uloga.setNazivUloge(dto.getSearch());
        ulogaService.updateUloga(uloga);
        return ResponseEntity.ok(new MessageResponse("Uloga izmjenjena!"));
    }

    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<?> addUloga(@RequestBody IdDTO dto) {
        Uloga novaUloga = new Uloga(dto.getId());
        ulogaService.createUloga(novaUloga);
        return ResponseEntity.ok(new MessageResponse("Uloga dodana!"));
    }
}
