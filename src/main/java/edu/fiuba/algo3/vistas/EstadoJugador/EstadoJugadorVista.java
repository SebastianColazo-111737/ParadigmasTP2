package edu.fiuba.algo3.vistas.EstadoJugador;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
    // Fondo semitransparente marrón claro
    Rectangle fondo = new Rectangle(160, 300);
    fondo.setArcWidth(20);
    fondo.setArcHeight(20);
    fondo.setFill(Color.rgb(46, 29, 0, 0.7));
    fondo.setStroke(Color.GRAY);
    fondo.setStrokeWidth(2);

    // Textos en blanco
    textoNombre = new Text(jugador.nombre());
    textoNombre.setFont(Font.font(18));
    textoNombre.setFill(Color.WHITE);

    textoDescarte = new Text();
    textoDescarte.setFill(Color.WHITE);

    textoMazo = new Text();
    textoMazo.setFill(Color.WHITE);

    textoMano = new Text();
    textoMano.setFill(Color.WHITE);

    textoPuntajeActual = new Text();
    textoPuntajeActual.setFill(Color.WHITE);

    botonFinalizar = new Button("FIN");
    botonFinalizar.setFont(Font.font("Arial", FontWeight.BOLD, 14));
    botonFinalizar.setStyle(
        "-fx-background-color: red;" +
            "-fx-text-fill: white;" +
            "-fx-border-color: white;" +
            "-fx-border-width: 1;" +
            "-fx-background-radius: 5;" +
            "-fx-border-radius: 5;");

    VBox contenedorTexto = new VBox(10, textoNombre, textoDescarte, textoMazo, textoMano, textoPuntajeActual,
        botonFinalizar);
    contenedorTexto.setAlignment(Pos.CENTER);

    StackPane panelInterior = new StackPane(fondo, contenedorTexto);
    panelInterior.setAlignment(Pos.CENTER);

    this.getChildren().addAll(panelInterior);
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
