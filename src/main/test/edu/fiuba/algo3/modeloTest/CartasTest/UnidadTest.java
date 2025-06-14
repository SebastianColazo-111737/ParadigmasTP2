package edu.fiuba.algo3.modeloTest.CartasTest;

import edu.fiuba.algo3.modelo.cartas.Unidad;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UnidadTest {

    @Test
    public void unaUnidadDevuelveTrueSiPuedeColocarseEnUnaPosicionIgualALaSuya(){

        // Arrange
        Posicion posicionDeEjemplo = new CuerpoACuerpo();
        Unidad unidad = new Unidad("Unidad", 0, posicionDeEjemplo);

        // Act
        boolean puedeColocarse = unidad.puedeColocarse(posicionDeEjemplo);

        // Assert
        assertTrue(puedeColocarse);
    }

    @Test
    public void unaUnidadDevuelveFalseSiNoPuedeColocarseEnUnaPosicionQueEsDiferenteALaSuya(){

        // Arrange
        Posicion posicionDeUnidad = new CuerpoACuerpo();
        Posicion posicionDiferenteDeEjemplo = new Distancia();

        Unidad unidad = new Unidad("Unidad", 0, posicionDeUnidad);

        // Act
        boolean puedeColocarse = unidad.puedeColocarse(posicionDiferenteDeEjemplo);

        // Assert
        assertFalse(puedeColocarse);
    }
}
