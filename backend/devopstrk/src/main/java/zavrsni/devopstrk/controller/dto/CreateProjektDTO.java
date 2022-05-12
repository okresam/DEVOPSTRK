package zavrsni.devopstrk.controller.dto;

public class CreateProjektDTO {

    private String nazivProjekta;

    private String opisProjekta;

    private String datumPocetka;

    private String datumZavrsetka;

    private String emailVoditelja;

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

    public String getEmailVoditelja() {
        return emailVoditelja;
    }

    public void setEmailVoditelja(String emailVoditelja) {
        this.emailVoditelja = emailVoditelja;
    }
}
