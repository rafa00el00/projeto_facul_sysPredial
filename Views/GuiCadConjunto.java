package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import languages.*;

public class GuiCadConjunto extends JDialog implements ActionListener{
     
   private JLabel lblConjunto, lblAndar, lblPreco, lblTamanho, lblOcupado;
   private JTextField txtConjunto, txtAndar, txtPreco, txtTamanho;
   private JComboBox cmbOcupado;
   private JButton btnOk,btnCancel;

   public GuiCadConjunto(JFrame fr,boolean op){
      super(fr,true);
      setTitle(Idiomas.getString("GuiCadConjunto.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setSize(250,400);
      setLayout(new GridLayout(7,2,5,5));
      
      
      lblConjunto= new JLabel(Idiomas.getString("GuiCadConjunto.lblConjunto"));
      lblAndar= new JLabel(Idiomas.getString("GuiCadConjunto.lblAndar"));
      lblPreco= new JLabel(Idiomas.getString("GuiCadConjunto.lblPreco"));
      lblTamanho= new JLabel(Idiomas.getString("GuiCadConjunto.lblTamanho"));
      lblOcupado= new JLabel(Idiomas.getString("GuiCadConjunto.lblOcupado"));
     
           
      txtConjunto = new JTextField();
      txtAndar = new JTextField();
      txtPreco = new JTextField();
      txtTamanho = new JTextField();
      
      cmbOcupado = new JComboBox();
      cmbOcupado.addItem("Sim");
      cmbOcupado.addItem("Não");
            
           
      if (op){
         btnOk = new JButton(Idiomas.getString("GuiCadConjunto.btnOk2"));
      }
      else{
         btnOk = new JButton(Idiomas.getString("GuiCadConjunto.btnOk1"));
      }
      
      btnCancel = new JButton(Idiomas.getString("GuiCadConjunto.btnCancel"));
      
      btnOk.addActionListener(this);
      btnCancel.addActionListener(this);
      
      add(lblConjunto);
      add(txtConjunto);
      add(lblAndar);
      add(txtAndar);
      add(lblPreco);
      add(txtPreco);
      add(lblTamanho);
      add(txtTamanho);
      add(lblOcupado);
      add(cmbOcupado);
      add(btnOk);
      add(btnCancel);
      
   }
   
   public void actionPerformed(ActionEvent e){
      if (e.getSource() == btnCancel){
      }
      else if(e.getSource() == btnOk){
      }
   
   }
   
}