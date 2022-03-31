/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bingo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
        Configuracion configuracion = new Configuracion();
        TandaPartidas tandaPartidas = new TandaPartidas();
        
        /* Creamos la tanda de partidas y preguntamos cuantas partidas tiene la tanda */
        System.out.print("¿Cuantas partidas quieres jugar?: ");
        int numPartidas = entrada.nextInt();
        while(numPartidas < 1) numPartidas = entrada.nextInt();
        configuracion.setNumPartidas(numPartidas);
        //tandaPartidas.añadirPartidas(numPartidas);
        /*****************************************************************************/
        
        /* Pregunta cuantos jugadores quieres en la partida y crea esos jugadores */
        ArrayList<Jugador> jugadores = new ArrayList<>();
        System.out.print("¿Cuantos jugadores quieres que haya en la partida?: ");
        int numJugadores = entrada.nextInt();
        while(numJugadores < 1) numJugadores = entrada.nextInt();
        configuracion.setNumJugadores(numJugadores);
        for(int i=0; i<numJugadores; i++){
            System.out.print("Introduce el nombre del jugador " + (i+1) + ": ");
            String nombre = entrada.nextLine();
            jugadores.add(new Jugador(nombre));
        }
        /*****************************************************************************/
        
        /* Pregunta cuantos cartones se quieren generar para cada jugador */
        System.out.print("¿Cuantos cartones quieres generar para cada jugador?: ");
        int numCartones = entrada.nextInt();
        while(numCartones < 1) numCartones = entrada.nextInt();
        configuracion.setNumCartonesPorJugador(numCartones);
        for(int i = 0; i<jugadores.size(); i++){
            jugadores.get(i).asignarCartones(numCartones);
        }
        tandaPartidas.añadirJugadores(jugadores);
        /*****************************************************************************/
        
        /* Pregunta cuantos puntos se otorgan por cada linea y bingo */
        System.out.print("¿Cuantos puntos se obtienen al cantar linea?: ");
        int puntosLinea = entrada.nextInt();
        while(puntosLinea < 1) puntosLinea = entrada.nextInt();
        configuracion.setPuntosLinea(puntosLinea);
        System.out.print("¿Cuantos puntos se obtienen al cantar bingo?: ");
        int puntosBingo = entrada.nextInt();
        while(puntosBingo < configuracion.getPuntosLinea()) puntosLinea = entrada.nextInt();
        configuracion.setPuntosBingo(puntosBingo);
        /*****************************************************************************/
        
        System.out.println("La configuracion de las partidas es la siguiente: ");
        System.out.println("Se jugaran " + configuracion.getNumPartidas() + " partidas");
        System.out.println("Jugaran " + configuracion.getNumJugadores() + " jugadores");
        System.out.println("Cada jugador dispone de " + configuracion.getNumCartonesPorJugador() + " cartones");
        System.out.println("Si alguien canta linea se le otorgaran " + configuracion.getPuntosLinea() + " puntos");
        System.out.println("Si alguien canta bingo se le otorgaran " + configuracion.getPuntosBingo() + " puntos");
        
        
        
        //Set<BolaAparecida> bAparecidas = new HashSet<>();
        /*Bombo b = new Bombo();
        System.out.println(b.toString());
        for(int i = 0; i<5; i++){
            BolaAparecida bola = b.sacarNumero();
            //bAparecidas.add(bola);
            System.out.println(bola.toString());
            System.out.println(b.toString());
        }
        //Cuando se cante linea se comprueba que la linea entera esté contenida en bAparecidas
        */
        
        
    }
    
}
