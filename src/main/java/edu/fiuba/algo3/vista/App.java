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
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.*;
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
        VistaMano vistaManoJ1 = new VistaMano(manoJ1);
        VistaMano vistaManoJ2 = new VistaMano(manoJ2);

        pantallaDeCambioDeCartas(stage, vistaManoJ1, vistaManoJ2);

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

    private void pantallaDeCambioDeCartas(Stage stage, VistaMano vistaManoJ1, VistaMano vistaManoJ2) {
        final int MAX_CAMBIOS = 2;
        int[] cambiosJ1 = {0};
        int[] cambiosJ2 = {0};
        boolean[] pasoJ1 = {false};
        boolean[] pasoJ2 = {false};

        VBox seccionJ1 = new VBox(10);
        Label cambiosRestantesJ1 = new Label("Cambios restantes: 2");

        Button botonCambiarJ1 = new Button("Cambiar carta (Jugador 1)");
        botonCambiarJ1.setStyle("-fx-font-size: 14px; -fx-padding: 6px 12px;");

        Button botonPasarJ1 = new Button("Pasar cambios (Jugador 1)");
        botonPasarJ1.setStyle("-fx-font-size: 14px; -fx-padding: 6px 12px;");

        botonCambiarJ1.setOnAction(e -> {
            Carta cartaParaCambiar = vistaManoJ1.getCartaSeleccionada();
            if (cartaParaCambiar != null && cambiosJ1[0] < MAX_CAMBIOS && !pasoJ1[0]) {
                jugador1.cambiarCartaDeLaManoAlMazo(cartaParaCambiar);
                cambiosJ1[0]++;
                cambiosRestantesJ1.setText("Cambios restantes: " + (MAX_CAMBIOS - cambiosJ1[0]));
                if (cambiosJ1[0] == MAX_CAMBIOS) {
                    botonCambiarJ1.setDisable(true);
                    botonPasarJ1.setDisable(true);
                    pasoJ1[0] = true;
                    verificarSiTerminar(stage, pasoJ1[0], pasoJ2[0]);
                }
            }
        });

        botonPasarJ1.setOnAction(e -> {
            pasoJ1[0] = true;
            botonCambiarJ1.setDisable(true);
            botonPasarJ1.setDisable(true);
            cambiosRestantesJ1.setText("Cambios finalizados.");
            verificarSiTerminar(stage, pasoJ1[0], pasoJ2[0]);
        });

        seccionJ1.getChildren().addAll(vistaManoJ1, botonCambiarJ1, botonPasarJ1, cambiosRestantesJ1);
        seccionJ1.setPadding(new Insets(20));
        seccionJ1.setAlignment(Pos.CENTER);

        VBox seccionJ2 = new VBox(10);
        Label cambiosRestantesJ2 = new Label("Cambios restantes: 2");

        Button botonCambiarJ2 = new Button("Cambiar carta (Jugador 2)");
        botonCambiarJ2.setStyle("-fx-font-size: 14px; -fx-padding: 6px 12px;");

        Button botonPasarJ2 = new Button("Pasar cambios (Jugador 2)");
        botonPasarJ2.setStyle("-fx-font-size: 14px; -fx-padding: 6px 12px;");

        botonCambiarJ2.setOnAction(e -> {
            Carta cartaParaCambiar = vistaManoJ2.getCartaSeleccionada();
            if (cartaParaCambiar != null && cambiosJ2[0] < MAX_CAMBIOS && !pasoJ2[0]) {
                jugador2.cambiarCartaDeLaManoAlMazo(cartaParaCambiar);
                cambiosJ2[0]++;
                cambiosRestantesJ2.setText("Cambios restantes: " + (MAX_CAMBIOS - cambiosJ2[0]));
                if (cambiosJ2[0] == MAX_CAMBIOS) {
                    botonCambiarJ2.setDisable(true);
                    botonPasarJ2.setDisable(true);
                    pasoJ2[0] = true;
                    verificarSiTerminar(stage, pasoJ1[0], pasoJ2[0]);
                }
            }
        });

        botonPasarJ2.setOnAction(e -> {
            pasoJ2[0] = true;
            botonCambiarJ2.setDisable(true);
            botonPasarJ2.setDisable(true);
            cambiosRestantesJ2.setText("Cambios finalizados.");
            verificarSiTerminar(stage, pasoJ1[0], pasoJ2[0]);
        });

        seccionJ2.getChildren().addAll(vistaManoJ2, botonCambiarJ2, botonPasarJ2, cambiosRestantesJ2);
        seccionJ2.setPadding(new Insets(20));
        seccionJ2.setAlignment(Pos.CENTER);


        VBox contenedor = new VBox(50);
        contenedor.getChildren().addAll(seccionJ2, seccionJ1);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setStyle("-fx-background-color: #eee;");

        Scene scene = new Scene(new StackPane(contenedor), 1000, 800);
        stage.setScene(scene);
        stage.setTitle("Cambio de Cartas");
        stage.setFullScreen(true);
        stage.show();
    }

    private void verificarSiTerminar(Stage stage, boolean pasoJ1, boolean pasoJ2) {
        if (pasoJ1 && pasoJ2) {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmar");
            confirmacion.setHeaderText("¿Deseás finalizar los cambios?");
            confirmacion.setContentText("Una vez que salgas, no podrás cambiar más cartas.");

            ButtonType botonSi = new ButtonType("Sí");
            ButtonType botonNo = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
            confirmacion.getButtonTypes().setAll(botonSi, botonNo);

            confirmacion.showAndWait().ifPresent(respuesta -> {
                if (respuesta == botonSi) {
                    stage.close();
                }
            });
        }
    }



    public static void main(String[] args) {
        launch();
    }

}