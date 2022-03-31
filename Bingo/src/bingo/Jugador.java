/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alvar
 */
public class Jugador {
    
    private String name;
    private int puntos;
    private ArrayList<Carton> cartones;
    
    public Jugador(String name){
        this.name = name;
        puntos = 0;
        cartones = new ArrayList<Carton>();
    }
    
    public void asignarCartones(int numCartones){
        for(int i=0; i<numCartones; i++){
            cartones.add(new Carton());
        }
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getPuntos(){
        return this.puntos;
    }
    
}
