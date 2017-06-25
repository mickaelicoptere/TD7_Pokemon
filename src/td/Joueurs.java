package td;
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
    public static int mortj1=0;
    public static int mortj2=0;
    public static int boundj1 = 9;
    public static int boundj2 = 9;

    Joueurs(String nom, int niveau, int nbpoints) {
        this.nom=nom;
        this.niveau=niveau;
        this.nbpoints=nbpoints;
        this.pokedex = new ArrayList<>();
    }

//        ArrayList<Pokemon> pokedex = new ArrayList<>();
//        for ( int boundj1 = 0; boundj1 < 10; boundj1++ ) {
//                Collections.shuffle(initPokemon);
//                pokedex.add(boundj1, initPokemon.get(boundj1));
//                System.out.println("Pokemon n° : " + boundj1 + pokedex.get(boundj1) + "\n");
//            }
////        this.pokedex = pokedex;
//    }

    /**
     *
     * @return Une instance de la vitesse moyenne du pokedex du joueur
     */
    public double vitesseMoyenne() {
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

    /**
     *
     * @param t étant le type de pokemon dont on souhaite connaître le nombre d'instances
     * @return Un entier correspondant au nombre de pokemon de type t instanciés dans un pokedex
     */
    private int getNbPokemonOfType(String t) {
        int nbPokemonOfType = 0;
        for (Pokemon p : pokedex){
            if (p.typeToString(p.getType()).equals(t)) {
                nbPokemonOfType++;
            }
        }
        return nbPokemonOfType;
    }

    /**
     *
     * @param t étant le type de pokemon dont on souhaite obtenir la vitesse moyenne
     * @return Un double correspondant à la moyenne des vitesses des pokémons de type t d'un pokedex
     * @throws Exception
     */
    public double vitesseMoyenneTYPE(String t) throws Exception {

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


    /**
     *
     * @param j2 étant le joueur attaqué par le joueur this.
     *           L'algo instancie deux entiers i et j étant l'index du pokemon actuel de j1 et j2.
     *           Ces pokemon seront stockés dans les variables p1 et p2.
     *           Tant que j1 ou j2 a un pokemon en vie :
     *              Tant qu'un combat est en cours :
     *                  Un pokemon attaque l'autre selon leur vitesse. Si l'autre est toujours en vie, il réplique. Sinon,
     *                  on incrémente l'index de son pokemon actuel et on stocke ce dernier dans p1/p2.
     *                  On recommence la boucle jusqu'à ce qu'un joueur n'ait plus de pokemon.
     *                  On détermine lequel des deux a gagné.
     *          Un booléen j2HasSwitched est mis en place pour être sûr que j2 ne change pas de pokemon alors que j1 a déjà changé.
     */
    public void defier (Joueurs j2){
        int i = 0;
        int j = 0;
        int nbPokemonJ1 = 10;
        int nbPokemonJ2 = 10;
        boolean j2HasSwitched;

        Pokemon p1 = this.pokedex.get(i);
        Pokemon p2 = j2.pokedex.get(j);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        while(nbPokemonJ1 > 0 || nbPokemonJ2 > 0) {
            j2HasSwitched = false;
            System.out.println(p1.getNom()+" "+p1.getPv()+" pv et "+p1.getPc()+" pc attaque "+p2.getNom()+" "+p2.getPv()+" pv et "+p2.getPc()+" pc");
            while(p1.isAlive() && p2.isAlive()) {
                if(p1.getVitesse() > p2.getVitesse()) {
                    System.out.println(ansi().fg(Ansi.Color.BLUE).a("Joueur 1 attaque ").reset());
                    System.out.println(p1.getNom() + " " + p1.pv + "pv " + p1.pc + "pc attaque " + p2.getNom() + " " + p2.pv + "pv " + p2.pc + "pc !\n");
                    p1.attaquer(p2);
                    System.out.println(p2.getNom() + " a desormais " + p2.pv + "pv !\n");
                    if (p2.isAlive()) {
                        System.out.println(ansi().fg(Ansi.Color.YELLOW).a("Joueur 2 attaque ").reset());
                        System.out.println(p2.getNom() + " " + p2.pv + "pv " + p2.pc + "pc attaque " + p1.getNom() + " " + p1.pv + "pv " + p1.pc + "pc !\n");
                        p2.attaquer(p1);
                        System.out.println(p1.getNom() + " a desormais " + p1.pv + "pv !\n");
                    }
                } else if(p2.getVitesse() > p1.getVitesse()) {
                    p2.attaquer(p1);
                    if (p1.isAlive()) {
                        p1.attaquer(p2);
                    }
                }
            }
            if (p1.isAlive()) {
                System.out.println(ansi().fg(Ansi.Color.RED).a("\n" + "Le pokémon " + p1.getNom() + " " + p1.getPv() + " a mis KO : " + p2.getNom() +"("+p2.pv+"pv"+")"+ " !!!\n").reset());
                if(j == 9) {
                    System.out.println(this.getNom()+" a gagné");
                    return;
                }
                System.out.println(ansi().fg(Ansi.Color.GREEN).a("Nouveau duel !").reset());
                j++;
                p2 = j2.pokedex.get(j);
                nbPokemonJ2--;
                j2HasSwitched = true;
            } else if (p2.isAlive() && j2HasSwitched == false) {
                System.out.println(ansi().fg(Ansi.Color.RED).a("\n" + "Le pokémon " + p2.getNom() + " " + p2.getPv() + " a mis KO : " + p1.getNom()+ "("+p1.pv+"pv"+")" + " !!!\n").reset());
                if(i == 9) {
                    System.out.println(j2.getNom()+" a gagné");
                    return;
                }
                System.out.println(ansi().fg(Ansi.Color.GREEN).a("Nouveau duel !").reset());
                i++;
                p1 = this.pokedex.get(i);
                nbPokemonJ1--;
            }
        }

    }

//    public void defier(Joueurs adversaire){
//        Random rand = new Random();
//        int rndIndex1 = rand.nextInt(boundj1);
//        int rndIndex2 = rand.nextInt(boundj2);
//        Pokemon p1 = this.pokedex.get(rndIndex1);
//        Pokemon p2 = adversaire.pokedex.get(rndIndex2);
//
//        if(!p1.isAlive()) p1=selectAlivePokemon1(p1);
//        if(!p2.isAlive()) p2=selectAlivePokemon2(p2);
//
//        while (p2.isAlive() && p1.isAlive()) {

//            p1.attaquer(p2);
//            if(!p2.isAlive()){

//                boundj2--;
//                mortj2++;
//                break;
//            }

//            p2.attaquer(p1);
//            if(!p1.isAlive()){

//                boundj1--;
//                mortj1++;
//                break;
//            }
//        }
//    }

    /**
     * Mélange du pokedex grâce à la méthode shuffle, puis on instancie les 10 premiers pokemon dans le pokedex du joueur sur lequel on invoque la méthode.
     */

    public void initPokedex(){
        for ( int i = 0; i < 10; i++ ) {
            Collections.shuffle(initPokemon);
            pokedex.add(i, initPokemon.get(i));
            System.out.println("Pokemon n° : " + i + pokedex.get(i) + "\n");
        }
    }

//    public static int indexRandomPokemon(){
//        Random rnd = new Random();
//        int boundj2 = rnd.nextInt(10);
//        return boundj2;
//    }


//    public String hasWon(){
//    }


}
