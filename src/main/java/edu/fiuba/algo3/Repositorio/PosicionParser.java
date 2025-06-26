package edu.fiuba.algo3.Repositorio;

import org.json.simple.JSONObject;
import edu.fiuba.algo3.modelo.posiciones.*;

import java.util.ArrayList;
import java.util.List;

public class PosicionParser {

  public static List<Posicion> desdeJson(JSONObject jsonCarta) {
    List<Posicion> posiciones = new ArrayList<>();

    String seccion = (String) jsonCarta.get("seccion");

    if (seccion == null) {
      return posiciones;
    }

    String[] secciones = seccion.split(",");

    for (String nombre : secciones) {
      nombre = nombre.trim();

      switch (nombre) {
        case "Cuerpo a Cuerpo":
          posiciones.add(new CuerpoACuerpo());
          break;
        case "Rango":
          posiciones.add(new Distancia());
          break;
        case "Asedio":
          posiciones.add(new Asedio());
          break;
        default:
          break;
      }
    }

    return posiciones;
  }
}
