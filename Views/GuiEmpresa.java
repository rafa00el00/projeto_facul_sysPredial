package Views;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import languages.*;


public class GuiEmpresa extends GuiConsultar implements ActionListener{
   
   public GuiEmpresa(){
      super(Idiomas.getString("GuiEmpresa.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      //dados para teste
      Object[] colunas = {"CNPJ","Razão Social","Conjunto","horário de funcionamento","ar-condicionado"};
      Object[][] linhas = {
                           {"000000000000","Madereira da Silva","01","8:00 - 18:00","23º, 8:00 - 18:00"},
                           {"111111111111","Cabelereiro Marina","09","7:00 - 22:00","18º, 10:00 - 18:00"},
                           {"222222222222","Ednaldo Pereira Musicas","88","10:00 - 15:00","16º, 10:00 - 15:00"}
                           };
      DefaultTableModel dtm = new DefaultTableModel(linhas,colunas);
      tblConsulta.setModel(dtm);
      
      
      btnNovo.addActionListener(this);
      btnAlterar.addActionListener(this);
      btnDeletar.addActionListener(this);
      super.repaint();
   }
   public void actionPerformed(ActionEvent e){
      if (e.getSource() == btnNovo){
         GuiCadEmpresa cad = new GuiCadEmpresa(this,false);
         cad.setVisible(true);
      }else if (e.getSource() == btnAlterar){
         GuiCadEmpresa cad = new GuiCadEmpresa(this,true);
         cad.setVisible(true);
      }else if(e.getSource() == btnDeletar){
      
      }
   }

}