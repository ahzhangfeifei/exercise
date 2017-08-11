package com.design.mode.templatemethod;

/**
 * 模板模式
 * A test client
 */
public class Test  {
        /**
         * The entry point of application.
         *
         * @param args the input arguments
         */
        public static void main(String[] args) {
        // You should change the path of "test.txt" in your local machine
        String fileName = "D:\\WorkspaceMy\\DesignMode\\src\\com\\design\\mode\\templatemethod\\test.txt";
        String url = "http://www.the9.com/main.htm";
        
        AbstractRead fileRead = new ReadFile();
        AbstractRead htmlRead = new ReadHtml();

        fileRead.setResource(fileName);
        htmlRead.setResource(url);
        
        System.out.println("-----  Read from a file  -----");        
        fileRead.getContent();
        System.out.println("-----  Read from a url  -----");
        htmlRead.getContent();
    }
}