package by.bsuir.untitled.control.math;

import by.bsuir.untitled.model.Segment;

import java.awt.*;

import static by.bsuir.untitled.control.math.Calculator.distance;

public class Proector {

    private double e = 5;
    private final double koef = 0.9;
    private Segment ray;
    private Segment s;
    private final int xkoef;
    private final int ykoef;

    private Point proection = null;

    public static void main(String[] args) throws InterruptedException {
        Segment s = new Segment(new Point(0, 5), new Point(6, 2));
        Segment ray = new Segment(new Point(1, 2), new Point(4, 3));
        Proector proector = new Proector(ray, s);
        System.out.println("ans " + proector.proect());
    }

    public Proector(Segment ray, Segment s) {
        this.ray = ray;
        this.s = s;
        xkoef = (s.getEnd().getX() - s.getStart().getX() > 0) ? 1 : -1;
        ykoef = (s.getEnd().getY() - s.getStart().getY() > 0) ? 1 : -1;
    }

    public Point proect() {
        Point answer = new Point(ray.getEnd());

        System.out.println("gd " + getDif(answer));
        System.out.println("rs " + distance(ray.getStart(), s));

        for (double step = 1000; getDif(answer) > e; step *= koef) {
            Point left = new Point((int)(answer.x - step * xkoef), (int)(answer.y - step * ykoef));
            Point right = new Point((int)(answer.x + step * xkoef), (int)(answer.y + step * ykoef));

            answer = (getDif(left) < getDif(right)) ? left : right;
            System.out.println(step + " step " + answer);
            System.out.println("dif " + getDif(answer));

            try {
                Thread.sleep(10);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }

        proection = answer;
        return answer;
    }

    public Point getProection() {
        return proection;
    }

    private double getDif(Point guess) {
        return distance(guess, ray.getStart()) - distance(ray.getStart(), s);
    }

}
