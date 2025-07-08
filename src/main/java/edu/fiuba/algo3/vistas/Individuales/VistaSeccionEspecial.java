package edu.fiuba.algo3.vistas.Individuales;
import edu.fiuba.algo3.ControladorTurnos;
import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.especiales.CEspecial;
import edu.fiuba.algo3.modelo.cartas.especiales.DeBuffCleaner;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vistas.Contenedores.VistaMano;
import edu.fiuba.algo3.vistas.Contenedores.VistaTurnos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaSeccionEspecial extends StackPane {

    public VistaSeccionEspecial(String mensajeAyuda) {
        Rectangle fondo = new Rectangle(190, 140);
        fondo.setFill(Color.STEELBLUE);
        fondo.setStroke(Color.BLACK);

        Label etiqueta = new Label(mensajeAyuda);
        etiqueta.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);
        etiqueta.setAlignment(Pos.CENTER);
        etiqueta.setWrapText(true);
        etiqueta.setMaxWidth(140);

        this.getChildren().addAll(fondo, etiqueta);
        this.setPadding(new Insets(5));
        this.setAlignment(Pos.CENTER);
    }

    public void recibirCartaEspecial(VistaMano vistaMano1, VistaMano vistaMano2 ,Jugador jugador1 ,Jugador jugador2, ControladorTurnos controladorTurnos, VistaTurnos vistaTurnos) {
        this.setOnDragOver(e->{
            if(esDragValido(e,controladorTurnos.jugadorActual(), controladorTurnos)){
                e.acceptTransferModes(TransferMode.MOVE);
            }
            e.consume();
        });

        this.setOnDragDropped(e->{
            boolean seMovio = procesarDrop(vistaMano1, vistaMano2,jugador1,jugador2,controladorTurnos,vistaTurnos);
            e.setDropCompleted(seMovio);
            e.consume();
        });
    }

    private boolean esDragValido(DragEvent e, Jugador jugador, ControladorTurnos controladorTurnos) {
        if(!(e.getGestureSource() instanceof VistaCarta)) return false;
        if(VistaCarta.cartaSeleccionada == null) return false;
        if(!(VistaCarta.cartaSeleccionada.getCartaModelo() instanceof CEspecial)) return  false;

        if(!controladorTurnos.jugadorActual().equals(jugador)) return false;

        CEspecial especial = (CEspecial) VistaCarta.cartaSeleccionada.getCartaModelo();

        if (especial instanceof DeBuffCleaner) {
            this.getChildren().clear();
        }

        return !jugador.atril().hayCartaEspecialActiva() || especial instanceof DeBuffCleaner;
    }

    private boolean procesarDrop(VistaMano mano1,VistaMano mano2, Jugador jugador1, Jugador jugador2, ControladorTurnos controladorTurnos, VistaTurnos vistaTurnos) {
        VistaCarta vistaCarta = VistaCarta.cartaSeleccionada;

        if (vistaCarta == null || !(vistaCarta.getCartaModelo() instanceof CEspecial)) return false;

        Jugador jugadorActual = controladorTurnos.jugadorActual();
        Jugador jugadorSiguiente = controladorTurnos.jugadorProximo();
        VistaMano manoActual = jugadorActual.equals(jugador1) ? mano1 : mano2;

        CEspecial cartaEspecial = (CEspecial) vistaCarta.getCartaModelo();

        if(!puedeColocarEspecial(jugador1,jugador2,cartaEspecial)) return false;

        jugadorActual.jugarCarta(cartaEspecial,jugadorSiguiente,null);
        this.getChildren().add(vistaCarta);
        manoActual.removerVistaCarta(vistaCarta);

        ICarta cartaModelo = vistaCarta.getCartaModelo();

        controladorTurnos.AvanzarTurno();
        vistaTurnos.actualizarTurnos();

        VistaCarta.cartaSeleccionada = null;
        return true;
    }

    private boolean puedeColocarEspecial(Jugador J1, Jugador J2, CEspecial carta){
        boolean existeEspecial = !J1.atril().hayCartaEspecialActiva() || !J2.atril().hayCartaEspecialActiva();

        if(existeEspecial && !(carta instanceof DeBuffCleaner)){
            return false;
        }
        return true;
    }

}
