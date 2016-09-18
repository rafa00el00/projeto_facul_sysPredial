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
   protected ArrayList<Usuario> funcionarios;
   
   public GuiUsuario(){
      super(Idiomas.getString("GuiUsuario.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      funcionarios = new ArrayList<Usuario>();
      btnEnviarConfg = new JButton("Enviar Configura��o");
      //dados para teste
      Object[] colunas = {"CPF","Nome","Empresa","hor�rio de acesso ","Privilegio","OBJ"};
      Vector<Vector> dados = new Vector<Vector>();
      
      for (int i =0;i <=5;i++){
         Usuario fn = new Usuario();
         fn.setCPF("CPF"+i);
         fn.setNome("N"+i);
         fn.setEmpresa(new Empresa("Cnpj"+i,"Empresa "+i));
         fn.setHoraAcesso("H"+i);
         fn.setPrivilegio("P"+i);      
         funcionarios.add(fn);
      }
      
      
      for(Usuario fn : funcionarios){
         Vector v = new Vector();
         v.add(fn.getCPF());
         v.add(fn.getNome());
         v.add(fn.getEmpresa().getRazaoSocial());
         v.add(fn.getHoraAcesso());
         v.add(fn.getPrivilegio());
         v.add(fn);
         dados.add(v);
      }
      
                           
      CarregaTabela(dados,colunas);
      
      btnNovo.addActionListener(this);
      btnAlterar.addActionListener(this);
      btnDeletar.addActionListener(this);
      pnlButtons.add(btnEnviarConfg);
      super.repaint();
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