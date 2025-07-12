package edu.fiuba.algo3;

import edu.fiuba.algo3.vistas.Lienzo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private TextField campoName1;
    private TextField campoName2;

    @Override
    public void start(Stage stage){
        this.primerStage = stage;
        iniciarMenu();
    }

    // Inicia el menú de bienvenida
    private void iniciarMenu() {
        Label titulo = new Label("Bienvenido a GWENT");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD,50));

        Text tituloReglas = new Text("Reglas del juego:\n\n");
        tituloReglas.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        Text item1 = new Text("• En cada turno se puede jugar una carta o terminar la participación.\n");
        Text item2 = new Text("• Solo puede haber una carta especial activa por jugador en cada ronda.\n");
        Text item3 = new Text("• Si se termina la participación, no se podrá volver a jugar en la ronda.\n");
        Text item4 = new Text("• Gana la ronda aquel que tenga más puntos.\n");
        Text item5 = new Text("• Gana el juego aquel que logre ganar dos rondas primero.\n");

        Stream.of(item1, item2, item3, item4 ,item5).forEach(t -> t.setFont(Font.font("Arial", 16)));

        TextFlow reglasFlow = new TextFlow(tituloReglas, item1, item2, item3, item4 ,item5);
        reglasFlow.setMaxWidth(600);

        Button comenzar = new Button("¡Comenzar Juego!");
        comenzar.setDisable(true);
        comenzar.setOnAction(e -> iniciarJuego());

        VBox formulario = crearCampoCargarNombres(comenzar);

        VBox contenedor = new VBox(30, titulo, reglasFlow, formulario,comenzar);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setPadding(new Insets(40));

        Scene escenaMenu = new Scene(contenedor, 800, 600);
        primerStage.setScene(escenaMenu);
        primerStage.setTitle("Gwent - Menú Principal");
        primerStage.show();
    }

    // Inicia el juego directamente
    private void iniciarJuego() {
        String nomJ1 = campoName1.getText().trim();
        String nomJ2 = campoName2.getText().trim();

        Lienzo lienzo = GeneradorJuego.construirJuego(nomJ1,nomJ2);
        Scene escenaJuego = new Scene(lienzo, 1200, 1000);

        primerStage.setScene(escenaJuego);
        primerStage.setTitle("Gwent - Juego");
    }

    private VBox crearCampoCargarNombres(Button botonComenzar){
        Label labelJ1 = new Label("Nombre para Jugador 1: ");
        Label labelJ2 = new Label("Nombre para el Jugador 2: ");
        labelJ1.setStyle("-fx-font-size: 17px; -fx-font-weight: bold;");
        labelJ2.setStyle("-fx-font-size: 17px; -fx-font-weight: bold;");

        campoName1 = new TextField();
        campoName2 = new TextField();

        campoName1.textProperty().addListener((obs, oldVal, newVal) -> validarCampos(botonComenzar));
        campoName2.textProperty().addListener((obs, oldVal, newVal) -> validarCampos(botonComenzar));

        VBox formulario = new VBox(10,labelJ1,campoName1,labelJ2,campoName2);
        formulario.setAlignment(Pos.CENTER);
        return formulario;
    }

    private void validarCampos(Button botonComenzar){
        boolean comenzarJuego = !campoName1.getText().trim().isEmpty() &&
                !campoName2.getText().trim().isEmpty();
        botonComenzar.setDisable(!comenzarJuego);
    }

    public static void main(String[] args) {
        launch();
    }
}