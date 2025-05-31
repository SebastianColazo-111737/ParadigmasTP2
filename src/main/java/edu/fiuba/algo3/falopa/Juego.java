package edu.fiuba.algo3.falopa;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores ;

    public Juego(String nombreJ1, String nombreJ2){
        Mazo mazoJ1 = new Mazo(new ArrayList<Carta>());
        Jugador jugador1 = crearJugador(nombreJ1, mazoJ1);

        Mazo mazoJ2 = new Mazo(new ArrayList<Carta>());
        Jugador jugador2 = crearJugador(nombreJ2, mazoJ2);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        this.jugadores = jugadores;
    }

    private Jugador crearJugador(String nombre, Mazo mazo){
        return new Jugador(nombre,mazo);
    }

    public int cartasDelJugador(int indiceJugador){
        return jugadores.get(indiceJugador).cartasEnElMazo();
    }
}
