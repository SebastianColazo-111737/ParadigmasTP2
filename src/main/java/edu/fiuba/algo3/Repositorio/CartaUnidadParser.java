package edu.fiuba.algo3.Repositorio;

import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import org.json.simple.JSONObject;

import edu.fiuba.algo3.modelo.cartas.unidades.Agil;
import edu.fiuba.algo3.modelo.cartas.unidades.Animador;
import edu.fiuba.algo3.modelo.cartas.unidades.Espia;
import edu.fiuba.algo3.modelo.cartas.unidades.Legendaria;
import edu.fiuba.algo3.modelo.cartas.unidades.Medico;
import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;
import edu.fiuba.algo3.modelo.cartas.unidades.Unidas;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

import org.json.simple.JSONArray;
import java.util.ArrayList;
import java.util.List;

public class CartaUnidadParser {

  public static Unidad desdeJson(JSONObject cartaJson) {
    Unidad carta;

    List<Posicion> posiciones = PosicionParser.desdeJson(cartaJson);
    List<String> modificadores = new ArrayList<>();

    JSONArray mods = (JSONArray) cartaJson.get("modificador");
    for (Object mod : mods) {
      modificadores.add((String) mod);
    }

    String nombreOriginal = (String) cartaJson.get("nombre");
    String nombreConEmoji = agregarEmojisPosicion(nombreOriginal, posiciones);

    int puntos = Math.toIntExact((Long) cartaJson.get("puntos"));
    Puntaje puntaje = new Puntaje(puntos);

    String modificador = modificadores.isEmpty() ? "" : modificadores.get(0);

    if (modificador.equals("Medico")) {
      carta = new Medico(nombreConEmoji, puntaje, posiciones.get(0));
    } else if (modificador.equals("Legendaria")) {
      carta = new Legendaria(nombreConEmoji, puntaje, posiciones.get(0));
    } else if (modificador.equals("Carta Unida")) {
      carta = new Unidas(nombreConEmoji, puntaje, posiciones.get(0));
    } else if (modificador.equals("Morale Boost")) {
      carta = new Animador(nombreConEmoji, puntaje, posiciones.get(0));
    } else if (modificador.equals("Agil")) {
      carta = new Agil(nombreConEmoji, puntaje, posiciones.get(0), posiciones.get(1));
    } else if (modificador.equals("Espia")) {
      carta = new Espia(nombreConEmoji, puntaje, posiciones.get(0));
    } else {
      carta = new UnidadBasica(nombreConEmoji, puntaje, posiciones.get(0));
    }

    return carta;
  }

  private static String agregarEmojisPosicion(String nombreOriginal, List<Posicion> posiciones) {
    StringBuilder sb = new StringBuilder(nombreOriginal);
    sb.append("\n");

    for (Posicion p : posiciones) {
      if (p instanceof CuerpoACuerpo) {
        sb.append("🗡️ ");
      } else if (p instanceof Distancia) {
        sb.append("⋙ ");
      } else if (p instanceof Asedio) {
        sb.append("🛡️ ");
      }
    }

    return sb.toString().trim();
  }



}
