package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorNombreJugador extends VBox {

    public ContenedorNombreJugador(Stage stage, Juego juego, Scene escenaSeleccionMazo) {
        this.setPrefSize(800, 600);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(30);
        this.setPadding(new Insets(40));

        Label titulo = new Label("INGRESA TU NOMBRE GUERRERO");
        titulo.setFont(new Font(20));
        TextField campoNombre = new TextField();

        Button botonConfirmar = new Button("Confirmar");
        botonConfirmar.setOnAction(e -> {
            juego.jugadorActual().setNombre(campoNombre.getText());
            stage.setScene(escenaSeleccionMazo);
        });

        this.getChildren().addAll(titulo, campoNombre, botonConfirmar);
    }
}
