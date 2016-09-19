package Views;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import languages.*;
import Models.*;


public class GuiUsuario extends GuiConsultar implements ActionListener{
   
   protected JButton btnEnviarConfg;
   private Object[] colunas = {"CPF","Nome","Empresa","horário de acesso ","Privilegio","OBJ"};

   
   public GuiUsuario(ArrayList<Usuario> funcionarios){
      super(Idiomas.getString("GuiUsuario.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      btnEnviarConfg = new JButton("Enviar Configuração");
      //dados para teste
           
      
      for (int i =0;i <=5;i++){
         Usuario fn = new Usuario();
         fn.setCPF("CPF"+i);
         fn.setNome("N"+i);
         fn.setEmpresa(new Empresa("Cnpj"+i,"Empresa "+i));
         fn.setHoraAcesso("H"+i);
         fn.setHoraSaida("S"+i);      
         funcionarios.add(fn);
      }
      
      
      atualizarTabela(funcionarios);
      
      btnNovo.addActionListener(this);
      btnAlterar.addActionListener(this);
      btnDeletar.addActionListener(this);
      pnlButtons.add(btnEnviarConfg);
      super.repaint();
   }
   
   public void atualizarTabela(ArrayList list){
      ArrayList<Usuario> listU = list;
       Vector<Vector> dados = new Vector<Vector>();
      for(Usuario fn : listU){
         Vector v = new Vector();
         v.add(fn.getCPF());
         v.add(fn.getNome());
         v.add(fn.getEmpresa().getRazaoSocial());
         v.add(fn.getHoraAcesso());
         v.add(fn.getHoraSaida());
         v.add(fn);
         dados.add(v);
      }
      CarregaTabela(dados,colunas);

   }
   
   public void actionPerformed(ActionEvent e){
      if (e.getSource() == btnNovo){
         GuiCadUsuarios cad = new GuiCadUsuarios(this,false);
         cad.setVisible(true);
      }
      else if (e.getSource() == btnAlterar){
         if (tblConsulta.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(null,"Por favor selecione um registro!");
            return;
         }
         //Retorna o objeto de usuario da tabela
         Usuario usr = (Usuario)tblConsulta.getValueAt(tblConsulta.getSelectedRow(), tblConsulta.getColumnCount() -1);
         GuiCadUsuarios cad = new GuiCadUsuarios(this,true,usr);
         cad.setVisible(true);
      }
      else if(e.getSource() == btnDeletar){
         if (tblConsulta.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(null,"Por favor selecione um registro!");
            return;
         }
         //Retorna o objeto de usuario da tabela
         Usuario usr = (Usuario)tblConsulta.getValueAt(tblConsulta.getSelectedRow(), tblConsulta.getColumnCount() -1);
         //int resp = JOptionPane.showCofirmDialog("Deseja realmente deletar o Usuario " + usr.getNome() + "?");
         
         /*
         *implementar o deletar
         */
      
      }
   }
}