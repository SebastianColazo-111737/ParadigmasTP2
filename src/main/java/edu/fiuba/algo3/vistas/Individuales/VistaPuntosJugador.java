package edu.fiuba.algo3.vistas.Individuales;


//Tambien lo voy a usar para mostrar las rondas ganadas

import edu.fiuba.algo3.modelo.jugador.atril.Atril;
import edu.fiuba.algo3.vistas.Contenedores.VistaAtril;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class VistaPuntosJugador extends StackPane {
    private final Text textoPuntaje;
    private final Atril atril;
    private int puntajeAnterior = -1;

    public VistaPuntosJugador(VistaAtril vistaAtril) {
        this.atril = vistaAtril.getAtril();

        Circle circulo = new Circle(20);
        circulo.setFill(Color.GOLDENROD);
        circulo.setStroke(Color.BLACK);

        this.textoPuntaje = new Text("0");
        textoPuntaje.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        textoPuntaje.setFill(Color.BLACK);

        this.getChildren().addAll(circulo, textoPuntaje);
        this.setAlignment(Pos.CENTER);

        // Timeline que revisa si cambió el puntaje
        Timeline actualizador = new Timeline(new KeyFrame(Duration.millis(200), e -> {
            int nuevoPuntaje = atril.getPuntajeActual();
            if (nuevoPuntaje != puntajeAnterior) {
                actualizarPuntaje(nuevoPuntaje);
                puntajeAnterior = nuevoPuntaje;
            }
        }));
        actualizador.setCycleCount(Animation.INDEFINITE);
        actualizador.play();
    }

    public void actualizarPuntaje(int nuevoPuntaje) {
        textoPuntaje.setText(String.valueOf(nuevoPuntaje));
    }
}
