package edu.fiuba.algo3.ModeloTest.CartasTest.UnidadTest.ModificadoresTest.ModificadoresDeColocacion;

import edu.fiuba.algo3.modelo.carta.unidad.UnidadFactory;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mano;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mazo;
import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.posicion.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        String posicionExtra = "cuerpo a cuerpo";

        List<String> modificadores = new ArrayList<>();
        modificadores.add("Agil");

        List<String> posiciones = new ArrayList<>();
        posiciones.add("rango");
        posiciones.add(posicionExtra);

        Unidad unidadAgil = UnidadFactory.crear("UnidadAgil", 6, modificadores, posiciones);


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

        String posicionExtra = "asedio";

        List<String> modificadores = new ArrayList<>();
        modificadores.add("Agil");

        List<String> posiciones = new ArrayList<>();
        posiciones.add("rango");
        posiciones.add(posicionExtra);

        Unidad unidadAgil1 = UnidadFactory.crear("UnidadAgil", 6, modificadores, posiciones);
        Unidad unidadAgil2 = UnidadFactory.crear("UnidadAgil", 6, modificadores, posiciones);

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
