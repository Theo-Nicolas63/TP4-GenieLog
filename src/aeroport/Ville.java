package aeroport;

public class Ville {

    private String nom; 

     /** 
    * Constructeur de Ville
    *  
    * @param nom nom de la ville
    */
    public Ville(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Ville ){
            Ville v = (Ville) o;
            return this.nom.equals(v.getNom());
        }
        return false;
    }
}
