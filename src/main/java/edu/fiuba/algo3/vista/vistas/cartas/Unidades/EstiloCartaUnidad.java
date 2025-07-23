package edu.fiuba.algo3.vista.vistas.cartas.Unidades;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.unidad.Unidad;

import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.vista.vistas.cartas.EstiloVistaCarta;
import edu.fiuba.algo3.vista.vistas.cartas.VistaCarta;

import java.util.List;
import java.util.function.BiConsumer;

public class EstiloCartaUnidad implements EstiloVistaCarta {

    private final List<String> modificadores;
    private final List<String> posiciones;

    public EstiloCartaUnidad(List<String> modificadores, List<String> posiciones) {
        this.modificadores = modificadores;
        this.posiciones = posiciones;
    }

    @Override
    public VistaCarta construir(Carta unidad, BiConsumer<Carta, Posicion> eventoJugarCarta){
        return new VistaCartaUnidad((Unidad) unidad, modificadores, posiciones, eventoJugarCarta);
    }
}
