package edu.fiuba.algo3.vistas.Individuales;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import java.util.function.Consumer;

import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;

public class VistaCarta extends Button {
    public static VistaCarta cartaSeleccionada;
    private final ICarta cartaModelo;

    public VistaCarta(ICarta cartaModelo, Consumer<VistaCarta> oneSeleccionar) {
        super(cartaModelo.nombre());
        this.cartaModelo = cartaModelo;

        this.setPrefSize(70, 90);
        this.deseleccionar();
        this.setOnAction(e -> oneSeleccionar.accept(this));
        this.moverCarta();
    }

    public ICarta getCartaModelo(){
        return cartaModelo;
    }

    public void seleccionar(){
        this.setStyle("-fx-background-color: white; -fx-border-color: red; -fx-border-width: 2; -fx-font-weight: bold;");
    }

    public void deseleccionar(){
        this.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 1; -fx-font-weight: bold;");
    }

    private void moverCarta(){
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

