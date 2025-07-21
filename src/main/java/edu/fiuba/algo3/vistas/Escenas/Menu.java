package edu.fiuba.algo3.vistas.Escenas;

import edu.fiuba.algo3.vistas.App;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class Menu {
  private Scene scene;

  public Menu(App app) {
    Button btnJugar = new Button("Jugar");
    btnJugar.setOnAction(e -> app.mostrarJuego());

    VBox layout = new VBox(20);
    layout.setAlignment(Pos.CENTER);
    layout.getChildren().add(btnJugar);

    scene = new Scene(layout, 400, 300);
  }

  public Scene getScene() {
    return scene;
  }
}
