package com.design.mode.proxy;
import javax.swing.*;

/**
 * 代理模式
 *
 * @author zhangfeifei2
 */
public class Test  {
        /**
         * The entry point of application.
         *
         * @param args the input arguments
         */
        public static void main(String[] args) {
        JFrame frame = new JFrame("Proxy test client");
        JLabel label = new JLabel("Loading web page ......");
        frame.getContentPane().add(label);
        PageProxy pageProxy = new PageProxy();
        frame.getContentPane().add(pageProxy);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        //frame.pack();
        frame.setVisible(true);

        pageProxy.label.setText("aaa");
    }
}