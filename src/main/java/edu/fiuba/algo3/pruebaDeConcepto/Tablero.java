package edu.fiuba.algo3.pruebaDeConcepto;
import java.util.HashMap;

public class Tablero {
    private HashMap<Jugador, Mesa> mesas = new HashMap<>();

    public Tablero(Jugador jugador1, Jugador jugador2){
        mesas.put(jugador1, new Mesa());
        mesas.put(jugador2, new Mesa());
    }

    public void colocarUnidad(Unidad unidad, Jugador jugador){
        Mesa mesa = mesas.get(jugador);
        mesa.colocarUnidad(unidad);
    }

    public int calcularPuntaje(Jugador jugador){
        Mesa mesa = mesas.get(jugador);
        return mesa.calcularPuntaje();
    }
}
