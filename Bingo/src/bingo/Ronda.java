/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author alvar
 */
public class Ronda {
    
    Bombo bombo;
    
    //Queue<Integer> BolasAparecidas = new LinkedList<Integer>();
    BolasAparecidas BolasAparecidas = new BolasAparecidas();
    
    public Ronda(){
        bombo = new Bombo();
    }

    public void AñadirBolaAparecida(Bola BolaAparecida) {

        BolasAparecidas.AñadirBolaAparecida(BolaAparecida);

    }

    public String toStringBolasAparecidas() {
        String CadenaBolasAparecidas = " ";

        CadenaBolasAparecidas = BolasAparecidas.toStringBolasAparecidas();

        return CadenaBolasAparecidas;
    }

    public Bombo getBombo() {
        return bombo;
    }

    public void setBombo(Bombo bombo) {
        this.bombo = bombo;
    }

    

   

}
