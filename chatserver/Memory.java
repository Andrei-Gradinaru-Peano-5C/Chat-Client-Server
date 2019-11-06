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
public class Memory {
    private String[] messages;
    private int index;
    
    private static int LENGTH = 11;

    public Memory() {
        messages = new String[LENGTH];
        index = 0;
    }
     
    public void addMessage(String text) {
        if(this.index == LENGTH-1) {
            String[] copy = new String[LENGTH];
            for(int i=0; i<index; i++) {
                copy[i] = messages[i+1];
            }
            copy[LENGTH-1] = text;
            this.messages = copy;
        }
        else {
            this.messages[index] = text;
            index++;
        }
    }
    
    public String getMessage(int index) {
        if(index>=0 && index<this.index-1) {
            return this.messages[index];
        } else {
            throw new IllegalArgumentException("Index out of Bound");
        }
    }
}
