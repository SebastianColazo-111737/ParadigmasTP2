package edu.fiuba.algo3.modelo.carta.unidad;


import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;



import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Efecto;


import java.util.List;

public interface Unidad extends Carta {

    int getPuntajeActual();
    void setPuntajeActual(int puntajeActual);
    void resetearPuntaje();
    void calcularPuntaje(List<Unidad> unidades, List<Efecto> efectos);

    @Override
    default void jugarCarta(Jugador jugador, Jugador oponente, Posicion posicionElegida){
        if(!sePuedeColocar(posicionElegida)){
            throw new UnidadNoPuedeSerJugadaEnEsaPosicion("");
        }
        Atril atril = atrilDestino(jugador, oponente);
        atril.colocarUnidad(this, posicionElegida);

        realizarAccionAdicional(jugador, oponente);
    }
    boolean sePuedeColocar(Posicion posicion);
    Atril atrilDestino(Jugador jugador, Jugador oponente);
    void realizarAccionAdicional(Jugador jugador, Jugador oponente);
}
