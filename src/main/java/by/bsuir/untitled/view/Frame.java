package by.bsuir.untitled.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class Frame extends JFrame {

    private final int width = 400;
    private final int height = 400;

    @Autowired
    public Frame(Canvas canvas) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, height);
        add(canvas);
    }
}
