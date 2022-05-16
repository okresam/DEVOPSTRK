package zavrsni.devopstrk.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "zadatak")
public class Zadatak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idzadatka")
    private Long idZadatka;

    @Column(name = "nazivzadatka", nullable = false)
    private String nazivZadatka;

    @Column(name = "opiszadatka", nullable = false)
    private String opisZadatka;

    @Column(name = "datumstvaranjazadatka", nullable = false)
    private Date datumStvaranjaZadatka;

    @Column(name = "rokizvrsavanja", nullable = false)
    private Date rokIzvrsavanja;

    @Column(name = "datumstvarnogizvrsavanja")
    private Date datumStvarnogIzvrsavanja;

    @Column(name = "idzahtjeva", nullable = false)
    private String idZahtjeva;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idprojekta")
    private Projekt projekt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idvrstezadatka")
    private VrstaZadatka vrstaZadatka;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idstanja")
    private Stanje stanje;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idprioriteta")
    private Prioritet prioritet;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idizvrsitelja")
    private Korisnik izvrsitelj;

    public Zadatak() {

    }

    public Zadatak(Long idZadatka, String nazivZadatka, String opisZadatka, Date datumStvaranjaZadatka, Date rokIzvrsavanja, Date datumStvarnogIzvrsavanja, String idZahtjeva, Projekt projekt, VrstaZadatka vrstaZadatka, Stanje stanje, Prioritet prioritet, Korisnik izvrsitelj) {
        this.idZadatka = idZadatka;
        this.nazivZadatka = nazivZadatka;
        this.opisZadatka = opisZadatka;
        this.datumStvaranjaZadatka = datumStvaranjaZadatka;
        this.rokIzvrsavanja = rokIzvrsavanja;
        this.datumStvarnogIzvrsavanja = datumStvarnogIzvrsavanja;
        this.idZahtjeva = idZahtjeva;
        this.projekt = projekt;
        this.vrstaZadatka = vrstaZadatka;
        this.stanje = stanje;
        this.prioritet = prioritet;
        this.izvrsitelj = izvrsitelj;
    }

    public Long getIdZadatka() {
        return idZadatka;
    }

    public String getNazivZadatka() {
        return nazivZadatka;
    }

    public void setNazivZadatka(String nazivZadatka) {
        this.nazivZadatka = nazivZadatka;
    }

    public String getOpisZadatka() {
        return opisZadatka;
    }

    public void setOpisZadatka(String opisZadatka) {
        this.opisZadatka = opisZadatka;
    }

    public Date getDatumStvaranjaZadatka() {
        return datumStvaranjaZadatka;
    }

    public void setDatumStvaranjaZadatka(Date datumStvaranjaZadatka) {
        this.datumStvaranjaZadatka = datumStvaranjaZadatka;
    }

    public Date getRokIzvrsavanja() {
        return rokIzvrsavanja;
    }

    public void setRokIzvrsavanja(Date rokIzvrsavanja) {
        this.rokIzvrsavanja = rokIzvrsavanja;
    }

    public Date getDatumStvarnogIzvrsavanja() {
        return datumStvarnogIzvrsavanja;
    }

    public void setDatumStvarnogIzvrsavanja(Date datumStvarnogIzvrsavanja) {
        this.datumStvarnogIzvrsavanja = datumStvarnogIzvrsavanja;
    }

    public String getIdZahtjeva() {
        return idZahtjeva;
    }

    public void setIdZahtjeva(String idZahtjeva) {
        this.idZahtjeva = idZahtjeva;
    }

    public Projekt getProjekt() {
        return projekt;
    }

    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }

    public VrstaZadatka getVrstaZadatka() {
        return vrstaZadatka;
    }

    public void setVrstaZadatka(VrstaZadatka vrstaZadatka) {
        this.vrstaZadatka = vrstaZadatka;
    }

    public Stanje getStanje() {
        return stanje;
    }

    public void setStanje(Stanje stanje) {
        this.stanje = stanje;
    }

    public Prioritet getPrioritet() {
        return prioritet;
    }

    public void setPrioritet(Prioritet prioritet) {
        this.prioritet = prioritet;
    }

    public Korisnik getIzvrsitelj() {
        return izvrsitelj;
    }

    public void setIzvrsitelj(Korisnik izvrsitelj) {
        this.izvrsitelj = izvrsitelj;
    }
}

