package edu.fiuba.algo3.vista.vistas.controladoresVistas;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.vista.vistas.cartas.CacheEstilosVistaCarta;
import edu.fiuba.algo3.vista.vistas.cartas.EstiloVistaCarta;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


public class ControladorSeccion  {
    private Seccion seccionModelo;

    public ControladorSeccion(Seccion seccionModelo){
        this.seccionModelo = seccionModelo;
    }

    public void actualizarVista(HBox contenedorCartas, Text puntajeText) {
        contenedorCartas.getChildren().clear();

        for (Carta cartaModelo : seccionModelo.getUnidadesColocadas()) {
            EstiloVistaCarta estilo = CacheEstilosVistaCarta.getInstancia().getEstiloVistaCarta(cartaModelo.getNombre());
            Node vistaCarta = estilo.construir(cartaModelo, null);
            vistaCarta.setDisable(true);
            contenedorCartas.getChildren().add(vistaCarta);
        }

        puntajeText.setText(String.valueOf(seccionModelo.getPuntaje()));
    }

}
