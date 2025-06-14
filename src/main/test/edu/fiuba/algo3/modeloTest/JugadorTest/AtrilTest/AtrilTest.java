package edu.fiuba.algo3.modeloTest.JugadorTest.AtrilTest;

import edu.fiuba.algo3.modelo.cartas.Unidad;
import edu.fiuba.algo3.modelo.jugador.atril.Atril;
import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class AtrilTest {

    @Test
    public void elAtrilSePuedeLimpiarDescartandoTodasLasCartasDeLasSecciones(){

        // Arrange
        Atril atril = new Atril();
        Unidad unidad1 = new Unidad("Guerrero", 5, new CuerpoACuerpo());
        Unidad unidad2 = new Unidad("Arquero", 4, new Distancia());
        Unidad unidad3 = new Unidad("Catapulta", 8, new Asedio());
        atril.colocarUnidad(unidad1, new CuerpoACuerpo());
        atril.colocarUnidad(unidad2, new Distancia());
        atril.colocarUnidad(unidad3, new Asedio());

        // Act
       atril.descartarCartas();

        // Assert
        assertEquals(3, atril.getDescarte().size());
    }
}
