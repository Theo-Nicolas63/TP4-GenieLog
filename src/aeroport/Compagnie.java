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
            v.setCompagnieWithoutBidirectional(null);
        }

        this.vols = vols;

        if(this.vols != null) {
            for (Vol v : this.vols) {
                v.setCompagnieWithoutBidirectional(this);
            }
        }
    }

    public void addVol(Vol vol){
        vol.setCompagnieWithoutBidirectional(this);
        this.vols.add(vol);
    }

    public void removeVol(Vol vol){
        vol.setCompagnieWithoutBidirectional(null);
        this.vols.remove(vol);
    }


    protected void setVolsWithoutBidirectional(Collection<Vol> vols) {
        this.vols = vols;
    }

    protected void addVolWithoutBidirectional(Vol vol){
        this.vols.add(vol);
    }

    protected void removeVolWithoutBidirectional(Vol vol){
        this.vols.remove(vol);
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Compagnie){
            Compagnie compagnie = (Compagnie) o;
            return this.name.equals(compagnie.name);
        }
        return false;
    }
}
