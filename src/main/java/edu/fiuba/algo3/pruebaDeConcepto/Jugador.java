package edu.fiuba.algo3.pruebaDeConcepto;

import java.util.List;

public class Jugador {
    private String nombre;
    private Mazo mazo;
    private Mano mano;

    public Jugador(String nombre, Mazo mazo){
        this.nombre = nombre;
        this.mazo = mazo;
        this.mano = new Mano();
    }

    public void jugarCarta(Carta carta, Tablero tablero){
        this.mano.jugarCarta(carta, tablero, this);
    }

    public void robarCartas(int cant){
        List<Carta> cartas = this.mazo.darCartas(cant);
        this.mano.recibirCartas(cartas);
    }

    public String getNombre(){
        return this.nombre;
    }
    public Mazo getMazo(){
        return this.mazo;
    }
    public Mano getMano(){
        return this.mano;
    }
}
