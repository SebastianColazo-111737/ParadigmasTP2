package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Jugador;
//import edu.fiuba.algo3.vistas.Contenedores.ContenedorMenuPrincipal;


import edu.fiuba.algo3.vistas.Lienzo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.stream.Stream;

/**
 * JavaFX App
 */

public class App extends Application {

    private Stage primerStage;

    @Override
    public void start(Stage stage){
        this.primerStage = stage;
        iniciarMenu();
    }

    // Inicia el menú de bienvenida
    private void iniciarMenu() {
        Label titulo = new Label("Bienvenido a GWENT");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 50));

        Text tituloReglas = new Text("Reglas del juego:\n\n");
        tituloReglas.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        Text item1 = new Text("• En cada turno se puede jugar una carta o terminar la participación.\n");
        Text item2 = new Text("• Si se termina la participación, no se podrá volver a jugar en la ronda.\n");
        Text item3 = new Text("• Gana la ronda aquel que tenga más puntos.\n");
        Text item4 = new Text("• Gana el juego aquel que logre ganar dos rondas primero.\n");

        Stream.of(item1, item2, item3, item4).forEach(t -> t.setFont(Font.font("Arial", 16)));

        TextFlow reglasFlow = new TextFlow(tituloReglas, item1, item2, item3, item4);
        reglasFlow.setMaxWidth(600);

        Button comenzar = new Button("¡Comenzar Juego!");
        comenzar.setOnAction(e -> iniciarJuego());

        VBox contenedor = new VBox(30, titulo, reglasFlow, comenzar);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setPadding(new Insets(40));

        Scene escenaMenu = new Scene(contenedor, 800, 600);
        primerStage.setScene(escenaMenu);
        primerStage.setTitle("Gwent - Menú Principal");
        primerStage.show();
    }

    // Inicia el juego directamente
    private void iniciarJuego() {
        // Crear el juego desde GeneradorJuego
        Lienzo lienzo = GeneradorJuego.construirJuego();
        Scene escenaJuego = new Scene(lienzo, 1200, 1000);

        primerStage.setScene(escenaJuego);
        primerStage.setTitle("Gwent - Juego");
    }

    public static void main(String[] args) {
        launch();
    }
}