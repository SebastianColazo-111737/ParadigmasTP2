package edu.fiuba.algo3.modeloTest.cartasTest.UnidadesTest.Modificadores;

import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;
import edu.fiuba.algo3.modelo.cartas.unidades.modificadores.Agil;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.posiciones.*;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.tablero.Atril;
import edu.fiuba.algo3.modelo.tablero.Seccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ModificadorAgilTest {

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
    public void elModificadorAgilPermiteColocarUnaUnidadEnUnaPosicionExtra(){

        // Arrange

        UnidadBasica unidadBasica = new UnidadBasica(
                "Unidad",
                new Puntaje(0),
                new Distancia()
        );
        Posicion posicionExtra = new CuerpoACuerpo();
        Agil unidadAgil = new Agil(unidadBasica, posicionExtra);


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
        UnidadBasica unidadBasica1 = new UnidadBasica(
                "Unidad",
                new Puntaje(0),
                new Distancia()
        );
        Agil unidadAgil1 = new Agil(unidadBasica1, new Asedio());

        UnidadBasica unidadBasica2 = new UnidadBasica(
                "Unidad",
                new Puntaje(0),
                new Distancia()
        );
        Agil unidadAgil2 = new Agil(unidadBasica2, new Asedio());

        int cantidadDeUnidadesColocadasDistanciaInicial = distancia.getUnidadesColocadas().size();
        int cantidadDeUnidadesColocadasAsedioInicial = asedio.getUnidadesColocadas().size();


        // Act
        unidadAgil1.jugarCarta(jugador, tablero, new Distancia());
        unidadAgil2.jugarCarta(jugador, tablero, new Asedio());

        // Assert
        assertEquals(0, cantidadDeUnidadesColocadasDistanciaInicial);
        assertTrue(distancia.getUnidadesColocadas().contains(unidadAgil1));
        assertEquals(1, distancia.getUnidadesColocadas().size());

        assertEquals(0, cantidadDeUnidadesColocadasAsedioInicial);
        assertTrue(asedio.getUnidadesColocadas().contains(unidadAgil2));
        assertEquals(1, asedio.getUnidadesColocadas().size());
    }
}
