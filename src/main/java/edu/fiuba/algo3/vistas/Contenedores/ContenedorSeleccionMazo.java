package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Mazo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorSeleccionMazo extends VBox {

    public ContenedorSeleccionMazo(Stage stage, Gwent juego, Scene escenaTablero) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(30));
        Label etiqueta = new Label("ELIGE TU MAZO DE GUERRA");
        etiqueta.setFont(Font.font(20));
        HBox botones = new HBox(30);
        botones.setAlignment(Pos.CENTER);

        botones.getChildren().addAll(
                crearBotonMazo("MAZO1", stage, juego, escenaTablero),
                crearBotonMazo("MAZO2", stage, juego, escenaTablero),
                crearBotonMazo("MAZO3", stage, juego, escenaTablero)
        );

        this.getChildren().addAll(etiqueta, botones);
    }

    private Button crearBotonMazo(String nombreMazo, Stage stage, Gwent juego, Scene escenaTablero) {
        Button boton = new Button(nombreMazo);
        boton.setMinSize(104, 147);
        boton.setOnAction(e -> {
            juego.getJugadorActual().setMazo(new Mazo(nombreMazo));
            juego.siguienteJugador();

            if (!juego.juegoCompleto()) {
                ContenedorSeleccionMazo nuevoMazo = new ContenedorSeleccionMazo(stage, juego, escenaTablero);
                ContenedorNombreJugador nuevoNombre = new ContenedorNombreJugador(stage, juego,  new Scene(nuevoMazo, 600, 400));
                stage.setScene(new Scene(nuevoNombre));
            } else {
                stage.setScene(escenaTablero);
            }
        });
        return boton;
    }
}
