package by.bsuir.untitled.control;

import by.bsuir.untitled.model.Model;
import by.bsuir.untitled.model.Ray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

@Component
public class MouseController extends MouseAdapter implements MouseListener, MouseWheelListener {

    @Autowired
    private CursorCondition cursorCondition;

    @Autowired
    private Model model;

    @Override
    public void mousePressed(MouseEvent e) {
        cursorCondition.start();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        cursorCondition.stop();
        double angle = cursorCondition.getAngle();
        double deltaAngle = Math.PI * 2 / cursorCondition.getNumberOfRays();

        for (int i = 0; i < cursorCondition.getNumberOfRays(); i++) {
            model.startRay(new Ray(e.getPoint(), angle + i * deltaAngle));
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
         cursorCondition.incNumberOfRays(e.getWheelRotation() < 0 ? -1 : 1);
    }
}
