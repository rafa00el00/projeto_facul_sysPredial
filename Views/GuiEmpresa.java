package Views;

import javax.swing.*;
import javax.swing.table.*;

import Controllers.EmpresaController;
import Controllers.UsuarioController;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Date;
import languages.*;
import Models.*;
import Funcoes.*;

public class GuiEmpresa extends GuiConsultar implements ActionListener {

	private MyList<Empresa> empresas;
	private Object[] colunas = { "CNPJ", "Razão Social", "horário de funcionamento", "ar-condicionado", "OBJ" };

	public GuiEmpresa(MyList<Empresa> empresas) {
		super(Idiomas.getString("GuiEmpresa.title"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.empresas = new MyList<Empresa>();

		atualizarTabela(empresas);

		btnNovo.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnDeletar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		lblPesquisar.setText("Razão Social:");
		super.repaint();
	}

	@Override
	public void atualizarTabela(MyList list) {
		MyList<Empresa> listU = list;
		Vector<Vector> dados = new Vector<Vector>();
		for (Empresa ep : listU) {
			Vector v = new Vector();
			v.add(ep.getCnpj());
			v.add(ep.getRazaoSocial());
			v.add(String.format("%tT\n", ep.getHorarioAbertura())
					+" - " + String.format("%tT\n", ep.getHorarioFechamento()));
			v.add(ep.getTemperaturaPadrao() + " - "
					+ String.format("%tT\n", ep.getHoraIniAr())+
					" - " + String.format("%tT\n", ep.getHoraFimAr()));
			v.add(ep);
			dados.add(v);
		}

		CarregaTabela(dados, colunas);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNovo) {
			EmpresaController.incluir(this);
		} else if (e.getSource() == btnAlterar) {
			if (tblConsulta.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(null, "Por favor selecione um registro!");
				return;
			}
			// Retorna o objeto de usuario da tabela
			Empresa emp = (Empresa) tblConsulta.getValueAt(tblConsulta.getSelectedRow(),
					tblConsulta.getColumnCount() - 1);

			EmpresaController.alterar(this, emp);
		} else if (e.getSource() == btnDeletar) {
			if (tblConsulta.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(null, "Por favor selecione um registro!");
				return;
			}
			// Retorna o objeto de usuario da tabela
			Empresa emp = (Empresa) tblConsulta.getValueAt(tblConsulta.getSelectedRow(),
					tblConsulta.getColumnCount() - 1);
			 int resp = JOptionPane.showConfirmDialog(null,"Deseja realmente deletar a empresa " + emp.getRazaoSocial() + "?"
	        		 ,"Confirmar exclução!",JOptionPane.YES_NO_OPTION);
	         
	         if (resp == JOptionPane.YES_OPTION){
	        	 EmpresaController.deletar(emp);
	         }
            JOptionPane.showMessageDialog(null, "Deletado!");        

		} else if(e.getSource() == btnPesquisar){
			EmpresaController.consultar(txtPesquisar.getText(), this);
		}
	}

}