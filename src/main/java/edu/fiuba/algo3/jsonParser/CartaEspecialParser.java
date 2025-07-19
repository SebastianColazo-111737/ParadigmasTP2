package edu.fiuba.algo3.jsonParser;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.Especial.Clima;
import edu.fiuba.algo3.modelo.carta.Especial.ClimaSoleado;
import edu.fiuba.algo3.modelo.carta.Especial.MoraleBoost;
import edu.fiuba.algo3.modelo.carta.Especial.TierraArrasada;

import edu.fiuba.algo3.modelo.posicion.Posicion;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class CartaEspecialParser {

    public static Carta crearEspecial(JSONObject especialJson) {
        String nombre = (String) especialJson.get("nombre");
        String descripcion = (String) especialJson.get("descripcion");
        String tipo = (String) especialJson.get("tipo");
        List<Posicion> posiciones = new ArrayList<>();

        JSONArray posicionesAfectadasJson = (JSONArray) especialJson.get("afectado");
        if(posicionesAfectadasJson != null){
            List<String> posicionesTexto = new ArrayList<>();
            for (Object mod : posicionesAfectadasJson){
                posicionesTexto.add((String) mod);
            }
            posiciones.addAll(PosicionParser.crearPosiciones(posicionesTexto));
        }


        Carta nuevaEspecial = null;
        switch (tipo.toLowerCase()){
            case "morale boost": nuevaEspecial = new MoraleBoost(nombre); break;
            case "tierra arrasada": nuevaEspecial = new TierraArrasada(nombre); break;
            case "clima": nuevaEspecial = nombre.equals("Tiempo despejado")?
                        new ClimaSoleado(nombre, posiciones):
                        new Clima(nombre, posiciones); break;
        }
        return nuevaEspecial;
    }
}
