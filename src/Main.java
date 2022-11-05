import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		String password = JOptionPane.showInputDialog("Digite a senha: ");
		if (password.equals("Diuri4321$")) {
			Window window = new Window();
	        window.Run();
		} else {
			JOptionPane.showMessageDialog(null, "Senha errada! \n Acesso bloqueado");
		}
	}
}
