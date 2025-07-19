package edu.fiuba.algo3.jsonParser;

import edu.fiuba.algo3.modelo.posicion.*;

import java.util.ArrayList;
import java.util.List;

public class PosicionParser {

    public static List<Posicion> crearPosiciones(List<String> posicionesTexto){
        List<Posicion> posiciones = new ArrayList<>();
        for(String posicion: posicionesTexto){
            switch (posicion.toLowerCase()){
                case "cuerpo a cuerpo": posiciones.add(new CuerpoACuerpo()); break;
                case "rango": posiciones.add(new Distancia()); break;
                case "asedio": posiciones.add(new Asedio()); break;
            }
        }
        return posiciones;
    }
}
