package Views;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import languages.*;
import Models.*;
import Funcoes.*;
import Controllers.*;


public class GuiCadUsuarios extends JDialog implements ActionListener{
   private JLabel lblCPF,lblNome,lblEmpresa,lblHoraEntra,lblHoraSaida, lblPrivilegio,lblLogin,lblPwd;
   private JTextField txtCPF,txtNome,txtLogin;
   private JPasswordField txtPwd;
   private JComboBox cmbPrivilegio;
   private JButton btnOk,btnCancel;
   private String[] privilegio;
   private Usuario usr;
   private JComboBox cmbEmpresa;
   private JFormattedTextField txtHorarioEntrada,txtHorarioSaida;
   private MyList<Empresa> lstEmpresas;
   
   public void setLstEmpresas(MyList<Empresa> lstEmpresas){
      this.lstEmpresas = lstEmpresas;
   }
   
   public MyList<Empresa> getLstEmpresas(){
      return this.lstEmpresas;
   }
   
   
   public GuiCadUsuarios(JFrame fr,boolean op,Usuario usr){
      this(fr,op);
      this.usr = usr;
      
      txtLogin.setText(usr.getLogin());
      txtPwd.setText(usr.getSenha());
      txtCPF.setText(usr.getCPF());
      txtNome.setText(usr.getNome());
      txtHorarioEntrada.setText(usr.getHoraAcesso());
      txtHorarioSaida.setText(usr.getHoraSaida());
      //privilegio
      /*
      if (usr.getPerfil() == "AD"){
         cmbPrivilegio.setSelectedIndex(0);
      }else if (usr.getPerfil() == "AT"){
         cmbPrivilegio.setSelectedIndex(1);
      }else if (usr.getPerfil() == "FN"){
         cmbPrivilegio.setSelectedIndex(2);
      }
   */
   }

   public GuiCadUsuarios(JFrame fr,boolean op){
      super(fr,true);
      setTitle(Idiomas.getString("GuiCadUsuario.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setSize(250,400);
      setLayout(new GridLayout(11,2,5,5));
      
      
      lblCPF= new JLabel(Idiomas.getString("GuiCadUsuario.lblCPF"));
      lblNome= new JLabel(Idiomas.getString("GuiCadUsuario.lblNome"));
      lblEmpresa= new JLabel(Idiomas.getString("GuiCadUsuario.lblEmpresa"));
      lblHoraEntra= new JLabel(Idiomas.getString("GuiCadUsuario.lblHoraEntra"));
      lblHoraSaida= new JLabel(Idiomas.getString("GuiCadUsuario.lblHoraSaida"));
      lblPrivilegio = new JLabel(Idiomas.getString("GuiCadUsuario.lblPrivilegio"));
      lblPwd = new JLabel(Idiomas.getString("GuiCadUsuario.lblPwd"));
      lblLogin = new JLabel(Idiomas.getString("GuiCadUsuario.lblLogin"));
      
      txtCPF = new JTextField();
      txtNome = new JTextField();
      //txtEmpresa = new JTextField();
      cmbEmpresa = new JComboBox();
   
      txtHorarioEntrada = new JFormattedTextField();
      txtHorarioSaida = new JFormattedTextField();
      txtLogin = new JTextField();
      txtPwd = new JPasswordField();
      
      MaskFormatter maskHora = null;
      try {
         maskHora = new MaskFormatter("##:##");
      } 
      catch (Exception e) {
      	// TODO Auto-generated catch block
         e.printStackTrace();
         return;
      }
      maskHora.install(txtHorarioEntrada);
      maskHora.install(txtHorarioSaida);
                  
      lstEmpresas = new MyList<Empresa>();
      cmbPrivilegio = new JComboBox(lstEmpresas.toArray());
      privilegio = new String[3];
      privilegio[0] = ("AD");
      privilegio[1] = ("AT");
      privilegio[2] = ("FN");
      cmbPrivilegio.addItem(Idiomas.getString("GuiCadUsuario.cmbPrivilegio.Admin"));
      cmbPrivilegio.addItem(Idiomas.getString("GuiCadUsuario.cmbPrivilegio.Atendente"));
      cmbPrivilegio.addItem(Idiomas.getString("GuiCadUsuario.cmbPrivilegio.Funcionario"));
      
      if (op){
         btnOk = new JButton(Idiomas.getString("GuiCadUsuario.btnOk2"));
      }
      else{
         btnOk = new JButton(Idiomas.getString("GuiCadUsuario.btnOk1"));
      }
      
      btnCancel = new JButton(Idiomas.getString("GuiCadUsuario.btnCancel"));
      
      btnOk.addActionListener(this);
      btnCancel.addActionListener(this);
      
      add(lblLogin);
      add(txtLogin);
      add(lblPwd);
      add(txtPwd);
      add(lblCPF);
      add(txtCPF);
      add(lblNome);
      add(txtNome);
      add(lblEmpresa);
      add(cmbEmpresa);
      add(lblHoraEntra);
      add(txtHorarioEntrada);
      add(lblHoraSaida);
      add(txtHorarioSaida);
      add(lblPrivilegio);
      add(cmbPrivilegio);
      add(btnOk);
      add(btnCancel);
      
   }
   
   public void actionPerformed(ActionEvent e){
      if (e.getSource() == btnCancel){
      }
      else if(e.getSource() == btnOk){
         if(usr == null){
            usr = new Usuario();
         }
         
         usr.setLogin(txtLogin.getText());
         usr.setSenha(txtPwd.getText());
         usr.setCPF(txtCPF.getText());
         usr.setNome(txtNome.getText());
         usr.setEmpresa(new Empresa());
         usr.getEmpresa().setId(((Empresa)cmbEmpresa.getSelectedItem()).getId());
         usr.setHoraAcesso(txtHorarioEntrada.getText());
         usr.setHoraSaida(txtHorarioSaida.getText());
         usr.setPerfil(privilegio[cmbPrivilegio.getSelectedIndex()]);
         System.out.println(usr.getPerfil());
         if(usr.getId()!=0){
            //alterar
            UsuarioController.alterar(usr);
            JOptionPane.showMessageDialog(null,"Alterado!");
         
         }
         else{
            //cadastrar
            UsuarioController.incluir(usr);
            JOptionPane.showMessageDialog(null,"Cadastrado!");
         }
         
      }
   
   }  
}