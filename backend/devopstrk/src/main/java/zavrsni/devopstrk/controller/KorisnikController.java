package zavrsni.devopstrk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zavrsni.devopstrk.controller.dto.CreateKorisnikDTO;
import zavrsni.devopstrk.model.Korisnik;
import zavrsni.devopstrk.service.KorisnikService;

import java.util.List;

@RestController
@RequestMapping("/korisnik")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/all")
    public List<Korisnik> listKorisnici() {
        return korisnikService.listAll();
    }

    @CrossOrigin("*")
    @PostMapping("/add")
    public Korisnik createKorisnik(@RequestBody CreateKorisnikDTO dto) {
        Korisnik korisnik = new Korisnik(dto.getIme(), dto.getPrezime(), dto.getEmail(), dto.getLozinka(), true);
        return korisnikService.createKorisnik(korisnik);
    }
}
