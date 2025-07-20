package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.jsonParser.MazoParser;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mano;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mazo;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
//        var javaVersion = SystemInfo.javaVersion();
//        var javafxVersion = SystemInfo.javafxVersion();
//
//        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        var scene = new Scene(new StackPane(label), 640, 480);
//        stage.setScene(scene);
//        stage.setFullScreen(true);
//        stage.show();

        Mazo mazo = null;
        Mano mano = new Mano();
        try {
            mazo = generarMazo("mazo_jugador_uno");
            mano.agregarCarta(mazo.darCartas(10));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cargar el mazo: " + e.getMessage(), e);
        }

        VistaMano vistaMano = new VistaMano(mano);

        Scene scene = new Scene(vistaMano, 800, 200);
        stage.setScene(scene);
        stage.setTitle("Mano del Jugador");
        stage.show();

    }
    private static Mazo generarMazo(String mazoString) throws Exception {
        Mazo mazo;
        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(new FileReader("src/test/resources/json/gwent3.json"));

        JSONObject mazoJson = (JSONObject) root.get(mazoString);

        mazo = MazoParser.crearMazo(mazoJson);
        return mazo;
    }


    public static void main(String[] args) {
        launch();
    }

}