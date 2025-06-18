package edu.fiuba.algo3.vistas;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import java.util.function.Consumer;

public class VistaMano extends HBox {

    private VistaCarta cartaSeleccionada = null;

    public VistaMano(Consumer<String> onCartaSeleccionada){
        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);

        for(int i = 1; i <= 10; i++){
            String nombre = "C" + i;

            VistaCarta carta = new VistaCarta(nombre, vistaCarta -> {
                if(cartaSeleccionada !=null) cartaSeleccionada.deseleccionar();
                vistaCarta.seleccionar();
                cartaSeleccionada = vistaCarta;
                onCartaSeleccionada.accept(nombre);
            });
            this.getChildren().add(carta);
        }
    }
}

