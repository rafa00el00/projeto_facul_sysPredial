package Views;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import languages.*;
import Models.*;
import Funcoes.*;
import Controllers.*;

public class GuiUsuario extends GuiConsultar implements ActionListener{
   
   protected JButton btnEnviarConfg;
   private Object[] colunas = {"CPF","Nome","Empresa","horário de acesso ","Privilegio","OBJ"};

   
   public GuiUsuario(MyList<Usuario> funcionarios){
      super(Idiomas.getString("GuiUsuario.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      btnEnviarConfg = new JButton("Enviar Configuração");
      //dados para teste
             
      
      atualizarTabela(funcionarios);
      
      btnNovo.addActionListener(this);
      btnAlterar.addActionListener(this);
      btnDeletar.addActionListener(this);
      btnPesquisar.addActionListener(this);
      pnlButtons.add(btnEnviarConfg);
      lblPesquisar.setText("Nome:");
      super.repaint();
   }
   
   
public void atualizarTabela(MyList list){
      MyList<Usuario> listU = list;
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
        /* GuiCadUsuarios cad = new GuiCadUsuarios(this,false);
         cad.setVisible(true);*/
         UsuarioController.incluir(this);
      }
      else if (e.getSource() == btnAlterar){
         if (tblConsulta.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(null,"Por favor selecione um registro!");
            return;
         }
         //Retorna o objeto de usuario da tabela
         Usuario usr = (Usuario)tblConsulta.getValueAt(tblConsulta.getSelectedRow(), tblConsulta.getColumnCount() -1);
         UsuarioController.alterar(this, usr);
      }
      else if(e.getSource() == btnDeletar){
         if (tblConsulta.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(null,"Por favor selecione um registro!");
            return;
         }
         //Retorna o objeto de usuario da tabela
         Usuario usr = (Usuario)tblConsulta.getValueAt(tblConsulta.getSelectedRow(), tblConsulta.getColumnCount() -1);
         int resp = JOptionPane.showConfirmDialog(null,"Deseja realmente deletar o Usuario " + usr.getNome() + "?"
        		 ,"Confirmar exclução!",JOptionPane.YES_NO_OPTION);
         
         if (resp == JOptionPane.YES_OPTION){
        	 UsuarioController.deletar(usr);
         }
              
      }
      else if (e.getSource() == btnPesquisar){
       UsuarioController.consultar(txtPesquisar.getText(),this);

      }
      
      
   }
}