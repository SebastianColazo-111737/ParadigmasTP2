package edu.fiuba.algo3.modelo.cartas.unidades.modificadores;

import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadDecoradora;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.modelo.tablero.Tablero;


public class Medico extends UnidadDecoradora {

    //private SelectorUnidad selectorUnidadParaRevivir;
    Unidad unidadParaRevivir;
    Posicion posicionParaUnidad;

    public Medico(Unidad unidad, Unidad unidadParaREvivir, Posicion posicionParaUnidad){
        super(unidad);
        this.unidadParaRevivir = unidadParaREvivir;
        this.posicionParaUnidad = posicionParaUnidad;
    }

    @Override
    public void realizarAccionAdicional(Jugador jugador, Tablero tablero){

        //Unidad unidadParaRevivir = selectorUnidadParaRevivir.getUnidad();
        //Posicion posicionParaRevivir = selectorUnidadParaRevivir.getPosicion();

        if(this.unidadParaRevivir != null && this.posicionParaUnidad != null){
            this.unidadParaRevivir.jugarCarta(jugador, tablero, this.posicionParaUnidad);
        }

        super.unidad.realizarAccionAdicional(jugador, tablero);
    }

}
