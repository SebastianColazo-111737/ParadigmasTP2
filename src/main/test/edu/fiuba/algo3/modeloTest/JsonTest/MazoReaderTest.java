package edu.fiuba.algo3.modeloTest.JsonTest;

import edu.fiuba.algo3.Repositorio.MazoParser;
import edu.fiuba.algo3.modelo.jugador.Mazo;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MazoReaderTest {

  private Mazo mazo;

  @BeforeEach
  void setUp() throws Exception {
    JSONParser parser = new JSONParser();
    JSONObject root = (JSONObject) parser.parse(new FileReader("src/test/resources/json/gwent3.json"));

    JSONObject mazoJson = (JSONObject) root.get("mazo_jugador_uno");

    mazo = MazoParser.desdeJson(mazoJson);
  }

  @Test
  public void elMazoTieneLaCantidadCorrectaDeCartas() {
    assertEquals(21, mazo.getCantidadCartas()); // 15 unidades + 6 especiales
  }
}
