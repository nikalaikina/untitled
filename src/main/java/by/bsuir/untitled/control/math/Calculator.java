package by.bsuir.untitled.control.math;

import by.bsuir.untitled.model.Segment;

import java.awt.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Calculator {


    public static double distance(Point a, Point b) {
        return sqrt(sqr(a.getX() - b.getX()) + sqr(a.getY() - b.getY()));
    }

    private static double sqrDistance(Segment s) {
        return sqrDistance(s.getStart(), s.getEnd());
    }

    private static double sqrDistance(Point a, Point b) {
        return sqr(a.getX() - b.getX()) + sqr(a.getY() - b.getY());
    }

    private static double sqr(double x) {
        return pow(x, 2);
    }

    public static double distance(Point point, Segment segment) {
        double a = sqrDistance(point, segment.getStart());
        double b = sqrDistance(point, segment.getEnd());
        double c = sqrDistance(segment);

        if (a >= b + c) return (int) sqrt(b);
        if (b >= a + c) return (int) sqrt(a);

        a = sqrt(a);
        b = sqrt(b);
        c = sqrt(c);

        double p = (a + b + c) / 2;
        double s = sqrt((p - a) * (p - b) * (p - c) * p);

        return s * 2 / c;
    }

    public static double angle(Segment ray, Point proection) {
        int difX = proection.x - ray.getEnd().x;
        int difY = proection.y - ray.getEnd().y;
        Segment halfdif = new Segment(proection, ray.getEnd());
        Point newEnd = new Point(ray.getStart().x + difX, ray.getStart().y + difY);
        Point angle = new Point(newEnd.x - ray.getEnd().x, newEnd.y - ray.getEnd().y);
        return Math.atan2(angle.y, angle.x);
    }


}
