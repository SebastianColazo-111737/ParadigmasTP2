package edu.fiuba.algo3.pruebaDeConcepto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static Mazo crearMazoInicial() {
        List<Carta> cartas = new ArrayList<>();
        Random random = new Random();
        Posicion[] posiciones = Posicion.values();

        for (int i = 0; i < 21; i++) {
            int puntaje = 1 + random.nextInt(10);
            Posicion posicion = posiciones[random.nextInt(posiciones.length)];
            cartas.add(new Unidad(puntaje, posicion));
        }

        return new Mazo(cartas);
    }

    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Pepe", crearMazoInicial());
        Jugador jugador2 = new Jugador("Lara", crearMazoInicial());
        Juego juego = new Juego(jugador1,jugador2);

        System.out.println("Jugador1: " + jugador1.getNombre());
        System.out.println("Cartas en el mazo: " + jugador1.getMazo().getCartas());
        System.out.println("cantidad de cartas " + jugador1.getMazo().getCantCartas());
        System.out.println("Cartas en la mano: " + jugador1.getMano().getCartas());
        System.out.println("cantidad de cartas " + jugador1.getMano().getCantCartas());


        System.out.println("\n\nJuego reparte cartas\n\n");
        juego.repartirCartas();

        System.out.println("Jugador1: " + jugador1.getNombre());
        System.out.println("Cartas en el mazo: " + jugador1.getMazo().getCartas());
        System.out.println("cantidad de cartas " + jugador1.getMazo().getCantCartas());
        System.out.println("Cartas en la mano: " + jugador1.getMano().getCartas());
        System.out.println("cantidad de cartas " + jugador1.getMano().getCantCartas());


        System.out.println("\n\nPuntaje de Jugador1: " + juego.calcularPuntaje(jugador1));

        System.out.println("\n\nJugador1 juega la primera carta de su mano\n\n");
        Carta carta = jugador1.getMano().getCartas().get(0);
        juego.jugarCarta(jugador1, carta);

        System.out.println("Puntaje de Jugador1: " + juego.calcularPuntaje(jugador1));
        System.out.println("Cartas en la mano: " + jugador1.getMano().getCartas());
        System.out.println("cantidad de cartas " + jugador1.getMano().getCantCartas());
    }

}
