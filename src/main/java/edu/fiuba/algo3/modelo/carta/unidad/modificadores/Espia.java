package edu.fiuba.algo3.modelo.carta.unidad.modificadores;


import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Espia extends UnidadModificada {
    private final static int CantidadDeCartasParaRobar = 2;

    public Espia(Unidad unidad) {
        super(unidad);
    }

    @Override
    public Atril atrilDestino(Jugador jugador, Jugador oponente){
        return oponente.getAtril();
    }

    @Override
    public void realizarAccionAdicional(Jugador jugador, Jugador oponente){
        jugador.robarCartasDelMazo(CantidadDeCartasParaRobar);

        //continura la cadena
        super.unidad.realizarAccionAdicional(jugador, oponente);
    }

}
