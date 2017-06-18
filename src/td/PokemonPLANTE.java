package td;

/**
 * Created by shuwn on 30/05/2017.
 */
public class PokemonPLANTE extends Pokemon {

    public PokemonPLANTE(String nom, double taille, double poids, int pv, int pc, TypesPokemon t){
        super(nom, taille, poids, pv, pc, TypesPokemon.PLANTE);
    }

    public double calculVitesse(){
        return 10/(poids*taille);
    }

    public double getVitesse(){
        double v = this.calculVitesse();
        return v;
    }

    public void attaquer(Pokemon p) {
        switch (p.getType()) {
            case EAU:
                 p.pv -= this.pc;
                break;
            case FEU:
                p.pv -= 0.5 * this.pc;
                break;
            case ELECTRIQUE:
                p.pv -= 2 * this.pc;
                break;
            case PLANTE:
                p.pv -= 0.5 * this.pc;
                break;
        }
    }

    public String toString(){
        return super.toString()+" Ma vitesse est de "+this.calculVitesse()+" kilomètres/heures.";
    }

}
