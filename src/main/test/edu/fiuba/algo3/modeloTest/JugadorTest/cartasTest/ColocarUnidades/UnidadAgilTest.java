package edu.fiuba.algo3.modeloTest.JugadorTest.cartasTest.ColocarUnidades;

import edu.fiuba.algo3.modelo.cartas.unidades.Agil;
import edu.fiuba.algo3.modelo.cartas.unidades.Puntaje;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.jugador.atril.*;
import edu.fiuba.algo3.modelo.posiciones.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;


public class UnidadAgilTest {

    private Jugador jugador;
    private Mano mano;
    private Mazo mazo;
    private Atril atril;

    @BeforeEach
    void setUp() {
        mano = new Mano();
        mazo = new Mazo();
        atril = new Atril();

        jugador = new Jugador(mazo, mano, atril);
    }

    @Test
    public void unaUnidadAgilSePuedeColocarEnDosSeccionesDiferentesDeUnMismoJugador(){

        // Arrange
        Agil agil1 = new Agil(
                "agil1",
                new Puntaje(5),
                new CuerpoACuerpo(),
                new Distancia()
        );
        Agil agil2 = new Agil(
                "agil2",
                new Puntaje(5),
                new CuerpoACuerpo(),
                new Distancia()
        );

        mano.agregarCarta(List.of(agil1, agil2));

        Seccion cuerpoACuerpoJ1 = new Seccion(new CuerpoACuerpo());
        Seccion distanciaJ1 = new Seccion(new Distancia());
        atril.agregarSeccion(cuerpoACuerpoJ1);
        atril.agregarSeccion(distanciaJ1);

        // Act
        jugador.jugarCarta(agil1, cuerpoACuerpoJ1);
        jugador.jugarCarta(agil2, distanciaJ1);


        // Assert
        assertEquals(1, cuerpoACuerpoJ1.getUnidadesColocadas().size());
        assertEquals(1, distanciaJ1.getUnidadesColocadas().size());
        assertTrue(cuerpoACuerpoJ1.getUnidadesColocadas().contains(agil1));
        assertTrue(distanciaJ1.getUnidadesColocadas().contains(agil2));

    }
}
