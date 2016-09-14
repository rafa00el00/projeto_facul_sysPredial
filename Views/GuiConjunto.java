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


public class GuiConjunto extends GuiConsultar implements ActionListener{
   
   public GuiConjunto(){
      super(Idiomas.getString("GuiConjunto.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      //dados para teste
      Object[] colunas = {"Conjunto","Andar","preco alugel","tamanho","ocupado"};
      Object[][] linhas = {
                           {"01","1","R$ 200,00","45m²","Sim"},
                           {"02","1","R$ 200,00","45m²","Não"},
                           {"09","3","R$ 300,00","50m²","Não"}
                           };
                           

      Vector<Vector> dados = new Vector<Vector>();
      for(Empresa ep : empresas){
         Vector v = new Vector();
         v.add(ep.getCnpj());
         v.add(ep.getRazaoSocial());
         v.add(String.format("%tD\n",ep.getHorarioFuncionamento()));
         v.add(ep.getTemperaturaPadrao() + " - " + String.format("%tT\n",ep.getHorarioArCondicionado()));
         dados.add(v);
      }

      
      btnNovo.addActionListener(this);
      btnAlterar.addActionListener(this);
      btnDeletar.addActionListener(this);
   
      super.repaint();
   }
   
   public void actionPerformed(ActionEvent e){
      if (e.getSource() == btnNovo){
         GuiCadConjunto cad = new GuiCadConjunto(this,false);
         cad.setVisible(true);
      }
      else if (e.getSource() == btnAlterar){
         GuiCadConjunto cad = new GuiCadConjunto(this,true);
         cad.setVisible(true);
      }
      else if(e.getSource() == btnDeletar){
      
      }
   }

}