package edu.fiuba.algo3.modelo.jugador.Atril;

import edu.fiuba.algo3.modelo.Observer.Observador;
import edu.fiuba.algo3.modelo.carta.unidad.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Descarte {
    private List<Unidad> unidadesDescartadas;
    private List<Observador> observadores;

    public Descarte(){
        this.unidadesDescartadas = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    public void descartarUnidad(Unidad unidad){
        this.unidadesDescartadas.add(unidad);
        notificarObservadores();
    }

    public void descartarUnidad(List<Unidad> unidades){
        this.unidadesDescartadas.addAll(unidades);
        notificarObservadores();

    }

    public Unidad getUltimaCarta(){
        Unidad ultimaCarta = unidadesDescartadas.isEmpty()?
                null:
                this.unidadesDescartadas.remove(this.unidadesDescartadas.size()-1);
        notificarObservadores();
        return ultimaCarta;
    }

    public List<Unidad> getUnidadesDescartadas(){
        return this.unidadesDescartadas;
    }

    public void agregarObservador(Observador observador){
        this.observadores.add(observador);
    }

    private void notificarObservadores() {
        for (Observador observador : observadores){
            observador.notificar();
        }
    }
}
