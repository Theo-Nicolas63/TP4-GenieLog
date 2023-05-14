package aeroport;

public class GeneratorNumeroVol {

    private String prefixe; // préfixe de la compagnie

    private int id; // dernier id

    public GeneratorNumeroVol(String prefixe) {
        this.prefixe = prefixe;
        this.id = 0;
    }

    // génère et retourne un nouveau numéro de vol
    public String next(){
        return prefixe + id++;
    }
    
}
