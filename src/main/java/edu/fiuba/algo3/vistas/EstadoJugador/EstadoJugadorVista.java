package edu.fiuba.algo3.vistas.EstadoJugador;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import edu.fiuba.algo3.Controller.GameController;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class EstadoJugadorVista extends StackPane {

  private Jugador jugador;

  private Text textoNombre;
  private Text textoDescarte;
  private Text textoMazo;
  private Text textoMano;
  private Text textoPuntajeActual;
  private Button botonFinalizar;

  public EstadoJugadorVista(Jugador jugador) {
    this.jugador = jugador;

    this.setPrefSize(180, 350);
    this.setMinSize(180, 350);
    this.setMaxSize(180, 350);
    this.setPickOnBounds(true);

    construirVista();
  }

  private void construirVista() {
    Rectangle fondo = new Rectangle(180, 250);
    fondo.setFill(Color.LIGHTGRAY);
    fondo.setStroke(Color.BLACK);

    textoNombre = new Text(jugador.nombre());
    textoNombre.setFont(Font.font(18));

    textoDescarte = new Text();
    textoMazo = new Text();
    textoMano = new Text();
    textoPuntajeActual = new Text();
    botonFinalizar = new Button("Finalizar");

    VBox contenedorTexto = new VBox(10, textoNombre, textoDescarte, textoMazo, textoMano, textoPuntajeActual,
        botonFinalizar);
    contenedorTexto.setAlignment(Pos.CENTER);

    this.getChildren().addAll(fondo, contenedorTexto);
  }

  public void actualizarVista(GameController game) {
    textoDescarte.setText("Descarte: " + jugador.descarte().getCantidadCartas());
    textoMazo.setText("Mazo: " + jugador.mazo().getCantidadCartas());
    textoMano.setText("Mano: " + jugador.mano().getCantidadCartas());
    textoPuntajeActual.setText("Puntaje: " + jugador.puntajeTablero());

    if (jugador.equals(game.getJugadorActual())) {
      botonFinalizar.setDisable(false);
      botonFinalizar.setOnAction(e -> {
        System.out.println("finalizar");
        game.finalizarTurnoJugadorPlayer();
      });
    } else {
      botonFinalizar.setDisable(true);
      botonFinalizar.setOnAction(null);
    }
  }
}
