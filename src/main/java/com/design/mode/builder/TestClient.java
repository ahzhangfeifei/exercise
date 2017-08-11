package com.design.mode.builder;

/**
 * The type Test client.
 * Created by zhangfeifei on 2016/12/05.
 */
/*
 *  A test client to create a house
 *  but we do not know how the room and door be created
 */
public class TestClient  {
    /**
     * Instantiates a new Test client.
     */
    public TestClient() {
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        House myHouse = new House();
        ConcreteHouseBuilderA myHouseBuilder = new ConcreteHouseBuilderA();
        HouseDirector myHouseDirector = new HouseDirector();
        myHouseDirector.CreateHouse(myHouseBuilder);
        myHouse = myHouseBuilder.getHouse();

        System.out.println("My house has room :" + myHouse.getRoomNumber());
        System.out.println("My house has door :" + myHouse.getDoorNumber());
    }
}