package Views;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Controllers.EmpresaController;
import Funcoes.MyList;
import Models.Conjunto;
import Models.Empresa;
import languages.*;

public class GuiCadEmpresa extends JDialog implements ActionListener{
     
   private JLabel lblCNPJ, lblRazaoSocial, lblConjunto,
   lblhoraAberto,lblhoraFechado, lblIniAr,lblFimAr,lblTempAr;
   private JTextField txtCNPJ, txtRazaoSocial;
   private JComboBox<Conjunto> cmbConjunto;
   private JFormattedTextField txthoraAberto,txthoraFecha,txtIniAr,txthoraFimAr,txtTempAr;
   private JButton btnOk,btnCancel;
   
   private Empresa empresa;
   private MyList<Conjunto> lstConjuntos;
   
   public void setLstConjunto(MyList<Conjunto> lstConjuntos) {
		this.lstConjuntos = lstConjuntos;
		cmbConjunto.removeAll();
		for (Conjunto item : lstConjuntos) {
			cmbConjunto.addItem(item);
		}
	}

	public MyList<Conjunto> getLstConjunto() {
		return this.lstConjuntos;
	}

   public GuiCadEmpresa(JFrame fr,boolean op,Empresa emp){
      this(fr,op);
      empresa = emp;
      txtCNPJ.setText(emp.getCnpj());
      txtRazaoSocial.setText(emp.getRazaoSocial());
      txthoraAberto.setText(emp.getHorarioAbertura().toString().substring(0, 5));
      txthoraFecha.setText(emp.getHorarioFechamento().toString().substring(0, 5));
      txtIniAr.setText(emp.getHoraIniAr().toString().substring(0, 5));
      txthoraFimAr.setText(emp.getHoraFimAr().toString().substring(0, 5));
      txtTempAr.setText(emp.getTemperaturaPadrao()+"");
      if (emp.getConjunto().getId() != 0){
      cmbConjunto.insertItemAt(emp.getConjunto(), 0);
      cmbConjunto.setSelectedIndex(0);
      }
   }

   public GuiCadEmpresa(JFrame fr,boolean op){
      super(fr,true);
      setTitle(Idiomas.getString("GuiCadEmpresa.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setSize(250,400);
      setLayout(new GridLayout(11,2,5,5));
      
      
      lblCNPJ= new JLabel(Idiomas.getString("GuiCadEmpresa.lblCNPJ"));
      lblRazaoSocial= new JLabel(Idiomas.getString("GuiCadEmpresa.lblRazaoSocial"));
      lblConjunto= new JLabel(Idiomas.getString("GuiCadEmpresa.lblConjunto"));
      lblhoraAberto= new JLabel(Idiomas.getString("GuiCadEmpresa.lblhoraAberto"));
      lblhoraFechado = new JLabel(Idiomas.getString("GuiCadEmpresa.lblhoraFechado"));
      lblIniAr= new JLabel(Idiomas.getString("GuiCadEmpresa.lblIniAr"));
      lblFimAr = new JLabel(Idiomas.getString("GuiCadEmpresa.lblFimAr"));
      lblTempAr = new JLabel(Idiomas.getString("GuiCadEmpresa.lblTempAr"));
      
      MaskFormatter maskHora = null;
      try {
		maskHora = new MaskFormatter("##:##");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      txtCNPJ = new JTextField();
      txtRazaoSocial = new JTextField();
      cmbConjunto = new JComboBox();
      txthoraAberto = new JFormattedTextField(maskHora);
      txthoraFecha = new JFormattedTextField(maskHora);
      txtIniAr = new JFormattedTextField(maskHora);
      txthoraFimAr = new JFormattedTextField(maskHora);
      try {
		txtTempAr= new JFormattedTextField(new MaskFormatter("##"));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
           
      if (op){
         btnOk = new JButton(Idiomas.getString("GuiCadEmpresa.btnOk2"));
      }
      else{
         btnOk = new JButton(Idiomas.getString("GuiCadEmpresa.btnOk1"));
      }
      
      btnCancel = new JButton(Idiomas.getString("GuiCadEmpresa.btnCancel"));
      
      btnOk.addActionListener(this);
      btnCancel.addActionListener(this);
      
      add(lblCNPJ);
      add(txtCNPJ);
      add(lblRazaoSocial);
      add(txtRazaoSocial);
      add(lblConjunto);
      add(cmbConjunto);
      add(lblTempAr);
      add(txtTempAr);
      add(lblhoraAberto);
      add(txthoraAberto);
      add(lblhoraFechado);
      add(txthoraFecha);
      add(lblIniAr);
      add(txtIniAr);
      add(lblFimAr);
      add(txthoraFimAr);
      add(btnOk);
      add(btnCancel);
     
   }
   
   public void actionPerformed(ActionEvent e){
      if (e.getSource() == btnCancel){
    	 //dispose();
    	  txtCNPJ.setText("123456789900");
          txtRazaoSocial.setText("teste");
          txthoraAberto.setText("10:00");
          txthoraFecha.setText("14:00");
          txtIniAr.setText("10:30");
          txthoraFimAr.setText("13:30");
          txtTempAr.setText("11");
      }
      else if(e.getSource() == btnOk){
    	  if (empresa == null){
    		  empresa = new Empresa();
    	  }
    	  
    	  empresa.setCnpj(txtCNPJ.getText());
    	  empresa.setHoraFimAr(Time.valueOf(txthoraFimAr.getText()+":00"));
    	  empresa.setHorarioAbertura(Time.valueOf(txthoraAberto.getText()+":00"));
    	  empresa.setHorarioFechamento(Time.valueOf(txthoraFecha.getText()+":00"));
    	  empresa.setHoraIniAr(Time.valueOf(txtIniAr.getText()+":00"));
    	  empresa.setRazaoSocial(txtRazaoSocial.getText());
    	  empresa.setTemperaturaPadrao(Integer.parseInt(txtTempAr.getText()));
    	  empresa.setConjunto(((Conjunto)cmbConjunto.getSelectedItem()));

    	  if (empresa.getId() <=0){
    		  EmpresaController.incluir(empresa);
    	  }else{
    		  EmpresaController.alterar(empresa);
    	  }
    	  
    	  JOptionPane.showMessageDialog(null, "Ação Concluida!");
      }
   
   }
   
}