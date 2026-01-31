package net.kazakov.graphics3d.scenes;

import net.kazakov.graphics3d.BaseScene;
import net.kazakov.graphics3d.Colors;
import net.kazakov.graphics3d.Point;
import processing.core.PApplet;

public class Squares extends BaseScene {

    private final int[] colors = new int[] {
            Colors.BLUE,
            Colors.GREEN,
            Colors.CYAN,
            Colors.RED,
            Colors.MAGENTA,
            Colors.YELLOW,
            Colors.WHITE
    };
    private int colorIndex = 0;
    Point[] points;

    public Squares(PApplet app) {
        super(app);
        init();
        app.background(0);
    }

    @Override
    public void keyPressed(int keyCode) {
        if (keyCode == PApplet.LEFT) {
            colorIndex--;
        } else if (keyCode == PApplet.RIGHT) {
            colorIndex++;
        }
        colorIndex = (colorIndex + colors.length) % colors.length;
        init();
        super.keyPressed(keyCode);
    }

    private void init() {
        var size = this.app.height * 3 / 4;
        points = new Point[] {
                new Point(-size / 2.0, -size / 2.0),
                new Point(size / 2.0, -size / 2.0),
                new Point(size / 2.0, size / 2.0),
                new Point(-size / 2.0, size / 2.0)
        };
        app.strokeWeight(3);
        app.stroke(colors[colorIndex]);
    }

    @Override
    public void draw() {
        var offsetX = app.width / 2.0;
        var offsetY = app.height / 2.0;

        for (int i = 0; i < points.length; i++) {
            var start = points[i];
            var end = points[(i + 1) % points.length];
            app.line(
                    (float) (offsetX + start.x()),
                    (float) (offsetY - start.y()),
                    (float) (offsetX + end.x()),
                    (float) (offsetY - end.y())
            );
        }

        double p = 0.95;
        double q = 1 - p;
        Point[] newPoints = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            var start = points[i];
            var end = points[(i + 1) % points.length];
            newPoints[i] = new Point(start.x() * p + end.x()*q, start.y()*p+end.y()*q);
        }
        points = newPoints;
    }
}
