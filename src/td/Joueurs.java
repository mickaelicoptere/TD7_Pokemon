package td;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


/**
 * Created by shuwn on 12/06/2017.
 */
public class Joueurs {
    public String nom;
    public int niveau;
    public int nbpoints;
    public ArrayList<Pokemon> pokedex;
    public Random rand;


    public Joueurs (String nom, int niveau, int nbpoints) {
        this.nom=nom;
        this.niveau=niveau;
        this.nbpoints=nbpoints;
        pokedex = new ArrayList<Pokemon>();
        this.pokedex=pokedex;

    }
    
    public double vitesseMoyenne() {
        int nbpokemon;
        nbpokemon=pokedex.size();
        double vitesse=0;
        double vmoy=0;
        for (Pokemon p : pokedex ) {
           vitesse = p.getVitesse();
           vmoy = vitesse/nbpokemon;
        }
        return vmoy;
    }

    public double vitesseMoyenneTYPE(String t) throws Exception {
        int nbpokemon = pokedex.size();
        double vmoytype = 0;
        for ( Pokemon p : pokedex ) {
            if (p.getType().equals(t)) {
                vmoytype += p.getVitesse() / nbpokemon;
            }
        }
        return vmoytype;
    }

    public String toString (){
        return "\nNom : " + this.getNom() + "\nNiveau : " + this.getNiveau() + "\nNb Points : " + this.getNbpoints();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getNbpoints() {
        return nbpoints;
    }

    public void setNbpoints(int nbpoints) {
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

    public void attaquer(Joueurs adversaire){
        int pokJ1 = this.rand.nextInt(6);
        int pokJ2 = this.rand.nextInt(6);
        Pokemon p1 = this.pokedex.get(pokJ1);
        Pokemon p2 = j1.pokedex.get(pokJ2);
        p1.attaquer(p2);
    }

}
