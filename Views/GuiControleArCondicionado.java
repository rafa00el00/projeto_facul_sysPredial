package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import languages.*;

public class GuiControleArCondicionado extends JFrame  implements ActionListener{

   private JLabel lblStatus,lblEmpresa, lblTemperatura,lblHorarioFuncionamento;
   private JComboBox cmbEmpresa;
   private JSpinner spinner;
   private JButton btnOk,btnCancel;
   
   public GuiControleArCondicionado(){
      super();
      setTitle(Idiomas.getString("GuiControleArCondicionado.title"));
      setLayout(new GridLayout(9,1,5,5));
      setSize(200,500);
      
      lblStatus = new JLabel(Idiomas.getString("GuiControleArCondicionado.lblStatus") + " Desligado");
      lblEmpresa = new JLabel(Idiomas.getString("GuiControleArCondicionado.lblEmpresa")+" Carvalho novo");
      lblTemperatura = new JLabel(Idiomas.getString("GuiControleArCondicionado.lblTemperatura"));
      lblHorarioFuncionamento = new JLabel(Idiomas.getString("GuiControleArCondicionado.lblHorarioFuncionamento") + "8:00 - 18:00");
      
      btnOk = new JButton(Idiomas.getString("GuiControleArCondicionado.btnOk"));
      btnCancel = new JButton(Idiomas.getString("GuiControleArCondicionado.btnCancel"));
      
      
      //Numeric Up Down
      SpinnerModel model =
        new SpinnerNumberModel(23, //initial value
                               16, //min
                               27, //max
                               1);  //step
      spinner = new JSpinner(model);
      
      //Adiciona
      add(lblStatus);
      add(lblEmpresa);
      add(lblTemperatura);
      add(spinner);
      add(lblHorarioFuncionamento);
       add(btnOk);
      add(btnCancel);
   }
   
   public void actionPerformed(ActionEvent e){
      
      if(e.getSource() == btnOk){
      
      }else if(e.getSource() == btnCancel){
      
      }
   
   }

}