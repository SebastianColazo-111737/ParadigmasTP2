package edu.fiuba.algo3.modelo.cartas.especiales;

import edu.fiuba.algo3.modelo.cartas.Especial;
import edu.fiuba.algo3.modelo.jugador.Seccion;

// QUE PASA SI SE USA SOBRE UNA SECCION RIVAL?
public class MoralBoost extends Especial {
    @Override
    public void activar(Seccion seccion) {
        seccion.duplicarPuntos();
    }
}
