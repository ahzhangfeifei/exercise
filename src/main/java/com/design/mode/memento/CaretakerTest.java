package com.design.mode.memento;

import java.io.*;

/**
 *  备忘录模式
 *  A Caretaker as our test client
 */
public class CaretakerTest  {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TextOriginator originator = new TextOriginator();
        System.out.println("-----  Please edit text  -----");
        System.out.println("Usage: input \"undo\" to undo your edit");
        System.out.println("Usage: input \"end\" to end edit");
        try {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));            

            String str = "";
            while(true) {
                str = in.readLine();
                if(str.equals("end")) {
                    System.out.println("-----  End edit  -----");
                    break;
                } else if(str.equals("undo")) {
                    originator.setMemento();
                } else { 
                    if(! str.equals("")) {
                        originator.addText(str);
                        originator.createMemento();
                    }
                    
                }
                System.out.println("--Input Text is :" + originator.getText());
            }
        } catch(IOException e) {
            System.out.println("I/O Error !");
            System.exit(1);
        }
    }
}