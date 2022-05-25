package zavrsni.devopstrk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zavrsni.devopstrk.controller.dto.*;
import zavrsni.devopstrk.model.*;
import zavrsni.devopstrk.repository.SudjelujeNaRepository;
import zavrsni.devopstrk.repository.ZadatakRepository;
import zavrsni.devopstrk.service.*;

import java.sql.Date;
import java.sql.Timestamp;
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

    @Autowired
    private ZahtjevService zahtjevService;

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
        List<Zahtjev> zahtjevHistory = zahtjevService.findChangeHistory(dto.getId());
        Zahtjev najnoviji = zahtjevHistory.get(0);
        for (Zahtjev z : zahtjevHistory) {
            if (najnoviji.getIdZahtjeva().getDatumKreiranja().before(z.getIdZahtjeva().getDatumKreiranja())) {
                najnoviji = z;
            }
        }

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
                    sudjelujeNaService.findUloga(z.getIzvrsitelj().getIdKorisnika(), z.getProjekt().getIdProjekta()).getNazivUloge(),
                    najnoviji.getNazivZahtjeva()
            ));
        }
        return ResponseEntity.ok(zadaci);
    }

    @CrossOrigin("*")
    @PostMapping("/getProjektZadaci")
    public ResponseEntity<?> getProjektZadaci(@RequestBody IdDTO dto) {
        List<ZadatakInfoDTO> zadaci = new ArrayList<>();
        for (Zadatak z : zadatakService.projektZadaci(Long.parseLong(dto.getId()))) {
            List<Zahtjev> zahtjevHistory = zahtjevService.findChangeHistory(z.getIdZahtjeva());
            Zahtjev najnoviji = zahtjevHistory.get(0);
            for (Zahtjev zah : zahtjevHistory) {
                if (najnoviji.getIdZahtjeva().getDatumKreiranja().before(zah.getIdZahtjeva().getDatumKreiranja())) {
                    najnoviji = zah;
                }
            }

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
                    sudjelujeNaService.findUloga(z.getIzvrsitelj().getIdKorisnika(), z.getProjekt().getIdProjekta()).getNazivUloge(),
                    najnoviji.getNazivZahtjeva()
            ));
        }
        return ResponseEntity.ok(zadaci);
    }

    @CrossOrigin("*")
    @PostMapping("/getProjektZadaciTrazi")
    public ResponseEntity<?> getProjektZadaciTrazi(@RequestBody TraziDTO dto) {
        List<ZadatakInfoDTO> zadaci = new ArrayList<>();
        for (Zadatak z : zadatakService.projektZadaciTrazi(Long.parseLong(dto.getId()), dto.getSearch())) {
            List<Zahtjev> zahtjevHistory = zahtjevService.findChangeHistory(z.getIdZahtjeva());
            Zahtjev najnoviji = zahtjevHistory.get(0);
            for (Zahtjev zah : zahtjevHistory) {
                if (najnoviji.getIdZahtjeva().getDatumKreiranja().before(zah.getIdZahtjeva().getDatumKreiranja())) {
                    najnoviji = zah;
                }
            }

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
                    sudjelujeNaService.findUloga(z.getIzvrsitelj().getIdKorisnika(), z.getProjekt().getIdProjekta()).getNazivUloge(),
                    najnoviji.getNazivZahtjeva()
            ));
        }
        return ResponseEntity.ok(zadaci);
    }

    @CrossOrigin("*")
    @PostMapping("/delete")
    public ResponseEntity<?> deleteZadatak(@RequestBody IdDTO dto) {
        zadatakService.deleteZadatak(Long.parseLong(dto.getId()));
        return ResponseEntity.ok(new MessageResponse("Zadatak obrisan!"));
    }

    @CrossOrigin("*")
    @PostMapping("/edit")
    public ResponseEntity<?> editZadatak(@RequestBody EditZadatakDTO dto) {
        Zadatak zadatak = zadatakService.fetch(Long.parseLong(dto.getIdZadatka()));
        VrstaZadatka vrstaZadatka = vrstaZadatkaService.findById(Long.parseLong(dto.getIdVrsteZadatka())).get();
        Prioritet prioritet = prioritetService.findById(Long.parseLong(dto.getIdPrioriteta())).get();

        zadatak.setNazivZadatka(dto.getNazivZadatka());
        zadatak.setOpisZadatka(dto.getOpisZadatka());
        zadatak.setRokIzvrsavanja(dto.getRokIzvrsavanja());
        zadatak.setVrstaZadatka(vrstaZadatka);
        zadatak.setPrioritet(prioritet);

        zadatakService.updateZadatak(zadatak);

        return ResponseEntity.ok(new MessageResponse("Zadatak izmjenjen!"));
    }

    @CrossOrigin("*")
    @PostMapping("/completedNumber")
    public ResponseEntity<?> getCompletedNumber(@RequestBody IdDTO dto) {
        return ResponseEntity.ok(zadatakService.getBrojZavrsenih(dto.getId()));
    }

    @CrossOrigin("*")
    @PostMapping("/incompletedNumber")
    public ResponseEntity<?> getIncompletedNumber(@RequestBody IdDTO dto) {
        return ResponseEntity.ok(zadatakService.getBrojNezavrsenih(dto.getId()));
    }

    @CrossOrigin("*")
    @PostMapping("/getMojiZadaciNaProjektu")
    public ResponseEntity<?> getMojiZadaciNaProjektu(@RequestBody TraziDTO dto) {
        List<ZadatakInfoDTO> mojiZadaci = new ArrayList<>();

        for (Zadatak z : zadatakService.getMojiZadaciNaProjektu(Long.parseLong(dto.getId()), Long.parseLong(dto.getSearch()))) {
            List<Zahtjev> zahtjevHistory = zahtjevService.findChangeHistory(z.getIdZahtjeva());
            Zahtjev najnoviji = zahtjevHistory.get(0);
            for (Zahtjev zah : zahtjevHistory) {
                if (najnoviji.getIdZahtjeva().getDatumKreiranja().before(zah.getIdZahtjeva().getDatumKreiranja())) {
                    najnoviji = zah;
                }
            }

            mojiZadaci.add(new ZadatakInfoDTO(
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
               null,
               null,
               null,
                najnoviji.getNazivZahtjeva()
            ));
        }

        return ResponseEntity.ok(mojiZadaci);
    }

    @CrossOrigin("*")
    @PostMapping("/stanjeChange")
    public ResponseEntity<?> changeStanje(@RequestBody IdDTO dto) {
        Zadatak zadatak = zadatakService.fetch(Long.parseLong(dto.getId()));
        Stanje novoStanje = stanjeService.findById(zadatak.getStanje().getIdStanja() + 1).get();

        zadatak.setStanje(novoStanje);

        long stanjeId = novoStanje.getIdStanja();
        if (stanjeId == Long.parseLong("3")) {
            zadatak.setDatumStvarnogIzvrsavanja(new Date(Date.from(Instant.now()).getTime()));
        }

        zadatakService.updateZadatak(zadatak);

        return ResponseEntity.ok(new MessageResponse("Stanje zadatka izmjenjeno!"));
    }
}
