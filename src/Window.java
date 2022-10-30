import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame {

    private Button searchButton;
    private InputArea textInput;
    private Button getNames;
    private String fileName;


    public void Run() {
        this.setTitle("Pegar lista de nomes no geral");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(new Color(255, 0, 0));
        
        this.textInput = new InputArea(110, 50, 240, 20);
        this.add(this.textInput);
        
        Label pathOnSavelbl = new Label(20, 90, 70, 20, "Salvar em:");
        this.add(pathOnSavelbl);
        InputArea pathOnSaveInput = new InputArea(110, 90, 240, 20);
        this.add(pathOnSaveInput);
        Button pathOnSaveBtn = new Button(360, 90, 100, 20, "Procurar");
        this.add(pathOnSaveBtn);
        
        this.searchButton = new Button(360, 50, 100, 20, "Procurar");
        this.getNames = new Button(160, 150, 150, 20, "Pegar nomes");
        ButtonEvent event = new ButtonEvent(this.searchButton, this.getNames, pathOnSaveBtn, this, this.textInput, pathOnSaveInput, this.fileName);
        this.searchButton.addActionListener(event);
        this.getNames.addActionListener(event);
        pathOnSaveBtn.addActionListener(event);
        this.add(this.searchButton);
        this.add(this.getNames);
        
        Label searchLabel = new Label(20, 50, 100, 20, "Procurar pasta:");
        this.add(searchLabel);
        
        Label lbl = new Label(490, 290, 10, 10, " ");
        this.add(lbl);
        
        this.setVisible(true);
        
    }
}
