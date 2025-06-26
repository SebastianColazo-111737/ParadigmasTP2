package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.GeneradorJuego;
import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vistas.Individuales.VistaDescripcionCarta;
import edu.fiuba.algo3.vistas.Lienzo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;

public class ContenedorTablero extends StackPane {
    public ContenedorTablero(Stage stage, Gwent juego) {
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.setStyle("-fx-background-color: #202020;");

        // CREAMOS ACA EL LIENZO, ASI QUE RECIBIMOS LOS JUGADORES QUE NECESITA
        List<Jugador> jugadores = juego.getJugadores();
        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);

        // VAN A APARECER LOS BOTONES POR ENCIMA DEL TABLERO (LIENZO)
        Lienzo lienzo = new Lienzo(jugador1, jugador2, this::mostrarVistaDescripcion);
        this.getChildren().add(lienzo);
    }

    public void mostrarVistaDescripcion(String descripcion, Image imagen) {
        VistaDescripcionCarta vista = new VistaDescripcionCarta(descripcion, imagen,
                () -> this.getChildren().removeIf(n -> n instanceof VistaDescripcionCarta)); // ESTA LAMBDA ME PERMITE VOLVER AL TABLERO

        StackPane.setAlignment(vista, Pos.CENTER);
        this.getChildren().add(vista);
    }
}
