package Internacionalizacao;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TelaExemplo extends JFrame implements ActionListener {

   private JLabel rt;
   private JComboBox cb;
   private ResourceBundle bn = null;

   public void escolhaIdioma(String lingua, String pais) {
      
      Locale.setDefault(new Locale(lingua, pais));
      Locale locale = Locale.getDefault();
      bn = ResourceBundle.getBundle("Internacionalizacao.Ex1", locale);
      rt.setText(bn.getString("tela1.rotulo.valor") + ":");
      setTitle(bn.getString("tela1.titulo"));
      
   }

   public TelaExemplo() { // Menu simples de escolha de idioma
   
   // Escolhe Layout do conteiner
      Container cx = getContentPane();
      cx.setLayout(new FlowLayout());
   
   // Instanciação dos objetos
      rt = new JLabel("Valor:");
      cb = new JComboBox();
   // Inclusão no container
      cx.add(cb);
      cx.add(rt);
   // Adicionando itens no combobox       
      cb.addItem("Portugues");
      cb.addItem("Ingles");
      cb.addItem("Frances");
   // Registro no listener dos objetos controlados
      // bt.addActionListener(this);
      cb.addActionListener(this);
   // Ajustes finais do frame
      setTitle("Exemplo");
      setSize(200, 104);
      setVisible(true);
   }
// Implementacao do metodo da interface ActionListener

   public void actionPerformed(ActionEvent e) {
   
      if (cb.getSelectedIndex() == 0) {
         escolhaIdioma("pt", "BR");
      } 
      else if (cb.getSelectedIndex() == 1) {
         escolhaIdioma("en", "US");
      } 
      else if (cb.getSelectedIndex() == 2) {
         escolhaIdioma("fr", "FR");
      } 
   
   }

   public static void main(String args[]) {
      TelaExemplo exemplo = new TelaExemplo();
      exemplo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
