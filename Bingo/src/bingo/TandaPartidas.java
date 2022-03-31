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
public class TandaPartidas {
    private ArrayList<Partida> listaPartidas;
    private ArrayList<Jugador> listaJugadores;
    
    public TandaPartidas(){
        listaPartidas = new ArrayList<>();
        listaJugadores = new ArrayList<>();
    }
    
    public void añadirPartidas(int numero){
        for(int i=0; i<numero; i++){
            listaPartidas.add(new Partida());
        }
    }
    
    public void añadirJugadores(ArrayList<Jugador> j){
        listaJugadores = j;
    }
}
