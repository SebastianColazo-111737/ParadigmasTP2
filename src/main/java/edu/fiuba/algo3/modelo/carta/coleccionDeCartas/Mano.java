package edu.fiuba.algo3.modelo.carta.coleccionDeCartas;

import edu.fiuba.algo3.modelo.Observer.Observador;
import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.ArrayList;
import java.util.List;

public class Mano extends ColeccionDeCartas{

    public Mano(){
        super();
    }

    public void removerCarta(Carta carta){
        if(!this.cartas.contains(carta)){
            throw new ManoNoContieneCartaException(
                    "La mano no puede remover una carta que no contiene"
            );
        }
        this.cartas.remove(carta);
        notificarObservadores();
    }
}
