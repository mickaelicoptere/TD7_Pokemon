package td;

import static org.junit.Assert.assertNotNull;
import junit.framework.TestCase;
import org.junit.*;
import static org.junit.Assert.*;
import td.Pokemon;


/**
 * Created by Virgile on 12/06/2017.
 * TU VOLES TU PAIES
 */
public class PokemonTest {

    PokemonFEU pFeu;
    PokemonEAU pEau;
    PokemonELECTRIQUE pElec;
    PokemonPLANTE pPlante;

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
    }

    @After
    public void nettoyer() throws Exception {
        pEau = null;
        pElec = null;
        pFeu = null;
        pPlante = null;
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