package Controllers;

import java.awt.*;
import com.jfoenix.controls.JFXListView;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import t2s.son.LecteurTexte;
import td.Partie;

public class ControllerGUI implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private JFXListView<String> ListePokemon = new JFXListView<>();
    private Map<String, String> correspondanceNom = new HashMap<>();
    @FXML
    private Text Description = new Text();




    private Point initialClick;
    private int nbPoke = Partie.increment;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Initialisation du controller");
        for(int i = 0; i < nbPoke; i++) {
            ListePokemon.getItems().add(Partie.correspondanceId.get(i).getNom());
            correspondanceNom.put(Partie.correspondanceId.get(i).getNom(), Partie.correspondanceId.get(i).toString());
        }
    }

    /**
     *
     * @param event étant l'évènement mouseDragging
     * @throws Exception
     *      Récupère les coordonnées lors du click initial grâce à la méthode initialClick, calcule le delta entre le click initial et l'endroit où l'on drag la souris,
     *      puis repositionne la fenêtre à l'endroit actuel de la fenêtre + ce delta.
     */
    @FXML
void drag(MouseEvent event) throws Exception {
        if ((isBetween(199, 692, initialClick.x)) && (isBetween(2, 38, initialClick.y))) {
            // get location of Window
            double thisX = ap.getLayoutX();
            double thisY = ap.getLayoutY();

            // Determine how much the mouse moved since the initial click
            double xMoved = (thisX + event.getX()) - (thisX + initialClick.x);
            double yMoved = (thisY + event.getY()) - (thisY + initialClick.y);

            // Move window to this position
            double X = thisX + xMoved;
            double Y = thisY + yMoved;
            ap.setLayoutX(X);
            ap.setLayoutY(Y);
        }
}

@FXML
void handleListeClicked() {
    String str = correspondanceNom.get(ListePokemon.getSelectionModel().getSelectedItem());
    Description.setText(str);
    LecteurTexte lecteur = new LecteurTexte(str);
    lecteur.play();
    }

    /**
     *
     * @param event
     *      Récupère l'event mouseClicked et stocke dans une variable pTemp les coordonnées du click pour les passer à la méthode drag
     */
    @FXML
void getInitialClick(MouseEvent event) {
        int xTemp = (int)Math.round(event.getX());
        int yTemp = (int)Math.round(event.getY());
        initialClick = new Point(xTemp, yTemp);
}


    private boolean isBetween(int a, int b, int c) throws Exception {
        return b > a ? c > a && c < b : c > b && c < a;
    }
}