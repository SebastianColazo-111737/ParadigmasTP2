package edu.fiuba.algo3.vistas;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class VistaMano extends HBox {

    public VistaMano(){
        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);

        for(int i = 1; i <= 10; i++){
            this.getChildren().add(new VistaCarta("C"+i));
        }
    }
}

