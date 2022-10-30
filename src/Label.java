import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class Label extends JLabel {
    public Label(int x, int y, int width, int height, String text) {
        this.setText(text);
        this.setFont(new Font("Arial", Font.PLAIN, 12));
        this.setForeground(new Color(0, 0, 0));
        this.setBackground(new Color(255, 255, 255));
        this.setBounds(x, y, width, height);
        this.setVisible(true);
    }
}
