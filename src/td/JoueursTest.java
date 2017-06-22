package td;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by shuwn on 12/06/2017.
 */

class JoueursTest {

    private PokemonFEU j1p1;
    private PokemonPLANTE j1p2;
    private PokemonEAU j1p3;
    private PokemonELECTRIQUE j1p4;
    private PokemonFEU j1p5;
    private PokemonFEU j1p6;

    private PokemonFEU j2p1;
    private PokemonPLANTE j2p2;
    private PokemonEAU j2p3;
    private PokemonELECTRIQUE j2p4;
    private PokemonFEU j2p5;
    private PokemonFEU j2p6;

    private Joueurs j1;
    private Joueurs j2;

    private double vmoy;

    public JoueursTest() {
    }

    @Before
    public void initialiser(){

        j1p1 = new PokemonFEU("Dracofeu", 300, 200, 230, 500, TypesPokemon.FEU);
        j1p2 = new PokemonPLANTE("Herbizarre", 200, 300, 280, 300, TypesPokemon.PLANTE);
        j1p3 = new PokemonEAU("Tortank", 250, 150, 180, 700, TypesPokemon.EAU);
        j1p4 = new PokemonELECTRIQUE("Electhor", 150, 100, 250, 400, TypesPokemon.ELECTRIQUE);
        j1p5 = new PokemonFEU("Mickael", 190, 70, 230, 850, TypesPokemon.FEU);
        j1p6 = new PokemonFEU("Freundlich", 300, 20000, 23, 5, TypesPokemon.FEU);

        j2p1 = new PokemonFEU("Nekfeu", 300, 200, 230, 420, TypesPokemon.FEU);
        j2p2 = new PokemonPLANTE("Weedizar", 200, 420, 420, 300, TypesPokemon.PLANTE);
        j2p3 = new PokemonEAU("Torbong", 420, 150, 180, 420, TypesPokemon.EAU);
        j2p4 = new PokemonELECTRIQUE("Electehr", 150, 100, 250, 420, TypesPokemon.ELECTRIQUE);
        j2p5 = new PokemonFEU("Bulbeuhzar", 190, 70, 420, 850, TypesPokemon.FEU);
        j2p6 = new PokemonFEU("Shitiflor", 300, 420, 23, 5, TypesPokemon.FEU);

        j1 = new Joueurs("Virgile", 4, 69);
        j2 = new Joueurs("Mickael", 4, 420);

        j1.pokedex.add(j1p1);
        j1.pokedex.add(j1p2);
        j1.pokedex.add(j1p3);
        j1.pokedex.add(j1p4);
        j1.pokedex.add(j1p5);
        j1.pokedex.add(j1p6);

        j2.pokedex.add(j2p1);
        j2.pokedex.add(j2p2);
        j2.pokedex.add(j2p3);
        j2.pokedex.add(j2p4);
        j2.pokedex.add(j2p5);
        j2.pokedex.add(j2p6);

    }



    @Test
    void vitesseMoyenne() {
        vmoy = j1.vitesseMoyenne();
        System.out.println(vmoy);
    }

    @Test
    void vitesseMoyenneTYPE(String t) throws Exception {
        j1.vitesseMoyenneTYPE("EAU");
        assertEquals("La vitesse moyenne du type est incorrecte", TypesPokemon.EAU, j1.vitesseMoyenneTYPE("EAU") );
    }

    @Test
    void getNom() {
        assertEquals("Le nom est incorrect", "Virgile", j1.getNom());
    }

    @Test
    void setNom() {
        j1.setNom("LeSang");
        assertEquals("Le nom est incorrect", "LeSang", j1.getNom());
    }

    @Test
    void getNiveau() {
        assertEquals("Le niveau est incorrect", 4, j1.getNiveau());
    }

    @Test
    void setNiveau() {
        j1.setNiveau(7);
        assertEquals("Le niveau est incorrect", 7, j1.getNiveau());
    }

    @Test
    void getNbpoints() {
        assertEquals("Le nombre de points est incorrect",420, j2.getNiveau());
    }

    @Test
    void setNbpoints() {
        j1.setNbpoints(666);
        assertEquals("Le nb de points est incorrect", 666, j1.getNbpoints());
    }

    @Test
    void Attraper() {
        j1.pokedex.add(j2p1);
        assertEquals("Le pokémon attrapé est incorrect", j2p1, j1.pokedex.get(7));
    }

    @Test
    void transferer() {
        j2.pokedex.remove(1);
        assertEquals("Le pokémon supprimé est incorrect", j2p1, j1.pokedex.get(1));
    }

    @Test
    void attaquer() {

    }


}