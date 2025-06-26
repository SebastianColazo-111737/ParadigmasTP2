package edu.fiuba.algo3.modelo.carta.Especial;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.EfectoBoost;

public class MoraleBoost implements Carta {
    private String nombre;
    private EfectoBoost efecto;
    private final static int multiplicador = 2;

    public MoraleBoost(String nombre){
        this.nombre = nombre;
        this.efecto = new EfectoBoost(multiplicador);
    }
    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void jugarCarta(Jugador jugador, Jugador oponente, Posicion posicionElegida) {
        Atril atrilJugador = jugador.getAtril();
        atrilJugador.agregarEfecto(this.efecto , posicionElegida);
    }


}
