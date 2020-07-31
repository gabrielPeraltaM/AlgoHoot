package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceClasicaTest {
    @Test
    public void TestCreacionPreguntaMCClasicaConDosRespuestasCorrectas(){
        PreguntaChoiceClasica pregunta1 = new PreguntaChoiceClasica(4);
        ArrayList <ListaRespuesta> listaRespuestasJugadores= new <ListaRespuesta>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Respuesta resp1 = new Respuesta();
        Respuesta resp2 = new Respuesta();
        Respuesta resp3 = new Respuesta();
        Respuesta resp4 = new Respuesta();

        pregunta1.agregarRespuestaCorrecta(resp1);
        pregunta1.agregarRespuestaCorrecta(resp3);

        assertEquals(2, pregunta1.cantidadRespuestasCorrectas());
    }

    @Test
    public void TestPreguntaMCClasicaSuma1ParaJugadorConTodasCorrectasY0ParaJugadorConUnaIncorrecta(){
        PreguntaChoiceClasica pregunta1 = new PreguntaChoiceClasica(4);
        ArrayList <ListaRespuesta> listaRespuestasJugadores= new <ListaRespuesta>ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Respuesta resp1 = new Respuesta();
        Respuesta resp2 = new Respuesta();
        Respuesta resp3 = new Respuesta();
        Respuesta resp4 = new Respuesta();

        pregunta1.agregarRespuestaCorrecta(resp1);
        pregunta1.agregarRespuestaCorrecta(resp3);

        ListaRespuesta listaRespuestasJugador1 = new ListaRespuesta(jugador1);
        listaRespuestasJugador1.agregarRespuesta(resp1);
        listaRespuestasJugador1.agregarRespuesta(resp2);
        listaRespuestasJugador1.agregarRespuesta(resp3);

        ListaRespuesta listaRespuestasJugador2 = new ListaRespuesta(jugador2);
        listaRespuestasJugador2.agregarRespuesta(resp1);
        listaRespuestasJugador2.agregarRespuesta(resp3);

        listaRespuestasJugadores.add( listaRespuestasJugador1);
        listaRespuestasJugadores.add( listaRespuestasJugador2);

        pregunta1.evaluarRespuesta(listaRespuestasJugadores);

        assertEquals(0, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }
}


