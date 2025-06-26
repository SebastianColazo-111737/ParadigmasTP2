package edu.fiuba.algo3.ModeloTest.Jugador;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.unidad.UnidadBasica;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Mano;
import edu.fiuba.algo3.modelo.jugador.Mazo;
import edu.fiuba.algo3.modelo.posicion.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class JugadorTest {

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
    public void unJugadorPuedeRobarCartasDeSuMazoParaAgreagarlasASuMano(){
        // Arrange
        Carta cartaParaAgregarAlMazo1 = new UnidadBasica("Unidad1", new Puntaje(5), new CuerpoACuerpo());
        Carta cartaParaAgregarAlMazo2 = new UnidadBasica("Unidad2", new Puntaje(4), new Asedio());
        mazo.agregarCarta(cartaParaAgregarAlMazo1);
        mazo.agregarCarta(cartaParaAgregarAlMazo2);
        int cantidadDeCartasEnElMazoInicial = mazo.getCantidadCartas();
        int cantidadDeCartasEnLaManoInicial = mano.getCantidadCartas();
        // Act
        jugador.robarCartasDelMazo(2);

        // Assert
        assertEquals(2, cantidadDeCartasEnElMazoInicial);
        assertEquals(0, cantidadDeCartasEnLaManoInicial);
        assertEquals(0, mazo.getCantidadCartas());
        assertEquals(2, mano.getCantidadCartas());
    }

    @Test
    public void unJugadorPuedeCambiarUnaCartaDeSuManoPorOtraDeSuMazo(){
        // Arrange
        Carta cartaQueEmpiezaEnLaMano = new UnidadBasica("Unidad1", new Puntaje(5), new CuerpoACuerpo());
        mano.agregarCarta(cartaQueEmpiezaEnLaMano);

        Carta cartaQueEmpiezaEnElMazo = new UnidadBasica("Unidad2", new Puntaje(4), new Asedio());
        mazo.agregarCarta(cartaQueEmpiezaEnElMazo);

        int cantidadDeCartasEnElMazoInicial = mazo.getCantidadCartas();
        int cantidadDeCartasEnLaManoInicial = mano.getCantidadCartas();

        // Act
        jugador.cambiarCartaDeLaManoAlMazo(cartaQueEmpiezaEnLaMano);

        // Assert

        assertEquals(cantidadDeCartasEnElMazoInicial, mazo.getCantidadCartas());
        assertTrue(mano.getCartas().contains(cartaQueEmpiezaEnElMazo));
        assertEquals(cantidadDeCartasEnLaManoInicial, mano.getCantidadCartas());
    }
}
