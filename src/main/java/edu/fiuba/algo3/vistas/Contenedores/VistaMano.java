package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.ControladorTurnos;
import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.vistas.Individuales.VistaCarta;
import edu.fiuba.algo3.vistas.Individuales.VistaTurnos;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import java.util.function.Consumer;
import java.util.List;

public class VistaMano extends HBox {

    private VistaCarta cartaSeleccionada = null;
    private ControladorTurnos controladorTurnos;
    private VistaTurnos vistaTurnos;

    public VistaMano(List<ICarta> cartas, Consumer<ICarta> onCartaSeleccionada){
        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);

        for(ICarta cartaModelo : cartas){
            System.out.println("Agregando carta a la mano: " + cartaModelo.nombre());
            String nombre = cartaModelo.nombre();

            VistaCarta carta = new VistaCarta(cartaModelo, vistaCarta -> {
                if(cartaSeleccionada !=null) cartaSeleccionada.deseleccionar();
                vistaCarta.seleccionar();
                cartaSeleccionada = vistaCarta;
                onCartaSeleccionada.accept(cartaModelo);
            });

            this.getChildren().add(carta);
        }
    }
    public void removerVistaCarta(VistaCarta carta) {
        this.getChildren().remove(carta);

        if(controladorTurnos != null && vistaTurnos != null){
            controladorTurnos.AvanzarTurno();
            vistaTurnos.actualizarTurnos();
        }
    }
}

