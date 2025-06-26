package edu.fiuba.algo3.ModeloTest.CartasTest.UnidadTest.ModificadoresTest.ModificadoresDeColocacion;

import edu.fiuba.algo3.modelo.carta.unidad.UnidadBasica;
import edu.fiuba.algo3.modelo.carta.unidad.modificadores.Agil;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.posicion.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class AgilTest {

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
    public void elModificadorAgilPermiteColocarUnaUnidadEnUnaPosicionExtra(){

        // Arrange
        Posicion posicionExtra = new CuerpoACuerpo();
        Agil unidadAgil = new Agil(
                new UnidadBasica(
                        "Unidad",
                        new Puntaje(0),
                        new Distancia()
                ),
                posicionExtra
        );

        // Act
        boolean sePuedeColocarEnCuerpoACuerpo = unidadAgil.sePuedeColocar(new CuerpoACuerpo());
        boolean sePuedeColocarEnDistancia = unidadAgil.sePuedeColocar(new Distancia());

        boolean sePuedeColocarEnAsedio = unidadAgil.sePuedeColocar(new Asedio());


        // Assert
        assertTrue(sePuedeColocarEnCuerpoACuerpo);
        assertTrue(sePuedeColocarEnDistancia);
        assertFalse(sePuedeColocarEnAsedio);
    }

    @Test
    public void unaUnidadAgilSePuedeJugarYColocarEnDiferentesPosiciones(){

        // Arrange

        //utilizo 2 cartas diferentes con los mismos parametros para mostrar las 2 posibilidades

        Agil unidadAgil1 = new Agil(
                new UnidadBasica(
                        "Unidad",
                        new Puntaje(0),
                        new Distancia()
                ),
                new Asedio()
        );

        Agil unidadAgil2 = new Agil(
                new UnidadBasica(
                        "Unidad",
                        new Puntaje(0),
                        new Distancia()
                ),
                new Asedio()
        );

        int cantidadDeUnidadesColocadasDistanciaInicial = distancia.getUnidadesColocadas().size();
        int cantidadDeUnidadesColocadasAsedioInicial = asedio.getUnidadesColocadas().size();


        // Act
        unidadAgil1.jugarCarta(jugador, oponente, new Distancia());
        unidadAgil2.jugarCarta(jugador, oponente, new Asedio());

        // Assert
        assertEquals(0, cantidadDeUnidadesColocadasDistanciaInicial);
        assertTrue(distancia.getUnidadesColocadas().contains(unidadAgil1));
        assertEquals(1, distancia.getUnidadesColocadas().size());

        assertEquals(0, cantidadDeUnidadesColocadasAsedioInicial);
        assertTrue(asedio.getUnidadesColocadas().contains(unidadAgil2));
        assertEquals(1, asedio.getUnidadesColocadas().size());
    }
}
