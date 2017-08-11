package com.design.mode.adapter;

/**
 * 接口的适配器模式：当不希望实现一个接口中所有的方法时，
 * 可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可。
 * Created by zhangfeifei on 2016/12/02.
 */
public class TestAbstractShape {
	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		 Shape source1 = new Shape1();  
		 Shape source2 = new Shape2();  
	          
	        source1.Draw();  
	        source1.Border();   
	        source2.Draw();  
	        source2.Border();  
	}

}
