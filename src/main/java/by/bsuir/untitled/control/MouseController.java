package by.bsuir.untitled.control;

import by.bsuir.untitled.model.Model;
import by.bsuir.untitled.model.Ray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@Component
public class MouseController extends MouseAdapter implements MouseListener {

    @Autowired
    private CursorCondition cursorCondition;

    @Autowired
    private Model model;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        cursorCondition.start();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        cursorCondition.stop();
        model.startRay(new Ray(e.getPoint(), cursorCondition.getAngle()));
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
