package td;

/**
 * Created by shuwn on 30/05/2017.
 */
public class PokemonFEU extends Pokemon {
    protected int pattes;

    public PokemonFEU(String nom, double taille, double poids, int pv, int pc, TypesPokemon t) {
        super(nom, taille, poids, pv, pc, TypesPokemon.FEU);
    }

    public double calculVitesse(){
        return pattes * poids * 0.03;
    }

    public double getVitesse(){
        double v = this.calculVitesse();
        return v;
    }

    public int getPattes() {
        return pattes;
    }

    public void setPattes(int pattes) {
        this.pattes = pattes;
    }

    public void attaquer(Pokemon p) {
        switch (p.getType()) {
            case EAU:
                 p.pv -= 0.5 * this.pc;
                break;
            case FEU:
                 p.pv -= this.pc;
                break;
            case ELECTRIQUE:
                 p.pv -= 0.05 * this.pc;
                break;
            case PLANTE:
                 p.pv -= 2 * this.pc;
                break;
        }
    }

    public String toString(){
        return super.toString()+" Ma vitesse est de "+this.calculVitesse()+" kilomètres/heures "+"et j'ai "+this.getPattes()+" pattes.";
    }

}
