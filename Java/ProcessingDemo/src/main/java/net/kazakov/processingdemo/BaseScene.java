package net.kazakov.processingdemo;

import processing.core.PApplet;

public abstract class BaseScene {
    protected final PApplet app;
    protected boolean up;
    protected boolean down;
    protected boolean left;
    protected boolean right;

    protected BaseScene(PApplet app) {
        this.app = app;
    }

    public abstract void draw();

    public void keyPressed(int keyCode) {
        if (keyCode == PApplet.UP) {
            up = true;
        } else if (keyCode == PApplet.DOWN) {
            down = true;
        } else if (keyCode == PApplet.LEFT) {
            left = true;
        } else if (keyCode == PApplet.RIGHT) {
            right = true;
        }
    }

    public void keyReleased(int keyCode) {
        if (keyCode == PApplet.UP) {
            up = false;
        } else if (keyCode == PApplet.DOWN) {
            down = false;
        } else if (keyCode == PApplet.LEFT) {
            left = false;
        } else if (keyCode == PApplet.RIGHT) {
            right = false;
        }
    }
}
