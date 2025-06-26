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
      return new BuffCartas(nombre, posiciones);
    }

    if (tipo.equals("Clima")) {
      JSONArray afectadoArray = (JSONArray) cartaJson.get("afectado");
      ArrayList<Posicion> posiciones = new ArrayList<>();

      for (Object o : afectadoArray) {
        String nombrePos = ((String) o).trim();

        if (nombrePos.equals("Combate Cuerpo a Cuerpo"))
          nombrePos = "Cuerpo a Cuerpo";
        else if (nombrePos.equals("Combate a Distancia"))
          nombrePos = "Rango";
        else
          nombrePos = "Asedio";
        JSONObject seccionFake = new JSONObject();
        seccionFake.put("seccion", nombrePos);
        posiciones.addAll(PosicionParser.desdeJson(seccionFake));
      }

      return new Debuff(nombre, posiciones);
    }

    if (tipo.equals("Tierra arrasada")) {
      return new TierraArrasada(nombre, null);
    }

    return null;
  }
}
