package com.design.mode.chainofresponsibility;

/**
 * 责任链模式
 * A client to test
 * Created by zhangfeifei on 2016/12/05.
 */

public class Test  {
        /**
         * The entry point of application.
         *
         * @param args the input arguments
         */
        public static void main(String[] args) {
        Manager aManager = new Manager();
        ProjectManager aPM = new ProjectManager();
        Programmer aProgrammer = new Programmer();
        QA aQA = new QA();
        Others others = new Others();

        aManager.addChain(aPM);
        aPM.addChain(aProgrammer);
        aProgrammer.addChain(aQA);
        aQA.addChain(others);

        aManager.sendToChain("Get Project");
        aManager.sendToChain("Design");
        aManager.sendToChain("Coding");
        aManager.sendToChain("Test");
        aManager.sendToChain("Kill La Deng !");
    }
}