package com.company;

import java.awt.*;

public class Clicker {
    private final int delay;
    private final int keyCode;
    private final Robot robot = new Robot();

    public Clicker(int delay, int keyCode) throws AWTException {
        this.delay = delay;
        this.keyCode = keyCode;
    }

    public void start() throws InterruptedException {
        while (true) {
            robot.keyPress(keyCode);
            Thread.sleep(200);
            robot.keyRelease(keyCode);
            Thread.sleep(delay);
        }
    }
}
