package edu.fiuba.algo3.vista.Cartas.Unidades;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.unidad.Unidad;

import edu.fiuba.algo3.vista.Cartas.EstiloVistaCarta;
import javafx.scene.Node;

import java.util.List;

public class EstiloCartaUnidad implements EstiloVistaCarta {

    private final List<String> modificadores;
    private final List<String> posiciones;

    public EstiloCartaUnidad(List<String> modificadores, List<String> posiciones) {
        this.modificadores = modificadores;
        this.posiciones = posiciones;
    }

    @Override
    public Node construir(Carta unidad) {
        return new VistaCartaUnidad((Unidad) unidad, modificadores, posiciones);
    }
}
