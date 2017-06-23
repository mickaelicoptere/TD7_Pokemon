package td;
//TODO FAIRE JAVADOC
import org.fusesource.jansi.Ansi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.fusesource.jansi.Ansi.ansi;
import static td.Partie.initPokemon;


/**
 * Created by shuwn on 12/06/2017.
 */
public class Joueurs {
    private String nom;
    private int niveau;
    private int nbpoints;
    public ArrayList<Pokemon> pokedex;

    Joueurs(String nom, int niveau, int nbpoints) {
        this.nom=nom;
        this.niveau=niveau;
        this.nbpoints=nbpoints;
        this.pokedex = new ArrayList<>();
    }

//        ArrayList<Pokemon> pokedex = new ArrayList<>();
//        for ( int i = 0; i < 10; i++ ) {
//                Collections.shuffle(initPokemon);
//                pokedex.add(i, initPokemon.get(i));
//                System.out.println("Pokemon n° : " + i + pokedex.get(i) + "\n");
//            }
////        this.pokedex = pokedex;
//    }
    
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

    public void defier(Joueurs adversaire){
        Random rand = new Random();
        int rndIndex1 = rand.nextInt(9);
        int rndIndex2 = rand.nextInt(9);
        Pokemon p1 = this.pokedex.get(rndIndex1);
        Pokemon p2 = adversaire.pokedex.get(rndIndex2);
        while (p2.isAlive() && p1.isAlive()) {
            System.out.println(ansi().fg(Ansi.Color.BLUE).a("Joueur 1 attaque ").reset());
            System.out.println(p1.getNom() + " " + p1.pv + "pv " + p1.pc + "pc attaque " + p2.getNom() + " " + p2.pv + "pv " + p2.pc + "pc !\n");
            p1.attaquer(p2);
            if(p2.isAlive()==false){
                System.out.println(ansi().fg(Ansi.Color.RED).a("\n" + "Le pokémon " + p1.getNom() + " a mis KO : " + p2.getNom() +"("+p2.pv+"pv"+")"+ " !!!\n").reset());
                System.out.println(ansi().fg(Ansi.Color.GREEN).a("Nouveau duel !").reset());
                break;
            }
            System.out.println(p2.getNom() + " a desormais " + p2.pv + "pv !\n");
            System.out.println(ansi().fg(Ansi.Color.YELLOW).a("Joueur 2 attaque ").reset());
            System.out.println(p2.getNom() + " " + p2.pv + "pv " + p2.pc + "pc attaque " + p1.getNom() + " " + p1.pv + "pv " + p1.pc + "pc !\n");
            p2.attaquer(p1);
            if(p1.isAlive()==false){
                System.out.println(ansi().fg(Ansi.Color.RED).a("\n" + "Le pokémon " + p2.getNom() + " a mis KO : " + p1.getNom()+ "("+p1.pv+"pv"+")" + " !!!\n").reset());
                System.out.println(ansi().fg(Ansi.Color.GREEN).a("Nouveau duel !").reset());
                break;
            }
            System.out.println(p1.getNom() + " a desormais " + p1.pv + "pv !\n");
        }
    }

    public void initPokedex(){
        for ( int i = 0; i < 10; i++ ) {
            Collections.shuffle(initPokemon);
            pokedex.add(i, initPokemon.get(i));
            System.out.println("Pokemon n° : " + i + pokedex.get(i) + "\n");
        }
    }

    public static int indexRandomPokemon(){
        Random rnd = new Random();
        int j = rnd.nextInt(10);
        return j;
    }

//    public String hasWon(){
//    }

}
