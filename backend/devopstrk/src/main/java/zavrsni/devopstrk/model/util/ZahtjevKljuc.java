package zavrsni.devopstrk.model.util;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;

@Embeddable
public class ZahtjevKljuc implements Serializable {

    private String idZahtjeva;

    private Timestamp datumKreiranja;

    public ZahtjevKljuc() {

    }

    public ZahtjevKljuc(String idZahtjeva, Timestamp datumKreiranja) {
        this.idZahtjeva = idZahtjeva;
        this.datumKreiranja = datumKreiranja;
    }

    public String getIdZahtjeva() {
        return idZahtjeva;
    }

    public void setIdZahtjeva(String idZahtjeva) {
        this.idZahtjeva = idZahtjeva;
    }

    public Timestamp getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Timestamp datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    @Override
    public int hashCode() {
        return idZahtjeva.hashCode() + datumKreiranja.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof ZahtjevKljuc)) {
            return false;
        }

        ZahtjevKljuc other = (ZahtjevKljuc) obj;
        return this.idZahtjeva.equals(other.idZahtjeva) && this.datumKreiranja.equals(other.datumKreiranja);
    }
}
