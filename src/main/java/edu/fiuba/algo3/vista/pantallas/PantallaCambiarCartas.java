package edu.fiuba.algo3.vista.pantallas;


import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.controlador.ControladorCambiarCartas;
import edu.fiuba.algo3.vista.vistas.EstilosPantalla;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;

public class PantallaCambiarCartas {
    private ControladorCambiarCartas controlador;

    public PantallaCambiarCartas(Jugador jugador1, Jugador jugador2) {
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.initStyle(StageStyle.TRANSPARENT);
        ventana.setFullScreenExitHint("");

        this.controlador = new ControladorCambiarCartas(jugador1, jugador2, ventana);

        VBox layout = new VBox(30);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.rgb(30, 30, 30, 0.8), null, null)));

        VBox manoJ2 = cartasEnLaManoJugador(true);
        VBox manoJ1 = cartasEnLaManoJugador(false);

        layout.getChildren().addAll(manoJ2, manoJ1);

        Scene escena = new Scene(layout, 1200, 800);
        escena.setFill(Color.TRANSPARENT);
        ventana.setScene(escena);
        ventana.setFullScreen(true);
        ventana.showAndWait();
    }

    private VBox cartasEnLaManoJugador(boolean esJugador2) {
        HBox contenedorCartas = new HBox(10);
        contenedorCartas.setAlignment(Pos.CENTER);

        List<Node> vistasCartas = new ArrayList<>();
        this.controlador.cargarCartas(contenedorCartas, vistasCartas, esJugador2);

        Button botonPasar = new Button("Pasar");
        botonPasar.setPrefSize(120, 40);
        botonPasar.setStyle(EstilosPantalla.botonEstiloNormal());
        botonPasar.setOnAction(e -> {
            this.controlador.eventoPasar(esJugador2);
            botonPasar.setDisable(true);
        });


        botonPasar.setOnMouseEntered(e -> botonPasar.setStyle(EstilosPantalla.botonEstiloHover()));
        botonPasar.setOnMouseExited(e -> botonPasar.setStyle(EstilosPantalla.botonEstiloNormal()));

        HBox controles = new HBox(15, this.controlador.getLabelCambios(esJugador2), botonPasar);
        controles.setAlignment(Pos.CENTER);

        VBox seccion = new VBox(10, contenedorCartas, controles);
        seccion.setAlignment(Pos.CENTER);

        return seccion;
    }
}