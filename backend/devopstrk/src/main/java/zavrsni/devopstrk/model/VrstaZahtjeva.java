package zavrsni.devopstrk.model;

import javax.persistence.*;

@Entity
@Table(name = "vrstazahtjeva")
public class VrstaZahtjeva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvrstezahtjeva")
    private Long idVrsteZahtjeva;

    @Column(name = "nazivvrstezahtjeva", nullable = false)
    private String nazivVrsteZahtjeva;

    public VrstaZahtjeva() {

    }

    public VrstaZahtjeva(String nazivVrsteZahtjeva) {
        this.nazivVrsteZahtjeva = nazivVrsteZahtjeva;
    }

    public Long getIdVrsteZahtjeva() {
        return idVrsteZahtjeva;
    }

    public String getNazivVrsteZahtjeva() {
        return nazivVrsteZahtjeva;
    }

    public void setNazivVrsteZahtjeva(String nazivVrsteZahtjeva) {
        this.nazivVrsteZahtjeva = nazivVrsteZahtjeva;
    }
}
