package zavrsni.devopstrk.model;

import javax.persistence.*;

@Entity
@Table(name = "vrstazadatka")
public class VrstaZadatka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvrstezadatka")
    private Long idVrsteZadatka;

    @Column(name = "nazivvrstezadatka", nullable = false)
    private String nazivVrsteZadatka;

    public VrstaZadatka() {

    }

    public VrstaZadatka(String nazivVrsteZadatka) {
        this.nazivVrsteZadatka = nazivVrsteZadatka;
    }

    public Long getIdVrsteZadatka() {
        return idVrsteZadatka;
    }

    public String getNazivVrsteZadatka() {
        return nazivVrsteZadatka;
    }

    public void setNazivVrsteZadatka(String nazivVrsteZadatka) {
        this.nazivVrsteZadatka = nazivVrsteZadatka;
    }
}
