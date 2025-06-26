package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.ControladorTurnos;
import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
    private final Button botonParaPasar;

    public VistaTurnos(Gwent juego, Jugador jugador1, Jugador jugador2, VistaMano vistaMano1, VistaMano vistaMano2, ControladorTurnos controladorTurnos){
        this.juego = juego;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.vistaMano1 = vistaMano1;
        this.vistaMano2 = vistaMano2;

        this.indicadorDeTurno = new Circle(20);
        indicadorDeTurno.setStrokeWidth(4);
        indicadorDeTurno.setStroke(Color.BLACK);

        this.botonParaPasar = new Button("Terminar Participacion");

        this.botonParaPasar.setOnAction(e->{
            controladorTurnos.finalizarParticipacion();
            actualizarTurnos();
        });

        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);

        this.getChildren().addAll(indicadorDeTurno,botonParaPasar);
        actualizarTurnos();

    }
    public void actualizarTurnos(){
        Jugador jugadorActual =  juego.getJugadorActual();

        vistaMano1.setDisable(!jugadorActual.equals(jugador1));
        vistaMano2.setDisable(!jugadorActual.equals(jugador2));
        botonParaPasar.setDisable(false);

        if(jugadorActual.equals(jugador1)){
            indicadorDeTurno.setFill(Color.BLUE);
        }else{
            indicadorDeTurno.setFill(Color.GREEN);
        }
    }
}