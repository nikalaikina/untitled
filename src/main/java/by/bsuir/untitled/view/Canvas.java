package by.bsuir.untitled.view;

import by.bsuir.untitled.control.MouseController;
import by.bsuir.untitled.model.Model;
import by.bsuir.untitled.model.Segment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Component
public class Canvas extends JPanel {

    private final int width = 350;
    private final int height = 300;

    @Autowired
    private Model model;

    @Autowired
    public Canvas(MouseController mouseController) {
        setSize(width, height);
        addMouseListener(mouseController);
        setVisible(true);
    }

    public void redraw(List<Segment> segments) {
        segments.stream().forEach(this::drawSegment);
    }

    private void drawSegment(Segment segment) {
        int x1 = (int) segment.getStart().getX();
        int y1 = (int) segment.getStart().getY();
        int x2 = (int) segment.getEnd().getX();
        int y2 = (int) segment.getEnd().getY();

        getGraphics().drawLine(x1, y1, x2, y2);
    }


}
