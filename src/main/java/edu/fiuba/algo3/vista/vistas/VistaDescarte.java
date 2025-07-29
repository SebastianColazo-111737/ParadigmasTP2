package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.modelo.Observer.Observador;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.jugador.Atril.Descarte;
import edu.fiuba.algo3.vista.vistas.cartas.CacheEstilosVistaCarta;
import edu.fiuba.algo3.vista.vistas.cartas.EstiloVistaCarta;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;


public class VistaDescarte extends StackPane implements Observador {

    private Descarte descarteModelo;
    private Node vistaCarta;


    public VistaDescarte(Descarte descarte) {
        this.descarteModelo = descarte;
        this.descarteModelo.agregarObservador(this);

        Rectangle fondo = new Rectangle(120, 180);
        fondo.setFill(Color.TRANSPARENT);
        fondo.setStroke(Color.BLACK);
        fondo.setArcWidth(15);
        fondo.setArcHeight(15);

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(fondo);

        actualizarVista();
    }

    public void actualizarVista() {

        if (vistaCarta != null) {
            this.getChildren().remove(vistaCarta);
            vistaCarta = null;
        }

        List<Unidad> descartadas = descarteModelo.getUnidadesDescartadas();
        if (!descartadas.isEmpty()) {
            Carta ultimaCarta = descartadas.get(descartadas.size() - 1);
            String nombreCarta = ultimaCarta.getNombre();
            EstiloVistaCarta estilo = CacheEstilosVistaCarta.getInstancia().getEstiloVistaCarta(nombreCarta);
            vistaCarta = estilo.construir(ultimaCarta, null);
            vistaCarta.setDisable(true);
            vistaCarta.setStyle(vistaCarta.getStyle() + "; -fx-border-color: black;");
            this.getChildren().add(vistaCarta);
        }

    }

    @Override
    public void notificar() {
        actualizarVista();
    }
}
