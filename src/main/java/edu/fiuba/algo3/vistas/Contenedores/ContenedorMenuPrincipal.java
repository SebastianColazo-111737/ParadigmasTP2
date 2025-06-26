package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.modelo.juego.Gwent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorMenuPrincipal extends VBox {

    public ContenedorMenuPrincipal(Stage stage, Gwent juego, Scene escenaNombreJugador) {
        this.setPrefSize(800, 600);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(40);
        this.setPadding(new Insets(50));

        Label titulo = new Label("GWENT");
        titulo.setFont(new Font("Arial", 48));

        Button botonJugar = new Button("JUGAR");
        botonJugar.setOnAction(e -> stage.setScene(escenaNombreJugador));

        this.getChildren().addAll(titulo, botonJugar);
    }
}
