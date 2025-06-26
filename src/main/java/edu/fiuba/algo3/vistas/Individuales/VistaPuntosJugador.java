package edu.fiuba.algo3.vistas.Individuales;


//Tambien lo voy a usar para mostrar las rondas ganadas

import edu.fiuba.algo3.modelo.jugador.atril.Atril;
import edu.fiuba.algo3.vistas.Contenedores.VistaAtril;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class VistaPuntosJugador extends StackPane {
    private final Text textoPuntaje;
    private final Atril atril;
    private int puntajeAnterior = -1;
    private int rondasGanadas = 0;
    private final HBox circuloDeRonda = new HBox(10);
    private final List<Circle> circulosDeRonda = new ArrayList<>();

    public VistaPuntosJugador(VistaAtril vistaAtril) {
        this.atril = vistaAtril.getAtril();

        Circle circulo = new Circle(20);
        circulo.setFill(Color.GOLDENROD);
        circulo.setStroke(Color.BLACK);

        this.textoPuntaje = new Text("0");
        textoPuntaje.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        textoPuntaje.setFill(Color.BLACK);

        for(int i = 0; i < 2; i++){
            Circle ronda = new Circle(8, Color.GREY);
            ronda.setStroke(Color.BLACK);
            circulosDeRonda.add(ronda);
        }

        circuloDeRonda.getChildren().addAll(circulosDeRonda);
        circuloDeRonda.setAlignment(Pos.CENTER);
        circuloDeRonda.setTranslateY(25);

        StackPane.setAlignment(circuloDeRonda, Pos.BOTTOM_CENTER);

        this.getChildren().addAll(circulo, textoPuntaje,circuloDeRonda);
        this.setAlignment(Pos.CENTER);

        // Timeline que revisa si se actualizo el puntaje
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

    public void ganarRonda(){
        if(rondasGanadas < 2){
            circulosDeRonda.get(rondasGanadas).setFill(Color.RED);
            rondasGanadas++;
        }
    }

    public int getRondasGanadas(){
        return rondasGanadas;
    }

    /*public void reiniciarRonda(){   <--- Esto serviria si tenemos algun boton para reiniciar el juego completamente
        puntajeAnterior = -1;
        for(Circle c : circulosDeRonda) c.setFill(Color.GREY);
        rondasGanadas = 0;
    } */
}
