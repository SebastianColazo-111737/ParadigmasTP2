package edu.fiuba.algo3.falopa;

public class Jugador {
    private String nombre;
    private Mazo mazo;
    private Mano mano;

    public Jugador(String nombre, Mazo mazo){
        this.mazo = mazo;
        this.nombre = nombre;
        this.mano = crearMano();
    }

    private Mano crearMano(){
        return new Mano();
    }

    public int cartasEnElMazo(){
        return mazo.cantCartas();
    }
}
