package edu.fiuba.algo3.vistas.Info;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import edu.fiuba.algo3.Controller.*;

public class InfoVista extends StackPane {

  private Text textoVidaJ1;
  private Text textoVidaJ2;
  private Text textoTurno;

  public InfoVista() {

    Rectangle fondo = new Rectangle(180, 120);
    fondo.setFill(Color.LIGHTGRAY);
    fondo.setStroke(Color.BLACK);

    Text titulo = new Text("Información");
    titulo.setFont(Font.font("Arial", 15));
    titulo.setFill(Color.DARKBLUE);

    this.textoVidaJ2 = new Text("Jugador 2:");
    this.textoTurno = new Text("Turno:");
    this.textoVidaJ1 = new Text("Jugador 1:");

    VBox contenido = new VBox(6, textoVidaJ2, textoTurno, textoVidaJ1);
    contenido.setAlignment(Pos.CENTER);

    VBox layout = new VBox(10, titulo, contenido);
    layout.setAlignment(Pos.TOP_CENTER);
    VBox.setMargin(titulo, new Insets(5, 0, 10, 0));

    this.setPrefSize(180, 120);
    this.getChildren().addAll(fondo, layout);
  }

  public void actualizarVista(GameController game) {
    this.textoTurno.setText("Turno: " + game.getJugadorActual().nombre());
    this.textoVidaJ1.setText("Jugador 1: " + game.getJugador1().getVida());
    this.textoVidaJ2.setText("Jugador 2: " + game.getJugador2().getVida());
  }
}
