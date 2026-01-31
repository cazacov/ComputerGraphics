package net.kazakov.graphics3d;

import net.kazakov.graphics3d.scenes.DemoScene;
import net.kazakov.graphics3d.scenes.Squares;
import processing.core.PApplet;

public class Main extends PApplet {
    private BaseScene scene;

    public static void main(String[] args) {
        PApplet.main(Main.class);
    }

    @Override
    public void settings() {
        pixelDensity(1);
        size(2700, 1800);
    }

    @Override
    public void setup() {
        //scene = new DemoScene(this);
        scene = new Squares(this);
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