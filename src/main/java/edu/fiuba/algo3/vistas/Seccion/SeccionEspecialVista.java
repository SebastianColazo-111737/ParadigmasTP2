package edu.fiuba.algo3.vistas.Seccion;

import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.atril.SeccionEspecial;
import edu.fiuba.algo3.vistas.Cartas.CartaVista;

public class SeccionEspecialVista extends StackPane {

  private HBox contenedorCartas;

  public SeccionEspecialVista() {

    Rectangle fondo = new Rectangle(250, 80);
    fondo.setStroke(Color.BROWN);
    fondo.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/images/seccion.jpg"))));
    fondo.setArcWidth(20);
    fondo.setArcHeight(20);

    contenedorCartas = new HBox(10);
    contenedorCartas.setAlignment(Pos.CENTER);
    contenedorCartas.setPadding(new Insets(10));

    StackPane fondoConCartas = new StackPane(fondo, contenedorCartas);
    fondoConCartas.setMaxWidth(700);
    fondoConCartas.setMaxHeight(80);

    VBox layoutVertical = new VBox(20);
    layoutVertical.setPadding(new Insets(20));
    layoutVertical.setAlignment(Pos.CENTER);
    layoutVertical.getChildren().addAll(fondoConCartas);
    VBox.setVgrow(fondoConCartas, Priority.ALWAYS);

    this.getChildren().addAll(layoutVertical);
    this.setPrefSize(250, 300);
    this.setMaxWidth(250);
  }

  public void actualizarVista(SeccionEspecial seccion) {
    contenedorCartas.getChildren().clear();

    int cantidadCartas = seccion.cantidad();
    double anchoDisponible = 150 - (10 * (cantidadCartas - 1));
    double anchoCarta = cantidadCartas > 0 ? Math.min(100, anchoDisponible / cantidadCartas) : 100;

    for (ICarta u : seccion.getCartas()) {
      CartaVista uVista = new CartaVista(u);
      uVista.setPrefWidth(anchoCarta);
      uVista.setPrefHeight(60);
      contenedorCartas.getChildren().add(uVista);
    }
  }
}
