package edu.fiuba.algo3.modelo;



import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Carta.*;
import edu.fiuba.algo3.modelo.Posicion.IPosicion;

public class Gwent {
    private Tablero tablero;

    public Gwent(){
        this.tablero = new Tablero();
    }

    public void jugarCarta(Jugador jugador, ICarta carta, IPosicion posicion){
        jugador.removerCartaDeLaMano(carta);
        carta.jugarCarta(jugador, tablero, posicion);
    }
}
