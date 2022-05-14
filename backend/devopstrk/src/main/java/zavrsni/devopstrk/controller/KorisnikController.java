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
import zavrsni.devopstrk.security.jwt.JwtUtils;
import zavrsni.devopstrk.security.services.UserDetailsImpl;
import zavrsni.devopstrk.service.KorisnikService;

import java.util.List;

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
        Korisnik korisnik = new Korisnik(dto.getIme(), dto.getPrezime(), dto.getEmail(), encoder.encode(dto.getLozinka()), true);
        korisnikService.createKorisnik(korisnik);
        return ResponseEntity.ok(new MessageResponse("Korisnik dodan!"));
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
        return ResponseEntity.ok(korisnikService.fetch(dto.getId()).get().getMojiProjekti());
    }
}
