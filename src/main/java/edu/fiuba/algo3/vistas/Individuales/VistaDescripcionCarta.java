package edu.fiuba.algo3.vistas.Individuales;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class VistaDescripcionCarta extends VBox {
    public VistaDescripcionCarta(String descripcionCarta, Image imagenCarta, Runnable onVolver) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(30));
        this.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7);"); // DIFUMINA EL FONDO (CREO)

        Label descripcion = new Label(descripcionCarta);
        descripcion.setTextFill(Color.WHITE);
        descripcion.setFont(Font.font(18));
        descripcion.setWrapText(true);
        descripcion.setTextAlignment(TextAlignment.CENTER);

        ImageView imagen = new ImageView(imagenCarta);
        imagen.setFitWidth(200);
        imagen.setPreserveRatio(true);

        Button volver = new Button("Volver");
        volver.setOnAction(e -> onVolver.run());

        this.getChildren().addAll(imagen, descripcion, volver);
    }
}
