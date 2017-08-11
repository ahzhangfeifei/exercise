package com.design.mode.prototype;

import java.util.Hashtable;

/**
 * 原型模式
 *
 */
public class GraphicTool  {
    /**
     * Instantiates a new Graphic tool.
     */
    public GraphicTool() {
    }

    /**
     * 很简单，一个原型类，只需要实现Cloneable接口，覆写clone方法，此处clone方法可以改成任意的名称，
     * 因为Cloneable接口是个空接口，你可以任意定义实现类的方法名，如cloneA或者cloneB，因为此处的重点是super.clone()这句话，
     * super.clone()调用的是Object的clone()方法，而在Object类中，clone()是native的，具体怎么实现，我会在另一篇文章中，
     * 关于解读Java中本地方法的调用，此处不再深究。在这儿，我将结合对象的浅复制和深复制来说一下，首先需要了解对象深、浅复制的概念：
     * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
     * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        //-----  Initial our prototype instance  ---------- 
        SymbolLoader myLoader = new SymbolLoader();
        Hashtable mySymbols = myLoader.getSymbols();

        //-----  Draw a Line  -------------------------------
        Graphic myLine = (Graphic)((Graphic)mySymbols.get("Line")).clone();
        myLine.DoSomething();
    }
}