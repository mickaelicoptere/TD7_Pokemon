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

        System.out.println(ansi().fg(Ansi.Color.BLUE).a("Joueur 1 : " + j1.toString() + "\n").reset());
        System.out.println(ansi().fg(Ansi.Color.YELLOW).a("Joueur 2 : " + j2.toString() + "\n").reset());

        j1.defier(j2);

        System.out.println(ansi().fg(Ansi.Color.BLUE).a("Morts chez le joueur 1 : " + Joueurs.mortj1).reset());
        Partie.printDeadPokemonsj1(j1);

        System.out.println(ansi().fg(Ansi.Color.YELLOW).a("\nMorts chez le joueur 2 : " + Joueurs.mortj2).reset());
        Partie.printDeadPokemonsj2(j2);

    }
}
