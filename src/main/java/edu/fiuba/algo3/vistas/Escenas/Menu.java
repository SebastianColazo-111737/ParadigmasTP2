package edu.fiuba.algo3.vistas.Escenas;

import edu.fiuba.algo3.vistas.App;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.text.Font;

public class Menu {
  private Scene scene;

  public Menu(App app) {
    Image logoImg = new Image(getClass().getResource("/images/logogwent.png").toExternalForm());
    ImageView logoView = new ImageView(logoImg);
    logoView.setPreserveRatio(true);
    logoView.setSmooth(true);
    logoView.setFitWidth(400);

    Button btnJugar = new Button("Jugar");
    btnJugar.setFont(Font.font(18));
    btnJugar.setStyle("-fx-background-color: #222; -fx-text-fill: white; -fx-padding: 10 20 10 20;");
    btnJugar.setOnAction(e -> app.mostrarJuego());

    Button btnSalir = new Button("Salir");
    btnSalir.setFont(Font.font(18));
    btnSalir.setStyle("-fx-background-color: #444; -fx-text-fill: white; -fx-padding: 10 20 10 20;");
    btnSalir.setOnAction(e -> System.exit(0));

    VBox layout = new VBox(30);
    layout.setAlignment(Pos.CENTER);
    layout.getChildren().addAll(logoView, btnJugar, btnSalir);

    scene = new Scene(layout, 800, 600);

    Image fondoImg = new Image(getClass().getResource("/images/gwentbg.jpg").toExternalForm());
    BackgroundImage fondo = new BackgroundImage(
        fondoImg,
        BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.CENTER,
        new BackgroundSize(
            100, 100, true, true, true, true));
    layout.setBackground(new Background(fondo));

    scene.widthProperty().addListener((obs, oldVal, newVal) -> {
      double nuevoAncho = newVal.doubleValue() * 0.5;
      logoView.setFitWidth(nuevoAncho);
    });

    scene.heightProperty().addListener((obs, oldVal, newVal) -> {
      layout.setBackground(new Background(fondo));
    });
  }

  public Scene getScene() {
    return scene;
  }
}
