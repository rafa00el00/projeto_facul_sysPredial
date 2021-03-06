package Views;

import javax.swing.*;

import Controllers.UsuarioController;

import java.awt.*;
import java.awt.event.*;
import languages.*;
import Funcoes.*;
import Models.*;

public class GuiLogin extends JDialog implements ActionListener {

	private JLabel lblLogin, lblSenha;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JButton btnOk, btnCancel;
	private Login login;

	public GuiLogin(JFrame fr) {
		super(fr, true);
		setTitle(Idiomas.getString("GuiLogin.title"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setSize(300, 150);
		setLayout(new GridLayout(3, 2, 5, 5));

		lblLogin = new JLabel(Idiomas.getString("GuiLogin.lblLogin"));
		lblSenha = new JLabel(Idiomas.getString("GuiLogin.lblSenha"));

		txtLogin = new JTextField();
		txtSenha = new JPasswordField();

		btnOk = new JButton(Idiomas.getString("GuiLogin.btnOk"));
		btnCancel = new JButton(Idiomas.getString("GuiLogin.btnCancel"));

		btnCancel.addActionListener(this);
		btnOk.addActionListener(this);

		add(lblLogin);
		add(txtLogin);
		add(lblSenha);
		add(txtSenha);
		add(btnOk);
		add(btnCancel);

		login = new Login();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			txtLogin.setText("Rafa");
			txtSenha.setText("123");
			// System.exit(0);
		} else if (e.getSource() == btnOk) {
			if (UsuarioController.logar(txtLogin.getText(), txtSenha.getText())) {
				JOptionPane.showMessageDialog(null, "Acesso Autorizado!");
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Usu�rio ou senha incorreto!");
			}
		}
	}

}