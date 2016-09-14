package Models;
import java.util.ArrayList;
public class Funcionario{

   private String CPF;
   private String nome;
   private Empresa empresa;
   private String horaAcesso;
   private String privilegio;
 
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
 
}