package edu.fiuba.algo3.modeloTest.CartasTest;


import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.cartas.Unidad;
import edu.fiuba.algo3.modelo.cartas.especiales.Nieve;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Seccion;
import edu.fiuba.algo3.modelo.modificadores.*;
import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnidadTest {

    @Test
    public void UnidadSimpleSePuedeColocarEnSeccionPropiaConMismaPosicion(){
        // ARRANGE
        Jugador jugador = new Jugador("aksel");
        Seccion seccionUser = new Seccion(new CuerpoACuerpo(),jugador);

        List<Posicion> posiciones = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad unidadUser = new Unidad("barbaro",5,posiciones,false);

        // ACT
        unidadUser.jugarEnSeccion(seccionUser);
        List<Unidad> unidadesJugadas = seccionUser.getUnidadesColocadas();

        // ASSERT
        assertEquals(1,unidadesJugadas.size());
    }

    @Test
    public void UnidadSimpleNoSePuedeColocarEnSeccionRivalConMismaPosicion(){
        // INVASIVA = FALSE DEBERIA ARROJAR EXCEPCION
        // ACA DEBERIAS IMPLEMENTAR EXCEPCIONES (CUESTION DE SINTAXIS Y USO QUE NO ENTIENDO)
    }

    @Test
    public void UnidadSimpleNoSePuedeColocarEnSeccionConPosicionDiferente(){
        // COMPARAR POSICION DEBERIA ARROJAR EXCEPCION
        // ACA DEBERIAS IMPLEMENTAR EXCEPCIONES (CUESTION DE SINTAXIS Y USO QUE NO ENTIENDO)
    }

    @Test
    public void UnidadConModificadoresSePuedeColocarEnSeccionPropia(){
        // ARRANGE
        Jugador jugador = new Jugador("aksel");
        Seccion seccionUser = new Seccion(new CuerpoACuerpo(),jugador);

        List<Posicion> posiciones = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad unidadUser = new Unidad("barbaro",5,posiciones,false);

        Modificador legendaria = new Legendaria(unidadUser,20);
        List<Modificador> modificadores = new ArrayList<>(List.of(legendaria));
        unidadUser.setModificadores(modificadores);

        // ACT
        unidadUser.jugarEnSeccion(seccionUser);
        List<Unidad> unidadesJugadas = seccionUser.getUnidadesColocadas();

        // ASSERT
        assertEquals(1,unidadesJugadas.size());
    }

    @Test
    public void UnidadLegendariaAumentaSusPuntos(){
        // ARRANGE
        Jugador jugador = new Jugador("aksel");
        Seccion seccionUser = new Seccion(new CuerpoACuerpo(),jugador);

        List<Posicion> posiciones = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad unidadUser = new Unidad("barbaro",5,posiciones,false);

        Modificador legendaria = new Legendaria(unidadUser,20);
        List<Modificador> modificadores = new ArrayList<>(List.of(legendaria));
        unidadUser.setModificadores(modificadores);

        // ACT
        unidadUser.jugarEnSeccion(seccionUser);
        int puntosDeUnidadLegendaria = seccionUser.obtenerPuntosTotales();

        // ASSERT
        assertEquals(20,puntosDeUnidadLegendaria);
    }

    @Test
    public void UnidadUnidasAumentaUnidadDeNombreIgualEnSeccion(){
        // ARRANGE
        Jugador jugador = new Jugador("aksel");
        Seccion seccionUser = new Seccion(new CuerpoACuerpo(),jugador);

        // OTRAS UNIDADES QUE SE JUGARON ANTES
        List<Posicion> posiciones1 = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad carta1 = new Unidad("ciclope",25,posiciones1,false);
        carta1.jugarEnSeccion(seccionUser);
        List<Posicion> posiciones2 = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad carta2 = new Unidad("jinete",10,posiciones2,false);
        carta2.jugarEnSeccion(seccionUser);
        List<Posicion> posiciones = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad carta13 = new Unidad("barbaro",5,posiciones,false);
        carta13.jugarEnSeccion(seccionUser);

        List<Posicion> posicionesUnidadUser = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad unidadUser = new Unidad("barbaro",5,posicionesUnidadUser,false);

        Unidas unidas = new Unidas(unidadUser.getNombre());
        List<Modificador> modificadores = new ArrayList<>(List.of(unidas));
        unidadUser.setModificadores(modificadores);

        // ACT
        unidadUser.jugarEnSeccion(seccionUser);
        int puntosTotales = seccionUser.obtenerPuntosTotales();

        // ASSERT
        assertEquals(55,puntosTotales);
    }

    @Test
    public void UnidadSumaDeValorBaseAumentaTodasLasUnidadesEnSeccion(){
        // ARRANGE
        Jugador jugador = new Jugador("aksel");
        Seccion seccionUser = new Seccion(new CuerpoACuerpo(),jugador);

        // OTRAS UNIDADES QUE SE JUGARON ANTES
        List<Posicion> posiciones1 = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad carta1 = new Unidad("ciclope",25,posiciones1,false);
        carta1.jugarEnSeccion(seccionUser);
        List<Posicion> posiciones2 = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad carta2 = new Unidad("jinete",10,posiciones2,false);
        carta2.jugarEnSeccion(seccionUser);
        List<Posicion> posiciones = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad carta13 = new Unidad("barbaro",5,posiciones,false);
        carta13.jugarEnSeccion(seccionUser);

        List<Posicion> posicionesUnidadUser = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad unidadUser = new Unidad("mago",10,posicionesUnidadUser,false);

        SumaValorBase sumaValorBase = new SumaValorBase(1);
        List<Modificador> modificadores = new ArrayList<>(List.of(sumaValorBase));
        unidadUser.setModificadores(modificadores);

        // ACT
        unidadUser.jugarEnSeccion(seccionUser);
        int puntosTotales = seccionUser.obtenerPuntosTotales();

        // ASSERT
        assertEquals(54,puntosTotales);
    }

    @Test
    public void UnidadMedicoReviveUnidadSimpleDescartada(){
        // ARRANGE
        Jugador jugador = new Jugador("aksel");
        Seccion seccionUser = new Seccion(new CuerpoACuerpo(),jugador);

        // OTRAS UNIDADES QUE SE JUGARON ANTES
        List<Posicion> posiciones = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad unidadSimple = new Unidad("barbaro",5,posiciones,false);
        List<Carta> descarte = new ArrayList<>(List.of(unidadSimple));

        // CREO UNIDAD A EVALUAR
        List<Posicion> posicionesUnidadUser = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad unidadUser = new Unidad("mago oscuro",15,posicionesUnidadUser,false);

        // AGREGO MODIFICADORES
        Medico medico = new Medico(descarte);
        List<Modificador> modificadores = new ArrayList<>(List.of(medico));
        unidadUser.setModificadores(modificadores);

        // ACT
        unidadUser.jugarEnSeccion(seccionUser);
        List<Unidad> unidadesColocadas = seccionUser.getUnidadesColocadas();

        // ASSERT
        assertEquals(2,unidadesColocadas.size());
    }

    @Test
    public void UnidadMedicoReviveUnidadSumaValorBase(){
        // ARRANGE
        Jugador jugador = new Jugador("aksel");
        Seccion seccionUser = new Seccion(new CuerpoACuerpo(),jugador);

        // OTRAS UNIDADES QUE SE JUGARON ANTES
        List<Posicion> posiciones = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad unidadMuerta = new Unidad("mago",10,posiciones,false);
        SumaValorBase sumaValorBase = new SumaValorBase(3);
        List<Modificador> modificadoresUnidadMuerta = new ArrayList<>(List.of(sumaValorBase));
        unidadMuerta.setModificadores(modificadoresUnidadMuerta);
        List<Carta> descarte = new ArrayList<>(List.of(unidadMuerta));

        // CREO UNIDAD A EVALUAR
        List<Posicion> posicionesUnidadUser = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad unidadUser = new Unidad("mago oscuro",15,posicionesUnidadUser,false);

        // AGREGO MODIFICADORES
        Medico medico = new Medico(descarte);
        List<Modificador> modificadores = new ArrayList<>(List.of(medico));
        unidadUser.setModificadores(modificadores);

        // ACT
        unidadUser.jugarEnSeccion(seccionUser);
        int puntosTotales = seccionUser.obtenerPuntosTotales();

        // ASSERT
        assertEquals(31,puntosTotales);
    }

    // CUESTA HACER QUE MEDICO REVIVA UN MEDICO
    @Test
    public void UnidadMedicoReviveUnidadUnidasYMedico(){
        // ARRANGE
        Jugador jugador = new Jugador("aksel");
        Seccion seccionUser = new Seccion(new CuerpoACuerpo(),jugador);
        List<Carta> descarte = new ArrayList<>();

        // OTRAS UNIDADES QUE SE JUGARON ANTES
        List<Posicion> posiciones = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad unidadMuerta = new Unidad("mago oscuro",15,posiciones,false);
        Medico medico2 = new Medico(descarte);
        Unidas unidas = new Unidas(unidadMuerta.getNombre());
        List<Modificador> modificadoresUnidadMuerta = new ArrayList<>(List.of(medico2,unidas));
        unidadMuerta.setModificadores(modificadoresUnidadMuerta);
        List<Posicion> posiciones2 = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad unidadMuerta2 = new Unidad("barbaro",5,posiciones2,false);

        descarte.add(unidadMuerta);
        descarte.add(unidadMuerta2);

        // CREO UNIDAD A EVALUAR
        List<Posicion> posicionesUnidadUser = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad unidadUser = new Unidad("mago oscuro",15,posicionesUnidadUser,false);

        // AGREGO MODIFICADORES
        Medico medico = new Medico(descarte);
        List<Modificador> modificadores = new ArrayList<>(List.of(medico));
        unidadUser.setModificadores(modificadores);

        // ACT
        unidadUser.jugarEnSeccion(seccionUser);
        int puntosTotales = seccionUser.obtenerPuntosTotales();

        // ASSERT
        assertEquals(65,puntosTotales);
    }

    @Test
    public void UnidadMedicoReviveEspecialDescartada(){
        // ARRANGE
        // SIMULO JUEGO
        Jugador jugador1 = new Jugador("nico");
        Jugador jugador2 = new Jugador("aksel");
        List<Carta> descarte = new ArrayList<>();

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
        Nieve cartaDescartada = new Nieve(seccionesAfectadas,1);
        descarte.add(cartaDescartada);

        // CREO UNIDAD A EVALUAR
        List<Posicion> posicionesUnidadUser = new ArrayList<>(List.of(new CuerpoACuerpo()));
        Unidad unidadUser = new Unidad("mago oscuro",15,posicionesUnidadUser,false);

        // AGREGO MODIFICADORES
        Medico medico = new Medico(descarte);
        List<Modificador> modificadores = new ArrayList<>(List.of(medico));
        unidadUser.setModificadores(modificadores);

        // ACT
        unidadUser.jugarEnSeccion(seccion4);
        int puntosTotales1 = seccion1.obtenerPuntosTotales();
        List<Unidad> unidadesActuales = seccion4.getUnidadesColocadas();

        // ASSERT
        assertEquals(2,puntosTotales1);
        assertEquals(4,unidadesActuales.size());
    }
}
