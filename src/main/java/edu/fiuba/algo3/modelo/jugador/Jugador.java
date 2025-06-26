package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.posicion.Posicion;

import java.util.List;

public class Jugador {
    private Mazo mazo;
    private Mano mano;
    private Atril atril;

    public Jugador(Mazo mazo, Mano mano, Atril atril) {
        this.mazo = mazo;
        this.mano = mano;
        this.atril = atril;
    }

    public void robarCartasDelMazo(int cantidad){
        List<Carta> cartasDelMazo = this.mazo.darCartas(cantidad);
        this.mano.agregarCarta(cartasDelMazo);
    }

    public void cambiarCartaDeLaManoAlMazo(Carta carta){

        //Puede lanzar exepcion
        mano.removerCarta(carta);

        Carta cartaDelMazo = this.mazo.cambiarCarta(carta);
        agregarCartaALaMano(cartaDelMazo);
    }

    public void agregarCartaALaMano(Carta carta){
        this.mano.agregarCarta(carta);
    }

    public void removerCartaDeLaMano(Carta carta){
        this.mano.removerCarta(carta);
    }


    public void jugarCarta(Carta carta, Jugador oponenete, Posicion posicionElegida){

        //puede lanzar exepcion
        mano.removerCarta(carta);

        try {
            carta.jugarCarta(this, oponenete, posicionElegida);

        } catch (Exception e) {

            // le vuelvo a agregar la carta
            mano.agregarCarta(carta);
            throw new RuntimeException(e);
        }

    }

    public Atril getAtril(){return this.atril;}
}
