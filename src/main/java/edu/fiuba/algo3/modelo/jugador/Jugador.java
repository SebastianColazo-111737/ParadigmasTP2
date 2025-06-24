package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.tablero.atril.Atril;
import edu.fiuba.algo3.modelo.tablero.atril.Seccion;

import java.util.List;

public class Jugador {
    private Mazo mazo;
    private Mano mano;

    public Jugador(Mazo mazo, Mano mano, Atril atril) {
        this.mazo = mazo;
        this.mano = mano;
    }

    public void robarCartasDelMazo(int cantidad){
        List<ICarta> cartasDelMazo = this.mazo.darCartas(cantidad);
        this.mano.agregarCarta(cartasDelMazo);
    }

    public void cambiarCartaDeLaManoAlMazo(ICarta carta){
        mano.removerCarta(carta);

        ICarta cartaDelMazo = this.mazo.cambiarCarta(carta);
        agregarCartaALaMano(cartaDelMazo);
    }

    public void agregarCartaALaMano(ICarta carta){
        this.mano.agregarCarta(carta);
    }


    public void jugarCarta(ICarta carta, Tablero tablero, Posicion posicion){
        mano.removerCarta(carta);

        try {
            carta.jugarCarta(this, tablero, posicion);
        }catch (Exception e){
            mano.agregarCarta(carta);
            throw e;
        }

    }

}
