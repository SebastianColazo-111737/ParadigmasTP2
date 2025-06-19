package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.utilidades.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        AnchorPane menu_principal = FXMLLoader.load(getClass().getResource(Paths.MENU_PRINCIPAL));
        Scene scene = new Scene(menu_principal);
        stage.setScene(scene);
//        var javaVersion = SystemInfo.javaVersion();
//        var javafxVersion = SystemInfo.javafxVersion();
//
//        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        var scene = new Scene(new StackPane(label), 640, 480);
//        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}