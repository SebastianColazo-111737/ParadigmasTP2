package edu.fiuba.algo3.vista.pantallas;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.vista.controlador.ControladorJuego;
import edu.fiuba.algo3.vista.vistas.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.function.BiConsumer;

public class PantallaJuego {

    private ControladorJuego controlador;

    private VistaJugador jugador1;
    private VistaAtril atrilJ1;
    private VistaMano manoJ1;
    private VistaMazo mazoJ1;
    private VistaDescarte descartej1;

    private VistaJugador jugador2;
    private VistaAtril atrilJ2;
    private VistaMano manoJ2;
    private VistaMazo mazoJ2;
    private VistaDescarte descartej2;

    public PantallaJuego(Stage stage, String nombreJ1, Image imagenJ1,
                         String nombreJ2, Image imagenJ2) {

        this.controlador = new ControladorJuego();
        this.jugador1 = new VistaJugador(controlador.getJugador1(), nombreJ1, imagenJ1);
        this.jugador2 = new VistaJugador(controlador.getJugador2(), nombreJ2, imagenJ2);

        this.atrilJ1 = new VistaAtril(controlador.getJugador1().getAtril(), true);
        this.atrilJ2 = new VistaAtril(controlador.getJugador2().getAtril(), false);

        BiConsumer<Carta, Posicion> eventoJugarCarta = (carta, posicion) -> {
            controlador.jugarCarta(carta, posicion);
            controlador.proximoTurno();
            emitirSonidoDeCarta();
            actualizarCambioDeTurno();


        };
        Image imagenDorsoJ1 = new Image("/imagenes/dorsoCarta1.png");
        Image imagenDorsoJ2 = new Image("/imagenes/dorsoCarta2.png");
        this.manoJ1 = new VistaMano(controlador.getJugador1().getMano(), eventoJugarCarta, imagenDorsoJ1);
        this.manoJ2 = new VistaMano(controlador.getJugador2().getMano(), eventoJugarCarta, imagenDorsoJ2);


        this.mazoJ1 = new VistaMazo(controlador.getJugador1().getMazo(), imagenDorsoJ1);
        this.descartej1 = new VistaDescarte(controlador.getJugador1().getDescarte());


        this.mazoJ2 = new VistaMazo(controlador.getJugador2().getMazo(), imagenDorsoJ2);
        this.descartej2 = new VistaDescarte(controlador.getJugador2().getDescarte());



        VBox contenedorJugadores = new VBox();
        contenedorJugadores.setPadding(new Insets(10));
        contenedorJugadores.setSpacing(20);
        contenedorJugadores.setAlignment(Pos.CENTER);
        VBox.setVgrow(jugador2, Priority.ALWAYS);
        VBox.setVgrow(jugador1, Priority.ALWAYS);
        contenedorJugadores.getChildren().addAll(jugador2, jugador1);


        VBox contenedorCentro = new VBox(10,
                manoJ2,
                atrilJ2,
                atrilJ1,
                manoJ1
        );
        contenedorCentro.setAlignment(Pos.CENTER);
        contenedorCentro.setPadding(new Insets(10));
        contenedorCentro.setMaxWidth(Double.MAX_VALUE);


        Button botonPasarTurno = new Button("Pasar");
        botonPasarTurno.setPrefWidth(150);
        botonPasarTurno.setStyle(estiloBotonNormal());
        botonPasarTurno.setOnAction(e -> {
            controlador.finalizarParticipacion();
            controlador.proximoTurno();
            actualizarCambioDeTurno();

        });
        botonPasarTurno.setOnMouseEntered(e -> botonPasarTurno.setStyle(estiloBotonHover()));
        botonPasarTurno.setOnMouseExited(e -> botonPasarTurno.setStyle(estiloBotonNormal()));

        VBox.setMargin(botonPasarTurno, new Insets(270, 0, 270, 0));

        VBox contenedorDerecha = new VBox(20);
        contenedorDerecha.setPadding(new Insets(10));
        contenedorDerecha.setAlignment(Pos.CENTER);
        contenedorDerecha.setPrefWidth(200);


        HBox mazoDescarteJ2 = new HBox(10, mazoJ2, descartej2);
        mazoDescarteJ2.setAlignment(Pos.CENTER);
        HBox mazoDescarteJ1 = new HBox(10, mazoJ1, descartej1);
        mazoDescarteJ1.setAlignment(Pos.CENTER);
        Region separadorCentro = new Region();
        VBox.setVgrow(separadorCentro, Priority.ALWAYS);
        contenedorDerecha.getChildren().addAll(mazoDescarteJ2, botonPasarTurno, mazoDescarteJ1);


        HBox layoutCompleto = new HBox(40, contenedorJugadores, contenedorCentro, contenedorDerecha);
        layoutCompleto.setAlignment(Pos.CENTER);
        layoutCompleto.setPadding(new Insets(20));
        layoutCompleto.setMaxWidth(Double.MAX_VALUE);

        Image bgImage = new Image(getClass().getResource("/images/backgroundGame.jpg").toExternalForm());
        BackgroundSize backgroundSize = new BackgroundSize(
                100, 100, true, true, true, true);
        BackgroundImage fondo = new BackgroundImage(
                bgImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);

        StackPane root = new StackPane();
        root.setBackground(new Background(fondo));
        StackPane.setAlignment(layoutCompleto, Pos.CENTER);
        StackPane.setMargin(layoutCompleto, new Insets(0));
        root.getChildren().add(layoutCompleto);

        Scene scene = new Scene(root);
        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            root.setBackground(new Background(
                    new BackgroundImage(bgImage,
                            BackgroundRepeat.NO_REPEAT,
                            BackgroundRepeat.NO_REPEAT,
                            BackgroundPosition.CENTER,
                            new BackgroundSize(100, 100, true, true, true, true))));
        });

        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
            root.setBackground(new Background(
                    new BackgroundImage(bgImage,
                            BackgroundRepeat.NO_REPEAT,
                            BackgroundRepeat.NO_REPEAT,
                            BackgroundPosition.CENTER,
                            new BackgroundSize(100, 100, true, true, true, true))));
        });


        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        stage.setTitle("Gwent");

        controlador.iniciarJuego();
        actualizarCambioDeTurno();
    }

    private void actualizarCambioDeTurno(){

        if(controlador.terminoLaRonda()){
            actualizarCambioDeRonda();
        }

        boolean esTurnoJ1 = controlador.getJugadorActual().equals(controlador.getJugador1());

        jugador1.resaltarTurno(esTurnoJ1);
        manoJ1.setInteractuable(esTurnoJ1);
        jugador1.actualizar(controlador.getRondasGanadas(controlador.getJugador1()));


        jugador2.resaltarTurno(!esTurnoJ1);
        manoJ2.setInteractuable(!esTurnoJ1);
        jugador2.actualizar(controlador.getRondasGanadas(controlador.getJugador2()));
    }

    private void actualizarCambioDeRonda(){
        if(controlador.terminoElJuego()){
            jugador1.actualizar(controlador.getRondasGanadas(controlador.getJugador1()));
            jugador2.actualizar(controlador.getRondasGanadas(controlador.getJugador2()));

            Jugador ganador = controlador.getGanador();
            if(ganador.equals(controlador.getJugador1())){
                jugador1.mostrarPantallaGanador(controlador.getResultados());
            }else{
                jugador2.mostrarPantallaGanador(controlador.getResultados());
            }
            return;
        }
        controlador.iniciarNuevaRonda();
    }

    private void emitirSonidoDeCarta(){
        try {
            File archivoSonido = new File("src/main/resources/sounds/playcard.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(archivoSonido);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private String estiloBotonNormal() {
        return "-fx-background-color: #333333;" +
                "-fx-text-fill: gold;" +
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Georgia';" +
                "-fx-font-size: 22px;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-border-color: gold;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, gold, 10, 0.4, 0, 0);";
    }

    private String estiloBotonHover() {
        return "-fx-background-color: #555555;" +
                "-fx-text-fill: gold;" +
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Georgia';" +
                "-fx-font-size: 22px;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-border-color: gold;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, gold, 12, 0.6, 0, 0);";
    }
}

