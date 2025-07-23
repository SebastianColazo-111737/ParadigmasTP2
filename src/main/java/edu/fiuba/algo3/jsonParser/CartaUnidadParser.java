package edu.fiuba.algo3.jsonParser;


import edu.fiuba.algo3.modelo.carta.unidad.UnidadFactory;
import edu.fiuba.algo3.modelo.carta.unidad.Unidad;


import edu.fiuba.algo3.vista.vistas.cartas.CacheEstilosVistaCarta;
import edu.fiuba.algo3.vista.vistas.cartas.Unidades.EstiloCartaUnidad;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class CartaUnidadParser {

    public static Unidad crearUnidad(JSONObject unidadJson) {
        String nombre = (String) unidadJson.get("nombre");

        int puntos = ((Long) unidadJson.get("puntos")).intValue();

        List<String> modificadores = new ArrayList<>();
        JSONArray modsArray = (JSONArray) unidadJson.get("modificador");
        for (Object mod : modsArray) {
            modificadores.add((String) mod);
        }

        String posicionesTexto = (String) unidadJson.get("seccion");
        List<String> posiciones = List.of(posicionesTexto.split(",\\s*"));

        Unidad nuevaUnidad = UnidadFactory.crear(nombre, puntos, modificadores, posiciones);

        // si es una nueva carta cargo su estilo
        if (!CacheEstilosVistaCarta.getInstancia().contieneEstilo(nombre)) {
            EstiloCartaUnidad nuevoEstilo = new EstiloCartaUnidad(modificadores, posiciones);
            CacheEstilosVistaCarta.getInstancia().agregarEstilo(nombre, nuevoEstilo);
        }

        return nuevaUnidad;
    }
}
