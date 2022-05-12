package zavrsni.devopstrk.model;

import javax.persistence.*;

@Entity
@Table(name = "stanje")
public class Stanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idstanja")
    private Long idStanja;

    @Column(name = "nazivstanja", nullable = false)
    private String nazivStanja;

    public Stanje() {

    }

    public Stanje(String nazivStanja) {
        this.nazivStanja = nazivStanja;
    }

    public String getNazivStanja() {
        return this.nazivStanja;
    }

    public void setNazivStanja(String nazivStanja) {
        this.nazivStanja = nazivStanja;
    }

    public Long getIdStanja() {
        return this.idStanja;
    }
}
