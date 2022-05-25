package zavrsni.devopstrk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import zavrsni.devopstrk.controller.dto.*;
import zavrsni.devopstrk.model.Korisnik;
import zavrsni.devopstrk.model.Projekt;
import zavrsni.devopstrk.model.SudjelujeNa;
import zavrsni.devopstrk.security.jwt.JwtUtils;
import zavrsni.devopstrk.security.services.UserDetailsImpl;
import zavrsni.devopstrk.service.KorisnikService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/korisnik")
public class KorisnikController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/all")
    public List<Korisnik> listKorisnici() {
        return korisnikService.listAll();
    }

    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<?> createKorisnik(@RequestBody CreateKorisnikDTO dto) {
        Korisnik korisnik = new Korisnik(
                dto.getIme(),
                dto.getPrezime(),
                dto.getEmail(),
                encoder.encode(dto.getLozinka()),
                true
                );
        korisnikService.createKorisnik(korisnik);

        return ResponseEntity.ok(new MessageResponse("Korisnik dodan!"));
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
    @PostMapping("/login")
    public ResponseEntity<?> loginKorisnik(@RequestBody LoginKorisnikDTO dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getLozinka()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(
                jwt,
                userDetails.getIdKorisnika(),
                userDetails.getIme(),
                userDetails.getPrezime(),
                userDetails.getUsername())
        );
    }

    @CrossOrigin("*")
    @PostMapping("/mojiProjekti")
    public ResponseEntity<?> getMojiProjekti(@RequestBody IdDTO dto) {
        List<ProjektInfoDTO> mojiProjekti = new ArrayList<>();

        for (Projekt p : korisnikService.fetch(dto.getId()).get().getMojiProjekti()) {
            mojiProjekti.add(new ProjektInfoDTO(
                    p.getIdProjekta(),
                    p.getNazivProjekta(),
                    p.getOpisProjekta(),
                    p.getDatumPocetka(),
                    p.getDatumZavrsetka(),
                    p.getStanje(),
                    p.getVoditelj().getIdKorisnika()
            ));
        }

        return ResponseEntity.ok(mojiProjekti);

        //return ResponseEntity.ok(korisnikService.fetch(dto.getId()).get().getMojiProjekti());
    }

    @CrossOrigin("*")
    @PostMapping("/otherProjekti")
    public ResponseEntity<?> getOtherProjekti(@RequestBody IdDTO dto) {
        List<ProjektInfoDTO> otherProjekti = new ArrayList<>();

        for (SudjelujeNa sn : korisnikService.fetch(dto.getId()).get().getSudjelujeNa()) {
            if (!sn.getProjekt().getVoditelj().getEmail().equals(dto.getId())) {
                otherProjekti.add(new ProjektInfoDTO(
                        sn.getProjekt().getIdProjekta(),
                        sn.getProjekt().getNazivProjekta(),
                        sn.getProjekt().getOpisProjekta(),
                        sn.getProjekt().getDatumPocetka(),
                        sn.getProjekt().getDatumZavrsetka(),
                        sn.getProjekt().getStanje(),
                        sn.getProjekt().getVoditelj().getIdKorisnika()
                ));
            }
        }

        /* List<Projekt> otherProjekti = new ArrayList<>();

        for (SudjelujeNa sn : korisnikService.fetch(dto.getId()).get().getSudjelujeNa()) {
            if (!sn.getProjekt().getVoditelj().getEmail().equals(dto.getId())) {
                otherProjekti.add(sn.getProjekt());
            }
        } */

        return ResponseEntity.ok(otherProjekti);
    }
}
