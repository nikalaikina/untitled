package by.bsuir.untitled.model;

import java.awt.*;

public class Ray {
    private final Point start;
    private final double angle; // radians
    private int length = 0;

    public static final int delta = 5;

    public Ray(Point start, double angle) {
        this.start = start;
        this.angle = angle;
    }

    public Point getEnd() {
        return start;
    }

    public int getLength() {
        return length;
    }

    public void lengthen() {
        length += delta;
    }

    public void lengthen(int delta) {
        length += delta;
    }

    public Segment getSegment() {
        Point end = new Point(
                (int) (start.getX() + (length * Math.cos(angle))),
                (int) (start.getY() - (length * Math.sin(angle))));

        return new Segment(start, end);
    }

}
