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
    private int N = 4;
    Point[] points;

    public Squares(PApplet app) {
        super(app);
        init();
        app.background(Colors.BLACK);
    }

    @Override
    public void keyPressed(int keyCode) {
        if (keyCode == PApplet.LEFT) {
            colorIndex--;
        } else if (keyCode == PApplet.RIGHT) {
            colorIndex++;
        }
        colorIndex = (colorIndex + colors.length) % colors.length;

        if(keyCode == PApplet.DOWN && N > 3) {
            N--;
            app.background(Colors.BLACK);
        }
        if (keyCode == PApplet.UP) {
            N++;
            app.background(Colors.BLACK);
        }

        init();
        super.keyPressed(keyCode);
    }

    private void init() {

        var phi0 = Math.PI * 3/ 2 - Math.PI / N;
        var dPhi = Math.PI * 2 / N;
        var h = -Math.sin(phi0);
        var radius = app.height / 2.0 * 0.9;

        points = new Point[N];
        for (var i = 0; i < N; i++) {
            var phi = phi0 + dPhi * i;
            points[i] = new Point(radius*Math.cos(phi), radius *  Math.sin(phi));
        }


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
