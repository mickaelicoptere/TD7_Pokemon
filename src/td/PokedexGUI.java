package td;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * Created by Virgile on 18/06/2017.
 * TU VOLES TU PAIES
 */
public class PokedexGUI {

    public static JFrame window;
    public static JPanel scene;

        public static void main(String[] args) {

            window = new JFrame("Pokedex");
            scene = new MotionPanel(window);

            window.setSize(900, 637);
            window.setLocationRelativeTo(null); //Centre la fenetre
            window.setResizable(false);
            window.setAlwaysOnTop(true);
            window.setContentPane(scene);
            window.setUndecorated(true);
            window.setBackground(new Color(0, 0, 0, 0));

            window.setVisible(true);



        }
    }

