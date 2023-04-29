package aeroport;

import java.util.List;

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

    public Saut getLastSaut(){
        return saut.getLastSaut();
    }

    public List<Etape> getEscales(){
        return saut.getEtapesEscales();
    }
}
