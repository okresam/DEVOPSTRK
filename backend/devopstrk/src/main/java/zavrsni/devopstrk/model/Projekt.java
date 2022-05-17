package zavrsni.devopstrk.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "projekt")
public class Projekt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprojekta")
    private Long idProjekta;

    @Column(name = "nazivprojekta", nullable = false)
    private String nazivProjekta;

    @Column(name = "opisprojekta", nullable = false)
    private String opisProjekta;

    @Column(name = "datumpocetka", nullable = false)
    private String datumPocetka;

    @Column(name = "datumzavrsetka", nullable = false)
    private String datumZavrsetka;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idstanja")
    public Stanje stanje;

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "idvoditelja")
    public Korisnik voditelj;

    @JsonBackReference
    @OneToMany(mappedBy = "projekt", cascade = CascadeType.REMOVE)
    Set<SudjelujeNa> sudjelujeNa;

    @OneToMany(mappedBy = "projekt")
    private Set<Zadatak> projektZadaci;

    @OneToMany(mappedBy = "projekt")
    private Set<Zahtjev> projektZahtjevi;

    public Projekt() {

    }

    public Projekt(String nazivProjekta, String opisProjekta, String datumPocetka, String datumZavrsetka, Stanje stanje, Korisnik voditelj) {
        this.nazivProjekta = nazivProjekta;
        this.opisProjekta = opisProjekta;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.stanje = stanje;
        this.voditelj = voditelj;
    }

    public Long getIdProjekta() {
        return idProjekta;
    }

    public String getNazivProjekta() {
        return nazivProjekta;
    }

    public void setNazivProjekta(String nazivProjekta) {
        this.nazivProjekta = nazivProjekta;
    }

    public String getOpisProjekta() {
        return opisProjekta;
    }

    public void setOpisProjekta(String opisProjekta) {
        this.opisProjekta = opisProjekta;
    }

    public String getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(String datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public String getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(String datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public Stanje getStanje() {
        return stanje;
    }

    public void setStanje(Stanje stanje) {
        this.stanje = stanje;
    }

    public Korisnik getVoditelj() {
        return voditelj;
    }

    public void setVoditelj(Korisnik voditelj) {
        this.voditelj = voditelj;
    }

    public Set<SudjelujeNa> getSudjelujeNa() {
        return sudjelujeNa;
    }

    public void setSudjelujeNa(Set<SudjelujeNa> sudjelujeNa) {
        this.sudjelujeNa = sudjelujeNa;
    }

    public Set<Zadatak> getProjektZadaci() {
        return projektZadaci;
    }

    public void setProjektZadaci(Set<Zadatak> projektZadaci) {
        this.projektZadaci = projektZadaci;
    }

    public Set<Zahtjev> getProjektZahtjevi() {
        return projektZahtjevi;
    }

    public void setProjektZahtjevi(Set<Zahtjev> projektZahtjevi) {
        this.projektZahtjevi = projektZahtjevi;
    }
}
