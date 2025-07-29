package edu.fiuba.algo3.vista.vistas;



import edu.fiuba.algo3.modelo.Observer.Observador;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mano;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.vista.vistas.controladoresVistas.ControladorMano;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.function.BiConsumer;

public class VistaMano extends StackPane implements Observador {


    private HBox contenedorCartas;
    private Image dorsoCarta;
    private ControladorMano controlador;

    public VistaMano(Mano mano, BiConsumer<Carta, Posicion> eventoJugarCarta, Image dorsoCarta) {

        this.controlador = new ControladorMano(mano, eventoJugarCarta);
        mano.agregarObservador(this);
        this.dorsoCarta = dorsoCarta;

        Image imagenFondo = new Image(getClass().getResourceAsStream("/images/mano.jpg"));
        Rectangle fondo = new Rectangle(1100, 100);
        fondo.setFill(new ImagePattern(imagenFondo));
        fondo.setStroke(Color.TRANSPARENT);

        contenedorCartas = new HBox(20);
        contenedorCartas.setAlignment(Pos.CENTER);
        contenedorCartas.setMinSize(1100, 110);
        contenedorCartas.setMaxSize(1100, 110);

        this.setMinSize(1100, 110);
        this.setMaxSize(1100, 110);
        this.getChildren().addAll(fondo, contenedorCartas);

    }

    public void setInteractuable(Boolean sePuedenJugarCartas) {
        controlador.setInteractuable(sePuedenJugarCartas);
        controlador.actualizarVista(contenedorCartas, dorsoCarta);
    }

    @Override
    public void notificar() {
        controlador.actualizarVista(contenedorCartas, dorsoCarta);
    }
}
