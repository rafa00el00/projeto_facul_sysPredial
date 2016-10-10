package Views;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import languages.*;
import Models.*;
import Funcoes.*;
import Controllers.*;

public class GuiRegistroAcesso extends GuiConsultar implements ActionListener{
   
   protected JButton btnEnviarConfg;
   private Object[] colunas = {"Data Acesso","Nome Funcionario","Acesso","OBJ"};

   
   public GuiRegistroAcesso(MyList<RegistroAcesso> acessos){
      super(Idiomas.getString("GuiRegistroAcesso.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      btnEnviarConfg = new JButton("Enviar Configuração");
      //dados para teste
             
      
      atualizarTabela(acessos);
      
      btnNovo.addActionListener(this);
      btnAlterar.addActionListener(this);
      btnDeletar.addActionListener(this);
      btnPesquisar.addActionListener(this);
      remove(pnlButtons);
      lblPesquisar.setText("Nome:");
      super.repaint();
   }
   
   
public void atualizarTabela(MyList list){
      MyList<RegistroAcesso> listA = list;
      Vector<Vector> dados = new Vector<Vector>();
      for(RegistroAcesso ra : listA){
         Vector v = new Vector();
         v.add(ra.getDataAcesso());
         v.add(ra.getUsuario().getLogin());
         v.add(ra.getTipo());
         v.add(ra);
         dados.add(v);
      }
      CarregaTabela(dados,colunas);
   
   }
   
   public void actionPerformed(ActionEvent e){
      if (e.getSource() == btnPesquisar){
       UsuarioController.consultarAcesso(txtPesquisar.getText(),this);

      }
      
      
   }
}