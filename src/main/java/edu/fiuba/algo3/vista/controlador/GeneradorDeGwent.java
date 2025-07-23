package edu.fiuba.algo3.vista.controlador;

import edu.fiuba.algo3.jsonParser.MazoParser;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mano;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mazo;
import edu.fiuba.algo3.modelo.gwent.Gwent;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class GeneradorDeGwent {

    public static Gwent construirGwent(String nombreArchivoJson) throws Exception {
        Mazo mazo1 = generarMazo(nombreArchivoJson, "mazo_jugador_uno");
        Mazo mazo2 = generarMazo(nombreArchivoJson, "mazo_jugador_dos");

        Mano mano1 = new Mano();
        Mano mano2 = new Mano();

        Jugador jugador1 = new Jugador(mazo1, mano1, crearAtril());
        Jugador jugador2 = new Jugador(mazo2, mano2, crearAtril());

        Gwent juego = new Gwent(jugador1, jugador2);
        juego.setJugadorActual(jugador1);

        return juego;
    }

    private static Mazo generarMazo(String archivo, String mazoString) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(new FileReader(archivo));
        JSONObject mazoJson = (JSONObject) root.get(mazoString);
        return MazoParser.crearMazo(mazoJson);
    }

    private static Atril crearAtril() {
        Atril atril = new Atril();
        atril.agregarSeccion(new Seccion(new CuerpoACuerpo()));
        atril.agregarSeccion(new Seccion(new Distancia()));
        atril.agregarSeccion(new Seccion(new Asedio()));
        return atril;
    }
}
