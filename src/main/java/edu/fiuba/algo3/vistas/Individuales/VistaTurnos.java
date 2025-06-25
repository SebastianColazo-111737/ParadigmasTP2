package edu.fiuba.algo3.vistas.Individuales;

import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vistas.Contenedores.VistaMano;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class VistaTurnos extends VBox {
    private Gwent juego;
    private Jugador jugador1;
    private Jugador jugador2;
    private VistaMano vistaMano1;
    private VistaMano vistaMano2;
    private Circle indicadorDeTurno;

    public VistaTurnos(Gwent juego, Jugador jugador1, Jugador jugador2, VistaMano vistaMano1, VistaMano vistaMano2){
        this.juego = juego;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.vistaMano1 = vistaMano1;
        this.vistaMano2 = vistaMano2;

        this.indicadorDeTurno = new Circle(10);
        this.getChildren().add(indicadorDeTurno);

        this.setAlignment(Pos.CENTER);
        actualizarTurnos();

    }
    public void actualizarTurnos(){
        Jugador jugadorActual =  juego.getJugadorActual();

        vistaMano1.setDisable(!jugadorActual.equals(jugador1));
        vistaMano2.setDisable(!jugadorActual.equals(jugador2));

        if(jugadorActual.equals(jugador1)){
            indicadorDeTurno.setFill(Color.BLUE);
        }else{
            indicadorDeTurno.setFill(Color.GREEN);
        }
    }
}
