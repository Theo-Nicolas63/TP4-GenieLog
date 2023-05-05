import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import aeroport.*;
import reservation.*;

public class Start {

    public static void main(String[] args){

        //CREATION CLIENTS
        Client client = new Client("ABRAHAM", "1234567890", "1234567");
        Client client2 = new Client("BOUCHER", "1234567890", "1234567");
        Client client3 = new Client("DURAND", "1234567890", "1234567");


        //CREATION PASSAGERS
        Passager passager1 = new Passager("ABRAHAM", "Lincoln", "222222222222");
        Passager passager2 = new Passager("BIDEN", "Joe", "777777777777");
        Passager passager3 = new Passager("OBAMA", "Barack", "888888888888");
        Passager passager4 = new Passager("FORD", "Gerald", "999999999999");
        Passager passager5 = new Passager("CLINTON", "BILL", "111111111111");

        //CREATION VILLE
        Ville ville1 = new Ville("Paris");
        Ville ville2 = new Ville("Lyon");
        Ville ville3 = new Ville("Toulouse");
        Ville ville4 = new Ville("Clermont-Ferrand");
        Ville ville5 = new Ville("Albi");
        Ville ville6 = new Ville("Versaille");
        Ville ville7 = new Ville("Bordeaux");
        Ville ville8 = new Ville("Marseille");
        Ville ville9 = new Ville("New-York");

        //CREATION AEROPORT
        Aeroport a1 = new Aeroport("Charles de Gaulle", ville1, ZoneId.of("Europe/Paris"));
        Aeroport a2 = new Aeroport("Blagnac", ville3, ZoneId.of("Europe/Paris"));
        Aeroport a3 = new Aeroport("Saint-Exupéry", ville2, ZoneId.of("Europe/Paris"));
        Aeroport a4 = new Aeroport("Bordeaux-Mérignac", ville7, ZoneId.of("Europe/Paris"));
        Aeroport a5 = new Aeroport("JFK", ville9, ZoneId.of("America/New_York"));

        //CREATION COMPAGNIE
        Compagnie compagnie1 = new Compagnie("AIR France", "AF");
        Compagnie compagnie2 = new Compagnie("EASY JET", "EJ");
        Compagnie compagnie3 = new Compagnie("KLM", "KLM");
        Compagnie compagnie4 = new Compagnie("VOLOTEA", "VOL");

        //CREATION DATE 
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String ddS = "21/10/2020 13:00";
        String daS = "23/10/2020 02:15";
        String ddS1 = "22/10/2020 13:00";
        String daS1 = "22/10/2020 14:15";

        Date dd1 = null;
        Date da1 = null;
        Date dd2 = null;
        Date da2 = null;
        Date dd4 = null;
        Date da4 = null;

        try {
            dd1 = format.parse(ddS);
            da1 = format.parse(daS);
            da2 = format.parse(daS1);
            dd2 = format.parse(ddS1);

        } catch (Exception e){
            throw new RuntimeException("Unable to format to date");
        }
        //CREATION VOL    

        Vol volSimple = new Vol("AF1", a1, a2, dd1, dd2);
        volSimple.ajouterEscale(a3, da2, dd2);
        //volSimple.ajouterEscale(a3, d1, d2);

        System.out.println(volSimple.toString() + "\n");
        System.out.println("Durée : " + volSimple.obtenirDuree().toHours());

        //Bidirectional
        Vol vol = new Vol();
        vol.setNumero("abc1");

        Vol vol2 = new Vol();
        vol2.setNumero("abc2");

        Compagnie compagnie = new Compagnie();
        compagnie.setName("Air France");
        compagnie.addVol(vol);
        compagnie.addVol(vol2);

        for(Vol v : compagnie.getVols()){
            System.out.println(v.getNumero());
        }

        System.out.println(vol.getCompagnie().getName());
        System.out.println(vol2.getCompagnie().getName());

        vol2.setCompagnie(null);
        System.out.println(vol2.getCompagnie());

        for(Vol v : compagnie.getVols()){
            System.out.println(v.getNumero());
        }

        Reservation v1 = new Reservation(volSimple, compagnie);
    }
}
