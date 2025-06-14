package edu.fiuba.algo3.modeloTest.Posiciones;

import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DistanciaTest {

    @Test
    public void unaPosicionDistanciaEsCompatibleConOtraPosicionDistancia(){
        //Arrange
        Posicion distancia1 = new Distancia();
        Posicion distancia2 = new Distancia();

        //Act
        boolean esCompatible = distancia1.esCompatible(distancia2);

        //Assert
        assertTrue(esCompatible);
    }

    @Test
    public void unaPosicionCuerpoACuerpoNoEsCompatibleConOtroTipoDePosicion(){
        //Arrange

        Posicion aDistancia = new Distancia();
        Posicion  cuerpoACuerpo = new CuerpoACuerpo();
        Posicion asedio = new Asedio();

        //Act
        boolean esCompatibleDistanciaYCuerpoACuerpo = aDistancia.esCompatible(cuerpoACuerpo);
        boolean esCompatibleDistanciaYAsedio = aDistancia.esCompatible(asedio);

        //Assert
        assertFalse(esCompatibleDistanciaYCuerpoACuerpo);
        assertFalse(esCompatibleDistanciaYAsedio);
    }
}
