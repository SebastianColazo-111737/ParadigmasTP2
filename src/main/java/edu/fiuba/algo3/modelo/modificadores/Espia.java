package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.jugador.Seccion;

import java.util.List;

public class Espia implements Modificador{
    private List<Carta> mazo;
    private List<Carta> mano;
    private int cantidadCartasATomar = 2;

    @Override
    public void aplicarEfecto(Seccion seccion){
        for (int i = 0; i < cantidadCartasATomar; i++) {
            Carta cartaNueva = mazo.remove(2);  //
            mano.add(cartaNueva);
        }
    }
}
