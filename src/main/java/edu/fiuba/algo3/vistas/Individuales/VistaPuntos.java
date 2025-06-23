package edu.fiuba.algo3.vistas.Individuales;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class VistaPuntos extends StackPane {
    private final Text textoPuntaje;

    public VistaPuntos(int puntajeInicialDeSeccion){
        Circle circulo = new Circle(20);
        circulo.setFill(Color.GOLDENROD);
        circulo.setStroke(Color.BLACK);

        this.textoPuntaje = new Text(String.valueOf(puntajeInicialDeSeccion));
        textoPuntaje.setFont(Font.font("Arial", FontWeight.BOLD,14));
        textoPuntaje.setFill(Color.BLACK);

        this.getChildren().addAll(circulo, textoPuntaje);
    }

    public void actualizarPuntaje(int puntajeActualizado){
        textoPuntaje.setText(String.valueOf(puntajeActualizado));
    }
}
