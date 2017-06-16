package td;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


/**
 * Created by shuwn on 12/06/2017.
 */
public class Joueurs {
    private String nom;
    private int niveau;
    private int nbpoints;
    ArrayList<Pokemon> pokedex;


    Joueurs(String nom, int niveau, int nbpoints) {
        this.nom=nom;
        this.niveau=niveau;
        this.nbpoints=nbpoints;
        pokedex = new ArrayList<>();

    }
    
    double vitesseMoyenne() {
        int nbpokemon;
        nbpokemon=pokedex.size();
        double vitesse = 0.0;
        double vmoy=0;
        double vtotal = 0.0;
        for (Pokemon p : pokedex ) {
           vitesse = p.getVitesse();
           vtotal += vitesse;
        }
        vmoy = vtotal/nbpokemon;
        return vmoy;
    }

    private int getNbPokemonOfType(String t) {
        int nbPokemonOfType = 0;
        for (Pokemon p : pokedex){
            if (p.typeToString(p.getType()).equals(t)) {
                nbPokemonOfType++;
            }
        }
        return nbPokemonOfType;
    }

    double vitesseMoyenneTYPE(String t) throws Exception {

        double vmoytype = 0;
        double vtotal = 0;
        for ( Pokemon p : pokedex ) {
            if (p.typeToString(p.getType()).equals(t)) {
                vtotal += p.getVitesse();
            }
        }
        vmoytype = vtotal / this.getNbPokemonOfType(t);
        return vmoytype;
    }

    public String toString (){
        return "\nNom : " + this.getNom() + "\nNiveau : " + this.getNiveau() + "\nNb Points : " + this.getNbpoints();
    }

    String getNom() {
        return nom;
    }

    void setNom(String nom) {
        this.nom = nom;
    }

    public int getNiveau() {
        return niveau;
    }

    void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    int getNbpoints() {
        return nbpoints;
    }

    void setNbpoints(int nbpoints) {
        this.nbpoints = nbpoints;
    }

    public ArrayList<Pokemon> getPokedex() {
        return pokedex;
    }

    public void setPokedex(ArrayList<Pokemon> pokedex) {
        this.pokedex = pokedex;
    }

    public void Attraper(Pokemon p){
        this.pokedex.add(p);
    }

    public void Transferer(Pokemon p){
        this.pokedex.remove(p);
    }

    void defier(Joueurs adversaire){
        Random rand = new Random();
        int pokJ1 = rand.nextInt(6);
        int pokJ2 = rand.nextInt(6);

        Pokemon p1 = this.pokedex.get(pokJ1);
        Pokemon p2 = adversaire.pokedex.get(pokJ2);
        System.out.println(p1.getNom()+" "+p1.pv+"pv "+p1.pc+"pc attaque "+p2.getNom()+" "+p2.pv+"pv "+p2.pc+"pc !");
        p1.attaquer(p2);
        System.out.println(p2.getNom()+" a desormais "+p2.pv+"pv !");
    }

}
