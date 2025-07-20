package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mano;

import edu.fiuba.algo3.vista.Cartas.CacheEstilosVistaCarta;
import edu.fiuba.algo3.vista.Cartas.EstiloVistaCarta;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;

public class VistaMano extends FlowPane {

    private Mano manoModelo;

    public VistaMano(Mano mano) {
        this.setHgap(10);
        this.setVgap(10);
        this.setStyle("-fx-background-color: beige; -fx-padding: 15px;");

        this.manoModelo = mano;
        actualizarVista(mano);
    }

    public void actualizarVista(Mano mano) {

        this.getChildren().clear();

        for (Carta cartaModelo : mano.getCartas()) {
            String nombreCarta = cartaModelo.getNombre();
            EstiloVistaCarta estiloVistaCarta = CacheEstilosVistaCarta.getInstancia().getEstiloVistaCarta(nombreCarta);
            Node vista = estiloVistaCarta.construir(cartaModelo);
            this.getChildren().add(vista);
        }

    }
}
