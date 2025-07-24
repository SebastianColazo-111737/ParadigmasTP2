package edu.fiuba.algo3.modelo.carta.unidad;

import edu.fiuba.algo3.jsonParser.PosicionParser;
import edu.fiuba.algo3.modelo.carta.unidad.modificadores.*;
import edu.fiuba.algo3.modelo.carta.unidad.modificadores.Legendaria;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.posicion.Posicion;


import java.util.List;

public class UnidadFactory {

    public static Unidad crear(
            String nombre,
            int puntos,
            List<String> modificadoresTexto,
            List<String> posicionesTexto
    ){
        List<Posicion> posiciones = PosicionParser.crearPosiciones(posicionesTexto);
        Unidad nuevaUnidad = new UnidadBasica(nombre,new Puntaje(puntos), posiciones.get(0));

        return modificadoresTexto.isEmpty()?
                nuevaUnidad:
                aplicarModificadores(nuevaUnidad, modificadoresTexto, posiciones);
    }



    private static Unidad aplicarModificadores(
            Unidad unidadBasica,
            List<String> modificadoresTexto,
            List<Posicion> posiciones
    ){
        Unidad unidadModificada = unidadBasica;
        for(String modificador: modificadoresTexto){
            switch (modificador.toLowerCase()){
                case "legendaria": unidadModificada = new Legendaria(unidadModificada); break;
                case "carta unida": unidadModificada = new Unida(unidadModificada);  break;
                case "espia": unidadModificada = new Espia(unidadModificada);  break;
                case "impulso de moral": unidadModificada = new Animador(unidadModificada);  break;
                case "agil": unidadModificada = new Agil(unidadModificada, posiciones);  break;
                case "medico": unidadModificada = new Medico(unidadModificada); break;
            }
        }
        return unidadModificada;
    }
}
