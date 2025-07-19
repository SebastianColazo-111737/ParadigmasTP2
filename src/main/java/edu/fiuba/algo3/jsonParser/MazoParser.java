package edu.fiuba.algo3.jsonParser;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mazo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MazoParser {

    public static Mazo crearMazo(JSONObject mazoJson) {
        List<Carta> unidades = new ArrayList<>();
        List<Carta> especiales = new ArrayList<>();

        JSONArray unidadesArray = (JSONArray) mazoJson.get("unidades");
        for (Object obj : unidadesArray) {
            JSONObject cartaJson = (JSONObject) obj;
            Carta unidad = CartaUnidadParser.crearUnidad(cartaJson);
            unidades.add(unidad);
        }

        JSONArray especialesArray = (JSONArray) mazoJson.get("especiales");
        for (Object obj : especialesArray) {
            JSONObject cartaJson = (JSONObject) obj;
            Carta especial = CartaEspecialParser.crearEspecial(cartaJson);
            especiales.add(especial);
        }

        Mazo mazo = new Mazo();
        mazo.agregarCarta(especiales);
        mazo.agregarCarta(unidades);
        return mazo;
    }
}
