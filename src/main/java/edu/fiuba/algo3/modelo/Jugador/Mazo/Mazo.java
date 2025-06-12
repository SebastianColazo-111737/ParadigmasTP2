package edu.fiuba.algo3.modelo.Jugador.Mazo;

import edu.fiuba.algo3.modelo.Carta.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mazo {
    private List<ICarta> cartas;

    public Mazo(){
        this.cartas =  new ArrayList<>();
    }

    public Mazo(List<ICarta> cartas){
        this.cartas =  new ArrayList<>();
        this.agregarCartas(cartas);
    }

    public void agregarCartas(List<ICarta> nuevasCartas){
        this.cartas.addAll(nuevasCartas);
    }

    public void agregarCarta(ICarta carta){
        this.cartas.add(carta);
    }

    public List<ICarta> darCartas(int cantidad){
        if(cantidad > this.cartas.size()){
            throw new MazoCantidadDeCartasPedidasInvalido("El numero de cartas pedido es mayor a la cantidad de cartas que tiene el mazo ");
        }

        List<ICarta> entregadas = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            entregadas.add(darCarta());
        }
        return entregadas;
    }

    private ICarta darCarta(){
        Random random = new Random();
        int indice = random.nextInt(this.cartas.size());
        return this.cartas.remove(indice);
    }

    public ICarta cambiarCarta(ICarta carta){
        if(cartas.isEmpty()){
            throw new MazoNoPuedeCambiarCartasVacio("El mazo esta vacio, no puede cambiar la carta por otra");
        }

        ICarta nuevaCarta = this.darCarta();
        agregarCarta(carta);
        return nuevaCarta;
    }

    public int getCantidadCartas(){
        return this.cartas.size();
    }

    public List<ICarta> getCartas(){
        return this.cartas;
    }
}
