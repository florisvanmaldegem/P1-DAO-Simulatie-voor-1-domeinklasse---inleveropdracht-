package Reiziger;

import java.sql.Date;

public class Reiziger {

    private String naam;
    private Date gbdatum;

    public Reiziger(String n, Date gbd){
        this.naam = n;
        this.gbdatum = gbd;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setGbdatum(Date gbdatum) {
        this.gbdatum = gbdatum;
    }

    public Date getGbdatum() {
        return gbdatum;
    }

    @Override
    public String toString() {
        return "Reiziger: " + this.naam + ", " + this.gbdatum.toString();
    }
}
