package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.ControladorTurnos;
import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.especiales.BuffCartas;
import edu.fiuba.algo3.modelo.cartas.especiales.Debuff;

public class EfectosEspecialesDispatcher {
    public static void aplicar(ICarta carta, IEfectoVisual vista, ControladorTurnos controlador, VistaSeccion seccion) {
        if (carta instanceof BuffCartas) {
            vista.activarBuff();
            controlador.registrarSeccionBuffeada(seccion);
        } else if (carta instanceof Debuff) {
            String nombre = carta.nombre().toLowerCase();
            if (nombre.equals("escarcha")) vista.activarDebuffEscarcha();
            else if (nombre.equals("lluvia")) vista.activarDebuffLluvia();
            else if (nombre.equals("tormeta")) vista.activarDebuffTormenta();

            controlador.registrarSeccionDebuffeada(seccion);
        }
    }
}
