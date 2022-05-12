package zavrsni.devopstrk.model;

import javax.persistence.*;

@Entity
@Table(name = "uloga")
public class Uloga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduloge")
    private Long idUloge;

    @Column(name = "nazivuloge", nullable = false)
    private String nazivUloge;

    public Uloga() {

    }

    public Uloga(String nazivUloge) {
        this.nazivUloge = nazivUloge;
    }

    public Long getIdUloge() {
        return idUloge;
    }

    public String getNazivUloge() {
        return nazivUloge;
    }

    public void setNazivUloge(String nazivUloge) {
        this.nazivUloge = nazivUloge;
    }
}
