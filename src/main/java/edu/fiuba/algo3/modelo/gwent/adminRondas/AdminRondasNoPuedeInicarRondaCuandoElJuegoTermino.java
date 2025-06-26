package edu.fiuba.algo3.modelo.gwent.adminRondas;

public class AdminRondasNoPuedeInicarRondaCuandoElJuegoTermino extends RuntimeException {
    public AdminRondasNoPuedeInicarRondaCuandoElJuegoTermino(String message) {
        super(message);
    }
}
