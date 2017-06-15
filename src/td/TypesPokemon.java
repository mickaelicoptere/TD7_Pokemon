package td;

/**
 * Created by shuwn on 30/05/2017.
 */
public enum TypesPokemon {

    EAU("Eau"),
    FEU("Feu"),
    ELECTRIQUE("Electrique"),
    PLANTE("Plante");

    private String description;

    TypesPokemon(String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }

}
