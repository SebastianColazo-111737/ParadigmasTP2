package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Mano;
import edu.fiuba.algo3.modelo.jugador.Mazo;
import edu.fiuba.algo3.modelo.jugador.atril.Atril;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import edu.fiuba.algo3.vistas.Lienzo;

import java.util.List;


public class GeneradorJuego {

    public static Lienzo construirJuego(){

        Mano mano1 = new Mano();
        Mano mano2 = new Mano();

        Mazo mazo1 = new Mazo();
        Mazo mazo2 = new Mazo();

        Seccion cuerpo1 = new Seccion(new CuerpoACuerpo());
        Seccion distancia1 = new Seccion(new Distancia());
        Seccion asedio1 = new Seccion(new Asedio());

        Seccion cuerpo2 = new Seccion(new CuerpoACuerpo());
        Seccion distancia2 = new Seccion(new Distancia());
        Seccion asedio2 = new Seccion(new Asedio());


        Atril atril1 = new Atril();
        Atril atril2 = new Atril();

        Jugador jugador1 = new Jugador(mazo1, mano1, atril1);
        Jugador jugador2 = new Jugador(mazo2, mano2, atril2);

        Gwent gwent = new Gwent(jugador1,jugador2);

        return new Lienzo(jugador1,jugador2);
    }
}
