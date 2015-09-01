package by.bsuir.untitled.control;

import by.bsuir.untitled.model.Model;
import by.bsuir.untitled.view.Canvas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Artist {

    @Autowired
    private Model model;

    @Autowired
    private Canvas canvas;

    @Scheduled(fixedRate = 15)
    public void redraw() {
        model.inc();
        canvas.redraw(model.getModel());
    }
}
