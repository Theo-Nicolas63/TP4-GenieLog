package aeroport;

public class Saut {

    private Etape depart;

    private Etape arrivee;

    private Saut suivant;

    public Saut(Etape depart, Etape arrivee) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.suivant = null;
    }

    public Etape getDepart() {
        return depart;
    }

    public Etape getArrivee() {
        return arrivee;
    }

}
