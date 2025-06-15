package edu.fiuba.algo3.vistas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.StackPane;


public class VistaPuntos extends StackPane {
    public VistaPuntos(){
        Circle circulo = new Circle(15);
        circulo.setFill(Color.GOLDENROD);
        circulo.setStroke(Color.BLACK);
        this.getChildren().add(circulo);
    }
}
