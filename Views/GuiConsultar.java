package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import languages.*;


public abstract class GuiConsultar extends JFrame{
   
   protected JTable tblConsulta;
   protected JLabel lblPesquisar;
   protected JTextField txtPesquisar;
   protected JButton btnNovo,btnAlterar,btnDeletar,btnPesquisar;
   private JScrollPane scrollPnl;
   protected JPanel pnlButtons;
   
   public GuiConsultar(String titulo){
      super();
      setTitle(titulo);
      setSize(800,500);
      setLayout(new BorderLayout());
         
      tblConsulta = new JTable();
                  
      //Imagens
      ImageIcon imgNovo,imgAlt,imgDel;
      imgNovo = new ImageIcon(getClass().getResource("../imgs/novo.png"));
      imgAlt = new ImageIcon(getClass().getResource("../imgs/alt.png"));
      imgDel = new ImageIcon(getClass().getResource("../imgs/delete.png"));
      
      //Pesquisar
      JPanel pnlPesquisar = new JPanel();
      pnlPesquisar.setLayout(new BorderLayout());
      lblPesquisar = new JLabel(Idiomas.getString("GuiConsultar.lblPesquisar"));
      txtPesquisar = new JTextField();
      btnPesquisar = new JButton(Idiomas.getString("GuiConsultar.btnPesquisar"));
      pnlPesquisar.add(lblPesquisar,BorderLayout.WEST);
      pnlPesquisar.add(txtPesquisar,BorderLayout.CENTER);
      pnlPesquisar.add(btnPesquisar,BorderLayout.EAST);
      
      //Botoes
       pnlButtons = new JPanel();
      pnlButtons.setLayout(new GridLayout(9,1,5,5));
      btnNovo = new JButton(imgNovo);
      btnAlterar = new JButton(imgAlt);
      btnDeletar = new JButton(imgDel);
      pnlButtons.add(btnNovo);
      pnlButtons.add(btnAlterar);
      pnlButtons.add(btnDeletar);
      
      //Table
      scrollPnl = new JScrollPane(tblConsulta);
      
      //Add no Geral
      add(scrollPnl,BorderLayout.CENTER);
      add(pnlPesquisar,BorderLayout.NORTH);
      add(pnlButtons,BorderLayout.WEST);
   
   }
   
   
}