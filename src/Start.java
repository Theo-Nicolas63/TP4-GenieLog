import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import aeroport.Aeroport;
import aeroport.Compagnie;
import aeroport.Vol;

public class Start {

    public static void main(String[] args){
        /*Vol volFinal = new Vol();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String dd = "21/10/2020 13:00";
        String da = "23/10/2020 02:15";

        try {
            volFinal.setDateDepart(format.parse(dd));
            volFinal.setDateArrivee(format.parse(da));
        } catch (Exception e){
            throw new RuntimeException("Unable to format to date");
        }
        */
       //System.out.println(volFinal.getDateArrivee());
        //System.out.println(volFinal.obtenirDuree().toString().substring(2));

        //CREATION VOL SIMPLE
        Aeroport a1 = new Aeroport("Charles de Gaulle", "Paris");
        Aeroport a2 = new Aeroport("Blagnac", "Toulouse");
        Aeroport a3 = new Aeroport("Saint-Exupéry", "Lyon");
        ZonedDateTime d1 = ZonedDateTime.of(2023, 6, 12, 0, 0, 0, 0, ZoneId.of("Europe/Paris"));
        ZonedDateTime d2 = ZonedDateTime.of(2023, 6, 12, 13, 0, 0, 0, ZoneId.of("Europe/Paris"));
        ZonedDateTime d3 = ZonedDateTime.of(2023, 6, 12, 0, 0, 0, 0, ZoneId.of("America/New_York"));

        Vol volSimple = new Vol("AF1", a1, a2, d1, d2);
        volSimple.ajouterEscale(a3, d1, d2);
        volSimple.ajouterEscale(a3, d1, d2);

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
    }
}
