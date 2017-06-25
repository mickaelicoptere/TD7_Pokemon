package td;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Virgile on 18/06/2017.
 * TU VOLES TU PAIES
 */
public class PokedexGUI extends Application {

    public static JFrame window;
    public static AnchorPane ap;


    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        try {
            Partie.initPartie();




            stage.initStyle(StageStyle.TRANSPARENT);
            ap = FXMLLoader.load(getClass().getResource("../Views/Pokedex.fxml"));
            ap.setStyle(
                    "-fx-background-color: rgba(255, 255, 255, 0);"
            );
            Scene scene = new Scene(ap, 900, 637);
            stage.setMaximized(true);
            stage.centerOnScreen();
            stage.setAlwaysOnTop(true);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            ap.setLayoutX(dim.width/4);
            ap.setLayoutY(dim.height/4);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);


            stage.show();

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }



    }
}