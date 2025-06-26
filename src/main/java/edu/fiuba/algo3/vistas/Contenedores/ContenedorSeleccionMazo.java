package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.GeneradorMazo;
import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Mazo;
import edu.fiuba.algo3.ControladorTurnos;
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

    public ContenedorSeleccionMazo(Stage stage, Runnable onMazoSeleccionado) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(30));
        Label etiqueta = new Label("ELIGE TU MAZO DE GUERRA");
        etiqueta.setFont(Font.font(20));
        HBox botones = new HBox(30);
        botones.setAlignment(Pos.CENTER);

        botones.getChildren().addAll(
                crearBotonMazo("MAZO1", stage, onMazoSeleccionado),
                crearBotonMazo("MAZO2", stage, onMazoSeleccionado),
                crearBotonMazo("MAZO3", stage, onMazoSeleccionado)
        );

        this.getChildren().addAll(etiqueta, botones);
    }

    private Button crearBotonMazo(String nombreMazo, Stage stage, Runnable onMazoSeleccionado) {
        Button boton = new Button(nombreMazo);
        boton.setMinSize(104, 147);
        boton.setOnAction(e -> onMazoSeleccionado.run());
        return boton;
    }
}
