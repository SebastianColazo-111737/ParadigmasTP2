package edu.fiuba.algo3.modelo.Observer;

public interface Observable {
     void agregarObservador(Observador observador);
      void notificarObservadores();
}
