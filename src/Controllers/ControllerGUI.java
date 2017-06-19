package Controllers;

import java.awt.*;
import java.awt.event.MouseAdapter;

import com.jfoenix.controls.JFXListView;
import javafx.scene.input.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import t2s.son.LecteurTexte;
import td.Partie;
import td.PokedexGUI;
import td.Pokemon;

import javax.swing.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;

public class ControllerGUI implements Initializable {

    @FXML
    AnchorPane ap;
    @FXML
    private JFXListView<String> ListePokemon = new JFXListView<>();
    private Map<String, String> correspondanceNom = new HashMap<>();




    public Point initialClick;
    int nbPoke = Partie.increment;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Initialisation du controller");
        for(int i = 0; i < nbPoke; i++) {
            ListePokemon.getItems().add(Partie.correspondanceId.get(i).getNom());
            correspondanceNom.put(Partie.correspondanceId.get(i).getNom(), Partie.correspondanceId.get(i).toString());
        }
    }

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
    LecteurTexte lecteur = new LecteurTexte(str);
    lecteur.play();
    }

@FXML
void getInitialClick(MouseEvent event) {
        int xTemp = (int)Math.round(event.getX());
        int yTemp = (int)Math.round(event.getY());
        Point pTemp = new Point(xTemp, yTemp);
        initialClick = pTemp;
}


    public boolean isBetween(int a, int b, int c) throws Exception {
        return b > a ? c > a && c < b : c > b && c < a;
    }
}