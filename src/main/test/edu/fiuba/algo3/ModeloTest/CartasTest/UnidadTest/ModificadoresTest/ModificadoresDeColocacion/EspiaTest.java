package edu.fiuba.algo3.ModeloTest.CartasTest.UnidadTest.ModificadoresTest.ModificadoresDeColocacion;

import edu.fiuba.algo3.modelo.carta.unidad.UnidadFactory;
import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.carta.unidad.UnidadBasica;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mano;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mazo;
import edu.fiuba.algo3.modelo.posicion.Asedio;
import edu.fiuba.algo3.modelo.posicion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posicion.Distancia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class EspiaTest {

    private Jugador jugador;
    private Mazo mazoJugador1;
    private Mano manoJugador1;

    private Jugador oponente;

    private Atril atrilOponente;
    private Seccion cuerpoACuerpo;
    private Seccion distancia;
    private Seccion asedio;


    @BeforeEach
    void setUp() {

        atrilOponente = new Atril();
        cuerpoACuerpo = new Seccion(new CuerpoACuerpo());
        distancia = new Seccion(new Distancia());
        asedio = new Seccion(new Asedio());
        atrilOponente.agregarSeccion(cuerpoACuerpo);
        atrilOponente.agregarSeccion(distancia);
        atrilOponente.agregarSeccion(asedio);

        mazoJugador1 = new Mazo();
        manoJugador1 = new Mano();
        jugador = new Jugador(mazoJugador1, manoJugador1, new Atril());

        oponente = new Jugador(new Mazo(), new Mano(), atrilOponente);
    }

    @Test
    public void elAtrilDestinoDeUnaUnidadEspiaEsElAtrilDelOponente() {

        // Arrange

        List<String> modificadores = new ArrayList<>();
        modificadores.add("Espia");
        List<String> posiciones = new ArrayList<>();
        posiciones.add("Rango");

        Unidad unidadEspia = UnidadFactory.crear("espia", 0, modificadores, posiciones);

        // Act
        Atril atrilDestino = unidadEspia.atrilDestino(jugador, oponente);

        // Assert
        assertEquals(atrilDestino, atrilOponente);
    }


    @Test
    public void elModificadorEspiaColocaLaUnidadEnElAtrilDelOponenteYLePermiteRobar2CartasAlJugador(){

        // Arrange
        UnidadBasica cartaParaRobar1 = new UnidadBasica(
                        "UnidadParaRobar1",
                        new Puntaje(0),
                        new CuerpoACuerpo());

        UnidadBasica cartaParaRobar2 = new UnidadBasica(
                "UnidadParaRobar2",
                new Puntaje(0),
                new Distancia()
        );

        List<String> modificadores = new ArrayList<>();
        modificadores.add("Espia");
        List<String> posiciones = new ArrayList<>();
        posiciones.add("Rango");

        Unidad unidadEspia = UnidadFactory.crear("espia", 0, modificadores, posiciones);


        mazoJugador1.agregarCarta(cartaParaRobar1);
        mazoJugador1.agregarCarta(cartaParaRobar2);

        int cantidadDeCartasEnLaManoInicial = manoJugador1.getCantidadCartas();
        int cantidadDeCartasEnElMazoInicial = mazoJugador1.getCantidadCartas();

        // Act
        unidadEspia.jugarCarta(jugador, oponente, new Distancia());


        // Assert
        assertEquals(0, cantidadDeCartasEnLaManoInicial);
        assertEquals(2, cantidadDeCartasEnElMazoInicial);

        assertEquals(1, distancia.getUnidadesColocadas().size());
        assertTrue(distancia.getUnidadesColocadas().contains(unidadEspia));

        assertEquals(2, manoJugador1.getCantidadCartas());
        assertEquals(0, mazoJugador1.getCantidadCartas());
        assertTrue(manoJugador1.getCartas().contains(cartaParaRobar1));
        assertTrue(manoJugador1.getCartas().contains(cartaParaRobar2));

    }


}
