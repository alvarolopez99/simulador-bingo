/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bingo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    
    public static void main(String[] args) {
        
        // Sistema de E/S
        Scanner entrada = new Scanner(System.in);
        
        // Variables
        
        Configuracion configuracion = new Configuracion();
        Partida Partida = new Partida();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Bombo Bombo = new Bombo();
        Ronda Ronda;
        
        int numRondas;
        int numJugadores;
        int numCartones;
        int NumeroAparecido = 0;
        
        boolean SeTachaNumero = false;
        boolean LineaCantada = false;
        boolean BingoCantado = false;
        boolean GanadorRonda = false;
        
        
        
        
        
        
        /* Creamos la partida y preguntamos cuantas rondas tiene la partida */
        
        System.out.println("¡Bienvenid@ al bingo!");
        System.out.println("¿Cuantas rondas quieres jugar?: ");
        numRondas =  Integer.parseInt(entrada.nextLine());
        
        while(numRondas < 1) numRondas = entrada.nextInt();
        configuracion.setNumPartidas(numRondas);
        
        //tandaPartidas.añadirPartidas(numPartidas);
        /*****************************************************************************/
        
        
        /* Pregunta cuantos jugadores quieres en la partida y crea esos jugadores */
        
        System.out.println("¿Cuantos jugadores quieres que haya en la partida?: ");
        numJugadores =  Integer.parseInt(entrada.nextLine());
        while(numJugadores < 2 || numJugadores > 4) numJugadores = entrada.nextInt();
        
        configuracion.setNumJugadores(numJugadores);
        
        for(int i=0; i<numJugadores; i++){
            
            System.out.println("Introduce el nombre del jugador " + (i+1) + ": ");
            String nombre = entrada.nextLine();
            jugadores.add(new Jugador(nombre));
        }
        
        Partida.anadirJugadores(jugadores);
        Partida.anadirRondas(numRondas);
        /* Pregunta cuantos cartones se quieren generar para cada jugador */
       
        System.out.println("¿Cuantos cartones quieres generar para cada jugador?: ");
        numCartones = entrada.nextInt();

        while(numCartones < 1) numCartones = entrada.nextInt();
        configuracion.setNumCartonesPorJugador(numCartones);
        
        /*****************************************************************************/
        
        /* Pregunta cuantos puntos se otorgan por cada linea y bingo */
        
        System.out.println("¿Cuantos puntos se obtienen al cantar linea?: ");
        int puntosLinea = entrada.nextInt();
        while(puntosLinea < 1) puntosLinea = entrada.nextInt();
        configuracion.setPuntosLinea(puntosLinea);
        
        System.out.println("¿Cuantos puntos se obtienen al cantar bingo?: ");
        int puntosBingo = entrada.nextInt();
        while(puntosBingo < configuracion.getPuntosLinea()) puntosLinea = entrada.nextInt();
        configuracion.setPuntosBingo(puntosBingo);
        
        /*****************************************************************************/
        
        System.out.println("La configuracion de las partidas es la siguiente: ");
        System.out.println("Se jugará una partida con " + configuracion.getNumPartidas() + " rondas");
        System.out.println("Jugaran " + configuracion.getNumJugadores() + " jugadores");
        System.out.println("Cada jugador dispone de " + configuracion.getNumCartonesPorJugador() + " cartones");
        System.out.println("Si alguien canta linea se le otorgaran " + configuracion.getPuntosLinea() + " puntos");
        System.out.println("Si alguien canta bingo se le otorgaran " + configuracion.getPuntosBingo() + " puntos");
        
        System.out.println("Si alguien canta bingo se le otorgaran " + configuracion.getPuntosBingo() + " puntos");
        
        
        
        
        Bola BolaAparecida = new Bola();

        System.out.println("Comienza la partida");

        
        int ContadorBolasAparecidas = 0;        
        
        for (int i = 0; i < numRondas; i++) {

            //NUEVA RONDA
            System.out.println("\n");
            System.out.println("Ronda " + (i + 1));
            
            Ronda = Partida.getListaRondas().get(i);
            Bombo = Ronda.getBombo();
            
            //Bombo.inicializarBombo();

            //REINICIAR TODO
            //Asignacion nuevos cartones
            for (int k = 0; k < Partida.getJugadores().size(); k++) {
                Partida.getJugadores().get(k).asignarCartonesNuevos(numCartones); // Por cada jugador se asigna el numero correspondiente de cartones
            }
            // Linea y bingo no estan cantados

            LineaCantada = false;
            BingoCantado = false;
            ContadorBolasAparecidas = 0;
            while (!BingoCantado) {

                BolaAparecida = Bombo.sacarNumero();
                Partida.getListaRondas().get(i).AnadirBolaAparecida(BolaAparecida);
                
                ContadorBolasAparecidas++;
                
                
                
                System.out.println("\n");
                System.out.println("Bola número: " + BolaAparecida.toString());
                
                System.out.println("\n");
                System.out.println("Hasta el momento han aparecido " +  ContadorBolasAparecidas + " bolas que son las siguientes:" + Ronda.toStringBolasAparecidas()) ;

                
                
                System.out.println();
                
                NumeroAparecido = BolaAparecida.getNumero();

                //Actualizar lista bolas aparecidas
                for (int j = 0; j < Partida.getJugadores().size(); j++) {

                    if (!BingoCantado) {

                        Jugador jugador =  Partida.getJugadores().get(j);

                        System.out.println("El jugador " + jugador.getName() + " va a comprobar el número " + NumeroAparecido + " este es su cartón: ");

                        jugador.MostrarCartones();

                        SeTachaNumero = jugador.TacharNumero(NumeroAparecido);

                        if (SeTachaNumero) {

                            System.out.println("\n");
                            System.out.println("El jugador " + jugador.getName() + " tacha el número " + NumeroAparecido + " este es su cartón: ");
                            jugador.MostrarCartones();

                            System.out.println("\n");
                            System.out.println("------------------");
                            System.out.println("| NUMERO TACHADO |");
                            System.out.println("------------------");
                            System.out.println("\n");
                        }

                        
                        String[] ComprobacionLinea = new String[2];
                        ComprobacionLinea = jugador.ComprobarLinea();
                        boolean HayLinea = Boolean.parseBoolean(ComprobacionLinea[0]);
                        
                        if (HayLinea && LineaCantada == false) {

                            System.out.println("\n");
                            System.out.println("-----------------");
                            System.out.println("|  CANTO LINEA  |");
                            System.out.println("-----------------");
                            System.out.println("\n");
                            System.out.println("El jugador " + jugador.getName() + " suma " + configuracion.getPuntosLinea() + " puntos");
                            System.out.println("\n");
                            System.out.println("SECUENCIA DE BOLAS DE LA LINEA: " + ComprobacionLinea[1]);
                            
                            
                            
                            //Sumar puntos al jugador j
                            
                            jugador.setPuntos(configuracion.getPuntosLinea()+jugador.getPuntos());
           
                            LineaCantada = true;

                        }
                        
                         String[] ComprobacionBingo = new String[2];
                         ComprobacionBingo = jugador.ComprobarCarton();
                         boolean Bingo = Boolean.parseBoolean(ComprobacionBingo[0]);
                         
                        if (Bingo  && LineaCantada == true) {

                            System.out.println("-----------------");
                            System.out.println("|  ¡¡¡BINGO!!!  |");
                            System.out.println("-----------------");
                            System.out.println("\n");
                            System.out.println("El jugador " + jugador.getName() + " suma:" + configuracion.getPuntosBingo() + " puntos");
                            System.out.println("Secuencia del cartón ganador: " + ComprobacionBingo[1]);
                                      
                            jugador.setPuntos(configuracion.getPuntosBingo()+jugador.getPuntos());
                            
                            BingoCantado = true;

                        }

                    }

                    //REVISAR CARTON 
                    //CANTAR O NO BINGO / LINEA
                }

            }
            
            System.out.println("\n");
            System.out.println("Fin de la ronda " + (i+1));
            System.out.println("Resumen de las puntuaciones: ");
            for (int k = 0; k < Partida.getJugadores().size(); k++) {
                
                System.out.println("Puntuacion acumulada del jugador " + Partida.getJugadores().get(k).getName() + ": " +Partida.getJugadores().get(k).getPuntos() + " puntos ");
                
            }
  
        }
        
        
        // Despues de terminar todas las rondas se imprime el ganador
      
        
   
        Map<Integer, ArrayList<String>> map = new HashMap<Integer,  ArrayList<String>>();

      
        ArrayList<String> ListaPorPuntuacion;
        Jugador jugador = new Jugador();
        
        int PuntuacionMaxima = 0;
        
        for (int k = 0; k < Partida.getJugadores().size(); k++) {

            
            if (PuntuacionMaxima < Partida.getJugadores().get(k).getPuntos()){
            
            PuntuacionMaxima = Partida.getJugadores().get(k).getPuntos();
            }
            
            if (map.get(Partida.getJugadores().get(k).getPuntos()) != null)  {
                ListaPorPuntuacion = map.get(Partida.getJugadores().get(k).getPuntos());
            } else
            {
            ListaPorPuntuacion = new ArrayList<String>();
            }
            
            ListaPorPuntuacion.add(Partida.getJugadores().get(k).getName());
            
            map.put(Partida.getJugadores().get(k).getPuntos(),ListaPorPuntuacion);
            
        }
        
        ListaPorPuntuacion = map.get(PuntuacionMaxima);
        
        
        
        System.out.println("El ganador es " + ListaPorPuntuacion + " con un total de " + PuntuacionMaxima + " puntos ");
        
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
