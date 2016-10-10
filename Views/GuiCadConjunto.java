package Views;

import javax.swing.*;

import Controllers.ConjuntoController;

import java.awt.*;
import java.awt.event.*;
import languages.*;
import Models.*;

public class GuiCadConjunto extends JDialog implements ActionListener {

	private JLabel lblConjunto, lblAndar, lblPreco, lblTamanho, lblOcupado;
	private JTextField txtConjunto, txtAndar, txtPreco, txtTamanho;
	private JComboBox cmbOcupado;
	private JButton btnOk, btnCancel;
	private Conjunto conjunto;

	public GuiCadConjunto(JFrame fr, boolean op, Conjunto conjunto) {
		this(fr, op);
		this.conjunto = conjunto;
		txtConjunto.setText(conjunto.getNrConjunto());
		txtAndar.setText(conjunto.getAndar());
		txtPreco.setText(conjunto.getAlugel() + "");
		txtTamanho.setText(conjunto.getTamanho() + "");
		// cmbOcupado.setSelectedIndex(conjunto.isOcupado());
	}

	public GuiCadConjunto(JFrame fr, boolean op) {
		super(fr, true);
		setTitle(Idiomas.getString("GuiCadConjunto.title"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(250, 400);
		setLayout(new GridLayout(7, 2, 5, 5));

		lblConjunto = new JLabel(Idiomas.getString("GuiCadConjunto.lblConjunto"));
		lblAndar = new JLabel(Idiomas.getString("GuiCadConjunto.lblAndar"));
		lblPreco = new JLabel(Idiomas.getString("GuiCadConjunto.lblPreco"));
		lblTamanho = new JLabel(Idiomas.getString("GuiCadConjunto.lblTamanho"));

		txtConjunto = new JTextField();
		txtAndar = new JTextField();
		txtPreco = new JTextField();
		txtTamanho = new JTextField();

		if (op) {
			btnOk = new JButton(Idiomas.getString("GuiCadConjunto.btnOk2"));
		} else {
			btnOk = new JButton(Idiomas.getString("GuiCadConjunto.btnOk1"));
		}

		btnCancel = new JButton(Idiomas.getString("GuiCadConjunto.btnCancel"));

		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);

		add(lblConjunto);
		add(txtConjunto);
		add(lblAndar);
		add(txtAndar);
		add(lblPreco);
		add(txtPreco);
		add(lblTamanho);
		add(txtTamanho);

		add(btnOk);
		add(btnCancel);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			System.exit(0);
		} else if (e.getSource() == btnOk) {
			if (conjunto == null) {
				conjunto = new Conjunto();
			}

			conjunto.setNrConjunto(txtConjunto.getText());
			conjunto.setAndar(txtAndar.getText());
			conjunto.setAlugel(Double.parseDouble(txtPreco.getText()));
			conjunto.setTamanho(Integer.parseInt(txtConjunto.getText()));
			conjunto.setOcupado(false);

			if (conjunto.getId() == 0) {
				ConjuntoController.incluir(conjunto);
				JOptionPane.showMessageDialog(null, "Cadastrado!");
			} else {
				ConjuntoController.alterar(conjunto);
				JOptionPane.showMessageDialog(null, "Alterado!");
			}
			this.dispose();
		}

	}

}