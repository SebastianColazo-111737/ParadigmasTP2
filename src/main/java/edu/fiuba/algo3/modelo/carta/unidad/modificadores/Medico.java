package edu.fiuba.algo3.modelo.carta.unidad.modificadores;


import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;

public class Medico extends UnidadModificada {

    // segunda opcion (se puede setear desde selectorDeUnidad)
    //private SelectorUnidad selectorUnidadParaRevivir;

    Unidad unidadParaRevivir;
    Posicion posicionParaUnidad;

    public Medico(Unidad unidad, Unidad unidadParaREvivir, Posicion posicionParaUnidad){
        super(unidad);
        // primera opcion (se crea con la unidad seteada)
        this.unidadParaRevivir = unidadParaREvivir;
        this.posicionParaUnidad = posicionParaUnidad;
    }

    @Override
    public void realizarAccionAdicional(Jugador jugador, Jugador oponente,
                                        Atril atril, Posicion posicionElegida){
        // segunda opcion
        //Unidad unidadParaRevivir = selectorUnidadParaRevivir.getUnidad();
        //Posicion posicionParaRevivir = selectorUnidadParaRevivir.getPosicion();

        if(this.unidadParaRevivir != null && this.posicionParaUnidad != null){
            this.unidadParaRevivir.jugarCarta(jugador, oponente, this.posicionParaUnidad);
        }

        //continuar la cadena
        super.unidad.realizarAccionAdicional(jugador, oponente, atril, posicionElegida);
    }

}
