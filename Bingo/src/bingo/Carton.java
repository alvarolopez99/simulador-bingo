/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author alvar
 */
public class Carton {
    
    //private ArrayList<Integer> carton;
    
    Linea LineaArriba = new Linea();
    Linea LineaMedio = new Linea();
    Linea LineaAbajo = new Linea();

    
    
    Queue<Integer> NumerosTachadosCarton = new LinkedList<Integer>();
    
    public Carton(){
        
        // Introducir metodos para generar las lineas
        
        //Linea LineaArriba = new Linea();
        //Linea LineaMedio = new Linea();
        //Linea LineaAbajo = new Linea();
        //carton = new ArrayList();
        //generarCarton();
        GenerarCarton();
        PintarCarton();
    }
    
    
    
    
    public String[] RevisarLineas(){
        
        //boolean HayLinea = false;
        
        //HayLinea = (LineaArriba.ComprobarLinea(LineaArriba) || LineaMedio.ComprobarLinea(LineaMedio) || LineaAbajo.ComprobarLinea(LineaAbajo));
        
        String[] ComprobacionLinea = new String[2];
        
        boolean HayLinea1 = false;
        boolean HayLinea2 = false;
        boolean HayLinea3 = false;

        HayLinea1 = LineaArriba.ComprobarLinea();
        HayLinea2 = LineaMedio.ComprobarLinea();
        HayLinea3 = LineaAbajo.ComprobarLinea();
        
        ComprobacionLinea[0] = String.valueOf(HayLinea1 || HayLinea2 || HayLinea3);
        
        if(HayLinea1){
         ComprobacionLinea[1] = LineaArriba.PintarSecuenciaLinea();
        }
        
        if(HayLinea2){
         ComprobacionLinea[1] = LineaMedio.PintarSecuenciaLinea();
        }
        
        if(HayLinea3){
         ComprobacionLinea[1] = LineaAbajo.PintarSecuenciaLinea();
        }
        
        
        return ComprobacionLinea;
    }
    
    public String[] RevisarCarton() {
        
        String[] array = new String[2];
        
        boolean HayLinea1 = false;
        boolean HayLinea2 = false;
        boolean HayLinea3 = false;

        boolean HayBingo = false;

        HayLinea1 = LineaArriba.ComprobarLinea();
        HayLinea2 = LineaMedio.ComprobarLinea();
        HayLinea3 = LineaAbajo.ComprobarLinea();
        
        array[0] = String.valueOf(HayLinea1 && HayLinea2 && HayLinea3);
        
        if (HayLinea1 && HayLinea2 && HayLinea3) {

            array[0] = String.valueOf(HayLinea1 && HayLinea2 && HayLinea3);
            array[1] = PintarSecuenciaBingo();
 
        }

        //return (HayLinea1 && HayLinea2 && HayLinea3);
        return array;
    }

    public boolean TacharNumero(int Numero) {

        boolean NumeroTachado = false;

        NumeroTachado = (LineaArriba.TacharNumero(Numero) || LineaMedio.TacharNumero(Numero) || LineaAbajo.TacharNumero(Numero));

        if (NumeroTachado) {
            NumerosTachadosCarton.add(Numero);
        }

        return NumeroTachado;

    }
    
    public String ObtenerSecuenciaLinea(){
    
    return "";
    }
    
    public void GenerarCarton(){

        LineaArriba = LineaArriba.GenerarPosicionesSuperiores(LineaArriba);
        // LineaArriba.PintarLinea(LineaArriba);
        
        LineaMedio = LineaMedio.GenerarPosicionesMedias(LineaMedio);
        // LineaMedio.PintarLinea(LineaMedio);
        
        
        LineaAbajo = LineaAbajo.GenerarPosicionesInferiores(LineaArriba, LineaMedio ,LineaAbajo);
        // LineaAbajo.PintarLinea(LineaAbajo);
        
        
        
        LineaArriba = LineaArriba.AsignarNumerosLineaArriba(LineaArriba);
       
        
        LineaMedio = LineaMedio.AsignarNumerosLineaMedio(LineaMedio);
       
        
        LineaAbajo = LineaAbajo.AsignarNumerosLineaAbajo(LineaAbajo);
        
    }
    
    public String PintarSecuenciaBingo() {

        String SecuenciaLinea = "";

        Iterator<Integer> it = NumerosTachadosCarton.iterator();

        while (it.hasNext()) {
            SecuenciaLinea = SecuenciaLinea + it.next();
            if (it.hasNext()) {
                SecuenciaLinea = SecuenciaLinea + ", ";
            }

        }
        
        return SecuenciaLinea;
    }
    
    public void PintarCarton(){
    
     LineaArriba.PintarLinea(LineaArriba);
     LineaMedio.PintarLinea(LineaMedio);
     LineaAbajo.PintarLinea(LineaAbajo);
     System.out.println("-----------------------------------------------------------------------------------------");
    }
    
    
}
    
    
    
    
    
    
    
    /*
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
    */
    /*
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
*/
