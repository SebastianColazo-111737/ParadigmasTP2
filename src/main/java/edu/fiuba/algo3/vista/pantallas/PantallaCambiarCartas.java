package edu.fiuba.algo3.vista.pantallas;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.vistas.cartas.CacheEstilosVistaCarta;
import edu.fiuba.algo3.vista.vistas.cartas.EstiloVistaCarta;
import edu.fiuba.algo3.vista.vistas.cartas.VistaCarta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PantallaCambiarCartas {
    private int cambiosRestantesJ1 = 2;
    private int cambiosRestantesJ2 = 2;
    private boolean pasoJ1 = false;
    private boolean pasoJ2 = false;
    private final Jugador jugador1;
    private final Jugador jugador2;
    private final HashMap<Jugador, Label> cambiosLabels = new HashMap<>();

    public PantallaCambiarCartas(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.initStyle(StageStyle.TRANSPARENT);

        VBox layout = new VBox(30);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.rgb(30, 30, 30, 0.8), null, null)));

        VBox manoJ2 = cartasEnLaManoJugador(jugador2, true);
        VBox manoJ1 = cartasEnLaManoJugador(jugador1, false);

        layout.getChildren().addAll(manoJ2, manoJ1);

        Scene escena = new Scene(layout, 1200, 800);
        escena.setFill(Color.TRANSPARENT);
        ventana.setScene(escena);
        ventana.setFullScreen(true);
        ventana.showAndWait();
    }

    private VBox cartasEnLaManoJugador(Jugador jugador, boolean esJugador2) {
        HBox contenedorCartas = new HBox(10);
        contenedorCartas.setAlignment(Pos.CENTER);

        List<Node> vistasCartas = new ArrayList<>();
        cargarCartas(jugador, contenedorCartas, vistasCartas, esJugador2);


        Label cambiosLabel = new Label("Cambios: " + (esJugador2 ? cambiosRestantesJ2 : cambiosRestantesJ1));
        cambiosLabel.setTextFill(Color.GOLD);
        cambiosLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        cambiosLabels.put(jugador, cambiosLabel);

        Button botonPasar = new Button("Pasar");
        botonPasar.setPrefSize(120, 40);
        botonPasar.setStyle(estiloBotonNormal());
        botonPasar.setOnAction(e -> {
            if (esJugador2) pasoJ2 = true;
            else pasoJ1 = true;
            cerrarSiCorresponde(botonPasar);
        });
        botonPasar.setOnMouseEntered(e -> botonPasar.setStyle(estiloBotonHover()));
        botonPasar.setOnMouseExited(e -> botonPasar.setStyle(estiloBotonNormal()));

        HBox controles = new HBox(15, cambiosLabel, botonPasar);
        controles.setAlignment(Pos.CENTER);

        VBox seccion = new VBox(10, contenedorCartas, controles);
        seccion.setAlignment(Pos.CENTER);

        return seccion;
    }

    private void refrescarCartas(Jugador jugador, HBox contenedor, List<Node> vistas, boolean esJugador2) {
        vistas.clear();
        contenedor.getChildren().clear();

        cargarCartas(jugador, contenedor, vistas, esJugador2);

        if (esJugador2) cambiosRestantesJ2--;
        else cambiosRestantesJ1--;

        Label cambiosLabel = cambiosLabels.get(jugador);
        if (cambiosLabel != null) {
            cambiosLabel.setText("Cambios: " + (esJugador2 ? cambiosRestantesJ2 : cambiosRestantesJ1));
        }

        cerrarSiCorresponde(contenedor);
    }

    public void cargarCartas(Jugador jugador, HBox contenedor, List<Node> vistas, boolean esJugador2){

        for (Carta carta : jugador.getMano().getCartas()) {
            EstiloVistaCarta estilo = CacheEstilosVistaCarta.getInstancia().getEstiloVistaCarta(carta.getNombre());
            VistaCarta vista = estilo.construir(carta, null);
            StackPane detalle = vista.getVentanaDetalle(false);
            detalle.setOnMouseClicked(e -> {
                if (puedeCambiar(jugador)) {
                    jugador.cambiarCartaDeLaManoAlMazo(carta);
                    refrescarCartas(jugador, contenedor, vistas, esJugador2);
                }
            });
            vistas.add(detalle);
            contenedor.getChildren().add(detalle);
        }

    }

    private boolean puedeCambiar(Jugador jugador) {
        return (jugador.equals(jugador1) && cambiosRestantesJ1 > 0)
                || (jugador.equals(jugador2) && cambiosRestantesJ2 > 0);
    }

    private void cerrarSiCorresponde(Node nodoCualquiera) {
        if ((cambiosRestantesJ1 == 0 || pasoJ1) && (cambiosRestantesJ2 == 0 || pasoJ2)) {
            Stage stage = (Stage) nodoCualquiera.getScene().getWindow();
            stage.close();
        }
    }

    private String estiloBotonNormal() {
        return "-fx-background-color: #333333;" +
                "-fx-text-fill: gold;" +
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Georgia';" +
                "-fx-font-size: 22px;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-border-color: gold;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, gold, 10, 0.4, 0, 0);";
    }

    private String estiloBotonHover() {
        return "-fx-background-color: #555555;" +
                "-fx-text-fill: gold;" +
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Georgia';" +
                "-fx-font-size: 22px;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-border-color: gold;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, gold, 12, 0.6, 0, 0);";
    }
}