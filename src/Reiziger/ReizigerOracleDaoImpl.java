package Reiziger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaoImpl implements ReizigerDAO {

    private ArrayList<Reiziger> reizigers;

    public ReizigerOracleDaoImpl(){
        this.reizigers = new ArrayList<>();
    }

    @Override
    public ArrayList<Reiziger> findAll() {
        return this.reizigers;
    }

    @Override
    public List<Reiziger> findByGbDatum(String gbDatum) {
        ArrayList<Reiziger> rl = new ArrayList<>();

        for(Reiziger r : this.reizigers){
            if(r.getGbdatum().equals(java.sql.Date.valueOf(gbDatum))){
                rl.add(r);
            }
        }
        return rl;
    }

    @Override
    public List<Reiziger> findByName(String naam) {
        ArrayList<Reiziger> rl = new ArrayList<>();

        for(Reiziger r : this.reizigers){
            if(r.getNaam().toUpperCase().equals(naam.toUpperCase())){
                rl.add(r);
            }
        }

        return rl;
    }

    @Override
    public Reiziger save(Reiziger reiziger) {
        if(!this.reizigers.contains(reiziger)) {
            this.reizigers.add(reiziger);
        }

        return reiziger;
    }

    @Override
    public Boolean delete(Reiziger reiziger) {
        if(this.reizigers.contains(reiziger)){
            this.reizigers.remove(reiziger);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Reiziger update(Reiziger reiziger){
        for(Reiziger r : this.reizigers){
            if(r.equals(reiziger)){
                return r;
            }
        }
        return new Reiziger("naam", java.sql.Date.valueOf(LocalDate.now()));
    }

    @Override
    public void closeConnection() {
        this.reizigers = new ArrayList<Reiziger>();
        System.out.println("closed connection");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alle reizigers: ");
        for(Reiziger r : this.reizigers){
            sb.append("\t").append(r.toString());
        }
        return sb.toString();
    }
}
