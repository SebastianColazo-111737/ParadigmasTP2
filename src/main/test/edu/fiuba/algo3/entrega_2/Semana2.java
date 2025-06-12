package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.clases.Modificadores.Agil;
import javafx.geometry.Pos;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import edu.fiuba.algo3.clases.*;
import edu.fiuba.algo3.clases.Modificadores.Unidas;

public class Semana2 {

    @Mock
    private Mazo mazoMock;

    @Mock
    private ArrayList<Carta> cartasMock1;

    @Mock
    private ArrayList<Carta> cartasMock2;

    @Mock
    private ZonaEspeciales zonaEspeciales;


    private Unidad cartaMock1;
    private Unidad cartaMock2;
    private Unidad cartaMock3;
    private Unidad cartaMock4;
    private Unidad cartaMock5;
    private Unidad cartaMock6;
    private Unidad cartaMock7;
    private Unidad cartaMock8;
    private Unidad cartaMock9;
    private Unidad cartaMock10;
    private Unidad cartaMock11;
    private Unidad cartaMock12;
    private Unidad cartaMock13;
    private Especial cartaMock14;
    private Unidad cartaMock15;
    private Unidad cartaMock16;
    private Unidad cartaMock17;
    private Unidad cartaMock18;
    private Especial cartaMock19;
    private Unidad cartaMock20;
    private Unidad cartaMock21;

    @BeforeEach
    public void setup() {
        this.cartaMock1 = new Unidad("Asesino", 8, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock2 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA, null);
        this.cartaMock3 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock4 = new Unidad("Medico", 2, Posicion.ASEDIO, null);
        this.cartaMock5 = new Unidad("Asesino", 8, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock6 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA, null);
        this.cartaMock7 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock8 = new Unidad("Catapulta", 8, Posicion.ASEDIO, null);
        this.cartaMock9 = new Unidad("Asesino", 10, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock10 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA, null);
        this.cartaMock11 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock12 = new Unidad("Catapulta", 8, Posicion.ASEDIO, new Unidas());
        this.cartaMock13 = new Unidad("Asesino", 8, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock14 = new Nieve("Nieve", zonaEspeciales);
        this.cartaMock15 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock16 = new Unidad("Medico", 2, Posicion.ASEDIO, null);
        this.cartaMock17 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA, null);
        this.cartaMock18 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock19 = new TierraArrasada("TierraArrasada", zonaEspeciales); //Se ve que no esta contando el indice de esta...
        this.cartaMock20 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA, null);
        this.cartaMock21 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);

        this.cartasMock1 = new ArrayList<>(Arrays.asList(
                cartaMock1, cartaMock2, cartaMock3, cartaMock4, cartaMock5,
                cartaMock6, cartaMock7, cartaMock8, cartaMock9, cartaMock10,
                cartaMock11, cartaMock12, cartaMock13, cartaMock14, cartaMock15,
                cartaMock16, cartaMock17, cartaMock18, cartaMock19, cartaMock20, cartaMock21));

        this.cartasMock2 = new ArrayList<>();
        for (Carta carta : this.cartasMock1) {
            if (carta instanceof Unidad) {
                Unidad unidad = (Unidad) carta;
                cartasMock2.add(new Unidad(unidad.getName(), unidad.obtenerPuntosBase(), unidad.getPosicion(), null));
            }
        }
    }



    @Test
    public void seUsaUnaCartaClimaYSePuedeEliminarEfecto(){
        // Arrange
        Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
        Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));


        Juego juego = new Juego(jugador2, jugador1);
        ZonaEspeciales zonaEspeciales = new ZonaEspeciales();

        jugador1.repartirMano();
        jugador2.repartirMano();

        Unidad cartaUnidad = (Unidad) jugador2.obtenerCartaEnMano(2);
        Especial cartaClima = (Especial) jugador1.obtenerCartaEnMano(7);

        // Act
        juego.jugarCarta(jugador2, cartaUnidad, Posicion.CUERPO_A_CUERPO);
        juego.jugarCartaEspecial(jugador1,cartaClima,zonaEspeciales);

        cartaClima.desactivar(juego.getTablero());

        // Assert
        assertEquals(6,cartaUnidad.getPuntosModificados());
    }

    @Test
    public void seUsaTierraArrasadaYSeEliminanLasCartasCorrectamente(){
        // Arrange
        Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
        Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));

        Juego juego = new Juego(jugador2, jugador1);
        ZonaEspeciales zonaEspeciales = new ZonaEspeciales();

        jugador1.repartirMano();
        jugador2.repartirMano();

        Unidad cartaUnidad1 = (Unidad) jugador2.obtenerCartaEnMano(3);
        Unidad cartaUnidad2 = (Unidad) jugador2.obtenerCartaEnMano(1);

        Unidad cartaUnidad3 = (Unidad) jugador1.obtenerCartaEnMano(4);
        Especial cartaTierraArrasada = (Especial) jugador1.obtenerCartaEnMano(2);

        // Act
        juego.jugarCarta(jugador2, cartaUnidad1, Posicion.CUERPO_A_CUERPO); // <-- esta deberia ir al descarte
        juego.jugarCarta(jugador1, cartaUnidad3, Posicion.A_DISTANCIA);
        juego.jugarCarta(jugador2, cartaUnidad2, Posicion.A_DISTANCIA);
        juego.jugarCartaEspecial(jugador1,cartaTierraArrasada,zonaEspeciales);

        // Assert
        assertEquals(2, jugador2.getDescarte().getCantCartasEnPila()); //2 cartas en descarte: cartaUnidad1 + cartaTierraArrasada
        assertEquals(0, juego.cantidadCartasEnSeccion(jugador2, Posicion.CUERPO_A_CUERPO));
    }

    @Test
    public void cartaAgilSeColocaEnPosicionDeseada() {
        // Arrange
        Jugador jugador1 = new Jugador("jugador1", new Mazo(this.cartasMock1));
        Jugador jugador2 = new Jugador("jugador2", new Mazo(this.cartasMock2));
        Tablero tablero = new Tablero(jugador1, jugador2);
        Unidad cartaAgil = new Unidad("hechizero", 10, Posicion.A_DISTANCIA, new Agil());
        Boolean seJugoCartaAgil = false;

        // Act
        seJugoCartaAgil = jugador1.jugarCarta(cartaAgil, tablero, Posicion.CUERPO_A_CUERPO);

        // Assert
        assertTrue(seJugoCartaAgil);
    }

   /* @Test
    public void seUsaMedicoYSePuedeAgarrarUnaCartaDeLaPilaDeDescarteYJugarla() {
        Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
        Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
        Juego juego = new Juego(jugador1, jugador2);

        jugador1.repartirMano();
        jugador2.repartirMano();

        Unidad cartaUnidad1 = (Unidad) jugador1.obtenerCartaEnMano(4);
        Unidad cartaMedico = (Unidad) jugador1.obtenerCartaEnMano();

        // Act
        juego.jugarCarta(jugador1,cartaUnidad1,Posicion.A_DISTANCIA);
        jugador1.descartarCarta(cartaUnidad1);
        juego.jugarCarta(jugador1,cartaMedico,Posicion.CUERPO_A_CUERPO);
        cartaMedico.revivirCarta(jugador1,cartaUnidad1, Posicion.A_DISTANCIA, juego.getTablero());

        // Assert
        assertEquals(1, juego.cantidadCartasEnSeccion(jugador1, Posicion.A_DISTANCIA));
        assertEquals(1, jugador1.getDescarte().getCantCartasEnPila()); //Aca deberia estar ahora el medico
    }*/
}