package bingo;

import java.util.ArrayList;

/**
 *
 * @author alvar
 */
public class Linea {
    private ArrayList<Integer> posHuecos;
    private ArrayList<Integer> numeros;
    private ArrayList<Integer> linea;
    
    public Linea(){
        posHuecos = new ArrayList();
        numeros = new ArrayList();
        linea = new ArrayList();
        for(int i=0; i<9; i++){
            linea.add(0);
        }
    }

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
