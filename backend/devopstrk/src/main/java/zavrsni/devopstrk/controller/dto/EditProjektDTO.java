package zavrsni.devopstrk.controller.dto;

public class EditProjektDTO {

    private String idProjekta;

    private String nazivProjekta;

    private String opisProjekta;

    private String datumPocetka;

    private String datumZavrsetka;

    private String idStanja;

    public String getIdProjekta() {
        return idProjekta;
    }

    public void setIdProjekta(String idProjekta) {
        this.idProjekta = idProjekta;
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

    public String getIdStanja() {
        return idStanja;
    }

    public void setIdStanja(String idStanja) {
        this.idStanja = idStanja;
    }
}
