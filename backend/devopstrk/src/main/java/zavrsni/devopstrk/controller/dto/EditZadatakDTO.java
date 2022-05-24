package zavrsni.devopstrk.controller.dto;

import java.sql.Date;

public class EditZadatakDTO {

    private String idZadatka;

    private String nazivZadatka;

    private String opisZadatka;

    private Date rokIzvrsavanja;

    private String idVrsteZadatka;

    private String idPrioriteta;

    public String getIdZadatka() {
        return idZadatka;
    }

    public void setIdZadatka(String idZadatka) {
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

    public Date getRokIzvrsavanja() {
        return rokIzvrsavanja;
    }

    public void setRokIzvrsavanja(Date rokIzvrsavanja) {
        this.rokIzvrsavanja = rokIzvrsavanja;
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

}
