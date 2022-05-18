package zavrsni.devopstrk.controller.dto;

import zavrsni.devopstrk.model.Prioritet;
import zavrsni.devopstrk.model.Stanje;
import zavrsni.devopstrk.model.VrstaZadatka;

import java.sql.Date;

public class ZadatakInfoDTO {
    private Long idZadatka;

    private String nazivZadatka;

    private String opisZadatka;

    private Date datumStvaranjaZadatka;

    private Date rokIzvrsavanja;

    private Date datumStvarnogIzvrsavanja;

    private VrstaZadatka vrstaZadatka;

    private Stanje stanje;

    private Prioritet prioritet;

    private Long idIzvrsitelja;

    private String imeIzvrsitelja;

    private String prezimeIzvrsitelja;

    private String ulogaIzvrsitelja;

    public ZadatakInfoDTO() {

    }

    public ZadatakInfoDTO(Long idZadatka, String nazivZadatka, String opisZadatka, Date datumStvaranjaZadatka, Date rokIzvrsavanja, Date datumStvarnogIzvrsavanja, VrstaZadatka vrstaZadatka, Stanje stanje, Prioritet prioritet, Long idIzvrsitelja, String imeIzvrsitelja, String prezimeIzvrsitelja, String ulogaIzvrsitelja) {
        this.idZadatka = idZadatka;
        this.nazivZadatka = nazivZadatka;
        this.opisZadatka = opisZadatka;
        this.datumStvaranjaZadatka = datumStvaranjaZadatka;
        this.rokIzvrsavanja = rokIzvrsavanja;
        this.datumStvarnogIzvrsavanja = datumStvarnogIzvrsavanja;
        this.vrstaZadatka = vrstaZadatka;
        this.stanje = stanje;
        this.prioritet = prioritet;
        this.idIzvrsitelja = idIzvrsitelja;
        this.imeIzvrsitelja = imeIzvrsitelja;
        this.prezimeIzvrsitelja = prezimeIzvrsitelja;
        this.ulogaIzvrsitelja = ulogaIzvrsitelja;
    }

    public Long getIdZadatka() {
        return idZadatka;
    }

    public void setIdZadatka(Long idZadatka) {
        this.idZadatka = idZadatka;
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

    public Long getIdIzvrsitelja() {
        return idIzvrsitelja;
    }

    public void setIdIzvrsitelja(Long idIzvrsitelja) {
        this.idIzvrsitelja = idIzvrsitelja;
    }

    public String getImeIzvrsitelja() {
        return imeIzvrsitelja;
    }

    public void setImeIzvrsitelja(String imeIzvrsitelja) {
        this.imeIzvrsitelja = imeIzvrsitelja;
    }

    public String getPrezimeIzvrsitelja() {
        return prezimeIzvrsitelja;
    }

    public void setPrezimeIzvrsitelja(String prezimeIzvrsitelja) {
        this.prezimeIzvrsitelja = prezimeIzvrsitelja;
    }

    public String getUlogaIzvrsitelja() {
        return ulogaIzvrsitelja;
    }

    public void setUlogaIzvrsitelja(String ulogaIzvrsitelja) {
        this.ulogaIzvrsitelja = ulogaIzvrsitelja;
    }
}
