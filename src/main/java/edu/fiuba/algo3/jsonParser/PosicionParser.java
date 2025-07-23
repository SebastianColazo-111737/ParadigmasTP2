package edu.fiuba.algo3.jsonParser;

import edu.fiuba.algo3.modelo.posicion.*;

import java.util.ArrayList;
import java.util.List;

public class PosicionParser {

    public static List<Posicion> crearPosiciones(List<String> posicionesTexto){
        List<Posicion> posiciones = new ArrayList<>();
        for(String posicion: posicionesTexto){
            posiciones.add(crearPosicion(posicion));
        }
        return posiciones;
    }

    public static Posicion crearPosicion(String posicionTexto){
        Posicion posicion = null;
        switch (posicionTexto.toLowerCase()){
            case "cuerpo a cuerpo": posicion = new CuerpoACuerpo(); break;
            case "rango": posicion = new Distancia(); break;
            case "asedio": posicion = new Asedio(); break;
        }
        return posicion;
    }
}
