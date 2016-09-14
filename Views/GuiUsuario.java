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
   protected ArrayList<Funcionario> funcionarios;
   
   public GuiUsuario(){
      super(Idiomas.getString("GuiUsuario.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      funcionarios = new ArrayList<Funcionario>();
      btnEnviarConfg = new JButton("Enviar Configuração");
      //dados para teste
      Object[] colunas = {"CPF","Nome","Empresa","horário de acesso ","Privilegio"};
      Vector<Vector> dados = new Vector<Vector>();
      
      for (int i =0;i <=5;i++){
         Funcionario fn = new Funcionario();
         fn.setCPF("CPF"+i);
         fn.setNome("N"+i);
         fn.setEmpresa(new Empresa("Cnpj"+i,"Empresa "+i));
         fn.setHoraAcesso("H"+i);
         fn.setPrivilegio("P"+i);
         funcionarios.add(fn);
      }
      
      
      for(Funcionario fn : funcionarios){
         Vector v = new Vector();
         v.add(fn.getCPF());
         v.add(fn.getNome());
         v.add(fn.getEmpresa().getRazaoSocial());
         v.add(fn.getHoraAcesso());
         v.add(fn.getPrivilegio());
         dados.add(v);
      }
      
                           
      CarregaTabela(dados,colunas);
      
      btnNovo.addActionListener(this);
      pnlButtons.add(btnEnviarConfg);
      super.repaint();
   }
   
   public void actionPerformed(ActionEvent e){
      if (e.getSource() == btnNovo){
         GuiCadUsuarios cad = new GuiCadUsuarios(this,false);
         cad.setVisible(true);
      }
      else if (e.getSource() == btnAlterar){
         GuiCadUsuarios cad = new GuiCadUsuarios(this,true);
         cad.setVisible(true);
      }
      else if(e.getSource() == btnDeletar){
      
      }
   }
}