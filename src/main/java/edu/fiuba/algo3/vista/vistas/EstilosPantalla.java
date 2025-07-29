package edu.fiuba.algo3.vista.vistas;

public class EstilosPantalla {

    public static String botonEstiloNormal() {
        return "-fx-background-color: #333333;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Georgia';" +
                "-fx-font-size: 24px;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-border-color: gold;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, black, 10, 0.5, 0, 2);";
    }

    public static String botonEstiloHover() {
        return "-fx-background-color: #555555;" +
                "-fx-text-fill: gold;" +
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Georgia';" +
                "-fx-font-size: 24px;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-border-color: gold;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, gold, 12, 0.6, 0, 0);";
    }


    public static String estiloInput() {
        return "-fx-background-color: #333333;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 18px;" +
                "-fx-font-family: 'Georgia';" +
                "-fx-border-color: gold;" +
                "-fx-border-width: 2px;" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 8 10 8 10;";
    }
}
