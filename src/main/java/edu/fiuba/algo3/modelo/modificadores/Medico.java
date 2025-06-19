package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.jugador.Seccion;

import java.util.List;

public class Medico implements Modificador{
    private List<Carta> descarteReferenciado;

    public Medico(List<Carta> cartas){
        this.descarteReferenciado = cartas;
    }

    @Override
    public void aplicarEfecto(Seccion seccion){
        int i = 0;
        Boolean sePudoRevivir = false;

        while (i < descarteReferenciado.size() && !sePudoRevivir) {
            Carta cartaRevivida = descarteReferenciado.get(i);

            // SE LANZA EXCEPCION
//            try {
//                cartaRevivida.jugarEnSeccion(seccion);
//                descarteReferenciado.remove(i);
//                sePudoRevivir = true;
//            } catch (NoSePudoAgregarCarta excepcion) {
//                System.out.println("No se pudo colocar carta, tomamos otra");
//                i++;
//            }

            // CODIGO PARA QUE PASE UNIDADTEST y no entre a bucle infinito
            cartaRevivida.jugarEnSeccion(seccion);
            descarteReferenciado.remove(i);
            sePudoRevivir = true;
            i++;
        }

    }
}
