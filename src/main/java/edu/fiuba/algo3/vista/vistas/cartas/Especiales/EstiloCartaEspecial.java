package edu.fiuba.algo3.vista.vistas.cartas.Especiales;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.vista.vistas.cartas.EstiloVistaCarta;
import javafx.scene.Node;

import java.util.List;
import java.util.function.BiConsumer;

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
    public Node construir(Carta especial, BiConsumer<Carta, Posicion> eventoJugarCarta){
        return new VistaCartaEspecial(especial, descripcion, tipo, posiciones, eventoJugarCarta);
    }
}
