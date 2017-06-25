package td;

import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.ansi;

public class Main  {

    public static void main(String[] args) {
        Joueurs j1 = new Joueurs("Mickaelicoptere", 7, 420);
        Joueurs j2 = new Joueurs("Virgilet de sauvetage", 8, 666);

        Partie.initPartie();
        j1.initPokedex();
        j2.initPokedex();

        System.out.println(ansi().fg(Ansi.Color.BLUE).a("Joueur 1 : "+j1.toString()+"\n").reset());
        System.out.println(ansi().fg(Ansi.Color.YELLOW).a("Joueur 2 : "+j2.toString()+"\n").reset());

//            while ( Joueurs.mortj1 <10 && Joueurs.mortj2 < 10){
                j1.defier(j2);
//            }
        System.out.println("Morts chez le joueur 1 : " + Joueurs.mortj1 + "Morts chez le joueur 2 : " + Joueurs.mortj2);
        }
    }
