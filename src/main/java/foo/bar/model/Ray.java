package foo.bar.model;

public class Ray {
    private final Point start;
    private final int angle;
    private int length = 0;

    public Ray(Point start, int angle) {
        this.start = start;
        this.angle = angle;
    }

    public Point getStart() {
        return start;
    }

    public int getAngle() {
        return angle;
    }

    public int getLength() {
        return length;
    }

    public void lengthen() {
        length++;
    }

    public void lengthen(int delta) {
        length += delta;
    }

    public Segment getSegment() {
        return new Segment(start, start); // TODO
    }

}
