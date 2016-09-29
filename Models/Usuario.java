package Models;
import java.util.ArrayList;
import Interfaces.*;
import DAO.*;
public class Usuario extends IEntidade{

   private String login;
   private String senha;
   private String perfil;
   private String CPF;
   private String nome;
   private Empresa empresa;
   private String horaAcesso;
   private String horaSaida; 
   private UsuarioDao dao;
   
   public Usuario(String login,String senha,String perfil){
      setLogin(login);
      setSenha(senha);
      setPerfil(perfil);
      dao = new UsuarioDao();
   }
   
   public Usuario(){
      this("","","");
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
   public String getHoraSaida() {
      return horaSaida;
   }
   public void setHoraSaida(String horaSaida) {
      this.horaSaida = horaSaida;
   }

   
   
   //Metodos
   public boolean fazerlogin(){
      return false;
   }
   
   public void incluir(){
      dao.incluir(this);          
   }
   
    public void alterar(){
      dao.alterar(this);          
   }
   
   public void consultar(){
      dao.consultar(this);          
   }

   public void deletar(){ }
   
}