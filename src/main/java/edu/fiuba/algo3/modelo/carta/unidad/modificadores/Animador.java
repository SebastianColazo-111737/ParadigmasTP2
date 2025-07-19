package edu.fiuba.algo3.modelo.carta.unidad.modificadores;

import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.EfectoAumentar;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;

public class Animador extends UnidadModificada{

    public Animador(Unidad unidad) {
        super(unidad);
    }

    @Override
    public void realizarAccionAdicional(Jugador jugador, Jugador oponente,
                                        Atril atrilDestino, Posicion posicionElegida){

        atrilDestino.agregarEfecto(new EfectoAumentar(1), posicionElegida);
        super.realizarAccionAdicional(jugador, oponente, atrilDestino, posicionElegida);
    }
}
