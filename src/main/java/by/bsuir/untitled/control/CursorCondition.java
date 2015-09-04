package by.bsuir.untitled.control;

import org.springframework.stereotype.Component;

@Component
class CursorCondition {

    private int numberOfRays = 1;
    private double angle = 0;
    private final double angleDelta = 0.00000001;
    private Rotator rotator;

    public void incNumberOfRays(int delta) {
        numberOfRays += delta;
        if (numberOfRays < 1) {
            numberOfRays = 1;
        }
    }

    private void incAngle() {
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
        if (rotator != null) {
            rotator.interrupt();
        }
    }

    private class Rotator extends Thread {

        @Override
        public void run() {
            while (!isInterrupted()) {
                incAngle();
            }
        }
    }
}



