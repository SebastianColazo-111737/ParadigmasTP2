package edu.fiuba.algo3.modeloTest;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.Unidad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class JugadorTest {

    private List<ICarta> cartas;

    @BeforeEach
    void setUp() {
        cartas = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            cartas.add(new Unidad());
        }
    }

    @Test
    public void unJugadorTieneCartasSuficientesEnSuMazoParaIniciarLaPartida(){
        // Arrange
        Jugador jugador = new Jugador("Jugador1");
        jugador.agregarCartasAlMazo(cartas);
        // Act
        int cantidadDeCartas = jugador.getCantidadCartasMazo();

        // Assert
        assertEquals(21, cantidadDeCartas);

    }

    @Test
    public void unJugadorSeCreaSinCartasEnElMazo(){
        // Arrange
        Jugador jugador = new Jugador("Jugador1");
        // Act
        int cantidadDeCartas = jugador.getCantidadCartasMazo();

        // Assert
        assertEquals(0, cantidadDeCartas);

    }
}
