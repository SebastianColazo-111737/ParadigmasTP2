package edu.fiuba.algo3.clases;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.AbstractMap;
import java.util.HashMap;




public class Tablero {
    private Map<Jugador,Mesa> mesas;

    public Tablero(Jugador jugador1, Jugador jugador2){
        mesas = new HashMap<>();
        mesas.put(jugador1, new Mesa());
        mesas.put(jugador2, new Mesa());
    }

    public Mesa getMesa(Jugador jugador){
        return mesas.get(jugador);
    }
    public void colocarUnidad(Unidad unidad, Jugador jugador) {
        Mesa mesa = mesas.get(jugador);
        mesa.colocarUnidad(unidad); // mesa decide en qué sección va según la posición de la unidad
    }
}
