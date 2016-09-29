package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import languages.*;
import Models.*;
import Controllers.*;

public class GuiCadEmpresa extends JDialog implements ActionListener{
     
   private JLabel lblCNPJ, lblRazaoSocial, lblConjunto, lblhorafuncionamento, lblArcondicionado;
   private JTextField txtCNPJ, txtRazaoSocial, txtConjunto, txthorafuncionamento, txtArcondicionado;
   private JButton btnOk,btnCancel;

   public GuiCadEmpresa(JFrame fr,boolean op,Empresa emp){
      this(fr,op);
      txtCNPJ.setText(emp.getCnpj());
      txtRazaoSocial.setText(emp.getRazaoSocial());
      txtConjunto.setText(emp.getCnpj());
      txthorafuncionamento.setText(emp.getHorarioAbertura().toString());
      txtArcondicionado.setText(emp.getTemperaturaPadrao()+ "");

      
   }

   public GuiCadEmpresa(JFrame fr,boolean op){
      super(fr,true);
      setTitle(Idiomas.getString("GuiCadEmpresa.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setSize(250,400);
      setLayout(new GridLayout(7,2,5,5));
      
      
      lblCNPJ= new JLabel(Idiomas.getString("GuiCadEmpresa.lblCNPJ"));
      lblRazaoSocial= new JLabel(Idiomas.getString("GuiCadEmpresa.lblRazaoSocial"));
      lblConjunto= new JLabel(Idiomas.getString("GuiCadEmpresa.lblConjunto"));
      lblhorafuncionamento= new JLabel(Idiomas.getString("GuiCadEmpresa.lblhorafuncionamento"));
      lblArcondicionado= new JLabel(Idiomas.getString("GuiCadEmpresa.lblArcondicionado"));
     
           
      txtCNPJ = new JTextField();
      txtRazaoSocial = new JTextField();
      txtConjunto = new JTextField();
      txthorafuncionamento = new JTextField();
      txtArcondicionado = new JTextField();
      
     
           
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
      add(txtConjunto);
      add(lblhorafuncionamento);
      add(txthorafuncionamento);
      add(lblhorafuncionamento);
      add(txthorafuncionamento);
      add(lblArcondicionado);
      add(txtArcondicionado);
      add(btnOk);
      add(btnCancel);
      
   }
   
   public void actionPerformed(ActionEvent e){
      if (e.getSource() == btnCancel){
      }
      else if(e.getSource() == btnOk){
      }
   
   }
   
}