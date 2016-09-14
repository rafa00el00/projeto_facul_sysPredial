package Funcoes;
import java.util.ArrayList;
import javax.swing.*;
import Models.*;
public class Login{
   
   
   private StringBuilder txtArquivo;
   private ManipulaTxt mnpTxt;
   private ArrayList<String>  cadastro;
   private ArrayList<Usuario> usuarios;
      
   public Login(){
      mnpTxt = new ManipulaTxt("users.txt");
      cadastro = new ArrayList<String>();
      usuarios = new ArrayList<Usuario>();
   }
   
   
   public void carregarLogins(){
      txtArquivo = mnpTxt.toStringBuilder();
      String[] linhas, user;
      linhas = txtArquivo.toString().split(";");
      
      for (int i = 0; i < linhas.length; i++){
         user = linhas[i].split(":");
         usuarios.add(new Usuario(user[0],user[1],user[2]));
      }
      
   }
   
   public void setLogin(String userName, String senha, String privilegio){
      cadastro.add(userName.replace(":","").replace(";","") + ":" +
                     senha.replace(":","").replace(";","") + ":" + 
                     privilegio.replace(":","").replace(";","") + ";");
        for (int i = 0;i < cadastro.size();i++){
            mnpTxt.setText(cadastro.get(i));
        }
         mnpTxt.fecharArquivo();                     
      JOptionPane.showMessageDialog(null,"Cadastrado!");
   }
   
   public Usuario logar(String userName, String senha){
      carregarLogins();
      return getLoginLinear(userName, senha);
   }
   
   public Usuario getLoginLinear(String userName, String senha){
      for (int i  = 0; i < usuarios.size();i++){
         if (((Usuario) usuarios.get(i)).getLogin().equals(userName)){
            if (((Usuario) usuarios.get(i)).getSenha().equals(senha)){
               return ((Usuario) usuarios.get(i));
            }
            return null;
         }
      }
      return null;
   }
      
   
}