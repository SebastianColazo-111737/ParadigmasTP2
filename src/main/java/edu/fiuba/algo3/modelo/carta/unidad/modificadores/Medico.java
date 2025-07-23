package edu.fiuba.algo3.modelo.carta.unidad.modificadores;


import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Atril.Descarte;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Asedio;
import edu.fiuba.algo3.modelo.posicion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posicion.Distancia;
import edu.fiuba.algo3.modelo.posicion.Posicion;

import java.util.ArrayList;
import java.util.List;

public class Medico extends UnidadModificada {

    public Medico(Unidad unidad){
        super(unidad);
    }

    @Override
    public void realizarAccionAdicional(Jugador jugador, Jugador oponente,
                                        Atril atril, Posicion posicionElegida){

        Descarte descarteJugador = jugador.getDescarte();
        Unidad unidadParaRevivir = descarteJugador.getUltimaCarta();
        if(unidadParaRevivir != null){
            List<Posicion> posicionesPosibles = new ArrayList<>();
            posicionesPosibles.add(new CuerpoACuerpo());
            posicionesPosibles.add(new Distancia());
            posicionesPosibles.add(new Asedio());
            for(Posicion posicionRevivir: posicionesPosibles){
                if(unidadParaRevivir.sePuedeColocar(posicionRevivir)){
                    unidadParaRevivir.jugarCarta(jugador, oponente, posicionRevivir);
                    break;
                }
            }
        }

        //continuar la cadena
        super.unidad.realizarAccionAdicional(jugador, oponente, atril, posicionElegida);
    }

}
