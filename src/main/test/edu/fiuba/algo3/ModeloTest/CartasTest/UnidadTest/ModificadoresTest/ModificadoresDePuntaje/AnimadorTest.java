package edu.fiuba.algo3.ModeloTest.CartasTest.UnidadTest.ModificadoresTest.ModificadoresDePuntaje;

import edu.fiuba.algo3.modelo.carta.unidad.UnidadFactory;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mano;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mazo;
import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.carta.unidad.UnidadBasica;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Asedio;
import edu.fiuba.algo3.modelo.posicion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posicion.Distancia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnimadorTest {

    private Jugador jugador;
    private Jugador oponente;

    private Atril atrilJugador;
    private Seccion cuerpoACuerpo;
    private Seccion distancia;
    private Seccion asedio;

    @BeforeEach
    void setUp() {

        atrilJugador = new Atril();
        cuerpoACuerpo = new Seccion(new CuerpoACuerpo());
        distancia = new Seccion(new Distancia());
        asedio = new Seccion(new Asedio());
        atrilJugador.agregarSeccion(cuerpoACuerpo);
        atrilJugador.agregarSeccion(distancia);
        atrilJugador.agregarSeccion(asedio);

        jugador = new Jugador(new Mazo(), new Mano(), atrilJugador);
        oponente = new Jugador(new Mazo(), new Mano(), new Atril());
    }

    @Test
    void alJugarUnAnimadorEnUnaSeccionLosPuntajesDeLasUnidadesDeEsaSeccionAumentanEn1(){

        // Arrange
        UnidadBasica unidadBasica = new UnidadBasica(
                "unidadBasica",
                new Puntaje(5),
                new CuerpoACuerpo()
        );


        List<String> modificadores = new ArrayList<>();
        modificadores.add("impulso de moral");
        List<String> posiciones = new ArrayList<>();
        posiciones.add("cuerpo a cuerpo");

        // Act
        Unidad animador = UnidadFactory.crear("animador", 2, modificadores, posiciones);

        int aumentoAnimador = 1;
        int puntajeEsperado = (5 + aumentoAnimador) + (2 + aumentoAnimador);

        // Act
        unidadBasica.jugarCarta(jugador, oponente, new CuerpoACuerpo());
        animador.jugarCarta(jugador, oponente, new CuerpoACuerpo());

        int puntajeSeccion = cuerpoACuerpo.getPuntaje();


        // Assert
        assertEquals(puntajeEsperado, puntajeSeccion);
    }
}
