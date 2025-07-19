package edu.fiuba.algo3.modelo.carta.Especial;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.carta.unidad.modificadores.Legendaria;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;

import java.util.List;
import java.util.stream.Collectors;

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
                .filter(unidad -> !(unidad instanceof Legendaria))
                .mapToInt(unidad -> unidad.getPuntaje().getPuntajeActual())
                .max()
                .orElse(0);

        List<Unidad> unidadesParaDescartar = unidadesOponente.stream()
                .filter(unidad -> !(unidad instanceof Legendaria))
                .filter(unidad -> unidad.getPuntaje().getPuntajeActual() == maxPuntaje)
                .collect(Collectors.toList());

        atrilOponente.descartarUnidadesIguales(unidadesParaDescartar);
    }
}
