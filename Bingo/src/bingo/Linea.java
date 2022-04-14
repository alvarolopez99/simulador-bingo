package bingo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author alvar
 */

public class Linea {
    
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    
    //ArrayList<Integer> posHuecos;
    //ArrayList<Integer> numeros;
    //ArrayList<Integer> linea;
    
    Set<Integer> ConjuntoNumerosLinea;
    Queue<Integer> NumerosTachadosLinea;
    
    int Posiciones[] = new int[9];

     
    public Linea(){
        
        int Posiciones[] = new int[9];
        
        ConjuntoNumerosLinea = new HashSet<Integer>();
        NumerosTachadosLinea = new LinkedList<Integer>();
        
        
        /*posHuecos = new ArrayList();
        numeros = new ArrayList();
        linea = new ArrayList();
        for(int i=0; i<9; i++){
            linea.add(0);*/
        }
    
    
    // Determinar las posiciones en las que habrá un número y en las que habrá un hueco

    public Linea GenerarPosicionesSuperiores(Linea LineaArriba) {

        int NumeroAleatorio;
        int PosicionesRestantes;
        int PosicionesPorAsignar = 5;
        int ContadorPosicionesAsignadas = 0;
        int MaximoPosiciones = 5;

        for (int i = 0; i < LineaArriba.Posiciones.length; i++) {

            NumeroAleatorio = (int) (Math.random() * 10);
            PosicionesRestantes = 9 - i;

            if (PosicionesRestantes == PosicionesPorAsignar) {
                LineaArriba.Posiciones[i] = 1;
                ContadorPosicionesAsignadas++;
                PosicionesPorAsignar--;

            } else {

                if (NumeroAleatorio < 5) {

                    LineaArriba.Posiciones[i] = 0;

                } else {

                    if (MaximoPosiciones != ContadorPosicionesAsignadas) {

                        LineaArriba.Posiciones[i] = 1;
                        ContadorPosicionesAsignadas++;
                        PosicionesPorAsignar--;

                    }

                }

            }

        }

        return LineaArriba;
    }
    
    
    
     public Linea GenerarPosicionesMedias(Linea LineaMedio) {
     
        int NumeroAleatorio;
        int PosicionesRestantes;
        int PosicionesPorAsignar = 5;
        int ContadorPosicionesAsignadas = 0;
        int MaximoPosiciones = 5;
     
      for (int i=0; i<LineaMedio.Posiciones.length; i++){
          
            NumeroAleatorio = (int) (Math.random()*10);
            PosicionesRestantes = 9 - i;
                    
            if (PosicionesRestantes == PosicionesPorAsignar){
                 LineaMedio.Posiciones[i] = 1;
                 ContadorPosicionesAsignadas++;
                 PosicionesPorAsignar--;
                
            } else {
            
                    if (NumeroAleatorio < 5){
  
                    LineaMedio.Posiciones[i] = 0;
                
                    } else {
                        if(MaximoPosiciones != ContadorPosicionesAsignadas){
                        LineaMedio.Posiciones[i] = 1;
                        ContadorPosicionesAsignadas++;
                        PosicionesPorAsignar--;
                        }
               
                    }

            }
               
        }
    
        int restUltimaFila = 5;
      
     
     
     
     return LineaMedio;
     
     }
    

    // Determina en que posiciones de una linea inferior de un carton tienen numero o hueco
    // en funcion de las lineas superiores a ella (lineas 1 y 2 de un carton de 3 lineas)
     
     // ***** REVISAR ALEATORIEDAD *****
    
    public Linea GenerarPosicionesInferiores(Linea LineaArriba, Linea LineaMedio, Linea LineaAbajo) {

        int PosicionesRestantes = 5;

        for (int i = 0; i < LineaMedio.Posiciones.length; i++) {

            if (LineaArriba.Posiciones[i] == 0 && LineaMedio.Posiciones[i] == 0) {

                LineaAbajo.Posiciones[i] = 1;
                PosicionesRestantes--;

            }

        }

        for (int i = 0; i < LineaAbajo.Posiciones.length; i++) {

            if (LineaArriba.Posiciones[i] != LineaMedio.Posiciones[i] && PosicionesRestantes != 0) {

                LineaAbajo.Posiciones[i] = 1;
                PosicionesRestantes--;

            }

        }

        return LineaAbajo;

    }

    
    
    // Asignación de numeros a una linea
    
    
    public Linea AsignarNumerosLineaArriba(Linea LineaArriba) {

        int sup = 3;
        int inf = 1;

        for (int i = 0; i < 9; i++) {

            if (LineaArriba.Posiciones[i] == 1) {

                LineaArriba.Posiciones[i] = (int) (Math.random() * (sup - inf + 1)) + inf;
                ConjuntoNumerosLinea.add( LineaArriba.Posiciones[i]);
                
            }

            sup = sup + 10;
            inf = sup - 3 + 1;

        }

        return LineaArriba;
    }

    public Linea AsignarNumerosLineaMedio(Linea LineaMedio) {

        int sup = 6;
        int inf = 4;

        for (int i = 0; i < 9; i++) {

            if (LineaMedio.Posiciones[i] == 1) {

                LineaMedio.Posiciones[i] = (int) (Math.random() * (sup - inf + 1)) + inf;
                ConjuntoNumerosLinea.add(LineaMedio.Posiciones[i]);
            }

            sup = sup + 10;
            inf = sup - 3 + 1;

        }

        return LineaMedio;
    }

    public Linea AsignarNumerosLineaAbajo(Linea LineaAbajo) {

        int sup = 0;
        int inf;

        for (int i = 0; i < 9; i++) {

            sup = sup + 10;
            inf = sup - 3;

            if (LineaAbajo.Posiciones[i] == 1) {

                LineaAbajo.Posiciones[i] = (int) Math.floor(Math.random() * (sup - inf + 1)) + inf;
                ConjuntoNumerosLinea.add(LineaAbajo.Posiciones[i]);
            }

        }

        return LineaAbajo;
    }

    
    public boolean ComprobarLinea() {

        boolean LineaTachada = false;

        if (ConjuntoNumerosLinea.isEmpty()) {

            LineaTachada = true;
        }

        return LineaTachada;
    }


    public boolean TacharNumero(int Numero) {

        boolean NumeroTachado = false;
        if (ConjuntoNumerosLinea.contains(Numero)) {
            ConjuntoNumerosLinea.remove(Numero);
            NumerosTachadosLinea.add(Numero);
            NumeroTachado = true;
        }

        return NumeroTachado;

    }
    
    public String PintarSecuenciaLinea() {

        String SecuenciaLinea = "";

        Iterator<Integer> it = NumerosTachadosLinea.iterator();

        while (it.hasNext()) {
            SecuenciaLinea = SecuenciaLinea + it.next();
            if (it.hasNext()) {
                SecuenciaLinea = SecuenciaLinea + ", ";
            }

        }
        
        return SecuenciaLinea;
    }

    
    
    
    //System.out.println(ANSI_RED + "Texto de color rojo" + ANSI_RESET);

    
    public void PintarLinea (Linea Linea){

        System.out.println("-----------------------------------------------------------------------------------------");
       
        for (int i = 0; i < Linea.Posiciones.length; i++) {

            if (NumerosTachadosLinea.contains(Linea.Posiciones[i])) {
                if (Linea.Posiciones[i] > 9) {

                    System.out.print(" | ");
                    System.out.print(" " + ANSI_RED + Linea.Posiciones[i] + ANSI_RESET + " ");
                    System.out.print(" | ");

                } else if (Linea.Posiciones[i] <= 9 && Linea.Posiciones[i] > 0) {

                    System.out.print(" |  ");
                    System.out.print(" " + ANSI_RED + Linea.Posiciones[i] + ANSI_RESET + " ");
                    System.out.print(" | ");

                } else {

                    System.out.print(" |");
                    System.out.print("      ");
                    System.out.print("| ");
                    
                }

            } else {
                
                 if (Linea.Posiciones[i] > 9) {

                    System.out.print(" | ");
                    System.out.print(" " + Linea.Posiciones[i] + " ");
                    System.out.print(" | ");

                } else if (Linea.Posiciones[i] <= 9 && Linea.Posiciones[i] > 0) {

                    System.out.print(" |  ");
                    System.out.print(" " + Linea.Posiciones[i] + " ");
                    System.out.print(" | ");

                } else {

                    System.out.print(" |");
                    System.out.print("      ");
                    System.out.print("| ");

                }
                
            }
        }

        System.out.print("\n");
    
    }

    
    
    
    

}





    /*
    public ArrayList getPosHuecos() {
        return posHuecos;
    }

    public ArrayList getNumeros() {
        return numeros;
    }

    public ArrayList getLinea() {
        return linea;
    }
    
    public void añadirHueco(int pos){
        posHuecos.add(pos);
    }
    
    public void añadirNumero(int numero){
        numeros.add(numero);
    }
    
    public void añadirALinea(int pos, int valor){
        linea.set(pos, valor);
    }

}

*/
