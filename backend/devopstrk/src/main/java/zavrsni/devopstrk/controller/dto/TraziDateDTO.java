package zavrsni.devopstrk.controller.dto;

import java.sql.Date;

public class TraziDateDTO {

    private String id;

    private Date datum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
