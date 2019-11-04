  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrei
 */
public class ChatClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UDPClient client = new UDPClient(6969, "127.0.0.1", 6969);
            Receive listener = new Receive(client);
            
            String username = JOptionPane.showInputDialog("Inserire Username");
            if(username == null) {
                System.exit(0);
            }
            while(username.length()<4) {
                username = JOptionPane.showInputDialog("L'Username deve contenere almeno 4 lettere");
                if(username == null) {
                    System.exit(0);
                }
            }
            
            listener.addGui(new Gui(client,username));
            
        } catch (SocketException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
