package edu.fiuba.algo3.vistas.Contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import edu.fiuba.algo3.vistas.Contenedores.VistaDatos;
import edu.fiuba.algo3.vistas.Individuales.VistaSeccionEspecial;

public class VistaColumnaIzquierda extends VBox{

    public VistaColumnaIzquierda(){
        super(20);

        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(20));
        this.setMaxWidth(180);

        VistaSeccionEspecial especiales = new VistaSeccionEspecial("Especiales");
        VistaDatos infoJugador2 = new VistaDatos("DatosJugador2");
        VistaDatos infoJugador1 = new VistaDatos("DatosJugador1");

        this.getChildren().addAll(infoJugador2,especiales,infoJugador1);
    }
}
