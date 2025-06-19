package edu.fiuba.algo3.modeloTest.CartasTest;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.cartas.Especial;
import edu.fiuba.algo3.modelo.cartas.Unidad;
import edu.fiuba.algo3.modelo.cartas.especiales.MoralBoost;
import edu.fiuba.algo3.modelo.cartas.especiales.Nieve;
import edu.fiuba.algo3.modelo.cartas.especiales.TierraArrasada;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EspecialTest {
    @Test
    public void TierraArrasadaEliminaUnidadesMasFuertes(){
        // ARRANGE
        // SIMULO JUEGO
        Jugador jugador1 = new Jugador("nico");
        Jugador jugador2 = new Jugador("aksel");

        // SIMULO JUEGO
        Seccion seccion1 = new Seccion(new CuerpoACuerpo(),jugador1);
        seccion1.agregarUnidad(new Unidad("barbaro",5,new ArrayList<Posicion>(List.of(new CuerpoACuerpo())),false));
        //seccion1.agregarUnidad(new Unidad("ciclope",25,new ArrayList<Posicion>(List.of(new CuerpoACuerpo())),false));
        seccion1.agregarUnidad(new Unidad("mago",10,new ArrayList<Posicion>(List.of(new CuerpoACuerpo())),false));

        Seccion seccion2 = new Seccion(new Distancia(),jugador1);
        seccion2.agregarUnidad(new Unidad("arquero",7,new ArrayList<Posicion>(List.of(new Distancia())),false));
        seccion2.agregarUnidad(new Unidad("ballestero",12,new ArrayList<Posicion>(List.of(new Distancia())),false));
        seccion2.agregarUnidad(new Unidad("troll",15,new ArrayList<Posicion>(List.of(new Distancia())),false));

        Seccion seccion3 = new Seccion(new Asedio(),jugador1);
        //seccion3.agregarUnidad(new Unidad("catapulta",25,new ArrayList<Posicion>(List.of(new Asedio())),false));
        seccion3.agregarUnidad(new Unidad("helepolis",20,new ArrayList<Posicion>(List.of(new Asedio())),false));
        //seccion3.agregarUnidad(new Unidad("ballesta",15,new ArrayList<Posicion>(List.of(new Asedio())),false));

        Seccion seccion4 = new Seccion(new CuerpoACuerpo(),jugador2);
        seccion4.agregarUnidad(new Unidad("leon",20,new ArrayList<Posicion>(List.of(new CuerpoACuerpo())),false));
        seccion4.agregarUnidad(new Unidad("jinete",20,new ArrayList<Posicion>(List.of(new CuerpoACuerpo())),false));
        seccion4.agregarUnidad(new Unidad("coloso",20,new ArrayList<Posicion>(List.of(new CuerpoACuerpo())),false));

        Seccion seccion5 = new Seccion(new Distancia(),jugador2);
        seccion5.agregarUnidad(new Unidad("arquero",7,new ArrayList<Posicion>(List.of(new Distancia())),false));
        //seccion5.agregarUnidad(new Unidad("lanzador de honda",5,new ArrayList<Posicion>(List.of(new Distancia())),false));
        seccion5.agregarUnidad(new Unidad("troll",15,new ArrayList<Posicion>(List.of(new Distancia())),false));

        Seccion seccion6 = new Seccion(new Asedio(),jugador2);
        seccion6.agregarUnidad(new Unidad("catapulta",25,new ArrayList<Posicion>(List.of(new Asedio())),false));
        //seccion6.agregarUnidad(new Unidad("catapulta",25,new ArrayList<Posicion>(List.of(new Asedio())),false));
        //seccion6.agregarUnidad(new Unidad("ballesta",15,new ArrayList<Posicion>(List.of(new Asedio())),false));


        List<Seccion> secciones = new ArrayList<>(List.of(seccion1,seccion2,seccion3,
                                                            seccion4,seccion5,seccion6));
        // SE CREA
        TierraArrasada cartaUser = new TierraArrasada(secciones);


        // ACT
        cartaUser.jugarEnSeccion(seccion4);
        List<Carta> descarte1 = jugador1.getDescarte();
        List<Unidad> unidadesActuales1 = seccion1.getUnidadesColocadas();
        List<Carta> descarte2 = jugador2.getDescarte();
        List<Unidad> unidadesActuales2 = seccion6.getUnidadesColocadas();

        // ASSERT
        assertEquals(3,descarte1.size());
        assertEquals(1,unidadesActuales1.size());
        assertEquals(3,descarte2.size());
        assertEquals(0,unidadesActuales2.size());
    }

    @Test
    public void NieveReduceA1TodasLasUnidadesDeSeccion(){
        // ARRANGE
        // SIMULO JUEGO
        Jugador jugador1 = new Jugador("nico");
        Jugador jugador2 = new Jugador("aksel");

        // SIMULO JUEGO
        Seccion seccion1 = new Seccion(new CuerpoACuerpo(),jugador1);
        seccion1.agregarUnidad(new Unidad("barbaro",5,new ArrayList<Posicion>(List.of(new CuerpoACuerpo())),false));
        //seccion1.agregarUnidad(new Unidad("ciclope",25,new ArrayList<Posicion>(List.of(new CuerpoACuerpo())),false));
        seccion1.agregarUnidad(new Unidad("mago",10,new ArrayList<Posicion>(List.of(new CuerpoACuerpo())),false));

        Seccion seccion4 = new Seccion(new CuerpoACuerpo(),jugador2);
        seccion4.agregarUnidad(new Unidad("leon",20,new ArrayList<Posicion>(List.of(new CuerpoACuerpo())),false));
        seccion4.agregarUnidad(new Unidad("jinete",20,new ArrayList<Posicion>(List.of(new CuerpoACuerpo())),false));
        seccion4.agregarUnidad(new Unidad("coloso",20,new ArrayList<Posicion>(List.of(new CuerpoACuerpo())),false));

        Seccion seccion6 = new Seccion(new Asedio(),jugador2);
        seccion6.agregarUnidad(new Unidad("catapulta",25,new ArrayList<Posicion>(List.of(new Asedio())),false));

        List<Seccion> seccionesAfectadas = new ArrayList<>(List.of(seccion1,seccion4));
        Nieve cartaUser = new Nieve(seccionesAfectadas,1);

        // ACT
        // NO DEBERIA IMPORTAR DONDE TOQUE EL USUARIO, NIEVE YA VA A SABER DONDE AFECTAR
        cartaUser.jugarEnSeccion(seccion6);
        int puntosTotales1 = seccion1.obtenerPuntosTotales();
        int puntosTotales4 = seccion4.obtenerPuntosTotales();

        assertEquals(2,puntosTotales1);
        assertEquals(3,puntosTotales4);
    }

    @Test
    public void MoralBoostAfectaSeccionELegida(){
        // ARRANGE
        // SIMULO JUEGO
        Jugador jugador1 = new Jugador("nico");

        Seccion seccion1 = new Seccion(new CuerpoACuerpo(),jugador1);
        seccion1.agregarUnidad(new Unidad("barbaro",5,new ArrayList<Posicion>(List.of(new CuerpoACuerpo())),false));
        //seccion1.agregarUnidad(new Unidad("ciclope",25,new ArrayList<Posicion>(List.of(new CuerpoACuerpo())),false));
        seccion1.agregarUnidad(new Unidad("mago",10,new ArrayList<Posicion>(List.of(new CuerpoACuerpo())),false));

        // ACT
        MoralBoost cartaUser = new MoralBoost();
        cartaUser.jugarEnSeccion(seccion1);
        int puntosTotales = seccion1.obtenerPuntosTotales();

        // ASSERT
        assertEquals(30, puntosTotales);
    }
}
