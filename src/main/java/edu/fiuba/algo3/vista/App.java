package edu.fiuba.algo3.vista;



import edu.fiuba.algo3.jsonParser.MazoParser;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mano;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mazo;
import edu.fiuba.algo3.modelo.gwent.Gwent;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Asedio;
import edu.fiuba.algo3.modelo.posicion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posicion.Distancia;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

/**
 * JavaFX App
 */
public class App extends Application {

    Jugador jugador1;
    Mazo mazoJ1;
    Mano manoJ1;

    Jugador jugador2;
    Mazo mazoJ2;
    Mano manoJ2;


    Gwent juego;

    @Override
    public void start(Stage stage) {

        generarJuego("Jugador 1", "Jugador 2");

        this.juego.repartirCartasALosJugadores();
        VistaMano vistaMano = new VistaMano(manoJ1);

        pantallaDeCambioDeCartas(stage, vistaMano);

    }

    private void generarJuego(String nombreJ1, String nombreJ2){

        Mazo mazoJ1 = null;
        Mazo mazoJ2 = null;
        Mano manoJ1 = new Mano();
        Mano manoJ2 = new Mano();
        try {
            mazoJ1 = generarMazo("mazo_jugador_uno");
            mazoJ2 = generarMazo("mazo_jugador_dos");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cargar el mazo: " + e.getMessage(), e);
        }
        Seccion cuerpoACuerpoJ1 = new Seccion(new CuerpoACuerpo());
        Seccion distanciaJ1 = new Seccion(new Distancia());
        Seccion asedioJ1 = new Seccion(new Asedio());
        Atril atrilJ1 = new Atril();
        atrilJ1.agregarSeccion(cuerpoACuerpoJ1);
        atrilJ1.agregarSeccion(distanciaJ1);
        atrilJ1.agregarSeccion(asedioJ1);
        Jugador jugador1 = new Jugador(mazoJ1, manoJ1, atrilJ1);
        Seccion cuerpoACuerpoJ2 = new Seccion(new CuerpoACuerpo());
        Seccion distanciaJ2 = new Seccion(new Distancia());
        Seccion asedioJ2 = new Seccion(new Asedio());
        Atril atrilJ2 = new Atril();
        atrilJ2.agregarSeccion(cuerpoACuerpoJ2);
        atrilJ2.agregarSeccion(distanciaJ2);
        atrilJ2.agregarSeccion(asedioJ2);

        Jugador jugador2 = new Jugador(mazoJ2, manoJ2, atrilJ2);

        Gwent juego = new Gwent(jugador1, jugador2);


        this.jugador1 = jugador1;
        this.manoJ1 = manoJ1;
        this.mazoJ1 = mazoJ1;

        this.jugador2 = jugador2;
        this.manoJ2 = manoJ2;
        this.mazoJ2 = mazoJ2;

        this.juego = juego;
        this.juego.setJugadorActual(jugador1);
    }

    private static Mazo generarMazo(String mazoString) throws Exception {
        Mazo mazo;
        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(new FileReader("src/test/resources/json/gwent3.json"));

        JSONObject mazoJson = (JSONObject) root.get(mazoString);

        mazo = MazoParser.crearMazo(mazoJson);
        return mazo;
    }



    private void pantallaDeCambioDeCartas(Stage stage, VistaMano vistaMano){
        VBox contenedor = new VBox(20);
        contenedor.setPadding(new Insets(400, 20, 40, 20));

        Button botonCambiar = new Button("Cambiar carta");
        botonCambiar.setStyle("-fx-font-size: 16px; -fx-padding: 10px 20px;");

        botonCambiar.setOnAction(e -> {
            Carta cartaParaCambiar = vistaMano.getCartaSeleccionada();
            if (cartaParaCambiar != null) {
                jugador1.cambiarCartaDeLaManoAlMazo(cartaParaCambiar);
            } else {
                System.out.println("Ninguna carta seleccionada.");
            }
        });

        contenedor.getChildren().addAll(vistaMano, botonCambiar);

        StackPane root = new StackPane(contenedor);
        Scene scene = new Scene(root, 800, 600);

        stage.setScene(scene);
        stage.setTitle("Cambiar cartas");
        stage.setFullScreen(true);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}