package edu.fiuba.algo3.vista.Cartas.Especiales;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.vista.Cartas.EstiloVistaCarta;
import javafx.scene.Node;

import java.util.List;

public class EstiloCartaEspecial implements EstiloVistaCarta {

    private final String descripcion;
    private final String tipo;
    private final List<String> posiciones;

    public EstiloCartaEspecial(String descripcion, String tipo, List<String> posiciones) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.posiciones = posiciones;
    }

    @Override
    public Node construir(Carta carta) {
        return new VistaCartaEspecial(carta, descripcion, tipo, posiciones);
    }
}
