package zavrsni.devopstrk.controller.dto;

public class ZahtjevInfoDTO {

    private String idZahtjeva;

    private String nazivZahtjeva;

    private String opisZahtjeva;

    private Long idVrsteZahtjeva;

    private String nazivVrsteZahtjeva;

    private Long idIzvora;

    private String emailIzvora;

    private String imeIzvora;

    private String prezimeIzvora;

    private String ulogaIzvora;

    public ZahtjevInfoDTO() {

    }

    public ZahtjevInfoDTO(String idZahtjeva, String nazivZahtjeva, String opisZahtjeva, Long idVrsteZahtjeva, String nazivVrsteZahtjeva, Long idIzvora, String emailIzvora, String imeIzvora, String prezimeIzvora, String ulogaIzvora) {
        this.idZahtjeva = idZahtjeva;
        this.nazivZahtjeva = nazivZahtjeva;
        this.opisZahtjeva = opisZahtjeva;
        this.idVrsteZahtjeva = idVrsteZahtjeva;
        this.nazivVrsteZahtjeva = nazivVrsteZahtjeva;
        this.idIzvora = idIzvora;
        this.emailIzvora = emailIzvora;
        this.imeIzvora = imeIzvora;
        this.prezimeIzvora = prezimeIzvora;
        this.ulogaIzvora = ulogaIzvora;
    }

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

    public Long getIdVrsteZahtjeva() {
        return idVrsteZahtjeva;
    }

    public void setIdVrsteZahtjeva(Long idVrsteZahtjeva) {
        this.idVrsteZahtjeva = idVrsteZahtjeva;
    }

    public String getNazivVrsteZahtjeva() {
        return nazivVrsteZahtjeva;
    }

    public void setNazivVrsteZahtjeva(String nazivVrsteZahtjeva) {
        this.nazivVrsteZahtjeva = nazivVrsteZahtjeva;
    }

    public Long getIdIzvora() {
        return idIzvora;
    }

    public void setIdIzvora(Long idIzvora) {
        this.idIzvora = idIzvora;
    }

    public String getEmailIzvora() {
        return emailIzvora;
    }

    public void setEmailIzvora(String emailIzvora) {
        this.emailIzvora = emailIzvora;
    }

    public String getImeIzvora() {
        return imeIzvora;
    }

    public void setImeIzvora(String imeIzvora) {
        this.imeIzvora = imeIzvora;
    }

    public String getPrezimeIzvora() {
        return prezimeIzvora;
    }

    public void setPrezimeIzvora(String prezimeIzvora) {
        this.prezimeIzvora = prezimeIzvora;
    }

    public String getUlogaIzvora() {
        return ulogaIzvora;
    }

    public void setUlogaIzvora(String ulogaIzvora) {
        this.ulogaIzvora = ulogaIzvora;
    }
}
