package com.design.mode.builder;

/**
 * The type Concrete house builder a.
 * Created by zhangfeifei on 2016/12/05.
 */
public class ConcreteHouseBuilderA  extends HouseBuilder{
    private House house;

    /**
     * Instantiates a new Concrete house builder a.
     */
    public ConcreteHouseBuilderA() {
        house = new House();
    }
    public void BuildRoom(int roomNo) {
        //you can create a new Room added to a House
        house.roomNumber++;
    }

    public void BuildDoor(int room1, int room2) {
        // you can create a new door assotiated with 2 room
        // and added this door into a house 
        house.doorNumber++;
    }

    public House getHouse() {
        return house;
    }
}