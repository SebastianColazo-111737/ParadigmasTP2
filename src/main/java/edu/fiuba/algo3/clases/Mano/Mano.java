package edu.fiuba.algo3.clases.Mano;

import edu.fiuba.algo3.clases.Carta.ICarta;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<ICarta> cartas;

    public Mano(){
        this.cartas = new ArrayList<>();
    }

    public void agregarCartas(List<ICarta> nuevasCartas){
        this.cartas.addAll(nuevasCartas);
    }

    public ICarta getCarta(int indiceCarta){
        if(indiceCarta >= cartas.size()){
            throw new ManoIndiceDeCartaInvalido("La mano no tiene tantas cartas");
        }
        return cartas.remove(indiceCarta);
    }

    public int getCantidadCartas(){
        return this.cartas.size();
    }

    public List<ICarta> getCartas(){
        return this.cartas;
    }
}
