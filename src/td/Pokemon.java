package td;

/**
 * Created by shuwn on 30/05/2017.
 */
public abstract class Pokemon {
    String nom;
    double taille;
    double poids;
    int pv;
    int pc;
    private TypesPokemon type;
    private double vitesse;

    public Pokemon(){
    }

    Pokemon(String nom, double taille, double poids, int pv, int pc, TypesPokemon t) {
        this.type = t;
        this.nom=nom;
        this.taille=taille;
        this.poids=poids;
        this.pv=pv;
        this.pc=pc;
        this.vitesse=calculVitesse();
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
        return "\nJe suis le Pokemon "+this.getNom()+" (type "+this.getType()+ ")."+" Mon poids est de "+this.getPoids()+" kg. Ma taille est de "+getTaille()+" m. J'ai "+getPv()+" pv et "+getPc()+" pc.";
    }

    String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    double getPoids() {
        return poids;
    }

    void setPoids(double poids) {
        this.poids = poids;
    }

    int getPv() {
        return pv;
    }

    void setPv(int pv) {
        this.pv = pv;
    }

    int getPc() {
        return pc;
    }

    void setPc(int pc) {
        this.pc = pc;
    }

    TypesPokemon getType() {
        return type;
    }

    void setType(TypesPokemon type) {
        this.type = type;
    }

    public abstract double getVitesse();

    public abstract double calculVitesse();

    String typeToString(TypesPokemon t) {
        return String.valueOf(t);
    }

}



