/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author alvar
 */
public class Carton {
    private ArrayList<Integer> carton;
    
    public Carton(){
        carton = new ArrayList();
        generarCarton();
    }
    
    public void generarCarton(){
        //int[] linea = new int[9]; 
        //ArrayList numerosInsertar = new ArrayList();
        for(int i=0; i<3; i++){
            Linea l = new Linea();
            //ArrayList posicionesHuecos = new ArrayList();
            while(l.getPosHuecos().size() < 4){
                int huecoGenerado = (int)(Math.random()*9);
                if(!l.getPosHuecos().contains(huecoGenerado)){
                    l.añadirHueco(huecoGenerado);
                }
            }
            for(int j=0; j<9; j++){
                if(l.getPosHuecos().contains(j)){
                    l.getLinea().set(j, 0);
                } else {
                    int numeroGenerado = (int)(Math.random()*89+1);
                    while(l.getNumeros().contains(numeroGenerado)){
                        numeroGenerado = (int)(Math.random()*89+1);                   
                    }
                    l.añadirNumero(numeroGenerado);
                    l.añadirALinea(j, numeroGenerado);
                }
            }
            for(int k=0; k<l.getLinea().size(); k++){
                carton.add((int)l.getLinea().get(k));
            }
        }
    }
    
    public String toString(){
        String cadena = "|----|----|----|----|----|----|----|----|----|\n";
        for(int i = 0; i < carton.size(); i++){
            if(carton.get(i) < 10){
                if(carton.get(i) == 0) cadena += "|    ";
                else cadena += "|  " + carton.get(i) + " ";
            }
            else  cadena += "| " + carton.get(i) + " ";
            if(i == 8 || i == 17 || i == 26){
                cadena += "|\n|----|----|----|----|----|----|----|----|----|\n";
            }
        }
        cadena += "\n";
        return cadena;
    }   
}

