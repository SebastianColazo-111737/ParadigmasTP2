package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<Carta> cartas;

    public Mano(){
        this.cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta){
        this.cartas.add(carta);
    }
    public void agregarCarta(List<Carta> cartas){
        this.cartas.addAll(cartas);
    }

    public void removerCarta(Carta carta){
        if(!this.cartas.contains(carta)){
            throw new ManoNoContieneCartaException(
                    "La mano no puede remover una carta que no contiene"
            );
        }
        this.cartas.remove(carta);
    }



    public List<Carta> getCartas(){
        return this.cartas;
    }
    public int getCantidadCartas(){
        return this.cartas.size();
    }

}
