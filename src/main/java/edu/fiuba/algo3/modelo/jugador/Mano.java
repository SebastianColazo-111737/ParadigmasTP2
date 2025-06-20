package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.cartas.ICarta;

import java.util.ArrayList;
import java.util.List;


public class Mano {
    private List<ICarta> cartas;

    public Mano(){
        this.cartas = new ArrayList<>();
    }

    public void agregarCarta(ICarta carta){
        this.cartas.add(carta);
    }
    public void agregarCarta(List<ICarta> cartas){
        this.cartas.addAll(cartas);
    }

    public List<ICarta> getCartas(){
        return this.cartas;
    }

    public int getCantidadCartas(){
        return this.cartas.size();
    }

    public void removerCarta(ICarta carta){
        if(!this.cartas.contains(carta)){
            throw new ManoNoContieneCartaException(
                    "La mano no puede remover una carta que no contiene"
            );
        }
        this.cartas.remove(carta);
    }
}
