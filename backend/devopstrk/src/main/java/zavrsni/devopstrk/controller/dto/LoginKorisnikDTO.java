package zavrsni.devopstrk.controller.dto;

public class LoginKorisnikDTO {
    private String email;
    private String lozinka;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}
