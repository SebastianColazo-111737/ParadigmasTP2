package edu.fiuba.algo3.vista.vistas.cartas;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.posicion.Posicion;

import java.util.function.BiConsumer;

public interface EstiloVistaCarta {
    VistaCarta construir(Carta carta,BiConsumer<Carta, Posicion> eventoJugarCarta);
}
