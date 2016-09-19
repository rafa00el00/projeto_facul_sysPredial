package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import languages.*;
import Models.*;
import Controllers.*;

public class GuiMenu extends JFrame implements ActionListener{
   
   private JMenu mnuArquivo, mnuUsuario,mnuEmpresa,mnuConjunto,mnuArCondicionado,mnuIdiomas;
   private JMenuItem mnuItExit,mnuItConsultarConjunto,mnuItConsultarEmpresa,mnuItConsultarUsuario
   ,mnuItAlterarArCondicionado,mnuItPT,mnuItEN,mnuItSP;
   private JLabel lblFundo;
   private Usuario usr;
   
   public GuiMenu(Usuario user){
      super(Idiomas.getString("GuiMenu.title"));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(600,500);
      this.usr = user;
      
      //Barra de Menu
      JMenuBar bar = new JMenuBar();
      setJMenuBar(bar);
      //Menu Arquivo
      mnuArquivo = new JMenu(Idiomas.getString("GuiMenu.mnuArquivo"));
      mnuArquivo.setMnemonic(Idiomas.getString("GuiMenu.mnuArquivo.mnemonico").charAt(0));
      mnuItExit = new JMenuItem(Idiomas.getString("GuiMenu.mnuArquivo.exit"));
      mnuItExit.setMnemonic(Idiomas.getString("GuiMenu.mnuArquivo.exit.mnemonico").charAt(0));
      mnuItExit.addActionListener(this);
      mnuArquivo.add(mnuItExit);
      
      //Menu Usuario
      mnuUsuario = new JMenu(Idiomas.getString("GuiMenu.mnuUsuario"));
      mnuUsuario.setMnemonic(Idiomas.getString("GuiMenu.mnuUsuario.mnemonico").charAt(0));
      mnuItConsultarUsuario = new JMenuItem(Idiomas.getString("GuiMenu.mnuUsuario.consultar"));
      mnuItConsultarUsuario.addActionListener(this);
      mnuUsuario.add(mnuItConsultarUsuario);
      
      
        //Menu Empresa
      mnuEmpresa = new JMenu(Idiomas.getString("GuiMenu.mnuEmpresa"));
      mnuEmpresa.setMnemonic(Idiomas.getString("GuiMenu.mnuEmpresa.mnemonico").charAt(0));
      mnuItConsultarEmpresa = new JMenuItem(Idiomas.getString("GuiMenu.mnuEmpresa.consultar"));
      mnuItConsultarEmpresa.addActionListener(this);
      mnuEmpresa.add(mnuItConsultarEmpresa);
            
        //Menu Conjunto
      mnuConjunto = new JMenu(Idiomas.getString("GuiMenu.mnuConjunto"));
      mnuConjunto.setMnemonic(Idiomas.getString("GuiMenu.mnuConjunto.mnemonico").charAt(0));
      mnuItConsultarConjunto = new JMenuItem(Idiomas.getString("GuiMenu.mnuConjunto.consultar"));
      mnuItConsultarConjunto.addActionListener(this);
      mnuConjunto.add(mnuItConsultarConjunto);
      
      
        //Menu ArCondicionado
      mnuArCondicionado = new JMenu(Idiomas.getString("GuiMenu.mnuArCondicionado"));
      mnuArCondicionado.setMnemonic(Idiomas.getString("GuiMenu.mnuArCondicionado.mnemonico").charAt(0));
      mnuItAlterarArCondicionado =  new JMenuItem(Idiomas.getString("GuiMenu.mnuArCondicionado.Alterar"));
      mnuItAlterarArCondicionado.addActionListener(this);
      mnuArCondicionado.add(mnuItAlterarArCondicionado);
        
   
   
           //Idiomas
      mnuIdiomas = new JMenu(Idiomas.getString("GuiMenu.mnuIdiomas"));
      mnuIdiomas.setMnemonic(Idiomas.getString("GuiMenu.mnuIdiomas.mnemonico").charAt(0));
      mnuItPT =  new JMenuItem(Idiomas.getString("GuiMenu.mnuIdiomas.mnuItPT"));
      mnuItPT.addActionListener(this);
      mnuIdiomas.add(mnuItPT);
      mnuItEN =  new JMenuItem(Idiomas.getString("GuiMenu.mnuIdiomas.mnuItEN"));
      mnuItEN.addActionListener(this);
      mnuIdiomas.add(mnuItEN);
      mnuItSP =  new JMenuItem(Idiomas.getString("GuiMenu.mnuIdiomas.mnuItSP"));
      mnuItSP.addActionListener(this);
      mnuIdiomas.add(mnuItSP);
      
      //AddMenus
      bar.add(mnuArquivo);
      bar.add(mnuUsuario);
      bar.add(mnuEmpresa);
      bar.add(mnuConjunto);
      bar.add(mnuArCondicionado); 
      if (user.getPerfil().equals("AD")){
         bar.add(mnuIdiomas);
      }
      
      
      ImageIcon img = new ImageIcon(getClass().getResource("../imgs/fundo.png"));
      lblFundo = new JLabel(img);
      
      add(lblFundo);
      
      //Controllers
      UsuarioController.init();
   }
   
   public void actionPerformed( ActionEvent e ) {
      
      if ( e.getSource() == mnuItExit ){
         System.exit(0);
      }
      else if (e.getSource() == mnuItConsultarUsuario){
         UsuarioController.consultar();
      }
      else if (e.getSource() == mnuItConsultarEmpresa){
         GuiEmpresa usr = new GuiEmpresa();
         usr.setVisible(true);
      }
      else if (e.getSource() == mnuItConsultarConjunto){
         GuiConjunto usr = new GuiConjunto();
         usr.setVisible(true);
      }
      else if (e.getSource() == mnuItAlterarArCondicionado){
         GuiControleArCondicionado usr = new GuiControleArCondicionado();
         usr.setVisible(true);
      }
      else if (e.getSource() == mnuItPT){
         Idiomas.changeIdioma(Idiomas.IDIOMASDISPONIVEIS.PT);
         GuiMenu mn = new GuiMenu(usr);
         mn.setVisible(true);
         dispose();
      }
      else if (e.getSource() == mnuItEN){
         Idiomas.changeIdioma(Idiomas.IDIOMASDISPONIVEIS.EN);
         GuiMenu mn = new GuiMenu(usr);
         mn.setVisible(true);
         dispose();
      }
      else if (e.getSource() == mnuItSP){
         Idiomas.changeIdioma(Idiomas.IDIOMASDISPONIVEIS.SP);
         GuiMenu mn = new GuiMenu(usr);
         mn.setVisible(true);
         dispose();
      }
      
   }
}