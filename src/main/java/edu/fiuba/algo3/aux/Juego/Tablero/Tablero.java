//package edu.fiuba.algo3.modelo.Juego.Tablero;
//
//import edu.fiuba.algo3.modelo.jugador.Jugador;
//
//import java.util.HashMap;
//
//public class Tablero {
//    private Seccion zonaDeClimas;
//    private HashMap<Jugador, Atril> atriles;
//
//    public Tablero(Jugador j1, Jugador j2){
//        this.zonaDeClimas = null;
//
//        this.atriles = new HashMap<>();
//
//        atriles.put(j1, new Atril());
//        atriles.put(j2,new Atril());
//    }
//
//    public Atril getAtril(Jugador jugador){
//        return this.atriles.get(jugador);
//    }
//
//    public int calcularPuntaje(Jugador jugador){
//        return this.atriles.get(jugador).calcularPuntaje();
//    }
//}
