package Models;
import java.util.ArrayList;
import Interfaces.*;
public class Usuario extends IEntidade{

   private String login;
   private String senha;
   private String perfil;
   private String CPF;
   private String nome;
   private Empresa empresa;
   private String horaAcesso;
   private String privilegio; 
   
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
   
    public String getCPF() {
      return CPF;
   }
   public void setCPF(String cPF) {
      CPF = cPF;
   }
   public String getNome() {
      return nome;
   }
   public void setNome(String nome) {
      this.nome = nome;
   }
   public Empresa getEmpresa() {
      return empresa;
   }
   public void setEmpresa(Empresa empresa) {
      this.empresa = empresa;
   }
   public String getHoraAcesso() {
      return horaAcesso;
   }
   public void setHoraAcesso(String horaAcesso) {
      this.horaAcesso = horaAcesso;
   }
   public String getPrivilegio() {
      return privilegio;
   }
   public void setPrivilegio(String privilegio) {
      this.privilegio = privilegio;
   }

   
   
   //Metodos
   public boolean fazerlogin(){
      return false;
   }
   
   
}