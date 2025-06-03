package edu.fiuba.algo3.pruebaDeConcepto;

import java.util.ArrayList;
import java.util.List;

public class Mazo {
    private List<Carta> cartas;

    public Mazo(List<Carta> cartas){
        this.cartas = cartas;
    }

    public List<Carta> darCartas(int cantidad){
        if(cantidad > this.cartas.size()){
            return null;
        }
        // faltaria una logica para que las cartas que se dan sean aleatorias
        List<Carta> cartasParaDar = new ArrayList<>(cartas.subList(0, cantidad));
        cartas.subList(0, cantidad).clear();
        return cartasParaDar;
    }

    public int getCantCartas(){
        return this.cartas.size();
    }

    public List<Carta> getCartas(){
        return this.cartas;
    }
}
