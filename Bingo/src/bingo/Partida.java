/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingo;

import java.util.ArrayList;

/**
 *
 * @author alvar
 */
public class Partida {
    private ArrayList<Ronda> listaRondas;
    private ArrayList<Jugador> listaJugadores;
    
    public Partida(){
        
        listaRondas = new ArrayList<>();
        listaJugadores = new ArrayList<>();
        
        Configuracion conf = new Configuracion();
        // JUGADORES
        // CONFIGURACION

    }
    
    public void anadirRondas(int numero){
        for(int i=0; i<numero; i++){
            listaRondas.add(new Ronda());
        }
    }
    
    public void anadirJugadores(ArrayList<Jugador> j){
        listaJugadores = j;
    }
    
    
    public ArrayList<Jugador> getJugadores(){
        
        return listaJugadores;
    }

    public ArrayList<Ronda> getListaRondas() {
        return listaRondas;
    }
    
}
