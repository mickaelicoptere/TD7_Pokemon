import static org.junit.Assert.*;
import org.junit.*;
import pokemon.*;

public class testPokemon {
	PokemonFeu pokeFeu;
	PokemonEau pokeEau;
	PokemonElectrik pokeElec;
	PokemonPlante pokePlant;
	
	@Before
	public void initialiser(){
		pokeFeu = new PokemonFeu("Dracofeu", 200, 70, 80.5, 210, 2);
		pokeEau = new PokemonEau("Magicarpe", 150, 45, 30.2, 42, 4);
		pokeElec = new PokemonElectrik("Voltia", 220, 60, 50, 50, 0, 2);
		pokePlant = new PokemonPlante("Bulbizar", 175, 75, 65, 80.2, 4);
	}
	
	@After
	public void nettoyer() throws Exception {
		pokeEau = null;
		pokeElec = null;
		pokeFeu = null;
		pokePlant = null;
	}
	
	@Test
	public void pokemon() {
		assertNotNull("L'instance du pokemon(Eau) n'est pas crée", pokeEau);
		assertNotNull("L'instance du pokemon(Electrik) n'est pas crée", pokeElec);
		assertNotNull("L'instance du pokemon(Plante) n'est pas crée", pokePlant);
		assertNotNull("L'instance du pokemon(Feu) n'est pas crée", pokeFeu);
	}
	
	@Test
	public void getNom() {
		assertEquals("Le nom est incorrect", "Dracofeu", pokeFeu.getNom());
	}
	@Test
	public void setNom() {
		pokeFeu.setNom("Feulminant");
		assertEquals("Le nom est incorrect", "Feulminant", pokeFeu.getNom());
	}
	
	@Test
	public void getType() {
		assertEquals("Le type est incorrect", "FEU", pokeFeu.getType());
	}
	@Test
	public void setType() {
		pokeFeu.setType("EAU");
		assertEquals("Le type est incorrect", "EAU", pokeFeu.getType());
	}
	
	@Test
	public void getPv() {
		assertEquals("Le nombre de pv est incorrect", 200, pokeFeu.getPv());
	}
	@Test
	public void setPv() {
		pokeFeu.setPv(100);
		assertEquals("Le nombre de pv est incorrect", 100, pokeFeu.getPv());
	}
	
	@Test
	public void getPc() {
		assertEquals("Le nombre de PC est incorrect", 70, pokeFeu.getPc());
	}
	@Test
	public void setPc() {
		pokeFeu.setPc(100);
		assertEquals("Le nombre de PC est incorrect", 100, pokeFeu.getPc());
	}
	
	@Test
	public void getPoids() {
		assertEquals("Le poids est incorrect", 80.5, pokeFeu.getPoids(), 2);
	}
	@Test
	public void setPoids() {
		pokeFeu.setPoids(10);
		assertEquals("Le poids est incorrect", 10, pokeFeu.getPoids(), 2);
	}
	
	@Test
	public void getTaille() {
		assertEquals("La taille est incorrect", 210, pokeFeu.getTaille(), 2);
	}
	@Test
	public void setTaille() {
		pokeFeu.setTaille(50);
		assertEquals("La taille est incorrect", 50, pokeFeu.getTaille(), 2);
	}
	
	@Test
	public void getNbPattes() {
		assertEquals("Le nombre de pattes est incorrect", 2, pokeFeu.getNbPattes());
	}
	@Test
	public void setNbPattes() {
		pokeFeu.setNbPattes(4);
		assertEquals("Le nombre de pattes est incorrect", 4, pokeFeu.getNbPattes());
	}
	
	@Test
	public void getNbNageoires() {
		assertEquals("Le nombre de nageoires est incorrect", 4, pokeEau.getNbNageoires());
	}
	@Test
	public void setNbNageoires() {
		pokeEau.setNbNageoires(3);
		assertEquals("Le nombre de nageoires est incorrect", 3, pokeEau.getNbNageoires());
	}
	
	@Test
	public void getNbAiles() {
		assertEquals("Le nombre d'ailes est incorrect", 2, pokeElec.getNbAiles());
	}
	@Test
	public void setNbAiles() {
		pokeElec.setNbAiles(6);
		assertEquals("Le nombre d'ailes est incorrect", 6, pokeElec.getNbAiles());
	}
	
	@Test
	public void getVitesse() {
		assertEquals("La vitesse est incorrecte", 10/(pokePlant.getPoids()*pokePlant.getTaille()), pokePlant.getVitesse(), 2);
	}
	@Test
	public void setVitesse() {
		pokePlant.setPoids(20);
		pokePlant.calculerVitesse();
		assertEquals("La vitesse est incorrecte", 10/(pokePlant.getPoids()*pokePlant.getTaille()), pokeEau.getVitesse(), 2);
	}
	
	@Test
	public void attaque(){
		int pv = pokePlant.getPv();
		pokeFeu.attaquer(pokePlant);
		assertEquals("L'attaque ne s'effectue pas correctement", pv-pokeFeu.getPc()*2, pokePlant.getPv());
	}
}
