/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bingo;

import java.util.Scanner;

/**
 *
 * @author alvar
 */
public class Bingo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("¿Cuantos cartones quieres generar para cada jugador?: ");
        int numCartones = entrada.nextInt();
        while(numCartones < 1) numCartones = entrada.nextInt();
        for(int i=0; i<numCartones; i++){
            System.out.println(new Carton().toString());
        }
        
        
    }
    
}
