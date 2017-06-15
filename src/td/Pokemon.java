package td;

/**
 * Created by shuwn on 30/05/2017.
 */
public abstract class Pokemon {
    protected String nom;
    protected double taille;
    protected double poids;
    protected int pv;
    protected int pc;
    protected TypesPokemon type;

    public Pokemon(){
    }

    public Pokemon(String nom, double taille, double poids, int pv, int pc, TypesPokemon t) {
        this.type = t;
        this.nom=nom;
        this.taille=taille;
        this.poids=poids;
        this.pv=pv;
        this.pc=pc;
    }


        public boolean isAlive () {
            if (this.pv > 0){
                return true;
            }else if (this.pv < 0){
                return false;
            }
            return true;
        }

        public abstract void attaquer(Pokemon p);

    public String toString() {
        return "\nJe suis le Pokemon "+this.getNom()+" (type "+this.getType()+ ")."+" Mon poids est de "+this.getPoids();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public TypesPokemon getType() {
        return type;
    }

    public void setType(TypesPokemon type) {
        this.type = type;
    }

    public abstract double getVitesse();

    public abstract double calculVitesse();

}



