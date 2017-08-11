package com.design.mode.builder;

/**
 * The type House director.
 * Created by zhangfeifei on 2016/12/05.
 */
/*
 *  This class is a Director
 */
public class HouseDirector  {
    /**
     * Create house.
     *
     * @param concreteBuilder the concrete builder
     */
    public void CreateHouse(HouseBuilder concreteBuilder) {
        concreteBuilder.BuildRoom(1);
        concreteBuilder.BuildRoom(2);
        concreteBuilder.BuildDoor(1, 2);

        //return builder.getHouse();
    }
}