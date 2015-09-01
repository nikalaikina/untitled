package foo.bar;

import javax.swing.*;

public class Canvas extends JPanel {
    public Canvas() {
        addMouseListener(new MouseController());
    }


}
