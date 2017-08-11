package com.design.mode.adapter;

/**
 * 适配器模式
 * 将某个类的接口转换成客户端期望的另一个接口表示，
 * 目的是消除由于接口不匹配所造成的类的兼容性问题。
 * 主要分为三类：类的适配器模式、对象的适配器模式、接口的适配器模式
 * 当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，
 * 创建一个新类，继承原有的类，实现新的接口即可。
 * <p>
 * Created by zhangfeifei on 2016/12/02.
 */
public class TextShapeClass extends Text implements Shape {
    /**
     * Instantiates a new Text shape class.
     */
    public TextShapeClass() {
    }

    public void Draw() {
        System.out.println("Draw a shap ! Impelement Shape interface !");
    }

    public void Border() {
        System.out.println("Set the border of the shap ! Impelement Shape interface !");
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TextShapeClass myTextShapeClass = new TextShapeClass();
        myTextShapeClass.Draw();
        myTextShapeClass.Border();
        myTextShapeClass.SetContent("A test text !");
        System.out.println("The content in Text Shape is :" + myTextShapeClass.GetContent());
    }
}