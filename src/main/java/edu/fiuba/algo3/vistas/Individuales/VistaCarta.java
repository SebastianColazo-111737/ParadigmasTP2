package edu.fiuba.algo3.vistas.Individuales;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.unidades.*;
import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import java.util.function.Consumer;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class VistaCarta extends Button {
    public static VistaCarta cartaSeleccionada;
    private final ICarta cartaModelo;
    private final String colorDeFondo;

    public VistaCarta(ICarta cartaModelo, Consumer<VistaCarta> oneSeleccionar) {
        super();
        this.cartaModelo = cartaModelo;
        this.colorDeFondo = cartaModelo.colorHex();

        this.setStyle("-fx-background-color: " + colorDeFondo + "; -fx-border-color: black; -fx-border-width: 2; -fx-font-weight: bold;");
        this.setPrefSize(70, 90);
        this.deseleccionar();

        VBox contenido = new VBox(2);
        contenido.setAlignment(Pos.CENTER);

        if(cartaModelo instanceof Unidad){
            Unidad unidad = (Unidad) cartaModelo;
            Label puntos = new Label(String.valueOf(unidad.getPuntaje().getPuntajeActual()));
            puntos.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 22));
            puntos.setTextFill(Color.BLACK);
            contenido.getChildren().add(puntos);
        }

        String[] partes = cartaModelo.nombre().split("\n");
        String nombreCarta = partes[0];
        String emojis = partes.length > 1 ? partes[1] : "";

        Label nombreLabel = new Label(cartaModelo.nombre());
        nombreLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        nombreLabel.setWrapText(true);
        nombreLabel.setTextAlignment(TextAlignment.CENTER);

        Label emojiLabel = new Label(emojis);
        emojiLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        emojiLabel.setTextAlignment(TextAlignment.CENTER);

        contenido.getChildren().addAll(nombreLabel,emojiLabel);

        this.setGraphic(contenido);

        this.setOnAction(e -> oneSeleccionar.accept(this));
        this.moverCarta();
    }

    public ICarta getCartaModelo(){
        return cartaModelo;
    }

    public void seleccionar() {
        this.setStyle("-fx-background-color: " + colorDeFondo + "; -fx-border-color: red; -fx-border-width: 2; -fx-font-weight: bold;");
    }

    public void deseleccionar() {
        this.setStyle("-fx-background-color: " + colorDeFondo + "; -fx-border-color: black; -fx-border-width: 1; -fx-font-weight: bold;");
    }

    public void moverCarta(){
        this.setOnDragDetected(e->{
            VistaCarta.cartaSeleccionada = this;

            Dragboard tablaCarta = this.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent contenido = new ClipboardContent();
            contenido.putString("carta");
            tablaCarta.setContent(contenido);

            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);
            Image snapshot = this.snapshot(params, null);
            tablaCarta.setDragView(snapshot);

            e.consume();
        });
    }
}

