package Views;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;

import languages.*;
import Models.*;
import Funcoes.*;
import Controllers.*;

public class GuiCadUsuarios extends JDialog implements ActionListener {
	private JLabel lblCPF, lblNome, lblEmpresa, lblHoraEntra, lblHoraSaida, lblPrivilegio, lblLogin, lblPwd;
	private JTextField txtCPF, txtNome, txtLogin;
	private JPasswordField txtPwd;
	private JComboBox cmbPrivilegio;
	private JButton btnOk, btnCancel;
	private String[] privilegio;
	private Usuario usr;
	private JComboBox cmbEmpresa;
	private JFormattedTextField txtHorarioEntrada, txtHorarioSaida;
	private MyList<Empresa> lstEmpresas;

	public void setLstEmpresas(MyList<Empresa> lstEmpresas) {
		this.lstEmpresas = lstEmpresas;
		cmbEmpresa.removeAll();
		for (Empresa item : lstEmpresas) {
			cmbEmpresa.addItem(item);
		}
	}

	public MyList<Empresa> getLstEmpresas() {
		return this.lstEmpresas;
	}

	public GuiCadUsuarios(JFrame fr, boolean op, Usuario usr,MyList<Empresa> empresas) {
		this(fr, op);
		this.usr = usr;
		setLstEmpresas(empresas);
		txtLogin.setText(usr.getLogin());
		txtPwd.setText(usr.getSenha());
		txtCPF.setText(usr.getCPF());
		txtNome.setText(usr.getNome());
		txtHorarioEntrada.setText(usr.getHoraAcesso().toString().substring(0, 5));
		txtHorarioSaida.setText(usr.getHoraSaida().toString().substring(0, 5));
		
		for (int i = 0 ; i < cmbEmpresa.getItemCount();i++){
			if (((Empresa)cmbEmpresa.getItemAt(i)).getId() == usr.getEmpresa().getId()){
				cmbEmpresa.setSelectedIndex(i);
			}
		}
		
		// privilegio

		if (usr.getPerfil().equals("AD")) {
			cmbPrivilegio.setSelectedIndex(0);
		} else if (usr.getPerfil().equals("AT")) {
			cmbPrivilegio.setSelectedIndex(1);
		} else if (usr.getPerfil().equals("FN")) {
			cmbPrivilegio.setSelectedIndex(2);
		} else if (usr.getPerfil().equals("CM")) {
			cmbPrivilegio.setSelectedIndex(2);
		}
		txtLogin.setEnabled(false);
	}

	public GuiCadUsuarios(JFrame fr, boolean op) {
		super(fr, true);
		setTitle(Idiomas.getString("GuiCadUsuario.title"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(250, 400);
		setLayout(new GridLayout(11, 2, 5, 5));

		lblCPF = new JLabel(Idiomas.getString("GuiCadUsuario.lblCPF"));
		lblNome = new JLabel(Idiomas.getString("GuiCadUsuario.lblNome"));
		lblEmpresa = new JLabel(Idiomas.getString("GuiCadUsuario.lblEmpresa"));
		lblHoraEntra = new JLabel(Idiomas.getString("GuiCadUsuario.lblHoraEntra"));
		lblHoraSaida = new JLabel(Idiomas.getString("GuiCadUsuario.lblHoraSaida"));
		lblPrivilegio = new JLabel(Idiomas.getString("GuiCadUsuario.lblPrivilegio"));
		lblPwd = new JLabel(Idiomas.getString("GuiCadUsuario.lblPwd"));
		lblLogin = new JLabel(Idiomas.getString("GuiCadUsuario.lblLogin"));

		txtCPF = new JTextField();
		txtNome = new JTextField();
		// txtEmpresa = new JTextField();
		lstEmpresas = new MyList<Empresa>();
		cmbEmpresa = new JComboBox(lstEmpresas.toArray());

		MaskFormatter maskHora = null;
		try {
			maskHora = new MaskFormatter("##:##");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		txtHorarioEntrada = new JFormattedTextField(maskHora);
		txtHorarioSaida = new JFormattedTextField(maskHora);
		txtLogin = new JTextField();
		txtPwd = new JPasswordField();

		cmbPrivilegio = new JComboBox();
		privilegio = new String[4];
		privilegio[0] = ("AD");
		privilegio[1] = ("AT");
		privilegio[2] = ("FN");
		privilegio[3] = ("CM");
		cmbPrivilegio.addItem(Idiomas.getString("GuiCadUsuario.cmbPrivilegio.Admin"));
		cmbPrivilegio.addItem(Idiomas.getString("GuiCadUsuario.cmbPrivilegio.Atendente"));
		cmbPrivilegio.addItem(Idiomas.getString("GuiCadUsuario.cmbPrivilegio.Funcionario"));
		cmbPrivilegio.addItem(Idiomas.getString("GuiCadUsuario.cmbPrivilegio.comum"));

		if (op) {
			btnOk = new JButton(Idiomas.getString("GuiCadUsuario.btnOk2"));
		} else {
			btnOk = new JButton(Idiomas.getString("GuiCadUsuario.btnOk1"));
		}

		btnCancel = new JButton(Idiomas.getString("GuiCadUsuario.btnCancel"));

		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);

		add(lblLogin);
		add(txtLogin);
		add(lblPwd);
		add(txtPwd);
		add(lblCPF);
		add(txtCPF);
		add(lblNome);
		add(txtNome);
		add(lblEmpresa);
		add(cmbEmpresa);
		add(lblHoraEntra);
		add(txtHorarioEntrada);
		add(lblHoraSaida);
		add(txtHorarioSaida);
		add(lblPrivilegio);
		add(cmbPrivilegio);
		add(btnOk);
		add(btnCancel);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
		} else if (e.getSource() == btnOk) {
			if (usr == null) {
				usr = new Usuario();
			}

			usr.setLogin(txtLogin.getText());
			usr.setSenha(txtPwd.getText());
			usr.setCPF(txtCPF.getText());
			usr.setNome(txtNome.getText());
			usr.setEmpresa(new Empresa());
			usr.getEmpresa().setId(((Empresa) cmbEmpresa.getSelectedItem()).getId());
			usr.setHoraAcesso(Time.valueOf(txtHorarioEntrada.getText() + ":00"));
			usr.setHoraSaida(Time.valueOf(txtHorarioSaida.getText() + ":00"));
			usr.setPerfil(privilegio[cmbPrivilegio.getSelectedIndex()]);
			System.out.println(usr.getPerfil());
			if (usr.getId() != 0) {
				// alterar
				UsuarioController.alterar(usr);
				JOptionPane.showMessageDialog(null, "Alterado!");

			} else {
				// cadastrar
				UsuarioController.incluir(usr);
				JOptionPane.showMessageDialog(null, "Cadastrado!");
			}

		}

	}
}