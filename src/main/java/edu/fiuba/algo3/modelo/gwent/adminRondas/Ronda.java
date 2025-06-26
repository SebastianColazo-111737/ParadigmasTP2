package edu.fiuba.algo3.modelo.gwent.adminRondas;

import edu.fiuba.algo3.modelo.gwent.adminRondas.adminTurnos.AdminTurnos;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.List;

public class Ronda {
    private Jugador ganador;
    private AdminTurnos<Jugador> adminTurnos;

    public Ronda(AdminTurnos<Jugador> adminTurnos){
        this.adminTurnos = adminTurnos;

    }


    public Jugador getGanador(){return this.ganador;}
}
