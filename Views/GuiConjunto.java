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
import Funcoes.*;


public class GuiConjunto extends GuiConsultar implements ActionListener{
   

   Object[] colunas = {"Conjunto","Andar","preco alugel","tamanho","ocupado","OBJ"};

   
   public GuiConjunto(MyList<Conjunto> conjuntos){
      super(Idiomas.getString("GuiConjunto.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      //dados para teste
                                       
   
      atualizarTabela(conjuntos);      
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
         ConjuntoController.alterar(this,coj);
      }
      else if(e.getSource() == btnDeletar){
         if (tblConsulta.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(null,"Por favor selecione um registro!");
            return;
         }
         //Retorna o objeto de usuario da tabela
         Conjunto coj = (Conjunto)tblConsulta.getValueAt(tblConsulta.getSelectedRow(), tblConsulta.getColumnCount() -1);
         
         /*
            Confirmar acesso
         */
         
         ConjuntoController.deletar(coj);
      
      }
   }
   
   public void atualizarTabela(MyList list){
      MyList<Conjunto> listC = list;
      Vector<Vector> dados = new Vector<Vector>();
      for(Conjunto cj : listC){
         Vector v = new Vector();
         v.add(cj.getNrConjunto());
         v.add(cj.getAndar());
         v.add(cj.getAlugel());
         v.add(cj.getTamanho());
         v.add(cj.isOcupado());
         v.add(cj);
         dados.add(v);
      }
      CarregaTabela(dados,colunas);
   
   }


}