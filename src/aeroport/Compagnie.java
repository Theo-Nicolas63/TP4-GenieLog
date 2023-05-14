package aeroport;

import java.util.ArrayList;
import java.util.Collection;

public class Compagnie {

    private String name;

    private GeneratorNumeroVol generatorNumeroVol;

    private Collection<Vol> vols = new ArrayList<>();


    public Compagnie(String nom, String prefixe) {
        this.name = nom;
        this.generatorNumeroVol = new GeneratorNumeroVol(prefixe);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Vol> getVols() {
        return vols;
    }

    public GeneratorNumeroVol getGeneratorNumeroVol() {
        return generatorNumeroVol;
    }

    public void setVols(Collection<Vol> vols) {
        for(Vol v : this.vols){
            v.removeCompagnieWithBidirectional();
        }

        this.vols = vols;

        if(this.vols != null) {
            for (Vol v : this.vols) {
                v.setCompagnieWithBidirectional(this);
            }
        }
    }

    //pas utilisée
    public void removeVol(Vol vol){
        vol.setCompagnieWithoutBidirectional(null);
        this.vols.remove(vol);
    }

    //Pas utilisée
    protected void setVolsWithoutBidirectional(Collection<Vol> vols) {
        this.vols = vols;
    }

    //pas utilisée
    protected void addVolWithoutBidirectional(Vol vol){
        this.vols.add(vol);
    }

    //pas utilisée
    protected void removeVolWithoutBidirectional(Vol vol){
        this.vols.remove(vol);
    }

    // bidirectional
    public void removeVolWithBidirectional(Vol vol){
        this.vols.remove(vol);

        if(vol.getCompagnie() != null)
            vol.removeCompagnieWithBidirectional();
    }

    //Bidirectional
    public void addVolWithBidirectional(Vol vol){

        this.vols.add(vol);

        if(vol.getCompagnie() != this){
            vol.setCompagnieWithBidirectional(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Compagnie){
            Compagnie compagnie = (Compagnie) o;
            return this.name.equals(compagnie.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Compagnie " + this.name;
    }
}
