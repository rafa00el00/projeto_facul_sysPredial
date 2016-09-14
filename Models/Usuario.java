package Models;
import Interfaces.*;
public class Usuario extends IEntidade{

   private String login;
   private String senha;
   private String perfil;
   private Empresa empresa;
   
   
   public Usuario(String login,String senha,String perfil){
      setLogin(login);
      setSenha(senha);
      setPerfil(perfil);
   }
   
   public Usuario(){
      setLogin("");
      setSenha("");
      setPerfil("");
   }
   
   //Settes
   public void setLogin(String login)
   {
      this.login = login;
   }
   public void setSenha(String senha)
   {
      this.senha = senha;
   }
   public void setPerfil(String perfil)
   {
      this.perfil = perfil;
   }
   
   //Getters
   public String getLogin()
   {
      return this.login;
   }
   public String getSenha()
   {
      return this.senha;
   }
   public String getPerfil()
   {
      return this.perfil;
   }
   
   //Metodos
   public boolean fazerlogin(){
      return false;
   }
   
   
}