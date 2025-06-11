package edu.fiuba.algo3.aux;

import java.util.ArrayList;
import java.util.List;

public class ZonaEspeciales {
    private List<Especial> cartas;

    public ZonaEspeciales(){
        this.cartas = new ArrayList<>();
    }

    public void colocar(Especial carta, Tablero tablero){
        this.cartas.add(carta);
        carta.activar(tablero);
    }

    public List<Especial> getCartas(){
        return this.cartas;
    }
}
