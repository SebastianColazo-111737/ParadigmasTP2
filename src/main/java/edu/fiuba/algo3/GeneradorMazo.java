package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;
import edu.fiuba.algo3.modelo.jugador.Mazo;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;

public class GeneradorMazo {
    public static Mazo desdeNombre(String nombre){
        Mazo mazo = new Mazo();

        switch (nombre) {
            case "MAZO1":
                mazo.agregarCarta(new UnidadBasica("Espadachin", new Puntaje(4), new CuerpoACuerpo()));
                mazo.agregarCarta(new UnidadBasica("Arquero", new Puntaje(3), new Distancia()));
                break;
            case "MAZO2":
                mazo.agregarCarta(new UnidadBasica("Mago", new Puntaje(5), new Distancia()));
                mazo.agregarCarta(new UnidadBasica("Catapulta", new Puntaje(6), new Asedio()));
                break;
            case "MAZO3":
                mazo.agregarCarta(new UnidadBasica("Soldado", new Puntaje(2), new CuerpoACuerpo()));
                mazo.agregarCarta(new UnidadBasica("Hechicero", new Puntaje(4), new Distancia()));
                break;
            default:
                // Mazo por defecto
                mazo.agregarCarta(new UnidadBasica("Espadachin", new Puntaje(1), new CuerpoACuerpo()));
                break;
        }
        return  mazo;
    }


}
