package zavrsni.devopstrk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
