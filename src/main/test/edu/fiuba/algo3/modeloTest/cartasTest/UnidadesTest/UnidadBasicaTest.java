package edu.fiuba.algo3.modeloTest.cartasTest.UnidadesTest;

import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadNoPuedeSerJugadaEnEsaPosicion;
import edu.fiuba.algo3.modelo.jugador.*;

import edu.fiuba.algo3.modelo.posiciones.*;

import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.tablero.Atril;
import edu.fiuba.algo3.modelo.tablero.Seccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnidadBasicaTest {

    private Jugador jugador;

    private Tablero tablero;

    private Atril atril;
    private Seccion cuerpoACuerpo;
    private Seccion distancia;
    private Seccion asedio;


    @BeforeEach
    void setUp() {

        //setUpJugador
        jugador = new Jugador(new Mazo(), new Mano(), new Descarte());

        // setUp tablero
        tablero = new Tablero();

        atril = new Atril();
        cuerpoACuerpo = new Seccion(new CuerpoACuerpo());
        distancia = new Seccion(new Distancia());
        asedio = new Seccion(new Asedio());
        atril.agregarSeccion(cuerpoACuerpo);
        atril.agregarSeccion(distancia);
        atril.agregarSeccion(asedio);

        tablero.agregarJugador(jugador, atril);

    }

    @Test
    public void unaUnidadBasicaNoSePuedeColocarEnUnaPosicionDiferenteALAsuya(){

        // Arrange
        UnidadBasica unidadBasica = new UnidadBasica(
                "Unidad",
                new Puntaje(0),
                new Distancia()
        );
        // Act
        boolean sePuedeColocarEnCuerpoACuerpo = unidadBasica.sePuedeColocar(new CuerpoACuerpo());
        boolean sePuedeColocarEnAsedio = unidadBasica.sePuedeColocar(new Asedio());

        // Assert
        assertFalse(sePuedeColocarEnCuerpoACuerpo);
        assertFalse(sePuedeColocarEnAsedio);

    }

    @Test
    public void unaUnidadBasicaSePuedeJugarYSeColocaEnLaSeccionCorrespondienteDelJugador(){

        // Arrange
        UnidadBasica unidadBasica = new UnidadBasica(
                "Unidad",
                new Puntaje(0),
                new CuerpoACuerpo()
        );
        int cantidadDeUnidadesColocadasInicial = cuerpoACuerpo.getUnidadesColocadas().size();

        // Act
        unidadBasica.jugarCarta(jugador, tablero, new CuerpoACuerpo());

        // Assert
        assertEquals(0, cantidadDeUnidadesColocadasInicial);
        assertTrue(cuerpoACuerpo.getUnidadesColocadas().contains(unidadBasica));
        assertEquals(1, cuerpoACuerpo.getUnidadesColocadas().size());

    }

    @Test
    public void unaUnidadBasicaNoSePuedeJugarEnUnaPosicionDiferenteALaSuya(){

        // Arrange
        UnidadBasica unidadBasica = new UnidadBasica(
                "Unidad",
                new Puntaje(0),
                new CuerpoACuerpo()
        );
        // Act

        // Assert
        assertThrows(
                UnidadNoPuedeSerJugadaEnEsaPosicion.class,
                () -> unidadBasica.jugarCarta(jugador, tablero, new Asedio())
        );
        assertThrows(
                UnidadNoPuedeSerJugadaEnEsaPosicion.class,
                () -> unidadBasica.jugarCarta(jugador, tablero, new Distancia())
        );
    }
}
