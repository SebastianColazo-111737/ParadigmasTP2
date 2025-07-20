package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.Observer.Observador;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mano;

import edu.fiuba.algo3.vista.Cartas.CacheEstilosVistaCarta;
import edu.fiuba.algo3.vista.Cartas.EstiloVistaCarta;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;

public class VistaMano extends FlowPane implements Observador {

    private Mano manoModelo;
    private Carta cartaSeleccionada;

    public VistaMano(Mano mano) {
        this.setHgap(10);
        this.setVgap(10);
        this.setStyle("-fx-background-color: beige; -fx-padding: 15px;");

        this.manoModelo = mano;
        this.manoModelo.agregarObservador(this);
        actualizarVista();
    }

    public Carta getCartaSeleccionada(){return this.cartaSeleccionada;}

    public void actualizarVista() {

        this.getChildren().clear();

        for (Carta cartaModelo : this.manoModelo.getCartas()) {
            String nombreCarta = cartaModelo.getNombre();
            EstiloVistaCarta estiloVistaCarta = CacheEstilosVistaCarta.getInstancia().getEstiloVistaCarta(nombreCarta);
            Node vista = estiloVistaCarta.construir(cartaModelo);


            // Estilo normal
            vista.setStyle(vista.getStyle() + "; -fx-border-color: black;");

            vista.setOnMouseClicked(e -> {
                cartaSeleccionada = cartaModelo;
                resaltarCartaSeleccionada(vista);
            });


            this.getChildren().add(vista);
        }
    }

    private void resaltarCartaSeleccionada(Node cartaSeleccionadaVista) {
        for (Node carta : this.getChildren()) {
            carta.setStyle(carta.getStyle()
                    .replaceAll("-fx-border-color: [^;]+;", "-fx-border-color: black;")
                    .replaceAll("-fx-border-width: [^;]+;", "-fx-border-width: 1px;"));
        }

        // Estilo más notorio para la seleccionada
        cartaSeleccionadaVista.setStyle(cartaSeleccionadaVista.getStyle()
                .replaceAll("-fx-border-color: [^;]+;", "-fx-border-color: dodgerblue;")
                .replaceAll("-fx-border-width: [^;]+;", "-fx-border-width: 3px;") +
                "; -fx-border-radius: 5px;");
    }

    @Override
    public void notificar() {
        actualizarVista();
    }
}
