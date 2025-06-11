package edu.fiuba.algo3.TestUnitarios;

import edu.fiuba.algo3.clases.Posicion.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PosicionTest {

    @Test
    public void unaPosicionDeCuerpoACuerpoEscompatibleConOtraPosicionCuerpoACuerpo(){
        // Arrange
        IPosicion posicion1 = new CuerpoACuerpo();
        IPosicion posicion2 = new CuerpoACuerpo();

        // Act
        Boolean esCompatible = posicion1.esCompatible(posicion2);

        // Assert
        assertTrue(esCompatible);
    }

    @Test
    public void unaPosicionDeDistanciaEscompatibleConOtraPosicionDeDistancia(){
        // Arrange
        IPosicion posicion1 = new Distancia();
        IPosicion posicion2 = new Distancia();

        // Act
        Boolean esCompatible = posicion1.esCompatible(posicion2);

        // Assert
        assertTrue(esCompatible);
    }

    @Test
    public void unaPosicionDeAsedioEscompatibleConOtraPosicionAsedio(){
        // Arrange
        IPosicion posicion1 = new Asedio();
        IPosicion posicion2 = new Asedio();

        // Act
        Boolean esCompatible = posicion1.esCompatible(posicion2);

        // Assert
        assertTrue(esCompatible);
    }

    @Test
    public void unaPosicionCuerpoACuerpoNoEsCompatibleConOtraPosicionDiferente(){
        // Arrange
        IPosicion cuerpoACuerpo = new CuerpoACuerpo();
        IPosicion distancia = new Distancia();
        IPosicion asedio = new Asedio();

        // Act
        Boolean esCompatibleCuerpoACuerpoConDistancia = cuerpoACuerpo.esCompatible(distancia);
        Boolean esCompatibleCuerpoACuerpoConAsedio = cuerpoACuerpo.esCompatible(asedio);

        // Assert
        assertFalse(esCompatibleCuerpoACuerpoConDistancia);
        assertFalse(esCompatibleCuerpoACuerpoConAsedio);
    }

    @Test
    public void unaPosicionDeDistanciaNoEsCompatibleConOtraPosicionDiferente(){
        // Arrange
        IPosicion distancia = new Distancia();
        IPosicion cuerpoACuerpo = new CuerpoACuerpo();
        IPosicion asedio = new Asedio();

        // Act
        Boolean esCompatibleDistanciaConCuerpoACuerpo = distancia.esCompatible(cuerpoACuerpo);
        Boolean esCompatibleDistanciaConAsedio = distancia.esCompatible(asedio);

        // Assert
        assertFalse(esCompatibleDistanciaConCuerpoACuerpo);
        assertFalse(esCompatibleDistanciaConAsedio);
    }

    @Test
    public void unaPosicionDeAsedioNoEsCompatibleConOtraPosicionDiferente(){
        // Arrange
        IPosicion asedio = new Asedio();
        IPosicion cuerpoACuerpo = new CuerpoACuerpo();
        IPosicion distancia = new Distancia();

        // Act
        Boolean esCompatibleAsedioConCuerpoACuerpo = asedio.esCompatible(cuerpoACuerpo);
        Boolean esCompatibleAsedioConDistancia = asedio.esCompatible(distancia);

        // Assert
        assertFalse(esCompatibleAsedioConCuerpoACuerpo);
        assertFalse(esCompatibleAsedioConDistancia);
    }
}
