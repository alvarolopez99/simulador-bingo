package bingo;


import bingo.Bola;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sergi
 */
public class BolasAparecidas {
    
    ArrayList<Integer> BolasAparecidas;
    
    public BolasAparecidas(){
    BolasAparecidas = new ArrayList<Integer>();
    } 
    
    public void AnadirBolaAparecida(Bola BolaAparecida) {

        BolasAparecidas.add(BolaAparecida.getNumero());

    }
    
    
     public String toStringBolasAparecidas() {
        String CadenaBolasAparecidas = " ";

        BolasAparecidas.contains(BolasAparecidas);
        for (int i = 0; i < BolasAparecidas.size(); i++) {

            
            
            if (i == BolasAparecidas.size() -1 ){
            CadenaBolasAparecidas = CadenaBolasAparecidas + BolasAparecidas.get(i);
            }else {
            CadenaBolasAparecidas = CadenaBolasAparecidas + BolasAparecidas.get(i) + ",";
            }

        }

        return CadenaBolasAparecidas;
    }
    
    
}
