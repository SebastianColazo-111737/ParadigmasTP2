package edu.fiuba.algo3.vistas.Individuales;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class VistaPuntos extends StackPane {
    private final Text textoPuntaje;
    private final Seccion seccion;
    private int puntajeAnterior = -1;

    public VistaPuntos(Seccion seccion) {
        this.seccion = seccion;

        Circle circulo = new Circle(20);
        circulo.setFill(Color.GOLDENROD);
        circulo.setStroke(Color.BLACK);

        this.textoPuntaje = new Text("0");
        textoPuntaje.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        textoPuntaje.setFill(Color.BLACK);

        this.getChildren().addAll(circulo, textoPuntaje);

        Timeline actualizador = new Timeline(new KeyFrame(Duration.millis(200), e -> {
            int puntajeActual = seccion.calcularPuntajeActualUnidades().getPuntajeActual();
            if (puntajeActual != puntajeAnterior) {
                textoPuntaje.setText(String.valueOf(puntajeActual));
                puntajeAnterior = puntajeActual;
            }
        }));
        actualizador.setCycleCount(Animation.INDEFINITE);
        actualizador.play();
    }
	
    public void actualizarPuntaje(int puntajeActualizado){
        textoPuntaje.setText(String.valueOf(puntajeActualizado));
    }
}
