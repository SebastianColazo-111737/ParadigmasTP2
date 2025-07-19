package edu.fiuba.algo3.modelo.carta.unidad;


import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;



import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Efecto;


import java.util.List;

public interface Unidad extends Carta {

    Puntaje getPuntaje();
    void calcularPuntaje(List<Unidad> unidades, List<Efecto> efectos);

    @Override
    default void jugarCarta(Jugador jugador, Jugador oponente, Posicion posicionElegida){
        if(!sePuedeColocar(posicionElegida)){
            throw new UnidadNoPuedeSerJugadaEnEsaPosicion("");
        }
        Atril atrilDestino = atrilDestino(jugador, oponente);
        atrilDestino.colocarUnidad(this, posicionElegida);

        realizarAccionAdicional(jugador, oponente, atrilDestino, posicionElegida);
    }
    boolean sePuedeColocar(Posicion posicion);
    Atril atrilDestino(Jugador jugador, Jugador oponente);
    void realizarAccionAdicional(Jugador jugador, Jugador oponente, Atril atrilDestino, Posicion posicionElegida);
}
