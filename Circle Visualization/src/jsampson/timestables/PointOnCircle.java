
package jsampson.timestables;

import static java.lang.Math.cos;
import static java.lang.Math.toRadians;
import static java.lang.StrictMath.sin;

import static jhaugh.timestables.Main.OFFSET_W;
import static jhaugh.timestables.Main.OFFSET_H;

/**
 * This class represents a point around the circle
 */
public class PointOnCircle {
    private int id;
    private double x, y;

    public PointOnCircle(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Adds the width offset to x before returning
     */
    public double getX() {

        return x + OFFSET_W;
    }

    public void setX(double x) {
        this.x = x;
    }

    /**
     * Adds the height offset to y before returning
     */
    public double getY() {

        return y + OFFSET_H;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Generates an array of points around a circle
     * with the given radius and number of points.
     */
    public static PointOnCircle[] generatePoints(double radius, double num) {
        PointOnCircle[] points = new PointOnCircle[(int)num];
        int i = 0;
        // Degrees of separation between points on the circle
        double pointSeparation = 360.0 / num;
        for(double angle = 180; angle < 540; angle += pointSeparation) {
            double x = cos(toRadians(angle)) * radius;
            double y = sin(toRadians(angle)) * radius;
            // TODO: Make a new PointOnCircle using i, x, and y
            //  Then assign it to points[i]

            points[i] = new PointOnCircle(i,x,y);
            i++;
        }
        return points;
    }
}
