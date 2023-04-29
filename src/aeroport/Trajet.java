package aeroport;

public class Trajet {

    private Saut saut;

    public Trajet(Saut saut) {
        this.saut = saut;
    }

    public Saut getSaut() {
        return saut;
    }

    public void setSaut(Saut saut) {
        this.saut = saut;
    }
}
