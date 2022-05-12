package zavrsni.devopstrk.model;

import zavrsni.devopstrk.model.util.SudjelujeNaKljuc;

import javax.persistence.*;

@Entity
@Table(name = "sudjelujena")
public class SudjelujeNa {

    @EmbeddedId
    private SudjelujeNaKljuc id;

    @ManyToOne
    @MapsId("idKorisnika")
    @JoinColumn(name = "idkorisnika")
    private Korisnik korisnik;

    @ManyToOne
    @MapsId("idProjekta")
    @JoinColumn(name = "idprojekta")
    private Projekt projekt;

    @ManyToOne
    @JoinColumn(name = "iduloge")
    private Uloga uloga;

    public SudjelujeNa() {

    }

    public SudjelujeNa(SudjelujeNaKljuc id, Korisnik korisnik, Projekt projekt, Uloga uloga) {
        this.id = id;
        this.korisnik = korisnik;
        this.projekt = projekt;
        this.uloga = uloga;
    }

    public SudjelujeNaKljuc getId() {
        return id;
    }

    public void setId(SudjelujeNaKljuc id) {
        this.id = id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Projekt getProjekt() {
        return projekt;
    }

    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }
}
