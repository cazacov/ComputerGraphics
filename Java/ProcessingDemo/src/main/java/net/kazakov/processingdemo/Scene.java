package net.kazakov.processingdemo;

import processing.core.PApplet;

public class Scene extends BaseScene {
    private float circleX;
    private float circleY;

    public Scene(PApplet app) {
        super(app);
        circleX = app.width / 2f;
        circleY = app.height / 2f;
        app.textSize(16);
    }

    public void draw() {
        app.background(0);

        updateCirclePosition();
        app.fill(255, 220, 0);
        app.noStroke();
        app.ellipse(circleX, circleY, 60, 60);

        app.fill(220);
        app.text("Use arrow keys to move the circle", 40, app.height - 30);
    }

    private void updateCirclePosition() {
        float speed = 3f;
        if (up) {
            circleY -= speed;
        }
        if (down) {
            circleY += speed;
        }
        if (left) {
            circleX -= speed;
        }
        if (right) {
            circleX += speed;
        }
        circleX = PApplet.constrain(circleX, 30, app.width - 30);
        circleY = PApplet.constrain(circleY, 30, app.height - 30);
    }
}
