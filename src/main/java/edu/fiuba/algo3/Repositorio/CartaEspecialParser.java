package edu.fiuba.algo3.Repositorio;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import edu.fiuba.algo3.modelo.cartas.especiales.*;
import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

import java.util.ArrayList;

public class CartaEspecialParser {

  public static CEspecial desdeJson(JSONObject cartaJson) {
    String nombre = (String) cartaJson.get("nombre");
    String descripcion = (String) cartaJson.get("descripcion");
    String tipo = (String) cartaJson.get("tipo");
    if (tipo.equals("Morale boost")) {
      ArrayList<Posicion> posiciones = new ArrayList<>();
      posiciones.add(new CuerpoACuerpo());
      posiciones.add(new Distancia());
      posiciones.add(new Asedio());

      return new BuffCartas(nombre, posiciones, descripcion);
    }

    if (tipo.equals("Clima")) {

      if (nombre.equalsIgnoreCase("Tiempo despejado")) {
        ArrayList<Posicion> todasLasPosiciones = new ArrayList<>();
        todasLasPosiciones.add(new CuerpoACuerpo());
        todasLasPosiciones.add(new Distancia());
        todasLasPosiciones.add(new Asedio());
        return new DeBuffCleaner(nombre, todasLasPosiciones, descripcion);
      }

      JSONArray afectadoArray = (JSONArray) cartaJson.get("afectado");
      ArrayList<Posicion> posiciones = new ArrayList<>();

      for (Object o : afectadoArray) {
        String nombrePos = ((String) o).trim();

        String nombreNormalizado = nombrePos.toLowerCase();

        if (nombreNormalizado.contains("cuerpo")) {
          nombrePos = "Cuerpo a Cuerpo";
        } else if (nombreNormalizado.contains("distancia")) {
          nombrePos = "Rango";
        } else if (nombreNormalizado.contains("asedio")) {
          nombrePos = "Asedio";
        } else {
          throw new IllegalArgumentException("Nombre de posición no reconocido: " + nombrePos);
        }

        JSONObject seccionFake = new JSONObject();
        seccionFake.put("seccion", nombrePos);
        posiciones.addAll(PosicionParser.desdeJson(seccionFake));
      }

      return new Debuff(nombre, posiciones, descripcion);
    }

    if (tipo.equals("Tierra arrasada")) {
      return new TierraArrasada(nombre, new ArrayList<>(), descripcion);
    }

    return null;
  }
}
