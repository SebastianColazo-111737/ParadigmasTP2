package edu.fiuba.algo3.modelo.carta.Especial;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;

import java.util.List;

public class TierraArrasada implements Carta {
    private String nombre;

    public TierraArrasada(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void jugarCarta(Jugador jugador, Jugador oponente, Posicion posicionElegida) {

        Atril atrilOponente = oponente.getAtril();
        List<Unidad> unidadesOponente = atrilOponente.getUnidadesColocadas();
        int maxPuntaje = unidadesOponente.stream()
                .mapToInt(Unidad::getPuntajeActual)
                .max()
                .orElse(0);
        atrilOponente.removerUnidadesConPuntaje(maxPuntaje);
    }


}
