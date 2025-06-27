package edu.fiuba.algo3.vistas.Individuales;
import edu.fiuba.algo3.ControladorTurnos;
import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.especiales.CEspecial;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vistas.Contenedores.VistaMano;
import edu.fiuba.algo3.vistas.Contenedores.VistaTurnos;
import javafx.scene.control.Label;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*public class VistaSeccionEspecial extends StackPane {

    public VistaSeccionEspecial(String nombre){
        Rectangle seccion = new Rectangle(150,90);
        seccion.setFill(Color.LIGHTGOLDENRODYELLOW);
        seccion.setStroke(Color.BLACK);

        Label etiqueta = new Label(nombre);
        StackPane rectanguloConTexto = new StackPane(seccion, etiqueta);

        this.getChildren().addAll(rectanguloConTexto);
    }



    public void recibirCartaEspecial(VistaMano vistaMano, Jugador jugador, ControladorTurnos controladorTurnos, VistaTurnos vistaTurnos) {
        this.setOnDragOver(e -> {
            if (e.getGestureSource() instanceof VistaCarta && VistaCarta.cartaSeleccionada.getCartaModelo() instanceof CEspecial) {
                e.acceptTransferModes(TransferMode.MOVE);
            }
            e.consume();
        });

        this.setOnDragDropped(e -> {
            boolean seMovio = false;

            if (VistaCarta.cartaSeleccionada != null
                    && VistaCarta.cartaSeleccionada.getCartaModelo() instanceof CEspecial
                    && controladorTurnos.jugadorActual().equals(jugador)) {

                VistaCarta vistaCarta = VistaCarta.cartaSeleccionada;
                ICarta cartaModelo = vistaCarta.getCartaModelo();

                jugador.jugarCarta(cartaModelo, controladorTurnos.jugadorProximo(), null);
                this.getChildren().add(vistaCarta);
                vistaMano.removerVistaCarta(vistaCarta);

                controladorTurnos.AvanzarTurno();
                vistaTurnos.actualizarTurnos();

                VistaCarta.cartaSeleccionada = null;
                seMovio = true;
            }

            e.setDropCompleted(seMovio);
            e.consume();
        });
    }
}
*/