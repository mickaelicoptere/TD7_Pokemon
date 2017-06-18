package td;

/**
 * Created by shuwn on 30/05/2017.
 */
public class PokemonELECTRIQUE extends Pokemon {
    protected int pattes;
    protected int ailes;
    protected double intensite;

    public PokemonELECTRIQUE(String nom, double taille, double poids, int pv, int pc, TypesPokemon t){
        super(nom, taille, poids, pv, pc, TypesPokemon.ELECTRIQUE);
    }

    public void attaquer(Pokemon p) {
        switch (p.getType()) {
            case EAU:
                 p.pv -= 2 * this.pc;
                break;
            case FEU:
                 p.pv -= this.pc;
                break;
            case ELECTRIQUE:
                p.pv -= 0.5 * this.pc;
                break;
            case PLANTE:
                 p.pv -= 0.5 * this.pc;
                break;
        }
    }

    public String toString(){
        return super.toString()+" Ma vitesse est de "+this.calculVitesse()+" kilomètres/heures. J'ai "+this.getAiles()+" ailes et "+this.getPattes()+" pattes. Mon intensité est de  "+this.getIntensite()+" volt.";
    }


    public int getPattes() {
        return pattes;
    }

    public void setPattes(int pattes) {
        this.pattes = pattes;
    }

    public int getAiles() {
        return ailes;
    }

    public void setAiles(int ailes) {
        this.ailes = ailes;
    }

    public double getIntensite() {
        return intensite;
    }

    public double getVitesse(){
        double v = this.calculVitesse();
        return v;
    }


    public double calculVitesse(){
        return (pattes+ailes)*intensite*0.05;
    }

    public void setIntensite(double intensite) {
        this.intensite = intensite;
    }
}
