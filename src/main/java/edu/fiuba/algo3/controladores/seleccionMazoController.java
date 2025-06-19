package edu.fiuba.algo3.controladores;


import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Mazo;
import edu.fiuba.algo3.utilidades.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class seleccionMazoController {
    private Juego juego;

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public void seleccionarMazo(ActionEvent event) throws Exception {
        String nombreMazo = ((Button) event.getSource()).getText();
        juego.jugadorActual().setMazo(new Mazo(nombreMazo));
        juego.siguienteJugador();

        FXMLLoader loader = new FXMLLoader();

        if (!juego.juegoCompleto()) {
            loader.setLocation(getClass().getResource(Paths.NOMBRE_JUGADOR));
        } else {
            // SE COMIENZA A JUGAR
            loader.setLocation(getClass().getResource(Paths.MENU_PRINCIPAL));
        }

        AnchorPane root = loader.load();
        Object controller = loader.getController();
        if (controller instanceof nombreJugadorController) {
            ((nombreJugadorController) controller).setJuego(juego);
        }

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
