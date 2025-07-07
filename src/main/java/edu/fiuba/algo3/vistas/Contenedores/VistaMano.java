package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.ControladorTurnos;
import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.especiales.CEspecial;
import edu.fiuba.algo3.modelo.jugador.Mano;
import edu.fiuba.algo3.vistas.Individuales.VistaCarta;
import edu.fiuba.algo3.vistas.Individuales.VistaCartaEspecial;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.List;

public class VistaMano extends HBox {

    private VistaCarta cartaSeleccionada = null;
    private ControladorTurnos controladorTurnos;
    private VistaTurnos vistaTurnos;
    private final Mano manoModelo;

    private final List<ICarta> cartasRevividas = new ArrayList<>();

    public VistaMano(Mano manoModelo,List<ICarta> cartas){
        this.manoModelo = manoModelo;
        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);

        this.actualizar();

        manoModelo.agregarObservador(() -> Platform.runLater(this::actualizar));

    }
    public void removerVistaCarta(VistaCarta carta) {
        this.getChildren().remove(carta);

        cartasRevividas.remove(carta.getCartaModelo());

        if(controladorTurnos != null && vistaTurnos != null){
            controladorTurnos.AvanzarTurno();
            vistaTurnos.actualizarTurnos();
        }
    }

    public void recibirCartaRevivida(ICarta cartaModelo){
        System.out.println("Agregando carta revivida a la mano: " + cartaModelo.nombre());
        cartasRevividas.add(cartaModelo);
        this.actualizar();
    }

    public void actualizar() {
        this.getChildren().clear();

        for (ICarta carta : manoModelo.getCartas()) {
            VistaCarta vistaCarta;

            Consumer<VistaCarta> seleccionador = vista -> {
                if(cartaSeleccionada != null) cartaSeleccionada.deseleccionar();
                vista.seleccionar();
                cartaSeleccionada = vista;
            };
            if(carta instanceof CEspecial){
                vistaCarta = new VistaCartaEspecial(carta,seleccionador);
            }else{
                vistaCarta = new VistaCarta(carta,seleccionador);
            }
            this.getChildren().add(vistaCarta);
        }
    }

}
