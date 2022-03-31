package bingo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Bombo {
    
    Set<Integer> bombo;
    
    
    public Bombo(){
        bombo = new HashSet<>();
        inicializarBombo();
    }
    
    void inicializarBombo(){
        for(int i=1; i<=90; i++){
            bombo.add(i);
        }
    }
    
    BolaAparecida sacarNumero(){
        int random = (int) Math.floor(Math.random()*(90)+1);
        while(!bombo.contains(random)){
            random = (int) Math.floor(Math.random()*(90)+1);
        }
        bombo.remove(random);
        //Retornar objeto correcto
        return new BolaAparecida(random);
    }
    
    public String toString(){
        Iterator it = bombo.iterator();
        String cadena = "[";
        while(it.hasNext()){
            cadena += it.next() + ", ";
        }
        cadena = cadena.substring(0, cadena.length()-2);
        cadena += "]";
        return cadena;
    }
}
