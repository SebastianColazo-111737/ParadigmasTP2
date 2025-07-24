package edu.fiuba.algo3.vista.vistas;



import edu.fiuba.algo3.modelo.Observer.Observador;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mano;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.vista.vistas.cartas.CacheEstilosVistaCarta;
import edu.fiuba.algo3.vista.vistas.cartas.EstiloVistaCarta;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class VistaMano extends StackPane implements Observador {

    private Mano manoModelo;
    private HBox contenedorCartas;
    private Rectangle fondo;
    private ArrayList<Node> cartasVistas;
    private BiConsumer<Carta, Posicion> eventoJugarCarta;
    private Image dorsoCarta;
    private boolean sePuedenJugarCartas;

    public VistaMano(Mano mano, BiConsumer<Carta, Posicion> eventoJugarCarta, Image dorsoCarta) {
        this.manoModelo = mano;
        this.manoModelo.agregarObservador(this);
        this.cartasVistas = new ArrayList<>();
        this.eventoJugarCarta = eventoJugarCarta;
        this.dorsoCarta = dorsoCarta;
        this.sePuedenJugarCartas = true;

        Image imagenFondo = new Image(getClass().getResourceAsStream("/images/mano.jpg"));
        fondo = new Rectangle(1100, 100);
        fondo.setFill(new ImagePattern(imagenFondo));
        fondo.setStroke(Color.TRANSPARENT);

        contenedorCartas = new HBox(20);
        contenedorCartas.setAlignment(Pos.CENTER);
        contenedorCartas.setMinSize(1100, 110);
        contenedorCartas.setMaxSize(1100, 110);

        this.setMinSize(1100, 110);
        this.setMaxSize(1100, 110);
        this.getChildren().addAll(fondo, contenedorCartas);

        actualizarVista();
    }

    public void actualizarVista() {
        contenedorCartas.getChildren().clear();
        cartasVistas.clear();

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
            cartasVistas.add(vista);
        }
    }

    public void setInteractuable(Boolean sePuedenJugarCartas) {
        this.sePuedenJugarCartas = sePuedenJugarCartas;
        actualizarVista();
    }

    @Override
    public void notificar() {
        actualizarVista();
    }
}
