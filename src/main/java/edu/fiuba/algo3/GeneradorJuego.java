package edu.fiuba.algo3;

import java.util.List;
import java.util.ArrayList;

import edu.fiuba.algo3.vistas.Lienzo;

import edu.fiuba.algo3.modelo.juego.Gwent;

import edu.fiuba.algo3.modelo.jugador.Mano;
import edu.fiuba.algo3.modelo.jugador.Mazo;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Atril;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;

import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;


public class GeneradorJuego {

    public static Lienzo construirJuego() {
        // Crear cartas para ambos jugadores
        List<ICarta> cartasJ1 = new ArrayList<>();
        List<ICarta> cartasJ2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            cartasJ1.add(new UnidadBasica("Espadachin", new Puntaje(4), new CuerpoACuerpo()));
            cartasJ2.add(new UnidadBasica("Arquero", new Puntaje(3), new Distancia()));
        }

        for (int i = 0; i < 11; i++) {
            cartasJ1.add(new UnidadBasica("Mago", new Puntaje(5), new Distancia()));
            cartasJ2.add(new UnidadBasica("Catapulta", new Puntaje(8), new Asedio()));
        }

        // Jugador 1
        Mazo mazoJ1 = new Mazo();
        mazoJ1.agregarCarta(cartasJ1);
        Mano manoJ1 = new Mano();
        manoJ1.agregarCarta(mazoJ1.darCartas(10));


        Seccion cuerpoACuerpoJ1 = new Seccion(new CuerpoACuerpo());
        Seccion distanciaJ1 = new Seccion(new Distancia());
        Seccion asedioJ1 = new Seccion(new Asedio());
        Atril atrilJ1 = new Atril();
        atrilJ1.agregarSeccion(cuerpoACuerpoJ1);
        atrilJ1.agregarSeccion(distanciaJ1);
        atrilJ1.agregarSeccion(asedioJ1);

        Jugador jugador1 = new Jugador(mazoJ1, manoJ1, atrilJ1);

        // Jugador 2
        Mazo mazoJ2 = new Mazo();
        mazoJ2.agregarCarta(cartasJ2);
        Mano manoJ2 = new Mano();
        manoJ2.agregarCarta(mazoJ2.darCartas(10));


        Seccion cuerpoACuerpoJ2 = new Seccion(new CuerpoACuerpo());
        Seccion distanciaJ2 = new Seccion(new Distancia());
        Seccion asedioJ2 = new Seccion(new Asedio());
        Atril atrilJ2 = new Atril();
        atrilJ2.agregarSeccion(cuerpoACuerpoJ2);
        atrilJ2.agregarSeccion(distanciaJ2);
        atrilJ2.agregarSeccion(asedioJ2);

        Jugador jugador2 = new Jugador(mazoJ2, manoJ2, atrilJ2);

        // Inicializar juego
        Gwent juego = new Gwent(jugador1, jugador2);
        ControladorTurnos controladorTurnos = new ControladorTurnos(juego);

        return new Lienzo(jugador1, jugador2, juego, controladorTurnos);
    }
}