/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Several;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import stucomroyal.Carta;
import stucomroyal.Jugador;
import static stucomroyal.StucomRoyal.cardList;
import static stucomroyal.StucomRoyal.playerList;
import stucomroyal.TipoCarta;

/**
 *
 * @author USUARIO
 */
public class PlayerThings {

    // Rellenando listas
    public static void addLists() {
        Jugador isain = new Jugador("isain", "isa23F");
        playerList.add(isain);
        
        Jugador camilo = new Jugador("camilo", "1234");
        camilo.setTrophy(3);
        playerList.add(camilo);
        
        Jugador david = new Jugador("david", "1234");
        david.setTrophy(1);
        playerList.add(david);
        
        Jugador angelly = new Jugador("angelly", "1361");
        angelly.setTrophy(5);
        playerList.add(angelly);
        
        Carta tre = new Carta("tre", 10, 5, 2, 2, TipoCarta.TROPA);
        cardList.add(tre);
        
        Carta pee = new Carta("pee", 10, 5, 2, 2, TipoCarta.ESTRUCTURA);
        cardList.add(pee);
        
        Carta yyy = new Carta("yyy", 10, 5, 2, 2, TipoCarta.ESTRUCTURA);
        cardList.add(yyy);
        
        Carta ooo = new Carta("ooo", 9, 5, 2, 2, TipoCarta.ESTRUCTURA);
        cardList.add(ooo);
        
        Carta www = new Carta("www", 10, 5, 2, 2, TipoCarta.ESTRUCTURA);
        cardList.add(www);
        
        Carta hhh = new Carta("hhh", 7, 5, 2, 2, TipoCarta.HECHIZO);
        cardList.add(hhh);
        
        isain.getPlayerCardList().add(pee);
        camilo.getPlayerCardList().add(hhh);
        angelly.getPlayerCardList().add(yyy);
        angelly.getPlayerCardList().add(ooo);
        angelly.getPlayerCardList().add(tre);
    }

    // Lista de todas las cartas disponibles.
    public static void cardList() {
        System.out.println("\n\n Esta es la lista de cartas que puedes Adquirir");
        System.out.println("....................................................");
        for (int i = 0; i < cardList.size(); i++) {
            System.out.println(i + 1 + " -- " + cardList.get(i).getName());
        }
    }

    // Metodo que compruaba si la tarjeta que se quiere adquirir esta repetida
    public static boolean checkTwinCard(String cardName, int playerPosition) {
        int counter = 0;
        for (int i = 0; i < playerList.get(playerPosition).getPlayerCardList().size(); i++) {
            if (playerList.get(playerPosition).getPlayerCardList().get(i).getName().equalsIgnoreCase(cardName)) {
                counter++;
            }
        }
        
        return (counter > 0) ? true : false;
    }

    // Metodo que muestra todas las cartas de jugador
    public static void playerCardList(int playerPosition) {
        System.out.println("           TU LISTA DE CARTAS              ");
        System.out.println(" --------------------------------------- \n");
        for (int i = 0; i < playerList.get(playerPosition).getPlayerCardList().size(); i++) {
            System.out.println(i + 1 + " -- " + playerList.get(playerPosition).getPlayerCardList().get(i).getName());
        }
    }

    // Metodo que cuenta las cartas de un jugador
    public static int cardNumber(int playerPosition) {
        int counter = 0;
        for (int i = 0; i < playerList.get(playerPosition).getPlayerCardList().size(); i++) {
            counter++;
        }
        
        return counter;
    }

    // Metodo que lista jugadores en ranking por numero de trofeos que tienen // pendiente por probar repetidos
    public static void rakingList() {
        ArrayList<Integer> trophyList = new ArrayList<>();
        
        for (int i = 0; i < playerList.size(); i++) {
            trophyList.add(playerList.get(i).getTrophy());
        }
        
        Comparator<Integer> comparator = Collections.reverseOrder();
        Collections.sort(trophyList, comparator);
        
        for (int i = 0; i < trophyList.size(); i++) {
            
            for (int j = 0; j < playerList.size(); j++) {
                if (trophyList.get(i) == playerList.get(j).getTrophy()) {
                    System.out.println(i + 1 + " -- " + playerList.get(j).getName() + " --> " + trophyList.get(i) + " trofeos");
                }
            }
        }
        
    }

    // Metodo que comprueba usuario y contraseña de jugadores
    public static String validateUserPass() {
        // Despues de pedir nombre de jugador se comprueba que este registrado
        String name = Control.Errores.askString("Ingresa Nombre Jugador");
        int playerPosition = Control.Errores.userTestingPosition(name);

        // Despues de pedir contraseña se comprueba si es correcta o no
        String pass = Control.Errores.askString("\nIngresa Contraseña");
        boolean passTesting = Control.Errores.passTesting(playerPosition, pass);
        
        return name;
    }
    
    // Metodo que lista todas las cartas por jugador, y escoger las reglamentaria del juego
    public static void cardPlayerList(int playerPosition) {
        for (int i = 0; i < playerList.get(playerPosition).getPlayerCardList().size(); i++) {
            System.out.println(i + 1 + " -- " + playerList.get(playerPosition).getPlayerCardList().get(i).getName());
            System.out.println("* Ataque  ----> " + playerList.get(playerPosition).getPlayerCardList().get(i).getAttackLevel());
            System.out.println("* Defensa ----> " + playerList.get(playerPosition).getPlayerCardList().get(i).getFenderLevel());
            System.out.println("* Elixir  ----> " + playerList.get(playerPosition).getPlayerCardList().get(i).getElixirCost());
            System.out.println("* vida    ----> " + playerList.get(playerPosition).getPlayerCardList().get(i).getScoreLevel());
            System.out.println("* tipo    ----> " + playerList.get(playerPosition).getPlayerCardList().get(i).getCardType());
        }
    }

    
}
