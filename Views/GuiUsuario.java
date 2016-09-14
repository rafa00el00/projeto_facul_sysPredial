package Views;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import languages.*;


public class GuiUsuario extends GuiConsultar implements ActionListener{
   
   protected JButton btnEnviarConfg;
   
   public GuiUsuario(){
      super(Idiomas.getString("GuiUsuario.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      btnEnviarConfg = new JButton("Enviar Configuração");
      //dados para teste
      Object[] colunas = {"CPF","Nome","Empresa","horário de acesso ","Privilegio"};
      Object[][] linhas = {
                           {"000000000000","Jose Goiaba","Predio","Livre","Sindico"},
                           {"111111111111","Maria Silva","Empresa 1","8:00 - 18:00","Funcionario"},
                           {"222222222222","Ednaldo Pereira","Predio","Livre","Atendente"}
                           };
      DefaultTableModel dtm = new DefaultTableModel(linhas,colunas);
      tblConsulta.setModel(dtm);
      
      btnNovo.addActionListener(this);
      pnlButtons.add(btnEnviarConfg);
      super.repaint();
   }
   
  public void actionPerformed(ActionEvent e){
      if (e.getSource() == btnNovo){
         GuiCadUsuarios cad = new GuiCadUsuarios(this,false);
         cad.setVisible(true);
      }else if (e.getSource() == btnAlterar){
         GuiCadUsuarios cad = new GuiCadUsuarios(this,true);
         cad.setVisible(true);
      }else if(e.getSource() == btnDeletar){
      
      }
   }
}