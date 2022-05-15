package zavrsni.devopstrk.controller.dto;

import zavrsni.devopstrk.model.Korisnik;
import zavrsni.devopstrk.model.Uloga;

public class SudionikDTO {
    String ime;

    String prezime;

    String email;

    Uloga ulogaSudionika;

    public SudionikDTO(String ime, String prezime, String email, Uloga ulogaSudionika) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.ulogaSudionika = ulogaSudionika;
    }

    public String getIme() {
        return ime;
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

    public Uloga getUlogaSudionika() {
        return ulogaSudionika;
    }

    public void setUlogaSudionika(Uloga ulogaSudionika) {
        this.ulogaSudionika = ulogaSudionika;
    }
}
