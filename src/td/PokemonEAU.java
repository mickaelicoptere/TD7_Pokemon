package td;

/**
 * Created by shuwn on 30/05/2017.
 */
public class PokemonEAU extends Pokemon {
    protected int nageoires;


    public PokemonEAU(String nom, double taille, double poids, int pv, int pc, TypesPokemon t) {
        super(nom, taille, poids, pv, pc, TypesPokemon.EAU);
    }

    public double calculVitesse() {
        return (poids * nageoires) / 25;
    }

    public void attaquer(Pokemon p) {
        switch (p.getType()){
            case EAU:  p.pv-=0.5*this.pc;
                break;
            case FEU:  p.pv-=2*this.pc;
                break;
            case ELECTRIQUE: p.pv-=this.pc;
                break;
            case PLANTE:  p.pv-=0.5*this.pc;
                break;
        }
    }


    public double getVitesse(){
        double v = this.calculVitesse();
        return v;
    }

    public int getNageoires() {
        return nageoires;
    }

    public void setNageoires(int nageoires) {
        this.nageoires = nageoires;
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public void setTaille(double taille){
        this.taille=taille;
    }

    public String toString(){
        return super.toString()+"Mon poids est de "+this.getPoids()+", ma vitesse est de "+this.getVitesse()+"km/h. J'ai "+this.getNageoires()+", ma taille est de "+this.getTaille();
    }

}
