package zavrsni.devopstrk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zavrsni.devopstrk.model.Stanje;
import zavrsni.devopstrk.service.StanjeService;

import java.util.List;

@RestController
@RequestMapping("/stanje")
public class StanjeController {

    @Autowired
    private StanjeService stanjeService;

    @CrossOrigin("*")
    @GetMapping("/all")
    public List<Stanje> listStanja() {
        return stanjeService.listAll();
    }

}
