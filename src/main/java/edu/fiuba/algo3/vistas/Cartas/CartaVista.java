package edu.fiuba.algo3.vistas.Cartas;

import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.unidades.*;

public class CartaVista extends StackPane {

  private ICarta carta;

  public CartaVista(ICarta carta) {
    this.carta = carta;

    this.setPrefSize(60, 70);
    this.setMinSize(60, 70);
    this.setMaxSize(60, 70);
    this.setPickOnBounds(true);
    Image bgImage = null;
    if (carta instanceof Legendaria) {
      bgImage = new Image(getClass().getResourceAsStream("/images/Legendaria.png"));

    } else if (carta instanceof Medico) {
      bgImage = new Image(getClass().getResourceAsStream("/images/medico.png"));
    } else {
      bgImage = new Image(getClass().getResourceAsStream("/images/unidadBasica.png"));
    }
    ImageView fondoImagen = new ImageView(bgImage);
    fondoImagen.setFitWidth(60);
    fondoImagen.setFitHeight(70);
    fondoImagen.setPreserveRatio(false);

    fondoImagen.setSmooth(true);
    fondoImagen.setCache(true);
    fondoImagen.setCacheHint(CacheHint.QUALITY);

    Rectangle borde = new Rectangle(60, 70);
    borde.setFill(Color.TRANSPARENT);
    borde.setStroke(Color.BLACK);

    Label texto = new Label(carta.nombre());
    texto.setTextFill(Color.WHITE);
    texto.setFont(Font.font("System", FontWeight.BOLD, 10));
    texto.setMaxWidth(60);
    texto.setAlignment(Pos.CENTER);
    texto.setWrapText(false);
    texto.setStyle("-fx-text-overrun: ellipsis;");

    VBox vbox = new VBox();
    vbox.setPrefSize(60, 70);
    vbox.setAlignment(Pos.BOTTOM_CENTER);
    vbox.getChildren().add(texto);

    this.getChildren().addAll(fondoImagen, borde, vbox);

    this.setOnMouseClicked(e -> {
      System.out.println("Estoy presionando click en " + carta.nombre());
    });
  }

  public ICarta getCarta() {
    return this.carta;
  }
}
