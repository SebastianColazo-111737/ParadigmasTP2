package edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio;


import edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.cartas.ICarta;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<ICarta> cartas;

    public Mano(){
        this.cartas = new ArrayList<>();
    }

    public boolean contiene(ICarta carta){
        return this.cartas.contains(carta);
    }

    public void removerCarta(ICarta carta){
        this.cartas.remove(carta);
    }
}
