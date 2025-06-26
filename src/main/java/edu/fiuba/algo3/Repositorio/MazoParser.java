package edu.fiuba.algo3.Repositorio;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.especiales.CEspecial;
import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.jugador.Mazo;

import java.util.ArrayList;
import java.util.List;

public class MazoParser {

  public static Mazo desdeJson(JSONObject mazoJson) {
    List<ICarta> unidades = new ArrayList<>();
    List<ICarta> especiales = new ArrayList<>();

    // Parsear unidades
    JSONArray unidadesArray = (JSONArray) mazoJson.get("unidades");
    for (Object obj : unidadesArray) {
      JSONObject cartaJson = (JSONObject) obj;
      Unidad unidad = CartaUnidadParser.desdeJson(cartaJson);
      unidades.add(unidad);
    }

    // Parsear especiales
    JSONArray especialesArray = (JSONArray) mazoJson.get("especiales");
    for (Object obj : especialesArray) {
      JSONObject cartaJson = (JSONObject) obj;
      CEspecial especial = CartaEspecialParser.desdeJson(cartaJson);
      especiales.add(especial);
    }

    Mazo mazo = new Mazo();
    mazo.agregarCarta(especiales);
    mazo.agregarCarta(unidades);
    return mazo;
  }
}
