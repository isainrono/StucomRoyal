/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static stucomroyal.StucomRoyal.playerList;

/**
 *
 * @author USUARIO
 */
public class Errores {

    public static String askString(String texto) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cadena = "";
        do {
            try {
                System.out.println(texto);
                cadena = br.readLine();
                if (cadena.equals("")) {
                    System.out.println("No se puede dejar el campo en blanco.");
                }
            } catch (IOException ex) {
                System.out.println("Error de entrada / salida.");
            }
        } while (cadena.equals(""));
        return cadena;
    }

    public static int askInt(String texto) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean error;
        do {
            try {
                System.out.println(texto);
                num = Integer.parseInt(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Error de entrada / salida.");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("Debes introducir un número entero.");
                error = true;
            }
        } while (error);
        return num;
    }

    // Metodo que verifica si el jugador existe devueve la posiscion del array en la que se encuentra
    public static int userTestingPosition(String name) {
        boolean exit = false;
        int counter = 0, ubication = -1;
        do {
            for (int i = 0; i < playerList.size(); i++) {
                if (playerList.get(i).getName().equalsIgnoreCase(name)) {
                    exit = true;
                    counter++;
                    ubication = i;
                }
            }
            if (counter <= 0) {
                System.out.println("!!Este jugador no exite!!!");
                name = askString("Escribe nombre de Jugador");
            }

        } while (!exit);

        return ubication;
    }
    
    // Metodo que verifica si la contraseña es correcta o no
    public static boolean passTesting(int position, String pass) {
        boolean exit = false;
        do {
            if(playerList.get(position).getPass().equals(pass)) {
                exit = true;   
            } else {
                System.out.println("!!!La Contraseña no es correcta!!!");
                pass = Control.Errores.askString("Ingresa Contraseña");
            }
        } while (!exit);
        
        return exit;
    }
}
