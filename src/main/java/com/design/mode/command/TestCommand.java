package com.design.mode.command;

/**
 * 命令模式
 * Created by zhangfeifei on 2016/12/05.
 */

public class TestCommand {

    /**
     * Instantiates a new Test command.
     */
    public TestCommand() {
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Light testLight = new Light();
        LightOnCommand testLOC = new LightOnCommand(testLight);
        LightOffCommand testLFC = new LightOffCommand(testLight);
        Switch testSwitch = new Switch(testLOC, testLFC);
        testSwitch.flipUp();
        testSwitch.flipDown();
        Fan testFan = new Fan();
        FanOnCommand foc = new FanOnCommand(testFan);
        FanOffCommand ffc = new FanOffCommand(testFan);
        Switch ts = new Switch(foc, ffc);
        ts.flipUp();
        ts.flipDown();
    }
}

/**
 * The type Fan.
 */
class Fan {
    /**
     * Start rotate.
     */
    public void startRotate() {
        System.out.println("Fan is Rotating now !");
    }

    /**
     * Stop rotate.
     */
    public void stopRotate() {
        System.out.println("Fan is stop now !");
    }
}

/**
 * The type Light.
 */
class Light {
    /**
     * Turn on.
     */
    public void turnOn() {
        System.out.println("Light is on now !");
    }

    /**
     * Turn off.
     */
    public void turnOff() {
        System.out.println("Light is off now !");
    }
}

/**
 * The type Switch.
 */
class Switch {
    private Command UpCommand, DownCommand;

    /**
     * Instantiates a new Switch.
     *
     * @param Up   the up
     * @param Down the down
     */
    public Switch(Command Up, Command Down) {
        UpCommand = Up;
        DownCommand = Down;
    }

    /**
     * Flip up.
     */
    void flipUp() {
        UpCommand.execute();
    }

    /**
     * Flip down.
     */
    void flipDown() {
        DownCommand.execute();
    }
}

/**
 * The type Light on command.
 */
class LightOnCommand implements Command {
    private Light myLight;

    /**
     * Instantiates a new Light on command.
     *
     * @param L the l
     */
    public LightOnCommand(Light L) {
        myLight = L;
    }

    public void execute() {
        myLight.turnOn();
    }
}

/**
 * The type Light off command.
 */
class LightOffCommand implements Command {
    private Light myLight;

    /**
     * Instantiates a new Light off command.
     *
     * @param L the l
     */
    public LightOffCommand(Light L) {
        myLight = L;
    }

    public void execute() {
        myLight.turnOff();
    }
}

/**
 * The type Fan on command.
 */
class FanOnCommand implements Command {
    private Fan myFan;

    /**
     * Instantiates a new Fan on command.
     *
     * @param F the f
     */
    public FanOnCommand(Fan F) {
        myFan = F;
    }

    public void execute() {
        myFan.startRotate();
    }
}

/**
 * The type Fan off command.
 */
class FanOffCommand implements Command {
    private Fan myFan;

    /**
     * Instantiates a new Fan off command.
     *
     * @param F the f
     */
    public FanOffCommand(Fan F) {
        myFan = F;
    }

    public void execute() {
        myFan.stopRotate();
    }
}
