  
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
            UDPClient client = new UDPClient(6969, "127.0.0.1", 7000);
            new Receive(client);
            
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Inserire Username: ");
            String username = sc.nextLine();
            
            while(true) {
                String text = sc.nextLine();
                new Send(client, ("["+ username +"] : "+text) );
            }
            
        } catch (SocketException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
