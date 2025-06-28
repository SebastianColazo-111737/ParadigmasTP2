package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.vistas.Individuales.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class VistaColumnaIzquierda extends VBox {
    private final VistaDatos infoJugador1;
    private final VistaDatos infoJugador2;

    public VistaColumnaIzquierda(VistaAtril vistaAtril1, VistaAtril vistaAtril2, VistaTurnos vistaTurnos, VistaPuntosJugador puntosJ1, VistaPuntosJugador puntosJ2) {
        super(20);
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(20));
        this.setMaxWidth(180);

        this.infoJugador2 = new VistaDatos("Ogro", puntosJ2);
        this.infoJugador1 = new VistaDatos("Guerrero", puntosJ1);

        //VistaSeccionEspecial especiales = new VistaSeccionEspecial("Especiales");

        this.getChildren().addAll(vistaTurnos,infoJugador2, /*especiales,*/ infoJugador1,crearGuiaModificadores());
    }
    public VistaPuntosJugador getPuntosJugador1(){
        return infoJugador1.getVistaPuntosJugador();
    }
    public VistaPuntosJugador getPuntosJugador2(){
        return infoJugador2.getVistaPuntosJugador();
    }

    private VBox crearGuiaModificadores() {
        Label titulo = new Label("Guía Modificadores:");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label significados = new Label(
                "➀ Medico\n" +
                        "②Legendaria\n" +
                        "③ Carta Unida\n" +
                        "④︎ Morale Boost\n" +
                        "⑤ Agil\n" +
                        "⑥ Espia"
        );
        significados.setFont(Font.font("Arial", 18));
        significados.setWrapText(true);
        significados.setTextAlignment(TextAlignment.LEFT);

        VBox infoEmojis = new VBox(5, titulo, significados);
        infoEmojis.setPadding(new Insets(10));
        infoEmojis.setStyle("-fx-background-color: lightgray; -fx-border-color: black;");
        infoEmojis.setMaxWidth(160);

        return infoEmojis;
    }
}