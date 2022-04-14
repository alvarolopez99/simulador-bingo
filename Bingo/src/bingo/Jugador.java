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
    
    public Jugador(){
        
    }
    
    public void asignarCartonesNuevos(int numCartones){
        cartones = new ArrayList<Carton>();
        //cartones.clear();
        for(int i=0; i<numCartones; i++){
            cartones.add(new Carton());
        }
    }
    
    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }


    public int getPuntos(){
        return this.puntos;
    }
    
    public ArrayList<Carton> GetCartones(){
    
    return cartones;
    }
    
    public boolean TacharNumero(int Numero) {

        boolean NumeroTachado = false;

        for (int j = 0; j < cartones.size(); j++) {

            Carton Carton = cartones.get(j);
            NumeroTachado = Carton.TacharNumero(Numero);

        }
        return NumeroTachado;

    }

    public void MostrarCartones() {
        for (int j = 0; j < cartones.size(); j++) {

            Carton Carton = cartones.get(j);
            Carton.PintarCarton();

        }

    }

    public String[] ComprobarLinea() {

        //boolean LineaCantada = false;
        
        String[] ComprobacionLinea = new String[2];

        for (int j = 0; j < cartones.size(); j++) {

            Carton Carton = cartones.get(j);
            ComprobacionLinea = Carton.RevisarLineas();

        }
        return ComprobacionLinea;

    }    
    
     public String[] ComprobarCarton() {

        boolean BingoCantado = false;

        String[] ComprobacionCarton = new String[2];
        
        ComprobacionCarton[0] =  String.valueOf(false);
        //AQUI HAY QUE HACER UN WHILE PARA QUE EN CUANTO UN CARTON SEA BINGO NO SEGUIR
        int ContCarton = 0;
        while (Boolean.parseBoolean(ComprobacionCarton[0]) != true  && (ContCarton < cartones.size())){
        
            Carton Carton = cartones.get(ContCarton);
            ComprobacionCarton = Carton.RevisarCarton();
            ContCarton++;
            
        }
        
        /*for (int j = 0; j < cartones.size(); j++) {

            Carton Carton = cartones.get(j);
            ComprobacionCarton = Carton.RevisarCarton();
        
        }*/
        
        return ComprobacionCarton;

    }   

}
