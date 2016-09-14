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
   
     private ArrayList<Conjunto> conjuntos;

   
   public GuiConjunto(){
      super(Idiomas.getString("GuiConjunto.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      //dados para teste
      Object[] colunas = {"Conjunto","Andar","preco alugel","tamanho","ocupado"};
                                 

      Vector<Vector> dados = new Vector<Vector>();
      for(Conjunto cj : conjuntos){
         Vector v = new Vector();
         v.add(cj.getNrConjunto());
         v.add(cj.getAndar());
         v.add(cj.getAlugel());
         v.add(cj.getTamanho());
         v.add(cj.getOcupado());
         
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