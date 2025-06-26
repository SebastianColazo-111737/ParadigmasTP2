package edu.fiuba.algo3.ModeloTest.CartasTest.UnidadTest;

import edu.fiuba.algo3.modelo.carta.unidad.UnidadBasica;
import edu.fiuba.algo3.modelo.carta.unidad.UnidadNoPuedeSerJugadaEnEsaPosicion;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.posicion.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnidadBasicaTest {

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
    public void unaUnidadBasicaNoSePuedeColocarEnUnaPosicionDiferenteALAsuya() {

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
    public void unaUnidadBasicaSePuedeJugarYSeColocaEnLaSeccionCorrespondienteDelJugador() {

        // Arrange
        UnidadBasica unidadBasica = new UnidadBasica(
                "Unidad",
                new Puntaje(0),
                new CuerpoACuerpo()
        );
        int cantidadDeUnidadesColocadasInicial = cuerpoACuerpo.getUnidadesColocadas().size();

        // Act
        unidadBasica.jugarCarta(jugador, oponente, new CuerpoACuerpo());

        // Assert
        assertEquals(0, cantidadDeUnidadesColocadasInicial);
        assertTrue(cuerpoACuerpo.getUnidadesColocadas().contains(unidadBasica));
        assertEquals(1, cuerpoACuerpo.getUnidadesColocadas().size());

    }

    @Test
    public void unaUnidadBasicaNoSePuedeJugarEnUnaPosicionDiferenteALaSuya() {

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
                () -> unidadBasica.jugarCarta(jugador, oponente, new Asedio())
        );
        assertThrows(
                UnidadNoPuedeSerJugadaEnEsaPosicion.class,
                () -> unidadBasica.jugarCarta(jugador, oponente, new Distancia())
        );
    }

    @Test
    public void elAtrilDestinoDeUnaUnidadBasicaEsElAtrilDelJugador() {

        // Arrange
        UnidadBasica unidadBasica = new UnidadBasica(
                "Unidad",
                new Puntaje(0),
                new CuerpoACuerpo()
        );
        // Act
        Atril atrilDestino = unidadBasica.atrilDestino(jugador, oponente);

        // Assert
        assertEquals(atrilDestino, atrilJugador);
    }
}
