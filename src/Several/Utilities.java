/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Several;

/**
 *
 * @author USUARIO
 */
public class Utilities {
    
    // Numero Random entre un numero inicial y un numero Final
    public static int random(int start, int end){
        int randomNumber = 0;
        
        randomNumber = (int) (Math.random()*end + start); 
                 
        return randomNumber;
    }
    
    // Limite de elixir de la aplicación, devuelve true si esta bien, false si esta mal
    public static boolean elixirStatus(int elixirCost){  
        return (elixirCost > 15 || elixirCost < 10) ? false : true;
    }
    
    // Limite de nivel de vida, devuelve true si esta bien, false si esta mal
    public static boolean scoreStatus(int scoreLevel){
        return (scoreLevel > 100 || scoreLevel < 1) ? false : true;
    }
    
    // Limite de nivel de fuerza, devuelve true si esta bien, false si esta mal
    public static boolean powerStatus(int powerLevel) {
        return (powerLevel > 5 || powerLevel < 1) ? false : true;
    }
    
    // Limite de nivel de alcance, devuelve true si esta bien, false si esta mal
    public static boolean reachStatus(int reach) {
        return (reach > 10 || reach < 5) ? false : true;
    }
    
    // Limite de nivel de escudo, devuelve true si esta bien, false si esta mal
    public static boolean coatStatus(int coatLevel) {
        return (coatLevel > 10 || coatLevel < 5) ? false : true;
    }
    
}
