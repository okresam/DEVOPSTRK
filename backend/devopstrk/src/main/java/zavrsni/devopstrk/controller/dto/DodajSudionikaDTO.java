package zavrsni.devopstrk.controller.dto;

public class DodajSudionikaDTO {

    private String emailSudionika;

    private String idUlogeSudionika;

    private String idProjekta;

    public String getEmailSudionika() {
        return emailSudionika;
    }

    public void setEmailSudionika(String emailSudionika) {
        this.emailSudionika = emailSudionika;
    }

    public String getIdUlogeSudionika() {
        return idUlogeSudionika;
    }

    public void setIdUlogeSudionika(String idUlogeSudionika) {
        this.idUlogeSudionika = idUlogeSudionika;
    }

    public String getIdProjekta() {
        return idProjekta;
    }

    public void setIdProjekta(String idProjekta) {
        this.idProjekta = idProjekta;
    }
}
