package edu.fiuba.algo3.pruebaDeConcepto;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<Carta> cartas = new ArrayList<>();


    public void recibirCartas(List<Carta> cartas){
        this.cartas.addAll(cartas);
    }
    public void jugarCarta(Carta carta, Tablero tablero, Jugador jugador){
        this.cartas.remove(carta);
        carta.jugarCarta(tablero, jugador);
    }

    public int getCantCartas(){
        return this.cartas.size();
    }
    public List<Carta> getCartas(){
        return this.cartas;
    }
}
