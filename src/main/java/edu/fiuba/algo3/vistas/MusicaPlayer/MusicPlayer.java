package edu.fiuba.algo3.vistas.MusicaPlayer;

import javax.sound.sampled.*;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {

  private Clip clip;
  private boolean enLoop = false;

  public void cargarAudio(String rutaArchivo)
      throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    if (clip != null) {
      clip.close();
    }
    AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(rutaArchivo));
    clip = AudioSystem.getClip();
    clip.open(audioIn);
    enLoop = false;
  }

  public void reproducir() {
    if (clip != null) {
      if (clip.isRunning()) {
        clip.stop();
      }
      clip.setFramePosition(0);
      clip.start();
      enLoop = false;
    }
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

  public void detener() {
    if (clip != null && clip.isRunning()) {
      clip.stop();
      enLoop = false;
    }
  }

  public void cerrar() {
    if (clip != null) {
      clip.close();
      enLoop = false;
    }
  }
}
