package edu.fiuba.algo3.modeloTest.JugadorTest;


import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Mano;
import edu.fiuba.algo3.modelo.jugador.Mazo;
import edu.fiuba.algo3.modelo.juego.Puntaje;
import edu.fiuba.algo3.modelo.tablero.atril.Atril;
import edu.fiuba.algo3.modelo.tablero.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class JugadorTest {

    private Jugador jugador;
    private Mano mano;
    private Mazo mazo;
    private Atril atril;
    private Seccion cuerpoACuerpoJ1;
    private Seccion distanciaJ1;
    private Seccion asedioJ1;

    @BeforeEach
    void setUp() {
        mano = new Mano();
        mazo = new Mazo();

        atril = new Atril();
        cuerpoACuerpoJ1 = new Seccion(new CuerpoACuerpo());
        distanciaJ1 = new Seccion(new Distancia());
        asedioJ1 = new Seccion(new Asedio());
        atril.agregarSeccion(cuerpoACuerpoJ1);
        atril.agregarSeccion(distanciaJ1);
        atril.agregarSeccion(asedioJ1);

        jugador = new Jugador(mazo, mano, atril);
    }

    @Test
    public void unJugadorPuedeRobarCartasDeSuMazoParaAgreagarlasASuMano(){
        // Arrange
        ICarta cartaParaAgregarAlMazo1 = new UnidadBasica("Unidad1", new Puntaje(5), new CuerpoACuerpo());
        ICarta cartaParaAgregarAlMazo2 = new UnidadBasica("Unidad2", new Puntaje(4), new Asedio());
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
        ICarta cartaQueEmpiezaEnLaMano = new UnidadBasica("Unidad1", new Puntaje(5), new CuerpoACuerpo());
        mano.agregarCarta(cartaQueEmpiezaEnLaMano);

        ICarta cartaQueEmpiezaEnElMazo = new UnidadBasica("Unidad2", new Puntaje(4), new Asedio());
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
