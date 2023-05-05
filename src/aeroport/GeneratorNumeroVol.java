package aeroport;

public class GeneratorNumeroVol {

    private String prefixe;

    private int id;

    public GeneratorNumeroVol(String prefixe) {
        this.prefixe = prefixe;
        this.id = 0;
    }

    public String next(){
        return prefixe + id++;
    }
    
}
