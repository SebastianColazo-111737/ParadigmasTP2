package edu.fiuba.algo3.modeloTest.JuegoTest;

public class JuegoTest {
//
//    private List<ICarta> cartasJ1;
//    private List<ICarta> cartasJ2;
//    private Jugador jugador1;
//    private Jugador jugador2;
//    private Juego juego;
//
//    @BeforeEach
//    void setUp() {
//        cartasJ1 = new ArrayList<>();
//        cartasJ2 = new ArrayList<>();
//
//        for (int i = 0; i < 21; i++) {
//            cartasJ1.add(new UnidadBasica("Catapulta", 8, new Asedio())); //algun metodos que cree el mazo?
//            cartasJ2.add(new UnidadBasica("Catapulta", 8, new Asedio()));
//        }
//
//        jugador1 = new Jugador("Jugador1");
//        jugador2 = new Jugador("Jugador2");
//        juego = new Juego(jugador1, jugador2);
//    }
//
//    @Test
//    public void alRepartirCartasLosJugadoresPasanATener10CartasEnLaMano(){
//        // Arrange
//        jugador1.agregarCartasAlMazo(cartasJ1);
//        jugador2.agregarCartasAlMazo(cartasJ2);
//
//        // Act
//        int cantidadDeCartasInicialEnLaManoJ1 = jugador1.getCantidadCartasMano();
//        int cantidadDeCartasInicialEnLaManoJ2 = jugador2.getCantidadCartasMano();
//        juego.repartirCartasALosJugadores();
//        int cantidadDeCartasFinalEnLaManoJ1 = jugador1.getCantidadCartasMano();
//        int cantidadDeCartasFinalEnLaManoJ2 = jugador2.getCantidadCartasMano();
//
//        // Assert
//        assertEquals(0, cantidadDeCartasInicialEnLaManoJ1);
//        assertEquals(0, cantidadDeCartasInicialEnLaManoJ2);
//        assertEquals(10, cantidadDeCartasFinalEnLaManoJ1);
//        assertEquals(10, cantidadDeCartasFinalEnLaManoJ2);
//
//    }
//
//    @Test
//    public void unJugadorPuedeColocarUnaCartaDeUnidadEnUnaSeccionConLaPosicionElegida(){
//
//        // Arrange
//        List<ICarta> cartasDelMazoJugador1 = new ArrayList<>();
//        ICarta cartaElegida =  new UnidadBasica("Catapulta", 8, new Asedio());
//        Posicion posicionElegida = new Asedio();
//        cartasDelMazoJugador1.add(cartaElegida);
//
//        jugador1.agregarCartasAlMazo(cartasDelMazoJugador1);
//        jugador1.robarCartas(1); //ahora la tiene en la mano
//
//
//        // Act
//        juego.jugarCarta(jugador1, cartaElegida, posicionElegida);
//
//        // Assert
//        assertFalse(jugador1.getCartasMano().contains(cartaElegida)); //el jugador ya no tiene la carta en la mano
//
//        Seccion seccionJ1 = juego.getAtril(jugador1).getSeccion(posicionElegida);
//        assertTrue(seccionJ1.getUnidadesColocadas().contains(cartaElegida)); // la Unidad ahora esta en la seccion
//
//    }
//
//    @Test
//    public void unJugadortieneUnPuntajeParcialLuegoDeJugarUnaUnidad(){
//
//        // Arrange
//        List<ICarta> cartasDelMazoJugador1 = new ArrayList<>();
//        ICarta carta1 =  new UnidadBasica("Catapulta", 8, new Asedio());
//        ICarta carta2 =  new UnidadBasica("Guerrero", 4, new CuerpoACuerpo());
//        cartasDelMazoJugador1.add(carta1);
//        cartasDelMazoJugador1.add(carta2);
//        jugador1.agregarCartasAlMazo(cartasDelMazoJugador1);
//        jugador1.robarCartas(2);
//
//        // Act
//        juego.jugarCarta(jugador1, carta1, new Asedio());
//        juego.jugarCarta(jugador1, carta2, new CuerpoACuerpo());
//        int puntajeJugador = juego.calcularPuntaje(jugador1);
//        // Assert
//        assertEquals(12, puntajeJugador);
//
//    }

}
