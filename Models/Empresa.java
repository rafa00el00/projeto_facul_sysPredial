package Models;
import Interfaces.*;
import java.util.*;

public class Empresa extends IEntidade{

   private String cnpj;
   private String razaoSocial;
   private Date horarioFuncionamento;
   private int temperaturaPadrao;
   private Date horarioArCondicionado;
   
   public Empresa(){
   
   }
   public Empresa(String cnpj,String razaoSocial){
      this.cnpj = cnpj;
      this.razaoSocial = razaoSocial;
   }
   
   //Settes
   public void setCnpj(String cnpj)
   {
      this.cnpj = cnpj;
   }
   public void setRazaoSocial(String razaoSocial)
   {
      this.razaoSocial = razaoSocial;
   }
   public void setHorarioFuncionamento(Date horarioFuncionamento)
   {
      this.horarioFuncionamento = horarioFuncionamento;
   }
   public void setTemperaturaPadrao(int temperaturaPadrao)
   {
      this.temperaturaPadrao = temperaturaPadrao;
   }
   public void setHorarioArCondicionado(Date horarioArCondicionado)
   {
      this.horarioArCondicionado = horarioArCondicionado;
   }
   
   //Getters
   public String getCnpj()
   {
      return this.cnpj;
   }
   public String getRazaoSocial()
   {
      return this.razaoSocial;
   }
   public Date getHorarioFuncionamento()
   {
      return this.horarioFuncionamento;
   }
   public int getTemperaturaPadrao()
   {
      return this.temperaturaPadrao;
   }
    public Date getHorarioArCondicionado()
   {
      return this.horarioArCondicionado;
   }
}