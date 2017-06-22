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
            for(int i=0; i<20; i++) {
                System.out.println(ansi().fg(Ansi.Color.GREEN).a("Nouveau duel !").reset());
                j1.defier(j2);
            }
        }
    }
