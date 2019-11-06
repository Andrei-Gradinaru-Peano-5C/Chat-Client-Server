/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

/**
 *
 * @author Andrei
 */
public class SendHisotry implements Runnable{
    private int index;
    private Memory history;
    private UDPServer server;

    public SendHisotry(int index, Memory history, UDPServer server) {
        this.index = index;
        this.server = server;
        this.history = history;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1);
            history.getMessage(0);
            server.send(index, "----------------- Hisotry -------------------");
            for (int i=0; true; i++) {
                server.send(index, history.getMessage(i));
                System.out.println("Send Hisotry : " + i);
            }
        } catch (Exception ex) {}
        
    }
    
}
