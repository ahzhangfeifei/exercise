package com.design.mode.facade;
/**
 *  外观模式/门面模式
 *  A very simple test
 *  Created by zhangfeifei on 2016/12/08.
 */
class Wall {
    /**
     * Instantiates a new Wall.
     */
    public Wall() {
        System.out.println("Create a wall !");
    }
}

/**
 * The type Door.
 */
class Door {
    /**
     * Instantiates a new Door.
     */
    public Door() {
        System.out.println("Create a door !");
    }
}

/**
 * The type Facade room.
 */
class FacadeRoom {
    /**
     * Create room.
     */
    public void CreateRoom() {
        Wall wall1 = new Wall();
        Wall wall2 = new Wall();
        Wall wall3 = new Wall();
        Wall wall4 = new Wall();
        Door door = new Door();
    }

}

/**
 * The type Test.
 */
public class Test  {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        FacadeRoom room = new FacadeRoom();
        room.CreateRoom();
    }
}