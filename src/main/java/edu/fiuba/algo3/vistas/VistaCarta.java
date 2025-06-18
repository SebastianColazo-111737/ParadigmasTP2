package edu.fiuba.algo3.vistas;

import javafx.scene.control.Button;
import java.util.function.Consumer;

public class VistaCarta extends Button {
    private final String nombre;

    public VistaCarta(String nombre, Consumer<VistaCarta> oneSeleccionar) {
        super(nombre);
        this.nombre = nombre;

        this.setPrefSize(45, 70);
        this.deseleccionar();
        this.setOnAction(e -> oneSeleccionar.accept(this));
    }

    public void seleccionar(){
        this.setStyle("-fx-background-color: white; -fx-border-color: red; -fx-border-width: 2; -fx-font-weight: bold;");
    }

    public void deseleccionar(){
        this.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 1; -fx-font-weight: bold;");
    }

    public String getNombre(){
        return nombre;
    }
}

