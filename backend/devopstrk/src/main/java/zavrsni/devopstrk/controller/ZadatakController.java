package zavrsni.devopstrk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zavrsni.devopstrk.controller.dto.CreateZadatakDTO;
import zavrsni.devopstrk.controller.dto.IdDTO;
import zavrsni.devopstrk.controller.dto.MessageResponse;
import zavrsni.devopstrk.controller.dto.ZadatakInfoDTO;
import zavrsni.devopstrk.model.*;
import zavrsni.devopstrk.repository.SudjelujeNaRepository;
import zavrsni.devopstrk.repository.ZadatakRepository;
import zavrsni.devopstrk.service.*;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zadatak")
public class ZadatakController {

    @Autowired
    private ZadatakService zadatakService;

    @Autowired
    private ProjektService projektService;

    @Autowired
    private VrstaZadatkaService vrstaZadatkaService;

    @Autowired
    private StanjeService stanjeService;

    @Autowired
    private PrioritetService prioritetService;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private SudjelujeNaService sudjelujeNaService;

    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<?> createZadatak(@RequestBody CreateZadatakDTO dto) {
        Projekt projekt = projektService.fetch(Long.parseLong(dto.getIdProjekta()));
        VrstaZadatka vrstaZadatka = vrstaZadatkaService.findById(Long.parseLong(dto.getIdVrsteZadatka())).get();
        Stanje stanje = stanjeService.findById(Long.parseLong("1")).get();
        Prioritet prioritet = prioritetService.findById(Long.parseLong(dto.getIdPrioriteta())).get();
        Korisnik izvrsitelj = korisnikService.fetch(dto.getEmailIzvrsitelja()).get();

        Zadatak zadatak = new Zadatak(
                dto.getNazivZadatka(),
                dto.getOpisZadatka(),
                new Date(Date.from(Instant.now()).getTime()),
                dto.getRokIzvrsavanja(),
                null,
                dto.getIdZahtjeva(),
                projekt,
                vrstaZadatka,
                stanje,
                prioritet,
                izvrsitelj
        );

        zadatakService.createZadatak(zadatak);
        return ResponseEntity.ok(new MessageResponse("Zadatak dodan!"));
    }

    @CrossOrigin("*")
    @PostMapping("/getZahtjevZadaci")
    public ResponseEntity<?> getZahtjevZadaci(@RequestBody IdDTO dto) {
        List<ZadatakInfoDTO> zadaci = new ArrayList<>();
        for (Zadatak z : zadatakService.zahtjevZadaci(dto.getId())) {
            zadaci.add(new ZadatakInfoDTO(
                    z.getIdZadatka(),
                    z.getNazivZadatka(),
                    z.getOpisZadatka(),
                    z.getDatumStvaranjaZadatka(),
                    z.getRokIzvrsavanja(),
                    z.getDatumStvarnogIzvrsavanja(),
                    z.getVrstaZadatka(),
                    z.getStanje(),
                    z.getPrioritet(),
                    z.getIzvrsitelj().getIdKorisnika(),
                    z.getIzvrsitelj().getIme(),
                    z.getIzvrsitelj().getPrezime(),
                    sudjelujeNaService.findUloga(z.getIzvrsitelj().getIdKorisnika(), z.getProjekt().getIdProjekta()).getNazivUloge()
            ));
        }
        return ResponseEntity.ok(zadaci);
    }

    @CrossOrigin("*")
    @PostMapping("/getProjektZadaci")
    public ResponseEntity<?> getProjektZadaci(@RequestBody IdDTO dto) {
        List<ZadatakInfoDTO> zadaci = new ArrayList<>();
        for (Zadatak z : zadatakService.projektZadaci(Long.parseLong(dto.getId()))) {
            zadaci.add(new ZadatakInfoDTO(
                    z.getIdZadatka(),
                    z.getNazivZadatka(),
                    z.getOpisZadatka(),
                    z.getDatumStvaranjaZadatka(),
                    z.getRokIzvrsavanja(),
                    z.getDatumStvarnogIzvrsavanja(),
                    z.getVrstaZadatka(),
                    z.getStanje(),
                    z.getPrioritet(),
                    z.getIzvrsitelj().getIdKorisnika(),
                    z.getIzvrsitelj().getIme(),
                    z.getIzvrsitelj().getPrezime(),
                    sudjelujeNaService.findUloga(z.getIzvrsitelj().getIdKorisnika(), z.getProjekt().getIdProjekta()).getNazivUloge()
            ));
        }
        return ResponseEntity.ok(zadaci);
    }
}
