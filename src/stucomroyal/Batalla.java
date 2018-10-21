/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;
import java.util.ArrayList;
import static stucomroyal.StucomRoyal.battle;
import static stucomroyal.StucomRoyal.CARDSPPLAY;
import static stucomroyal.StucomRoyal.PLAYERDSPGAME;
/**
 *
 * @author USUARIO
 */
public class Batalla {
    
    private ArrayList<Carta> battleCards = new ArrayList<>();
    
    // metodo que cuenta todas las cartas en juego
    public Batalla(){
    }

    public ArrayList<Carta> getBattleCards() {
        return battleCards;
    }

    public void setBattleCards(Carta newCard) {
        battleCards.add(newCard);
    }
    
    
    public int  countCardsinPlay() {
        int counter = 0;
        for (int i = 0; i < battleCards.size(); i++) {
            counter++;
        }
        return counter;
    }
    
    public static void showPlayersGame() {
        for (int i = 0; i < battle.size(); i++) {
            System.out.println(battle.get(i).getName());
        }
    }
}
