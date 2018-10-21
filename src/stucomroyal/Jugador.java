/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class Jugador {
    
    private String name;
    private String pass;
    private int trophy = 0;
    private ArrayList<Carta> playerCardList = new ArrayList<>();
    
    public Jugador(){
    }
    
    public Jugador(String name, String pass){
        this.name = name;
        this.pass = pass;
        this.trophy = 0; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getTrophy() {
        return trophy;
    }

    public void setTrophy(int trophy) {
        this.trophy = trophy;
    }

    public ArrayList<Carta> getPlayerCardList() {
        return playerCardList;
    }

    public void setPlayerCardList(Carta newCard) {
        playerCardList.add(newCard);
    }
    
    
}
