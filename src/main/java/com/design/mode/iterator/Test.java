package com.design.mode.iterator;

/**
 * 迭代子模式
 */

public class Test  {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String fileName = "D:\\WorkspaceMy\\DesignMode\\src\\com\\design\\mode\\iterator\\data.txt";
        DataVector dataVector = new DataVector(fileName);
        Iterator iVector = dataVector.CreateIterator();
        for(iVector.First(); ! iVector.IsDone(); iVector.Next()) {
            iVector.CurrentItem();
        }
    }
}