package zavrsni.devopstrk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zavrsni.devopstrk.controller.dto.*;
import zavrsni.devopstrk.model.*;
import zavrsni.devopstrk.model.util.SudjelujeNaKljuc;
import zavrsni.devopstrk.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projekt")
public class ProjektController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private SudjelujeNaService sudjelujeNaService;

    @Autowired
    private StanjeService stanjeService;

    @Autowired
    private UlogaService ulogaService;

    @Autowired
    private ProjektService projektService;

    @Autowired
    private ZahtjevService zahtjevService;

    @GetMapping("/all")
    public List<Projekt> listProjekti() {
        return projektService.listAll();
    }

    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<?> createProjekt(@RequestBody CreateProjektDTO dto) {
        Korisnik voditelj = korisnikService.fetch(dto.getEmailVoditelja()).get();

        Projekt projekt = new Projekt(
                dto.getNazivProjekta(),
                dto.getOpisProjekta(),
                dto.getDatumPocetka(),
                dto.getDatumZavrsetka(),
                stanjeService.findById(Long.parseLong("1")).get(),
                voditelj);

        projektService.createProjekt(projekt);

        sudjelujeNaService.createSudjelujeNa(new SudjelujeNa(new SudjelujeNaKljuc(voditelj.getIdKorisnika(), projekt.getIdProjekta()),
                voditelj,
                projekt,
                ulogaService.findById(Long.parseLong("1")).get()
                )
        );
        return ResponseEntity.ok(new MessageResponse("Projekt dodan!"));
    }

    @CrossOrigin("*")
    @PostMapping("/delete")
    public ResponseEntity<?> deleteProjekt(@RequestBody IdDTO dto) {
        Projekt projekt = projektService.fetch(Long.parseLong(dto.getId()));

        for (Zahtjev z : projekt.getProjektZahtjevi()) {
            zahtjevService.deleteByIdZahtjeva(z.getIdZahtjeva().getIdZahtjeva());
        }

        projektService.deleteByIdProjekta(Long.parseLong(dto.getId()));
        return ResponseEntity.ok(new MessageResponse("Projekt obrisan!"));
    }

    @CrossOrigin("*")
    @PostMapping("/getAllOtherProjekti")
    public ResponseEntity<?> getAllOtherProjekti(@RequestBody IdDTO dto) {
        return ResponseEntity.ok(sudjelujeNaService.findByIdKorisnika(Long.parseLong(dto.getId())));
    }

    @CrossOrigin("*")
    @PostMapping("/edit")
    public ResponseEntity<?> editProjekt(@RequestBody EditProjektDTO dto) {
        Projekt projekt = projektService.fetch(Long.parseLong(dto.getIdProjekta()));
        Stanje stanjeProjekta = stanjeService.findById(Long.parseLong(dto.getIdStanja())).get();

        projekt.setNazivProjekta(dto.getNazivProjekta());
        projekt.setOpisProjekta(dto.getOpisProjekta());
        projekt.setDatumPocetka(dto.getDatumPocetka());
        projekt.setDatumZavrsetka(dto.getDatumZavrsetka());
        projekt.setStanje(stanjeProjekta);

        projektService.updateProjekt(projekt);

        return ResponseEntity.ok(new MessageResponse("Projekt izmjenjen!"));
    }

    @CrossOrigin("*")
    @PostMapping("/sudionici")
    public ResponseEntity<?> getSudionici(@RequestBody IdDTO dto) {
        List<SudionikDTO> sudionici = new ArrayList<>();

        for (SudjelujeNa sn : projektService.fetch(Long.parseLong(dto.getId())).getSudjelujeNa()) {
            sudionici.add(new SudionikDTO(sn.getKorisnik().getIme(), sn.getKorisnik().getPrezime(), sn.getKorisnik().getEmail(), sn.getUloga()));
        }

        return ResponseEntity.ok(sudionici);
    }

    @CrossOrigin("*")
    @PostMapping("/dodajSudionika")
    public ResponseEntity<?> dodajSudionika(@RequestBody DodajSudionikaDTO dto) {
        Optional<Korisnik> maybeKorisnik = korisnikService.fetch(dto.getEmailSudionika());

        if (maybeKorisnik.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Korisnik sudionik = maybeKorisnik.get();
        Projekt projekt = projektService.fetch(Long.parseLong(dto.getIdProjekta()));


        sudjelujeNaService.createSudjelujeNa(new SudjelujeNa(new SudjelujeNaKljuc(sudionik.getIdKorisnika(), projekt.getIdProjekta()),
                        sudionik,
                        projekt,
                        ulogaService.findById(Long.parseLong(dto.getIdUlogeSudionika())).get()
                )
        );

        return ResponseEntity.ok(new MessageResponse("Sudionik dodan!"));
    }

}
