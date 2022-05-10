package zavrsni.devopstrk.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import zavrsni.devopstrk.model.Korisnik;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Long idKorisnika;
    private String ime;
    private String prezime;
    private String email;
    @JsonIgnore
    private String lozinka;
    boolean isVerified;
    public UserDetailsImpl(Long idKorisnika, String ime, String prezime, String email,
                           String lozinka, boolean isVerified) {
        this.idKorisnika = idKorisnika;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka = lozinka;
        this.isVerified = isVerified;
    }
    public static UserDetailsImpl build(Korisnik korisnik) {
        return new UserDetailsImpl(
                korisnik.getIdKorisnika(),
                korisnik.getIme(),
                korisnik.getPrezime(),
                korisnik.getEmail(),
                korisnik.getLozinka(),
                korisnik.getVerified()
                );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }

    public Long getIdKorisnika() {
        return idKorisnika;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    @Override
    public String getPassword() {
        return lozinka;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isVerified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(idKorisnika, user.idKorisnika);
    }
}
