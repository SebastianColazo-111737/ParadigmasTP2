package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.jugador.Seccion;

// QUE PASARIA SI HAY UNA CARTA QUE ELIMINA LOS MODIFICADORES?
public interface Modificador {
    public void aplicarEfecto(Seccion seccion);
}
