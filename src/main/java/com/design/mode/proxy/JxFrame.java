package com.design.mode.proxy;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



/**
 * The type Jx frame.
 */
public class JxFrame extends JFrame {
    /**
     * Instantiates a new Jx frame.
     *
     * @param title the title
     */
    public JxFrame(String title) {
        super(title);
        setCloseClick();
        setLF();
    }

    private void setCloseClick() {
        //create window listener to respond to window close click
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //------------------------------------------
    private void setLF() {
        // Force SwingApp to come up in the System L&F
        String laf = UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(laf);
        } catch (UnsupportedLookAndFeelException exc) {
            System.err.println("Warning: UnsupportedLookAndFeel: " + laf);
        } catch (Exception exc) {
            System.err.println("Error loading " + laf + ": " + exc);
        }
    }
}
