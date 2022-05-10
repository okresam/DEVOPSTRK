package zavrsni.devopstrk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "korisnik")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idkorisnika")
    private Long idKorisnika;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String lozinka;

    @Column(name = "isverified", nullable = false)
    private boolean isVerified;

    public Korisnik() {

    }

    public Korisnik(String ime, String prezime, String email, String lozinka, boolean isVerified) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka = lozinka;
        this.isVerified = isVerified;
    }

    public String getIme() {
        return ime;
    }

    public Long getIdKorisnika() {
        return idKorisnika;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public boolean getVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }
}
