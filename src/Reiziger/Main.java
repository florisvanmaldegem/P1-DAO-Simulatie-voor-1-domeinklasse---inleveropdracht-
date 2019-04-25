package Reiziger;


import java.sql.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {


    public static void main(String[] args){
        ReizigerOracleDaoImpl reizigerConnection = new ReizigerOracleDaoImpl();

        String[] names = {"Floris", "Lennart", "Poppy", "Esther", "Kiki", "Marco", "Test"};


        for(String name: names) {
            int randomYear = ThreadLocalRandom.current().nextInt(1990, 2010 + 1);
            int randomMonth = ThreadLocalRandom.current().nextInt(1, 12 + 1);
            int randomDay = ThreadLocalRandom.current().nextInt(1, 31 + 1);

            if (randomMonth % 2 == 0 && randomDay == 31) {
                randomDay = 30;
            }
            if (randomMonth == 2 && randomDay > 28) {
                randomDay = 28;
            }
            Date gbD = java.sql.Date.valueOf(String.format("%s-%s-%s", randomYear,randomMonth,randomDay));
            Reiziger reiziger = new Reiziger(name, gbD);
            System.out.println(reiziger.toString() + " wordt toegevoegd...");
            reizigerConnection.save(reiziger);
            System.out.println(reiziger.toString() + " is toegevoegd!");
            System.out.println();
        }


        /*
        CRUD TEST --1--
         */
        System.out.println("Vind de Reiziger met de naam Floris:");

        List<Reiziger> temp = reizigerConnection.findByName("Floris");
        for(Reiziger r : temp){
            System.out.println(r);
        }
        System.out.println();

        /*
        CRUD TEST --2--
         */
        System.out.println("Alle reizigers");
        temp = reizigerConnection.findAll();
        for(Reiziger r : temp){
            System.out.println(r);
        }
        System.out.println();

        /*
        CRUD TEST --3--
         */

        System.out.println("Verwijder test van de reizigers:");
        List<Reiziger> toRemoveL = reizigerConnection.findByName("test");
        toRemoveL.forEach(reizigerConnection::delete);

        System.out.println("Alle reizigers: ");
        temp = reizigerConnection.findAll();
        for(Reiziger r : temp){
            System.out.println(r);
        }
        System.out.println();
    }
}
