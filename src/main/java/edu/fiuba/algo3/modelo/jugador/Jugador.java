package edu.fiuba.algo3.modelo.jugador;
import edu.fiuba.algo3.modelo.cartas.Carta;

import java.util.List;

public class Jugador {
    private Mazo mazo;
    private Mano mano;
    private Descarte descarte;

    public Jugador(Mazo mazo, Mano mano, Descarte descarte) {
        this.mazo = mazo;
        this.mano = mano;
        this.descarte = descarte;
    }

    public void robarCartasDelMazo(int cantidad){
        List<Carta> cartasDelMazo = this.mazo.darCartas(cantidad);
        this.mano.agregarCarta(cartasDelMazo);
    }

    public void cambiarCartaDeLaManoAlMazo(Carta carta){
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

    public void descartarCarta(Carta carta){
        this.descarte.descartarCarta(carta);
    }

    public void descartarCarta(List<Carta> cartas){
        this.descarte.descartarCarta(cartas);
    }
}
