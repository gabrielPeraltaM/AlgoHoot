package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface Evaluador {
    void evaluar(ArrayList<Respuesta> respuestas, Jugador jugador);
    int evaluar(ArrayList<Integer> respuestasJugador, ArrayList<Respuesta> respuestas);
}
