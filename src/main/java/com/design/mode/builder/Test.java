package com.design.mode.builder;

/**
 * 建造者模式
 * 从这点看出，建造者模式将很多功能集成到一个类里，这个类可以创造出比较复杂的东西。所以与工程模式的区别就是：
 * 工厂模式关注的是创建单个产品，而建造者模式则关注创建符合对象，多个部分。因此，是选择工厂模式还是建造者模式，依实际情况而定。
 *
 * Created by zhangfeifei on 2016/12/05.
 */
public class Test {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Builder builder = new Builder();  
        builder.produceMailSender(10);  
    }  
}
