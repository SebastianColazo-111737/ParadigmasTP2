package edu.fiuba.algo3.vista.controlador;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.vistas.cartas.CacheEstilosVistaCarta;
import edu.fiuba.algo3.vista.vistas.cartas.EstiloVistaCarta;
import edu.fiuba.algo3.vista.vistas.cartas.VistaCarta;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;

public class ControladorCambiarCartas {
    private final static int CANT_CAMBIOS = 2;
    private int cambiosRestantesJ1;
    private int cambiosRestantesJ2;
    private boolean pasoJ1;
    private boolean pasoJ2;
    private final Jugador jugador1;
    private final Jugador jugador2;
    private final HashMap<Jugador, Label> cambiosLabels = new HashMap<>();
    private Stage ventana;

    public ControladorCambiarCartas(Jugador jugador1, Jugador jugador2, Stage ventana){
        this.jugador1 = jugador1;
        this.cambiosRestantesJ1 = CANT_CAMBIOS;
        this.pasoJ1 = false;

        this.jugador2 = jugador2;
        this.cambiosRestantesJ2 = CANT_CAMBIOS;
        this.pasoJ2 = false;

        this.ventana = ventana;
    }

    public void eventoPasar(boolean esJugador2){
        if (esJugador2) pasoJ2 = true;
        else pasoJ1 = true;
        cerrarSiCorresponde();
    }

    public Label getLabelCambios(boolean esJugador2){
        Jugador jugador = esJugador2 ? jugador2 : jugador1;
        return cambiosLabels.computeIfAbsent(jugador, j -> {
            Label label = new Label("Cambios: " + CANT_CAMBIOS);
            label.setTextFill(Color.GOLD);
            label.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
            return label;
        });
    }

    public void cargarCartas(HBox contenedor, List<Node> vistas, boolean esJugador2){
        Jugador jugador = esJugador2? jugador2: jugador1;

        for (Carta carta : jugador.getMano().getCartas()) {

            EstiloVistaCarta estilo = CacheEstilosVistaCarta.getInstancia().getEstiloVistaCarta(carta.getNombre());
            VistaCarta vistaCarta = estilo.construir(carta, null);
            StackPane vistaCartaDetalle = vistaCarta.getVentanaDetalle(false);

            vistaCartaDetalle.setOnMouseClicked(e -> {
                if (puedeCambiar(esJugador2)) {
                    jugador.cambiarCartaDeLaManoAlMazo(carta);
                    actualizarCartas(contenedor, vistas, esJugador2);
                }
            });
            vistas.add(vistaCartaDetalle);
            contenedor.getChildren().add(vistaCartaDetalle);
        }
    }

    private void actualizarCartas(HBox contenedor, List<Node> vistas, boolean esJugador2) {
        vistas.clear();
        contenedor.getChildren().clear();
        cargarCartas(contenedor, vistas, esJugador2);

        if (esJugador2) cambiosRestantesJ2--;
        else cambiosRestantesJ1--;

        Label cambiosLabel = getLabelCambios(esJugador2);
        if (cambiosLabel != null) {
            cambiosLabel.setText("Cambios: " + (esJugador2 ? cambiosRestantesJ2 : cambiosRestantesJ1));
        }

        cerrarSiCorresponde();
    }

    private void cerrarSiCorresponde() {
        if ((cambiosRestantesJ1 == 0 || pasoJ1) && (cambiosRestantesJ2 == 0 || pasoJ2)) {
            this.ventana.close();
        }
    }

    private boolean puedeCambiar(boolean esJugador2) {
        return esJugador2? cambiosRestantesJ2 > 0 && !pasoJ2: cambiosRestantesJ1 > 0 && !pasoJ1;
    }

}
