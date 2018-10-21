/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

import Several.Utilities;
import java.util.ArrayList;
import javax.print.attribute.standard.Severity;

/**
 *
 * @author USUARIO
 */
public class StucomRoyal {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Jugador> playerList = new ArrayList<>();
    public static ArrayList<Carta> cardList = new ArrayList<>();
    public static ArrayList<Jugador> battle = new ArrayList<>();
    public static int MAXIMUNCARD = 6, CARDSPPLAY = 3, PLAYERDSPGAME = 2;

    public static void main(String[] args) {

        Several.PlayerThings.addLists();

        boolean exit = false;

        do {
            int optionMenu = 0;
            Plantillas.Menu();
            optionMenu = Control.Errores.askInt("Que quieres hacer?");

            switch (optionMenu) {
                case 1:
                    boolean exitOption = false;
                    // Despues de pedir nombre de jugador se comprueba que este registrado
                    String name = Control.Errores.askString("Ingresa Nombre Jugador");
                    int playerPosition = Control.Errores.userTestingPosition(name);

                    // Despues de pedir contraseña se comprueba si es correcta o no
                    String pass = Control.Errores.askString("\nIngresa Contraseña");
                    boolean passTesting = Control.Errores.passTesting(playerPosition, pass);

                    do {

                        // Metodo que lista todas las cartas que se puden adquirir
                        Several.PlayerThings.cardList();
                        // Despus pedir una carta para agregar a su lista, se comprueba si esta repetida o no
                        int cardPositon = Control.Errores.askInt("Que carta quiere adquirir?");

                        if (cardPositon <= cardList.size() && cardPositon > 0) {
                            boolean playerCardTesting = Several.PlayerThings.checkTwinCard(cardList.get(cardPositon - 1).getName(), playerPosition);

                            // Metodo que cuenta las cartas que tiene cada jugador
                            int cardsNumber = Several.PlayerThings.cardNumber(playerPosition);

                            // If que añade la carta seleccionada a la mano del jugador o muestra mensajes de error
                            if (!playerCardTesting && cardsNumber < MAXIMUNCARD) {
                                System.out.println(" --> Se va Añadir esta carta a tu mano");
                                playerList.get(playerPosition).setPlayerCardList(cardList.get(cardPositon - 1));
                                cardList.remove(cardPositon - 1);
                            } else if (playerCardTesting) {
                                System.out.println("No es posible adquirir esta carta, ya tienes una igual");
                            } else if (cardsNumber >= MAXIMUNCARD) {
                                System.out.println("Ya tiene el maximo de cartas posible");
                            }

                            stucomroyal.Plantillas.menuCartas();
                            int optionMenuCard = 0;
                            optionMenuCard = Control.Errores.askInt("Que quieres hacer ahora?");

                            switch (optionMenuCard) {
                                case 1:
                                    if (playerList.get(playerPosition).getPlayerCardList().size() == MAXIMUNCARD) {
                                        System.out.println("Ya no puedes conseguir más cartas, tienes las " + MAXIMUNCARD + " permitidas!!!");
                                        exitOption = true;
                                    }
                                    break;
                                case 2:
                                    exitOption = true;
                                    break;
                            }
                        } else {
                            System.out.println("Opcion invalida, marque una valida por favor!!");
                        }

                    } while (!exitOption);

                    // Se muestran todas las cartas del jugador
                    Several.PlayerThings.playerCardList(playerPosition);

                    break;
                case 2:
                    Batalla newBattle = new Batalla();
                    // Seleccion de usuarios 
                    for (int i = 0; i < PLAYERDSPGAME; i++) {
                        String player1 = Several.PlayerThings.validateUserPass();
                        int playerPosition1 = Control.Errores.userTestingPosition(player1);
                        System.out.println("\n       SELECCIONA " + CARDSPPLAY + " CARTAS   ");
                        System.out.println("------------------------------------------\n");
                        Several.PlayerThings.cardPlayerList(playerPosition1);
                        battle.add(playerList.get(playerPosition1));

                        boolean exitSelecionCard = false;

                        do {
                            if (playerList.get(playerPosition1).getPlayerCardList().size() >= CARDSPPLAY) {
                                int cardSelected = Control.Errores.askInt("Escoge carta para el juego");
                                if (cardSelected > playerList.get(playerPosition1).getPlayerCardList().size() || cardSelected <= 0) {
                                    System.out.println("!!opcion invalida!!");
                                } else {
                                    Carta newCardBattle = new Carta(playerList.get(playerPosition1).getPlayerCardList().get(cardSelected - 1).getName(), playerList.get(playerPosition1).getName());
                                    newBattle.setBattleCards(newCardBattle);
                                    System.out.println(newBattle.getBattleCards().size() + "----");
                                    if (newBattle.getBattleCards().size() == CARDSPPLAY) {
                                        exitSelecionCard = true;
                                    }

                                }
                            } else {
                                System.out.println("\n!!! Estas cartas no son las suficientes para jugar !!!\n");
                                exitSelecionCard = true;
                            }

                        } while (!exitSelecionCard);

                    }

                    Batalla.showPlayersGame();

                    break;
                case 3:
                    Several.PlayerThings.rakingList();
                    break;
                case 4:
                    exit = true;
                    break;
            }

        } while (!exit);

    }

}
