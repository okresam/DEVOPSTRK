package zavrsni.devopstrk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "korisnik")
public class Korisnik {

    @Id
    @GeneratedValue
    private Long idKorisnika;

    private String ime;

    private String prezime;

    private String email;

    private String lozinka;

    private Boolean isVerified;

    public Korisnik() {

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

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }
}
