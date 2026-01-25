package net.kazakov.processingdemo;

import processing.core.PApplet;

public class Main extends PApplet {
    private Scene scene;

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
        if (keyCode == UP) {
            scene.up = true;
        } else if (keyCode == DOWN) {
            scene.down = true;
        } else if (keyCode == LEFT) {
            scene.left = true;
        } else if (keyCode == RIGHT) {
            scene.right = true;
        }
    }

    @Override
    public void keyReleased() {
        if (keyCode == UP) {
            scene.up = false;
        } else if (keyCode == DOWN) {
            scene.down = false;
        } else if (keyCode == LEFT) {
            scene.left = false;
        } else if (keyCode == RIGHT) {
            scene.right = false;
        }
    }
}
