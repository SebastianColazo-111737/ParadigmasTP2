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

    public ContenedorNombreJugador(Stage stage, Juego juego, Scene escenaMazo) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(30));

        Label etiqueta = new Label("INGRESA TU NOMBRE GUERRERO");
        etiqueta.setFont(Font.font(20));
        TextField campoNombre = new TextField();

        Button confirmar = new Button("Confirmar");
        confirmar.setOnAction(e -> {
            juego.jugadorActual().setNombre(campoNombre.getText());
            stage.setScene(escenaMazo);
        });

        this.getChildren().addAll(etiqueta, campoNombre, confirmar);
    }
}
