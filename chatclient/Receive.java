/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrei
 */
public class Receive implements Runnable{
    private UDPClient client;
    private Gui gui;
    
    public Receive(UDPClient client) {
        this.client = client;
        new Thread(this).start();
    }
    
    public void addGui(Gui gui) {
        this.gui = gui;
    }

    @Override
    public void run() {
        try {
            while(true) {
                String text = client.receive();        
                if (gui != null) {
                    gui.addMessage(text);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Receive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}