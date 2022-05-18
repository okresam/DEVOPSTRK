package zavrsni.devopstrk.controller.dto;

import java.sql.Date;

public class CreateZadatakDTO {

    private String nazivZadatka;

    private String opisZadatka;

    private Date rokIzvrsavanja;

    private Date datumStvarnogIzvrsavanja;

    private String idZahtjeva;

    private String idProjekta;

    private String idVrsteZadatka;

    private String idPrioriteta;

    private String emailIzvrsitelja;

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

    public Date getRokIzvrsavanja() {
        return rokIzvrsavanja;
    }

    public void setRokIzvrsavanja(Date rokIzvrsavanja) {
        this.rokIzvrsavanja = rokIzvrsavanja;
    }

    public String getIdZahtjeva() {
        return idZahtjeva;
    }

    public void setIdZahtjeva(String idZahtjeva) {
        this.idZahtjeva = idZahtjeva;
    }

    public String getIdProjekta() {
        return idProjekta;
    }

    public void setIdProjekta(String idProjekta) {
        this.idProjekta = idProjekta;
    }

    public String getIdVrsteZadatka() {
        return idVrsteZadatka;
    }

    public void setIdVrsteZadatka(String idVrsteZadatka) {
        this.idVrsteZadatka = idVrsteZadatka;
    }

    public String getIdPrioriteta() {
        return idPrioriteta;
    }

    public void setIdPrioriteta(String idPrioriteta) {
        this.idPrioriteta = idPrioriteta;
    }

    public String getEmailIzvrsitelja() {
        return emailIzvrsitelja;
    }

    public void setEmailIzvrsitelja(String emailIzvrsitelja) {
        this.emailIzvrsitelja = emailIzvrsitelja;
    }

    public Date getDatumStvarnogIzvrsavanja() {
        return datumStvarnogIzvrsavanja;
    }

    public void setDatumStvarnogIzvrsavanja(Date datumStvarnogIzvrsavanja) {
        this.datumStvarnogIzvrsavanja = datumStvarnogIzvrsavanja;
    }
}
