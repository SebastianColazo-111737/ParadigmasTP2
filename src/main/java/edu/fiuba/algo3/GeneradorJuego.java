package edu.fiuba.algo3;

import java.io.FileReader;

import edu.fiuba.algo3.Repositorio.MazoParser;
import edu.fiuba.algo3.modelo.jugador.Mazo;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import edu.fiuba.algo3.vistas.Lienzo;

import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Mano;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Atril;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;

import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;


public class GeneradorJuego {

    public static Lienzo construirJuego() {
        Mazo mazoJ1 = null;
        Mazo mazoJ2 = null;
        Mano manoJ1 = new Mano();
        Mano manoJ2 = new Mano();
      try {
            // Jugador 1
            mazoJ1 = generarMazo("mazo_jugador_uno");
            manoJ1.agregarCarta(mazoJ1.darCartas(10));


            // Jugador 2
            mazoJ2 = generarMazo("mazo_jugador_uno");
            manoJ2.agregarCarta(mazoJ2.darCartas(10));

        } catch (Exception e) {

        }
        Seccion cuerpoACuerpoJ1 = new Seccion(new CuerpoACuerpo());
        Seccion distanciaJ1 = new Seccion(new Distancia());
        Seccion asedioJ1 = new Seccion(new Asedio());
        Atril atrilJ1 = new Atril();
        atrilJ1.agregarSeccion(cuerpoACuerpoJ1);
        atrilJ1.agregarSeccion(distanciaJ1);
        atrilJ1.agregarSeccion(asedioJ1);
        Jugador jugador1 = new Jugador(mazoJ1, manoJ1, atrilJ1);
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
    private static Mazo generarMazo(String mazoString) throws Exception {
        Mazo mazo;
        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(new FileReader("src/test/resources/json/gwent3.json"));

        JSONObject mazoJson = (JSONObject) root.get(mazoString);

        mazo = MazoParser.desdeJson(mazoJson);
        return mazo;
    }

}