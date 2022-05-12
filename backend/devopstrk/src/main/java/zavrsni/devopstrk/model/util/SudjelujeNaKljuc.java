package zavrsni.devopstrk.model.util;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SudjelujeNaKljuc implements Serializable {

    @Column(name = "idkorisnika")
    Long idKorisnika;

    @Column(name = "idprojekta")
    Long idProjekta;

    public SudjelujeNaKljuc() {

    }

    public SudjelujeNaKljuc(Long idKorisnika, Long idProjekta) {
        this.idKorisnika = idKorisnika;
        this.idProjekta = idProjekta;
    }

    public Long getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Long idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public Long getIdProjekta() {
        return idProjekta;
    }

    public void setIdProjekta(Long idProjekta) {
        this.idProjekta = idProjekta;
    }

    @Override
    public int hashCode() {
        return idKorisnika.hashCode() + idProjekta.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof SudjelujeNaKljuc)) {
            return false;
        }

        SudjelujeNaKljuc other = (SudjelujeNaKljuc) obj;
        return this.idKorisnika.equals(other.idKorisnika) && this.idProjekta.equals(other.idProjekta);
    }
}
