package td;

import t2s.son.LecteurTexte;

import javafx.scene.control.ListView;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import td.PokedexGUI;

/**
 * Created by Virgile on 17/06/2017.
 * TU VOLES TU PAIES
 */
public class Partie extends PokedexGUI {



    private static Pokemon createPokemonOfType(String type, String nom, double taille, double poids, int pv, int pc, String[] pokeTemp) {
        switch (type) {
            case "Eau":
                PokemonEAU pokTempEau = new PokemonEAU(nom, taille, poids, pv, pc, TypesPokemon.EAU);
                if (pokeTemp.length > 6) {
                    pokTempEau.setNageoires(Integer.parseInt(pokeTemp[6]));
                }
                return pokTempEau;
            case "Feu":
                PokemonFEU pokTempFeu = new PokemonFEU(nom, taille, poids, pv, pc, TypesPokemon.FEU);
                if (pokeTemp.length > 6) {
                    pokTempFeu.setPattes(Integer.parseInt(pokeTemp[6]));
                }
                return pokTempFeu;
            case "Electrique":
                PokemonELECTRIQUE pokTempElec = new PokemonELECTRIQUE(nom, taille, poids, pv, pc, TypesPokemon.ELECTRIQUE);
                if (pokeTemp.length > 6) {
                    pokTempElec.setPattes(Integer.parseInt(pokeTemp[6]));
                    pokTempElec.setAiles(Integer.parseInt(pokeTemp[7]));
                    pokTempElec.setIntensite(Double.parseDouble(pokeTemp[8]));
                }
                return pokTempElec;
            case "Plante":
                PokemonPLANTE pokTempPlante = new PokemonPLANTE(nom, taille, poids, pv, pc, TypesPokemon.PLANTE);
                return pokTempPlante;
        }
        return null;
    }

    private static double doubleTemp[] = new double[10];
    private static int intTemp[] = new int[10];
    public static int increment;
    public static ArrayList<Pokemon> initPokemon;
    public static Map<Integer, Pokemon> correspondanceId = new HashMap<>();


    public static void initPartie() {

        String line = "";
        String splitBy = " ";
        initPokemon = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(new FileReader("ListePokemon.txt"))){
            while ((line = reader.readLine()) != null) {
                String[] pokeTemp = line.split(splitBy);
                for(int i = 2; i < 4; i++) {
                    doubleTemp[i] = Double.parseDouble(pokeTemp[i]);
//                    System.out.println(doubleTemp[i]);
                }
                for(int i = 4; i < 6; i++) {
                    intTemp[i] = Integer.parseInt(pokeTemp[i]);
//                    System.out.println(intTemp[i]);
                }
                String nTemp = pokeTemp[0];
                double dTemp1 = doubleTemp[2];
                double dTemp2 = doubleTemp[3];
                int iTemp1 = intTemp[4];
                int iTemp2 = intTemp[5];
                Pokemon pTemp = createPokemonOfType(pokeTemp[1], nTemp, dTemp1, dTemp2, iTemp1, iTemp2, pokeTemp);
                initPokemon.add(createPokemonOfType(pokeTemp[1], nTemp, dTemp1, dTemp2, iTemp1, iTemp2, pokeTemp));
                correspondanceId.put(increment, pTemp);
                increment++;

            }




        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
