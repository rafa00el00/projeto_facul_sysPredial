package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import languages.*;

public class GuiCadUsuarios extends JDialog implements ActionListener{
     
   private JLabel lblCPF,lblNome,lblEmpresa,lblHoraEntra,lblHoraSaida, lblPrivilegio;
   private JTextField txtCPF,txtNome,txtEmpresa,txtHorarioEntrada,txtHorarioSaida;
   private JComboBox cmbPrivilegio;
   private JButton btnOk,btnCancel;
   private String[] privilegio;

   public GuiCadUsuarios(JFrame fr,boolean op){
      super(fr,true);
      setTitle(Idiomas.getString("GuiCadUsuario.title"));
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setSize(250,400);
      setLayout(new GridLayout(7,2,5,5));
      
      
      lblCPF= new JLabel(Idiomas.getString("GuiCadUsuario.lblCPF"));
      lblNome= new JLabel(Idiomas.getString("GuiCadUsuario.lblNome"));
      lblEmpresa= new JLabel(Idiomas.getString("GuiCadUsuario.lblEmpresa"));
      lblHoraEntra= new JLabel(Idiomas.getString("GuiCadUsuario.lblHoraEntra"));
      lblHoraSaida= new JLabel(Idiomas.getString("GuiCadUsuario.lblHoraSaida"));
      lblPrivilegio = new JLabel(Idiomas.getString("GuiCadUsuario.lblPrivilegio"));
      
      txtCPF = new JTextField();
      txtNome = new JTextField();
      txtEmpresa = new JTextField();
      txtHorarioEntrada = new JTextField();
      txtHorarioSaida = new JTextField();
      
      
      cmbPrivilegio = new JComboBox();
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
      
      add(lblCPF);
      add(txtCPF);
      add(lblNome);
      add(txtNome);
      add(lblEmpresa);
      add(txtEmpresa);
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
      }
   
   }
   
}