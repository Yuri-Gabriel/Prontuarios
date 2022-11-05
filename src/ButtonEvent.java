import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ButtonEvent implements ActionListener {
	
    private Button searchButton;
    private Button getNames;
    private JFrame window;
    private InputArea searchTextInput;
    private InputArea saveFileTextInput;
    private File file;
    private String fileAndPath;
    private Button pathOnSaveBtn;
    
    public ButtonEvent(Button searchButton,
    		Button getNames,
    		Button pathOnSaveBtn,
    		JFrame window,
    		InputArea searchTextInput,
    		InputArea saveFileTextInput,
    		String fileAndPath) {
        this.searchButton = searchButton;
        this.window = window;
        this.searchTextInput = searchTextInput;
        this.getNames = getNames;
        this.fileAndPath = fileAndPath;
        this.pathOnSaveBtn = pathOnSaveBtn;
        this.saveFileTextInput = saveFileTextInput;
    }
    @Override
	public void actionPerformed(ActionEvent event) {
    	try {
    		if(event.getSource() == this.searchButton) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fc.showOpenDialog(this.window);

                this.file = fc.getSelectedFile();
                this.searchTextInput.setText(file.getAbsolutePath());
            } else if (event.getSource() == this.pathOnSaveBtn) {
            	if (this.file != null) {
            		JFileChooser fc = new JFileChooser();
                    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    fc.showOpenDialog(this.window);
                    
                    String filePath = fc.getSelectedFile().getAbsolutePath();
                    
                    this.fileAndPath = String.format("%s / nomes.txt".replaceAll(" ", ""), filePath);
                    this.saveFileTextInput.setText(this.fileAndPath);
            	} else {
            		boxMenssage("Selecione um diretorio primeiro");
            	}
            } else if (event.getSource() == this.getNames) {
            	if (this.fileAndPath != null) {
            		saveFileOnPath();
            	} else {
            		boxMenssage("Selecione um diretorio primeiro");
            	}
            	
            }
    	} catch (Exception e) {
    		boxMenssage("Erro: " + e.getMessage());
    	}
        
    }
    public void saveFileOnPath() {
    	try {
    		String[] arquivos = this.file.list();
            for (int i = 0; i < arquivos.length; i++) {
                if(arquivos[i].contains(".pdf")) {
                	String[] name = {
                			arquivos[i].substring(0, 5).trim(),
                			arquivos[i].substring(5, arquivos[i].length() - 10).trim(),
                	};
                	this.writeText(this.fileAndPath, String.format("%s = %s", name[1], name[0]));
                }
            }
            boxMenssage("Arquivo salvo em: \n" + this.fileAndPath);
    	} catch (Exception e) {
    		boxMenssage("Erro: " + e.getMessage());
    	}
        
    }
    
    public void writeText(String path, String text) {
        try (
            FileWriter creatorOfFile = new FileWriter(path, true);
            BufferedWriter buffer = new BufferedWriter(creatorOfFile);
            PrintWriter writerOfFile = new PrintWriter(buffer);
        ) {
            writerOfFile.append(String.format("%s \n", text));
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
    
    private void boxMenssage(String text) {
    	JOptionPane.showMessageDialog(null, text);
    }
}
