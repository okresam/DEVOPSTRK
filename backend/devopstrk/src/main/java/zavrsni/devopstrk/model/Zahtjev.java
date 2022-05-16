package zavrsni.devopstrk.model;

import zavrsni.devopstrk.model.util.ZahtjevKljuc;

import javax.persistence.*;

@Entity
@Table(name = "zahtjev")
public class Zahtjev {

    @EmbeddedId
    private ZahtjevKljuc idZahtjeva;

    @Column(nullable = false, name = "nazivzahtjeva")
    private String nazivZahtjeva;

    @Column(nullable = false, name = "opiszahtjeva")
    private String opisZahtjeva;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idvrstezahtjeva")
    private VrstaZahtjeva vrstaZahtjeva;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idizvora")
    private Korisnik izvor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idprojekta")
    private Projekt projekt;

    public Zahtjev() {

    }

    public Zahtjev(ZahtjevKljuc idZahtjeva, String nazivZahtjeva, String opisZahtjeva, VrstaZahtjeva vrstaZahtjeva, Korisnik izvor, Projekt projekt) {
        this.idZahtjeva = idZahtjeva;
        this.nazivZahtjeva = nazivZahtjeva;
        this.opisZahtjeva = opisZahtjeva;
        this.vrstaZahtjeva = vrstaZahtjeva;
        this.izvor = izvor;
        this.projekt = projekt;
    }

    public ZahtjevKljuc getIdZahtjeva() {
        return idZahtjeva;
    }

    public void setIdZahtjeva(ZahtjevKljuc idZahtjeva) {
        this.idZahtjeva = idZahtjeva;
    }

    public String getNazivZahtjeva() {
        return nazivZahtjeva;
    }

    public void setNazivZahtjeva(String nazivZahtjeva) {
        this.nazivZahtjeva = nazivZahtjeva;
    }

    public String getOpisZahtjeva() {
        return opisZahtjeva;
    }

    public void setOpisZahtjeva(String opisZahtjeva) {
        this.opisZahtjeva = opisZahtjeva;
    }

    public VrstaZahtjeva getVrstaZahtjeva() {
        return vrstaZahtjeva;
    }

    public void setVrstaZahtjeva(VrstaZahtjeva vrstaZahtjeva) {
        this.vrstaZahtjeva = vrstaZahtjeva;
    }

    public Korisnik getIzvor() {
        return izvor;
    }

    public void setIzvor(Korisnik izvor) {
        this.izvor = izvor;
    }

    public Projekt getProjekt() {
        return projekt;
    }

    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }
}
