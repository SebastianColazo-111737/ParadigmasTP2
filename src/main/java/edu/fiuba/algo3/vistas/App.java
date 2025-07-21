package edu.fiuba.algo3.vistas;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import edu.fiuba.algo3.Controller.GameController;
import edu.fiuba.algo3.vistas.Escenas.*;

public class App extends Application {

  private Stage primaryStage;
  private double screenWidth;
  private double screenHeight;

  @Override
  public void start(Stage stage) {
    this.primaryStage = stage;

    Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    screenWidth = screenBounds.getWidth();
    screenHeight = screenBounds.getHeight();

    stage.setTitle("Mi Juego JavaFX");
    // Mostrar menú con el tamaño de pantalla
    mostrarMenu();

    stage.setWidth(screenWidth);
    stage.setHeight(screenHeight);
    stage.show();
  }

  public void mostrarJuego() {
    GameController gameController = new GameController();
    GameVista gameScene = new GameVista(this, gameController);
    primaryStage.setScene(gameScene.getScene());
    primaryStage.setWidth(screenWidth);
    primaryStage.setHeight(screenHeight);
  }

  public void mostrarMenu() {
    Menu menuScene = new Menu(this);
    primaryStage.setScene(menuScene.getScene());
    primaryStage.setWidth(screenWidth);
    primaryStage.setHeight(screenHeight);
  }

  public double getAncho() {
    return this.screenWidth;
  }

  public double getAlto() {
    return this.screenHeight;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
