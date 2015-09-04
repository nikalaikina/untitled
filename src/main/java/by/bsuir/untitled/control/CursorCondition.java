package by.bsuir.untitled.control;

import org.springframework.stereotype.Component;

@Component
public class CursorCondition {
    private int numberOfRays = 1;
    private double angle = 0;
    private double angleDelta = 0.00000001;

    private Rotator rotator;

    public void incNumberOfRays() {
        numberOfRays++;
    }

    public void incNumberOfRays(int delta) {
        numberOfRays += delta;
    }

    public void decNumberOfRays() {
        if (numberOfRays > 1) {
            numberOfRays--;
        }
    }

    public void incAngle() {
        angle += angleDelta;
    }

    public int getNumberOfRays() {
        return numberOfRays;
    }

    public double getAngle() {
        return angle;
    }

    public void start() {
        angle = 0;
        rotator = new Rotator();
        rotator.start();
    }

    public void stop() {
        System.out.println("stop " + rotator);
        if (rotator != null) {
            rotator.interrupt();
        }
    }

    class Rotator extends Thread {

        @Override
        public void run() {
            while(!isInterrupted()) {
                incAngle();
            }
            System.out.println("interrupted");
        }
    }
}



