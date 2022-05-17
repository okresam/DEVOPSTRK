package zavrsni.devopstrk.controller.dto;

public class CreateZahtjevDTO {

    private String idZahtjeva;

    private String nazivZahtjeva;

    private String opisZahtjeva;

    private String idVrsteZahtjeva;

    private String emailIzvora;

    private String idProjekta;

    public String getIdZahtjeva() {
        return idZahtjeva;
    }

    public void setIdZahtjeva(String idZahtjeva) {
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

    public String getIdVrsteZahtjeva() {
        return idVrsteZahtjeva;
    }

    public void setIdVrsteZahtjeva(String idVrsteZahtjeva) {
        this.idVrsteZahtjeva = idVrsteZahtjeva;
    }

    public String getEmailIzvora() {
        return emailIzvora;
    }

    public void setEmailIzvora(String emailIzvora) {
        this.emailIzvora = emailIzvora;
    }

    public String getIdProjekta() {
        return idProjekta;
    }

    public void setIdProjekta(String idProjekta) {
        this.idProjekta = idProjekta;
    }
}
