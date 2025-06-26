package edu.fiuba.algo3.modelo.gwent.adminRondas;

import edu.fiuba.algo3.modelo.gwent.adminRondas.adminTurnos.AdminTurnos;
import edu.fiuba.algo3.modelo.gwent.adminRondas.reglaDeCierre.ReglaDeCierre;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class AdminRondas {
    private List<Jugador> jugadores;
    private AdminTurnos<Jugador> adminTurnos;
    private ReglaDeCierre reglaDeCierre;


    private List<Ronda> rondasJugadas;
    private Ronda rondaActual;

    public AdminRondas(
            List<Jugador> jugadores,
            AdminTurnos<Jugador> adminTurnos,
            ReglaDeCierre reglaDeCierre
            )
    {
        this.jugadores = jugadores;
        this.adminTurnos = adminTurnos;
        this.reglaDeCierre = reglaDeCierre;

        this.rondasJugadas = new ArrayList<>();
        this.rondaActual = iniciarNuevaRonda();
    }

    public Ronda iniciarNuevaRonda(){
        if(reglaDeCierre.terminoElJuego(rondasJugadas)){
            throw new AdminRondasNoPuedeInicarRondaCuandoElJuegoTermino("");
        }

        return new Ronda(this.adminTurnos);
    }


}
