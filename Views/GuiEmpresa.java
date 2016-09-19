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


public class GuiEmpresa extends GuiConsultar implements ActionListener{
   
   private ArrayList<Empresa> empresas;
   private Object[] colunas = {"CNPJ","Razão Social","horário de funcionamento","ar-condicionado","OBJ"};

   public GuiEmpresa(){
      super(Idiomas.getString("GuiEmpresa.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      empresas = new ArrayList<Empresa>();
      
      //dados para teste
                                       
      for (int i =0;i <=5;i++){
         Empresa ep = new Empresa();
         ep.setCnpj("CNPJ"+i);
         ep.setRazaoSocial("N"+i);
         ep.setHorarioFuncionamento(new Date());
         ep.setTemperaturaPadrao(i);
         ep.setHorarioArCondicionado(new Date());
         empresas.add(ep);
      }
   atualizarTabela(empresas);
            
      
      btnNovo.addActionListener(this);
      btnAlterar.addActionListener(this);
      btnDeletar.addActionListener(this);
      super.repaint();
   }
   
   public void atualizarTabela(ArrayList list){
      ArrayList<Usuario> listU = list;
       Vector<Vector> dados = new Vector<Vector>();
      for(Empresa ep : empresas){
         Vector v = new Vector();
         v.add(ep.getCnpj());
         v.add(ep.getRazaoSocial());
         v.add(String.format("%tD\n",ep.getHorarioFuncionamento()));
         v.add(ep.getTemperaturaPadrao() + " - " + String.format("%tT\n",ep.getHorarioArCondicionado()));
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