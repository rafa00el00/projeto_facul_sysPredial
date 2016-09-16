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
      usuarios.clear();
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
      Usuario[] us = usuarios.toArray(new Usuario[usuarios.size()]);
      ordernarusuarios(us);
      Usuario u = new Usuario(userName,senha,"");
      return LoginBinario(us,u);
      //return getLoginLinear(userName, senha);
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
   
   public void ordernarusuarios(Usuario[] usrs){
      //Ordena com selection Sort
      Usuario aux;
      for (int i = 0; i < usrs.length; i++){
         for(int r = i+1;r<usrs.length;r++){
            if(usrs[i].getLogin().compareTo(usrs[r].getLogin()) > 0){
               aux =usrs[i];
               usrs[i] = usrs[r];
               usrs[r] = aux;
            }
         }
      }
   
   }
   
   
   public Usuario LoginBinario(Usuario[] usrs,Usuario uBusca){
      int ini =0;
      int fim = usrs.length;
      int meio;
      
      
      while(ini<=fim){
         meio = (fim+ini)/2;       
         if(usrs[meio].getLogin().equals(uBusca.getLogin())){
            if(usrs[meio].getSenha().equals(uBusca.getSenha())){
               return usrs[meio];
            }
            return null;
         }
         else if(usrs[meio].getLogin().compareTo(uBusca.getLogin()) > 0){
            fim =meio -1;
         }
         else{
            ini =meio +1;
         }
      }
      return null;
   
   }
      
   
}