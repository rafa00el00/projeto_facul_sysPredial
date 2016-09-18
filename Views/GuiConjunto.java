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
      Object[] colunas = {"Conjunto","Andar","preco alugel","tamanho","ocupado","OBJ"};
                                 

      Vector<Vector> dados = new Vector<Vector>();
      for(Conjunto cj : conjuntos){
         Vector v = new Vector();
         v.add(cj.getNrConjunto());
         v.add(cj.getAndar());
         v.add(cj.getAlugel());
         v.add(cj.getTamanho());
         v.add(cj.getOcupado());
         v.add(cj);
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
          if (tblConsulta.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(null,"Por favor selecione um registro!");
            return;
         }
         //Retorna o objeto de usuario da tabela
         Conjunto coj = (Conjunto)tblConsulta.getValueAt(tblConsulta.getSelectedRow(), tblConsulta.getColumnCount() -1);
         GuiCadConjunto cad = new GuiCadConjunto(this,true);
         cad.setVisible(true);
      }
      else if(e.getSource() == btnDeletar){
      
      }
   }

}