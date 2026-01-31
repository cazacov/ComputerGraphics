package net.kazakov.processingdemo;

import processing.core.PApplet;

public class Main extends PApplet {
    private BaseScene scene;

    public static void main(String[] args) {
        PApplet.main(Main.class);
    }

    @Override
    public void settings() {
        size(800, 600);
    }

    @Override
    public void setup() {
        scene = new Scene(this);
    }

    @Override
    public void draw() {
        scene.draw();
    }

    @Override
    public void keyPressed() {
        scene.keyPressed(keyCode);
    }

    @Override
    public void keyReleased() {
        scene.keyReleased(keyCode);
    }
}
