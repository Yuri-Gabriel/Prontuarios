import java.awt.Color;

import javax.swing.JTextField;

public class InputArea extends JTextField{
    public InputArea(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setBackground(new Color(255, 255, 255));
        this.setVisible(true);
    }
}
