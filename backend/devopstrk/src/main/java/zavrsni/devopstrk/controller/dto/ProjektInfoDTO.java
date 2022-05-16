package zavrsni.devopstrk.controller.dto;

import zavrsni.devopstrk.model.Stanje;

public class ProjektInfoDTO {

    private Long idProjekta;

    private String nazivProjekta;

    private String opisProjekta;

    private String datumPocetka;

    private String datumZavrsetka;

    private Stanje stanje;

    private Long idVoditelja;

    public ProjektInfoDTO(Long idProjekta, String nazivProjekta, String opisProjekta, String datumPocetka, String datumZavrsetka, Stanje stanje, Long idVoditelja) {
        this.idProjekta = idProjekta;
        this.nazivProjekta = nazivProjekta;
        this.opisProjekta = opisProjekta;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.stanje = stanje;
        this.idVoditelja = idVoditelja;
    }

    public Long getIdProjekta() {
        return idProjekta;
    }

    public void setIdProjekta(Long idProjekta) {
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

    public Stanje getStanje() {
        return stanje;
    }

    public void setStanje(Stanje stanje) {
        this.stanje = stanje;
    }

    public Long getIdVoditelja() {
        return idVoditelja;
    }

    public void setIdVoditelja(Long idVoditelja) {
        this.idVoditelja = idVoditelja;
    }
}
