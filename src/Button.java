import javax.swing.JButton;

public class Button extends JButton {
    public Button(int x, int y, int width, int height, String text) {
        this.setBounds(x, y, width, height);
        this.setText(text);
        this.setVisible(true);
    }
}
