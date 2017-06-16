package td;

import static org.junit.Assert.assertNotNull;
import org.junit.*;
import static org.junit.Assert.*;


/**
 * Created by Virgile on 12/06/2017.
 * TU VOLES TU PAIES
 */
public class PokemonTest {

    private PokemonFEU pFeu;
    private PokemonEAU pEau;
    private PokemonELECTRIQUE pElec;
    private PokemonPLANTE pPlante;

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


    public PokemonTest() {
    }

    @Before
    public void initialiser(){
        pFeu = new PokemonFEU("Salameche", 210.0, 81.5, 200, 70, TypesPokemon.FEU);
        pEau = new PokemonEAU("Caratchoin", 200, 60, 33, 65, TypesPokemon.EAU);
        pElec = new PokemonELECTRIQUE("Voltorbe", 102, 99.9, 500, 200, TypesPokemon.ELECTRIQUE);
        pPlante = new PokemonPLANTE("Groot", 400, 95.3, 98, 85, TypesPokemon.PLANTE);
        pEau.setNageoires(3);
        pFeu.setPattes(2);
        pElec.setAiles(2);

        j1p1 = new PokemonFEU("Dracofeu", 300, 200, 230, 70, TypesPokemon.FEU);
        j1p1.setPattes(3);
        j1p2 = new PokemonPLANTE("Herbizarre", 3.5, 150, 280, 300, TypesPokemon.PLANTE);
        j1p3 = new PokemonEAU("Tortank", 250, 150, 180, 700, TypesPokemon.EAU);
        j1p3.setNageoires(3);
        j1p4 = new PokemonELECTRIQUE("Electhor", 150, 100, 250, 400, TypesPokemon.ELECTRIQUE);
        j1p4.setAiles(5);
        j1p4.setIntensite(10.4);
        j1p5 = new PokemonFEU("Mickael", 190, 70, 230, 850, TypesPokemon.FEU);
        j1p5.setPattes(4);
        j1p6 = new PokemonFEU("Freundlich", 300, 20000, 23, 5, TypesPokemon.FEU);
        j1p6.setPattes(8);

        j2p1 = new PokemonFEU("Nekfeu", 300, 200, 230, 420, TypesPokemon.FEU);
        j2p2 = new PokemonPLANTE("Weedizar", 200, 420, 420, 300, TypesPokemon.PLANTE);
        j2p3 = new PokemonEAU("Torbong", 420, 150, 180, 420, TypesPokemon.EAU);
        j2p4 = new PokemonELECTRIQUE("Electehr", 150, 100, 250, 420, TypesPokemon.ELECTRIQUE);
        j2p5 = new PokemonFEU("Bulbeuhzar", 190, 70, 420, 850, TypesPokemon.FEU);
        j2p6 = new PokemonFEU("Shitiflor", 300, 420, 23, 5, TypesPokemon.FEU);

        j1 = new Joueurs("test", 3, 10);
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

    @After
    public void nettoyer() throws Exception {
        pEau = null;
        pElec = null;
        pFeu = null;
        pPlante = null;
    }

    @Test
    public void vitesseMoyenneCalcul() throws Exception {
        vmoy = j1.vitesseMoyenneTYPE("FEU");
        System.out.println(vmoy);
        System.out.println(j1p1.getVitesse());
        System.out.println(j1p5.getVitesse());
        System.out.println(j1p6.getVitesse());
    }

    @Test
    public void defier() {
        System.out.println(j2p1.getPv());
        System.out.println(j2p1.getNom()+j2p1.getType()+" Attaqué par "+j1p1.getNom()+j1p1.getType()+" avec Pc = "+j1p1.getPc());
        j1.defier(j2);
        System.out.println(j2p1.getPv());
    }

    @Test
    public void Pokemon() {
        assertNotNull("L'instance du pokemon(Eau) n'est pas crée", pEau);
        assertNotNull("L'instance du pokemon(Electrik) n'est pas crée", pElec);
        assertNotNull("L'instance du pokemon(Plante) n'est pas crée", pPlante);
        assertNotNull("L'instance du pokemon(Feu) n'est pas crée", pFeu);
    }

    @Test
    public void getNom() {
        assertEquals("Le nom est incorrect", "Salameche", pFeu.getNom());
    }
    @Test
    public void setNom() {
        pFeu.setNom("Feulminant");
        assertEquals("Le nom est incorrect", "Feulminant", pFeu.getNom());
    }

    @Test
    public void getType() {
        assertEquals("Le type est incorrect", TypesPokemon.FEU, pFeu.getType());
    }
    @Test
    public void setType() {
        pFeu.setType(TypesPokemon.EAU);
        assertEquals("Le type est incorrect", TypesPokemon.EAU, pFeu.getType());
    }

    @Test
    public void getPv() {
        assertEquals("Le nombre de pv est incorrect", 200, pFeu.getPv());
    }
    @Test
    public void setPv() {
        pFeu.setPv(100);
        assertEquals("Le nombre de pv est incorrect", 100, pFeu.getPv());
    }

    @Test
    public void getPc() {
        assertEquals("Le nombre de PC est incorrect", 70, pFeu.getPc());
    }
    @Test
    public void setPc() {
        pFeu.setPc(100);
        assertEquals("Le nombre de PC est incorrect", 100, pFeu.getPc());
    }

    @Test
    public void getPoids() {
        assertEquals("Le poids est incorrect", 80.5, pFeu.getPoids(), 2);
    }
    @Test
    public void setPoids() {
        pFeu.setPoids(10);
        assertEquals("Le poids est incorrect", 10, pFeu.getPoids(), 2);
    }

    @Test
    public void getTaille() {
        assertEquals("La taille est incorrect", 210, pFeu.getTaille(), 2);
    }
    @Test
    public void setTaille() {
        pFeu.setTaille(50);
        assertEquals("La taille est incorrect", 50, pFeu.getTaille(), 2);
    }

    @Test
    public void getPattes() {
        assertEquals("Le nombre de pattes est incorrect", 2, pFeu.getPattes());
    }
    @Test
    public void setPattes() {
        pFeu.setPattes(4);
        assertEquals("Le nombre de pattes est incorrect", 4, pFeu.getPattes());
    }

    @Test
    public void setNageoires() {
        pEau.setNageoires(3);
        assertEquals("Le nombre de nageoires est incorrect", 3, pEau.getNageoires());
    }

    @Test
    public void getNageoires() {
        assertEquals("Le nombre de nageoires est incorrect", 3, pEau.getNageoires());
    }

    @Test
    public void setAiles() {
        pElec.setAiles(2);
        assertEquals("Le nombre d'ailes est incorrect", 2, pElec.getAiles());
    }

    @Test
    public void getAiles() {
        assertEquals("Le nombre d'ailes est incorrect", 2, pElec.getAiles());
    }

    @Test
    public void getVitesse() {
        assertEquals("La vitesse est incorrecte", 10/(pPlante.getPoids()*pPlante.getTaille()), pPlante.getVitesse(), 2);
    }
    @Test
    public void setVitesse() {
        pPlante.setPoids(20);
        pPlante.calculVitesse();
        assertEquals("La vitesse est incorrecte", 10/(pPlante.getPoids()*pPlante.getTaille()), pPlante.getVitesse(), 2);
    }

    @Test
    public void attaquer(){
        int pv = pPlante.getPv();
        pFeu.attaquer(pPlante);
        assertEquals("L'attaque ne s'effectue pas correctement", pv-pFeu.getPc()*2, pPlante.getPv());
    }

}