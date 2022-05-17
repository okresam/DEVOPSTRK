package zavrsni.devopstrk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zavrsni.devopstrk.controller.dto.CreateZahtjevDTO;
import zavrsni.devopstrk.controller.dto.IdDTO;
import zavrsni.devopstrk.controller.dto.MessageResponse;
import zavrsni.devopstrk.controller.dto.ZahtjevInfoDTO;
import zavrsni.devopstrk.model.Korisnik;
import zavrsni.devopstrk.model.Projekt;
import zavrsni.devopstrk.model.VrstaZahtjeva;
import zavrsni.devopstrk.model.Zahtjev;
import zavrsni.devopstrk.model.util.ZahtjevKljuc;
import zavrsni.devopstrk.service.KorisnikService;
import zavrsni.devopstrk.service.ProjektService;
import zavrsni.devopstrk.service.VrstaZahtjevaService;
import zavrsni.devopstrk.service.ZahtjevService;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@RestController
@RequestMapping("/zahtjev")
public class ZahtjevController {

    @Autowired
    private ZahtjevService zahtjevService;

    @Autowired
    private VrstaZahtjevaService vrstaZahtjevaService;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private ProjektService projektService;

    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<?> createZahtjev(@RequestBody CreateZahtjevDTO dto) {
        VrstaZahtjeva vrstaZahtjeva = vrstaZahtjevaService.findById(Long.parseLong(dto.getIdVrsteZahtjeva())).get();
        Korisnik izvor = korisnikService.fetch(dto.getEmailIzvora()).get();
        Projekt projekt = projektService.fetch(Long.parseLong(dto.getIdProjekta()));

        ZahtjevKljuc kljuc;

        if (dto.getIdZahtjeva() == null) {
            String emailPart = dto.getEmailIzvora().split("@")[0];
            LocalDate dateNow = LocalDate.now();
            LocalTime timeNow = LocalTime.now();
            String timePart = String.valueOf(dateNow.getYear()) + String.valueOf(dateNow.getMonthValue()) + String.valueOf(dateNow.getDayOfMonth()) + String.valueOf(timeNow.getHour()) + String.valueOf(timeNow.getMinute()) + String.valueOf(timeNow.getSecond());
            String randomPart = alphaNumericString(5);

            String id = emailPart + "-" + timePart + "-" + randomPart;

            kljuc = new ZahtjevKljuc(id, new Timestamp(System.currentTimeMillis()));
        } else {
            kljuc = new ZahtjevKljuc(dto.getIdZahtjeva(), new Timestamp(System.currentTimeMillis()));
        }

        Zahtjev zahtjev = new Zahtjev(
            kljuc,
            dto.getNazivZahtjeva(),
            dto.getOpisZahtjeva(),
            vrstaZahtjeva,
            izvor,
            projekt
        );

        zahtjevService.createZahtjev(zahtjev);

        return ResponseEntity.ok(new MessageResponse("Zahtjev dodan!"));
    }


    public static String alphaNumericString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    @CrossOrigin("*")
    @PostMapping("/getProjektZahtjevi")
    public ResponseEntity<?> getProjektZahtjevi(@RequestBody IdDTO dto) {
        Projekt projekt = projektService.fetch(Long.parseLong(dto.getId()));
        Set<Zahtjev> zahtjevi = projekt.getProjektZahtjevi();
        Map<String, Zahtjev> output = new HashMap<>();

        for (Zahtjev z : zahtjevi) {
            Zahtjev stored = output.get(z.getIdZahtjeva().getIdZahtjeva());

            if (stored == null || stored.getIdZahtjeva().getDatumKreiranja().before(z.getIdZahtjeva().getDatumKreiranja())) {
                output.put(z.getIdZahtjeva().getIdZahtjeva(), z);
            }
        }

        List<ZahtjevInfoDTO> result = new ArrayList<>();
        for (Zahtjev z : output.values()) {
            result.add(new ZahtjevInfoDTO(
                    z.getIdZahtjeva().getIdZahtjeva(),
                    z.getNazivZahtjeva(),
                    z.getOpisZahtjeva(),
                    z.getVrstaZahtjeva().getIdVrsteZahtjeva(),
                    z.getVrstaZahtjeva().getNazivVrsteZahtjeva(),
                    z.getIzvor().getIdKorisnika()
            ));
        }

        return ResponseEntity.ok(result);
    }
}
