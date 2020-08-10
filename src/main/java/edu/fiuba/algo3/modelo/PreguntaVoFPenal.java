package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVoFPenal extends PreguntaVoF {

    static public PreguntaVoFPenal crearPreguntaVerdadera() {
        PreguntaVoFPenal pregunta = new PreguntaVoFPenal();
        pregunta.setRespuestaVerdadera();
        return pregunta;
    }

    static public PreguntaVoFPenal crearPreguntaFalsa() {
        PreguntaVoFPenal pregunta = new PreguntaVoFPenal();
        pregunta.setRespuestaFalsa();
        return pregunta;
    }

    public void evaluarRespuestas(ArrayList<RespuestasJugador> respuestasVariosJugadores) {
        for (RespuestasJugador iterador: respuestasVariosJugadores) {
            iterador.evaluarRespuestasCon(new PuntuadorPenal());
        }
    }
}


