/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingo;

/**
 *
 * @author alvar
 */
public class Configuracion {
    private int numJugadores;
    private int numPartidas;
    private int numCartonesPorJugador;
    private int puntosLinea;
    private int puntosBingo;
    
    public Configuracion(){
        numJugadores = 0;
        numPartidas = 0;
        numCartonesPorJugador = 0;
        puntosLinea = 0;
        puntosBingo = 0;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public int getNumPartidas() {
        return numPartidas;
    }

    public int getNumCartonesPorJugador() {
        return numCartonesPorJugador;
    }

    public int getPuntosLinea() {
        return puntosLinea;
    }

    public int getPuntosBingo() {
        return puntosBingo;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public void setNumPartidas(int numPartidas) {
        this.numPartidas = numPartidas;
    }

    public void setNumCartonesPorJugador(int numCartonesPorJugador) {
        this.numCartonesPorJugador = numCartonesPorJugador;
    }

    public void setPuntosLinea(int puntosLinea) {
        this.puntosLinea = puntosLinea;
    }

    public void setPuntosBingo(int puntosBingo) {
        this.puntosBingo = puntosBingo;
    }
    
    
}
