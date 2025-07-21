package edu.fiuba.algo3.vistas.Cartas;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import edu.fiuba.algo3.modelo.cartas.ICarta;

public class CartaVista extends StackPane {

  private ICarta carta;

  public CartaVista(ICarta carta) {
    this.carta = carta;

    Rectangle fondo = new Rectangle(60, 70);
    fondo.setFill(Color.LIGHTGRAY);
    fondo.setStroke(Color.BLACK);

    this.setPrefSize(60, 70);
    this.setMinSize(60, 70);
    this.setMaxSize(60, 70);

    this.setPickOnBounds(true);

    Text texto = new Text(carta.nombre());
    texto.setWrappingWidth(50);
    texto.setStyle("-fx-font-size: 10px;");
    texto.setTranslateY(0);

    this.setOnMouseClicked(e -> {
      System.out.println("Estoy presionando click en " + carta.nombre());
    });

    this.getChildren().addAll(fondo, texto);
  }

  public ICarta getCarta() {
    return this.carta;
  }
}
