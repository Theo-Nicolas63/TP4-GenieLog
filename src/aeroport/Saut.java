package aeroport;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;


public class Saut {

    private Etape depart;

    private Etape arrivee;

    private Saut suivant;

    public Saut(Aeroport depart, Aeroport arrivee, Date dateDepart, Date dateArrivee) {

        if(!dateDepart.before(dateArrivee))
            throw new IllegalArgumentException("La date de départ doit etre anterieure à la date d'arrivée");

        this.depart = new Etape(dateDepart, depart);
        this.arrivee = new Etape(dateArrivee, arrivee);
        this.suivant = null;
    }

    public Saut(Etape depart, Etape arrivee) {
        this.depart = depart;
        this.arrivee = arrivee;
    }

    public Etape getEtapeDepart() {
        return depart;
    }

    public Etape getEtapeArrivee() {
        return arrivee;
    }

    public Saut getSuivant() {
        return this.suivant;
    }

    public Saut getLastSaut(){
        Saut last = this;

        while(last.getSuivant() != null)
            last = last.getSuivant();
        
        return last;
    }

    // A VERIFIER
    public void ajouterSuivant(Saut suivant){
        this.suivant = suivant;
    }

    public List<Etape> getEtapesEscales() {
        List<Etape> escales = new ArrayList<Etape>();
        Saut suiv = this;

        while(suiv != null){
            
            if(suiv.getSuivant() != null)
                escales.add(suiv.getEtapeArrivee());

            suiv = suiv.getSuivant();
        }
        return escales;
    }

    //Ajoute une escale au milieu du dernier saut du vol
    public void ajouterEscale(Aeroport aeroportEscale, Date datearrivee, Date datedepart){
        Saut s = getLastSaut();
        Etape escale = new Etape(datearrivee, aeroportEscale);
        Saut suiv = new Saut(escale, s.arrivee);
        s.arrivee = escale;
        s.suivant = suiv;
    }

    public void setDateDepart(Date date){
        if(isDateDepartValid(date))
            depart.setDate(date);
    }

    public void setDateArrivee(Date date){
        if(isDateArriveeValid(date))
            arrivee.setDate(date);
    }

    //Vérifie si la nouvelle date de départ est bien anterieure à la date d'arrivée
    public boolean isDateDepartValid(Date date){
        return arrivee.getDate().after(date);
    }

    //Vérifie si la nouvelle date d'arrivée est bien après la date de départ
    public boolean isDateArriveeValid(Date date){
        return depart.getDate().before(date);
    }

}
