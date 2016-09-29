package Views;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Date;
import languages.*;
import Models.*;
import Funcoes.*;


public class GuiEmpresa extends GuiConsultar implements ActionListener{
   
   private MyList<Empresa> empresas;
   private Object[] colunas = {"CNPJ","Razão Social","horário de funcionamento","ar-condicionado","OBJ"};

   public GuiEmpresa(){
      super(Idiomas.getString("GuiEmpresa.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      empresas = new MyList<Empresa>();
      
      
      atualizarTabela(empresas);
            
      
      btnNovo.addActionListener(this);
      btnAlterar.addActionListener(this);
      btnDeletar.addActionListener(this);
      super.repaint();
   }
   
   
   public void atualizarTabela(MyList list){
      MyList<Usuario> listU = list;
      Vector<Vector> dados = new Vector<Vector>();
      for(Empresa ep : empresas){
         Vector v = new Vector();
         v.add(ep.getCnpj());
         v.add(ep.getRazaoSocial());
         v.add(String.format("%tD\n",ep.getHorarioAbertura()));
         v.add(ep.getTemperaturaPadrao() + " - " + String.format("%tT\n",ep.getHoraIniAr()));
         v.add(ep);
         dados.add(v);
      }
      
                           
      CarregaTabela(dados,colunas);
   
   }

   
   
   public void actionPerformed(ActionEvent e){
      if (e.getSource() == btnNovo){
         GuiCadEmpresa cad = new GuiCadEmpresa(this,false);
         cad.setVisible(true);
      }
      else if (e.getSource() == btnAlterar){
         if (tblConsulta.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(null,"Por favor selecione um registro!");
            return;
         }
         //Retorna o objeto de usuario da tabela
         Empresa emp = (Empresa)tblConsulta.getValueAt(tblConsulta.getSelectedRow(), tblConsulta.getColumnCount() -1);
      
         GuiCadEmpresa cad = new GuiCadEmpresa(this,true,emp);
         cad.setVisible(true);
      }
      else if(e.getSource() == btnDeletar){
         if (tblConsulta.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(null,"Por favor selecione um registro!");
            return;
         }
         //Retorna o objeto de usuario da tabela
         Empresa emp = (Empresa)tblConsulta.getValueAt(tblConsulta.getSelectedRow(), tblConsulta.getColumnCount() -1);
      
      }
   }

}