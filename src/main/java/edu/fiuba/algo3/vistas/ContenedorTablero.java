package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ContenedorTablero extends StackPane {
    public ContenedorTablero(Stage stage, Juego juego) {
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.setStyle("-fx-background-color: #202020;");

        // VAN A APARECER LOS BOTONES POR ENCIMA DEL TABLERO (LIENZO)
        Lienzo lienzo = new Lienzo(this);
        this.getChildren().add(lienzo);
    }

    public void mostrarVistaDescripcion(String descripcion, Image imagen) {
        VistaDescripcionCarta vista = new VistaDescripcionCarta(descripcion, imagen,
                () -> this.getChildren().removeIf(n -> n instanceof VistaDescripcionCarta)); // ESTA LAMBDA ME PERMITE VOLVER AL TABLERO

        StackPane.setAlignment(vista, Pos.CENTER);
        this.getChildren().add(vista);
    }
}
