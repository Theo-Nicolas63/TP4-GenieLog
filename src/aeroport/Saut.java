package aeroport;

import java.util.List;

public class Saut {

    private Etape depart;

    private Etape arrivee;

    private Saut suivant;

    public Saut(Etape depart, Etape arrivee) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.suivant = null;
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

}
