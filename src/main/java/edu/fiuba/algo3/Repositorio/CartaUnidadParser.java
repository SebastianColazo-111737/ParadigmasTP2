package edu.fiuba.algo3.Repositorio;

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
    Unidad carta = null;
    List<Posicion> posicion = PosicionParser.desdeJson(cartaJson);

    List<String> modificadores = new ArrayList<>();
    JSONArray mods = (JSONArray) cartaJson.get("modificador");
    for (Object mod : mods) {
      modificadores.add((String) mod);
    }
    String modificador = "";
    if (modificadores.size() > 0)
      modificador = modificadores.get(0);
    if (modificador == "Medico")
      carta = new Medico((String) cartaJson.get("nombre"), new Puntaje(Math.toIntExact((Long) cartaJson.get("puntos"))),
          posicion.get(0));
    else if (modificador == "Legendaria")
      carta = new Legendaria((String) cartaJson.get("nombre"),
          new Puntaje(Math.toIntExact((Long) cartaJson.get("puntos"))), posicion.get(0));

    else if (modificador == "Carta Unida")
      carta = new Unidas((String) cartaJson.get("nombre"),
          new Puntaje(Math.toIntExact((Long) cartaJson.get("puntos"))), posicion.get(0));
    else if (modificador == "Morale Boost")
      carta = new Animador((String) cartaJson.get("nombre"),
          new Puntaje(Math.toIntExact((Long) cartaJson.get("puntos"))), posicion.get(0));
    else if (modificador == "Agil")
      carta = new Agil((String) cartaJson.get("nombre"),
          new Puntaje(Math.toIntExact((Long) cartaJson.get("puntos"))), posicion.get(0), posicion.get(1));

    else if (modificador == "Espia")
      carta = new Espia((String) cartaJson.get("nombre"),
          new Puntaje(Math.toIntExact((Long) cartaJson.get("puntos"))), posicion.get(0));

    else
      carta = new UnidadBasica((String) cartaJson.get("nombre"),
          new Puntaje(Math.toIntExact((Long) cartaJson.get("puntos"))), posicion.get(0));

    return carta;
  }
}
