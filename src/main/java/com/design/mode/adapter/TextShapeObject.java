package com.design.mode.adapter;

/**
 * 对象的适配器模式
 * 当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，
 * 持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行。
 * Created by zhangfeifei on 2016/12/02.
 */
public class TextShapeObject  implements Shape {
    private Text txt;

    /**
     * Instantiates a new Text shape object.
     *
     * @param t the t
     */
    public TextShapeObject(Text t) {
        txt = t;
    }
    public void Draw() {
        System.out.println("Draw a shap ! Impelement Shape interface !");
    }
    public void Border() {
        System.out.println("Set the border of the shap ! Impelement Shape interface !");
    }

    /**
     * Set content.
     *
     * @param str the str
     */
    public void SetContent(String str) {
        txt.SetContent(str);
    }

    /**
     * Get content string.
     *
     * @return the string
     */
    public String GetContent() {
        return txt.GetContent();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Text myText = new Text();
        TextShapeObject myTextShapeObject = new TextShapeObject(myText);
        myTextShapeObject.Draw();
        myTextShapeObject.Border();
        myTextShapeObject.SetContent("A test text !");
        System.out.println("The content in Text Shape is :" + myTextShapeObject.GetContent());
        
    }
}