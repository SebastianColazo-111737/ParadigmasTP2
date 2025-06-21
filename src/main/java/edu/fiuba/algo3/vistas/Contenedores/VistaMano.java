package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.vistas.Individuales.VistaCarta;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import java.util.function.Consumer;
import java.util.List;

public class VistaMano extends HBox {

    private VistaCarta cartaSeleccionada = null;

    public VistaMano(List<ICarta> cartas, Consumer<ICarta> onCartaSeleccionada){
        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);

        for(ICarta cartaModelo : cartas){
            String nombre = cartaModelo.nombre();

            VistaCarta carta = new VistaCarta(nombre, vistaCarta -> {
                if(cartaSeleccionada !=null) cartaSeleccionada.deseleccionar();
                vistaCarta.seleccionar();
                cartaSeleccionada = vistaCarta;
                onCartaSeleccionada.accept(cartaModelo);
            });

            this.getChildren().add(carta);
        }
    }
}

