package zavrsni.devopstrk.controller.dto;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long idKorisnika;
    private String ime;
    private String prezime;
    private String email;

    public JwtResponse(String accessToken, Long idKorisnika, String ime, String prezime, String email) {
        this.token = accessToken;
        this.idKorisnika = idKorisnika;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Long idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
