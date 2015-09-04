package by.bsuir.untitled;

import by.bsuir.untitled.view.Frame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(Main::createAndShowGui);
    }

    private static void createAndShowGui() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Frame frame = context.getBean(Frame.class);
        frame.setVisible(true);
    }
}
