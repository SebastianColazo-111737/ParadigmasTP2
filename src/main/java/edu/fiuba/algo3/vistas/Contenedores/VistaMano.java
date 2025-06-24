package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.vistas.Individuales.VistaCarta;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.List;

public class VistaMano extends HBox {

    private VistaCarta cartaSeleccionada = null;

    public VistaMano(List<ICarta> cartas, Consumer<ICarta> onCartaSeleccionada, BiConsumer<String, Image> onMostrarDescripcion){
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
            },
            onMostrarDescripcion
            );
            this.getChildren().add(carta);
        }
    }

    public void removerVistaCarta(VistaCarta carta) {
        this.getChildren().remove(carta);
    }

}

