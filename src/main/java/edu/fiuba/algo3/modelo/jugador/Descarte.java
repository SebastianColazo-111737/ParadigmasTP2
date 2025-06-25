package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.cartas.Carta;

import java.util.ArrayList;
import java.util.List;

public class Descarte {
    private List<Carta> cartasDescartadas;

    public Descarte(){
        this.cartasDescartadas = new ArrayList<>();
    }

    public void descartarCarta(Carta carta){
        this.cartasDescartadas.add(carta);
    }

    public void descartarCarta(List<Carta> cartas){
        this.cartasDescartadas.addAll(cartas);
    }


}
