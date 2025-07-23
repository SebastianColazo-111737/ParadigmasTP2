package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.modelo.Observer.Observador;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mazo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class VistaMazo extends StackPane implements Observador {

    private Mazo mazoModelo;
    private Label cantidadLabel;

    public VistaMazo(Mazo mazo, Image imagenDorso) {
        this.mazoModelo = mazo;
        mazo.agregarObservador(this);

        ImageView imagenView = new ImageView(imagenDorso);
        imagenView.setFitWidth(90);
        imagenView.setFitHeight(150);
        imagenView.setPreserveRatio(true);

        Circle circulo = new Circle(20, Color.DARKRED);
        circulo.setStroke(Color.BLACK);
        circulo.setStrokeWidth(2);

        cantidadLabel = new Label(String.valueOf(mazo.getCantidadCartas()));
        cantidadLabel.setTextFill(Color.WHITE);
        cantidadLabel.setFont(new Font("Arial", 20));

        StackPane indicadorCantidad = new StackPane();
        indicadorCantidad.getChildren().addAll(circulo, cantidadLabel);
        indicadorCantidad.setAlignment(Pos.CENTER);
        indicadorCantidad.setMaxSize(40, 40);
        indicadorCantidad.setPrefSize(40, 40);

        StackPane.setAlignment(indicadorCantidad, Pos.TOP_RIGHT);
        StackPane.setMargin(indicadorCantidad, new Insets(10, 10, 0, 0)); // Margen desde arriba y derecha

        this.getChildren().addAll(imagenView, indicadorCantidad);
        this.setAlignment(Pos.CENTER);
    }

    public void actualizarCantidad() {
        cantidadLabel.setText(String.valueOf(mazoModelo.getCantidadCartas()));
    }

    @Override
    public void notificar() {
        actualizarCantidad();
    }
}
