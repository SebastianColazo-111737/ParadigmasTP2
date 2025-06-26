package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.ControladorTurnos;
import edu.fiuba.algo3.modelo.juego.Gwent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class ContenedorNombreJugador extends VBox {

    public ContenedorNombreJugador(Stage stage, int numeroJugador, Consumer<String> onNombreConfirmado) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(30));

        Label etiqueta = new Label("Jugador " + numeroJugador + ", ingresa tu nombre:");
        etiqueta.setStyle("-fx-font-size: 20px;");
        TextField campoNombre = new TextField();

        Button confirmar = new Button("Confirmar");
        confirmar.setOnAction(e -> {
            String nombre = campoNombre.getText().trim();
            if (!nombre.isEmpty()) {
                onNombreConfirmado.accept(nombre);
            }
        });

        this.getChildren().addAll(etiqueta, campoNombre, confirmar);
    }
}
