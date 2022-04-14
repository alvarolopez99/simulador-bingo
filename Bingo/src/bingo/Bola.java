/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingo;

/**
 *
 * @author alvar
 */
public class Bola {
    private int numero;
    
    
    public Bola(int numero){
        this.numero = numero;
    }
    
    public Bola(){

    }
    
    public String toString(){
        return "[" + numero + "] ";
    }
    
    public int getNumero(){
        return this.numero;
    }
}
