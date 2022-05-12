package zavrsni.devopstrk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zavrsni.devopstrk.controller.dto.CreateKorisnikDTO;
import zavrsni.devopstrk.controller.dto.CreateProjektDTO;
import zavrsni.devopstrk.controller.dto.MessageResponse;
import zavrsni.devopstrk.model.Korisnik;
import zavrsni.devopstrk.model.Projekt;
import zavrsni.devopstrk.service.KorisnikService;
import zavrsni.devopstrk.service.ProjektService;
import zavrsni.devopstrk.service.StanjeService;

import java.util.List;

@RestController
@RequestMapping("/projekt")
public class ProjektController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private StanjeService stanjeService;

    @Autowired
    private ProjektService projektService;

    @GetMapping("/all")
    public List<Projekt> listProjekti() {
        return projektService.listAll();
    }

    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<?> createKorisnik(@RequestBody CreateProjektDTO dto) {
        Projekt projekt = new Projekt(
                dto.getNazivProjekta(),
                dto.getOpisProjekta(),
                dto.getDatumPocetka(),
                dto.getDatumZavrsetka(),
                stanjeService.findById(Long.parseLong("1")).get(),
                korisnikService.fetch(dto.getEmailVoditelja()).get());
        projektService.createProjekt(projekt);
        return ResponseEntity.ok(new MessageResponse("Projekt dodan!"));
    }

}
