package by.bsuir.untitled.model;

import java.awt.*;
import java.util.Objects;

public class Ray {

    private final Point start;
    private final double angle; // radians
    private int length = 0;

    private static final int delta = 5;

    public Ray(Point start, double angle) {
        this.start = start;
        this.angle = angle;
    }

    public Point getEnd() {
        return new Point(
                (int) (start.getX() + (length * Math.cos(angle))),
                (int) (start.getY() - (length * Math.sin(angle))));
    }

    public Point getStart() {
        return start;
    }

    public int getLength() {
        return length;
    }

    public boolean lengthen() {
        if (Math.abs(getEnd().getX()) < 1000 && Math.abs(getEnd().getY()) < 1000) {
            length += delta;
            return true;
        }
        return false;
    }

    public Segment getSegment() {
        return new Segment(start, getEnd());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return Objects.equals(angle, ray.angle) &&
                Objects.equals(start, ray.start);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, angle);
    }
}
