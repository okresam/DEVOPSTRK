package zavrsni.devopstrk.model;

import javax.persistence.*;

@Entity
@Table(name = "prioritet")
public class Prioritet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprioriteta")
    private Long idPrioriteta;

    @Column(name = "nazivprioriteta", nullable = false)
    private String nazivPrioriteta;

    public Prioritet() {

    }

    public Prioritet(String nazivPrioriteta) {
        this.nazivPrioriteta = nazivPrioriteta;
    }

    public Long getIdPrioriteta() {
        return idPrioriteta;
    }

    public String getNazivPrioriteta() {
        return nazivPrioriteta;
    }

    public void setNazivPrioriteta(String nazivPrioriteta) {
        this.nazivPrioriteta = nazivPrioriteta;
    }
}
