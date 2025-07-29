package edu.fiuba.algo3.vista.controlador;


import javafx.animation.PauseTransition;
import javafx.util.Duration;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicJuego {

    private Clip clip;
    private boolean enLoop = false;

    public MusicJuego(String rutaArchivo){

        try {
            cargarAudio(rutaArchivo);
            reproducirConLoop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarAudio(String rutaArchivo)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (clip != null) {
            clip.close();
        }
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(rutaArchivo));
        clip = AudioSystem.getClip();
        clip.open(audioIn);

        FloatControl volumen = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volumen.setValue(-10.0f);

        enLoop = false;
    }

    public void reproducirConLoop() {
        if (clip != null && !clip.isRunning() && !enLoop) {
            enLoop = true;
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(event -> {
                clip.setFramePosition(0);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            });
            delay.play();
        }
    }
}
