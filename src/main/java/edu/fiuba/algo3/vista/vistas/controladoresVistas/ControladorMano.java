package edu.fiuba.algo3.vista.vistas.controladoresVistas;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mano;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.vista.vistas.cartas.CacheEstilosVistaCarta;
import edu.fiuba.algo3.vista.vistas.cartas.EstiloVistaCarta;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.function.BiConsumer;

public class ControladorMano {
    private Mano manoModelo;
    private BiConsumer<Carta, Posicion> eventoJugarCarta;
    private boolean sePuedenJugarCartas;

    public ControladorMano(Mano mano, BiConsumer<Carta, Posicion> eventoJugarCarta){
        this.manoModelo = mano;
        this.eventoJugarCarta = eventoJugarCarta;
        this.sePuedenJugarCartas = true;
    }


    public void actualizarVista(HBox contenedorCartas, Image dorsoCarta) {
        contenedorCartas.getChildren().clear();

        for (Carta cartaModelo : manoModelo.getCartas()) {
            Node vista;
            if (sePuedenJugarCartas) {
                EstiloVistaCarta estilo = CacheEstilosVistaCarta.getInstancia().getEstiloVistaCarta(cartaModelo.getNombre());
                vista = estilo.construir(cartaModelo, eventoJugarCarta);
            } else {
                Rectangle dorso = new Rectangle(90, 105);
                dorso.setArcWidth(10);
                dorso.setArcHeight(10);
                dorso.setFill(new ImagePattern(dorsoCarta));
                vista = dorso;
            }

            contenedorCartas.getChildren().add(vista);
        }
    }

    public void setInteractuable(Boolean sePuedenJugarCartas) {
        this.sePuedenJugarCartas = sePuedenJugarCartas;
    }

}
