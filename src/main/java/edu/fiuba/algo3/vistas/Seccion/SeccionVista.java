package edu.fiuba.algo3.vistas.Seccion;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.layout.Priority;

import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.vistas.Cartas.CartaVista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class SeccionVista extends StackPane {

  private HBox contenedorCartas;
  private StackPane puntajePane;
  private Text puntajeText;
  private Seccion seccion;

  public SeccionVista(Seccion seccion) {
    this.seccion = seccion;

    // Fondo
    Rectangle fondo = new Rectangle(800, 70);
    fondo.setFill(Color.LIGHTGRAY);
    fondo.setStroke(Color.BLACK);

    // Puntaje
    puntajeText = new Text();
    Rectangle puntajeBg = new Rectangle(40, 40);
    puntajeBg.setFill(Color.GOLD);
    puntajePane = new StackPane(puntajeBg, puntajeText);
    puntajePane.setAlignment(Pos.CENTER);
    puntajePane.setPrefSize(50, 50);
    StackPane.setAlignment(puntajePane, Pos.CENTER_LEFT);

    // Cartas
    contenedorCartas = new HBox(10);
    contenedorCartas.setAlignment(Pos.CENTER_LEFT);
    contenedorCartas.setPadding(new Insets(5));
    contenedorCartas.setFillHeight(true);
    HBox.setHgrow(contenedorCartas, Priority.ALWAYS);
    contenedorCartas.setPrefHeight(60);
    contenedorCartas.setMaxWidth(700);

    // Layout principal
    HBox layoutPrincipal = new HBox(15);
    layoutPrincipal.setAlignment(Pos.CENTER_LEFT);
    layoutPrincipal.setPadding(new Insets(10));
    layoutPrincipal.getChildren().addAll(puntajePane, contenedorCartas);
    layoutPrincipal.setPrefSize(800, 70);

    this.getChildren().addAll(fondo, layoutPrincipal);
    this.setMinSize(800, 70);
    this.setPrefSize(800, 70);
    this.setMaxSize(800, 70);

    actualizarVista();
  }

  public void actualizarVista() {
    contenedorCartas.getChildren().clear();

    int cantidadCartas = seccion.getCartas().size();
    double anchoDisponible = 700 - (10 * (cantidadCartas - 1)); // restamos márgenes entre cartas
    double anchoCarta = cantidadCartas > 0 ? Math.min(100, anchoDisponible / cantidadCartas) : 100;

    for (Unidad u : seccion.getCartas()) {
      CartaVista uVista = new CartaVista(u);
      uVista.setPrefWidth(anchoCarta);
      uVista.setPrefHeight(50);
      contenedorCartas.getChildren().add(uVista);
    }

    puntajeText.setText(String.valueOf(seccion.calcularPuntajeActualUnidades().getPuntajeActual()));
  }
}
