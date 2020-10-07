
package jsampson.timestables;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.awt.*;


public class Visualization {
    private double r = 0;
    private boolean increment = true;
    private double colorMax = 1.0;
    private double colorMin = 0.0;

    private double timesTableNum;
    private double radius;

    public Visualization(double timesTableNum, double radius) {
        this.timesTableNum = timesTableNum;
        this.radius = radius;
    }

    public double getR() {
        return r;
    }

    public double getRadius() {
        return radius;
    }

    public double getTimesTableNum() {
        return timesTableNum;
    }

    public void setTimesTableNum(double timesTableNum) {
        this.timesTableNum = timesTableNum;
    }

    public void incrementTimesTableNum(double stepNum) {
        // TODO: Increment the timesTableNumber by the given
        //  stepNum.

        this.timesTableNum = timesTableNum + stepNum;
    }

    /**
     * Increment the "r" instance variable from 0 up to 1
     * then decrement back down to 0 then repeat.
     */
    private void incrementRed() {

        if (Double.compare(r, 0) <= 0) {
            increment = true;
        }

        if (Double.compare(r, 1) >= 0) {
            increment = false;
        }
        if (increment) {
            r += 0.1;
        }
        if (!increment) {
            r -= 0.1;
        }
    }


        /**
         * Generates all of the lines within the circle.
         * The color of each line is determined by the "r" instance variable
         * and the "g" and "b" arguments are kept constant.
         */
        public Group generateLines ( double numPoints){
            incrementRed();
            // TODO: Make a new color using r for the red value and whichever
            //  value you want for green and blue.

            double green = 0.5;
            double blue = 0.5;
            Color color = new Color(r, green, blue, .70);

            Group lines = new Group();
            PointOnCircle[] points = PointOnCircle.generatePoints(radius, numPoints);
            /**
             * Loop over each point and draw a line from it to the result
             * of the equation discussed in the video.
             */
            for (PointOnCircle poc : points) {
                // Generates the id of the point to draw a line to from
                //  the current point you are at. 

                double correspondingPointId = (((poc.getId() * getTimesTableNum()) % numPoints));
                PointOnCircle pointTo = points[(int) correspondingPointId];
                PointOnCircle pointFrom = points[poc.getId()];

                Line line = new Line(pointFrom.getX(), pointFrom.getY(), pointTo.getX(), pointTo.getY()); 

                line.setStroke(color);

                lines.getChildren().add(line);
            }
            return lines;
        }
    }


