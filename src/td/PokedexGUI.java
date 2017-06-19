package td;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;
import static td.MotionPanel.isBetween;

/**
 * Created by Virgile on 18/06/2017.
 * TU VOLES TU PAIES
 */
public class PokedexGUI extends Application {

    public static JFrame window;
    public static JPanel scene;
    public static JList listePokemon;
    public static Stage primaryStage;
    private Point initialClick;
    public static AnchorPane ap;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {






        try {
            Point p = new Point(297, 47);
            Dimension d = new Dimension(293, 214);


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