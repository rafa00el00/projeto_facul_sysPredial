package Models;
import Interfaces.*;
import java.util.*;

public class Empresa extends IEntidade{

   private String cnpj;
   private String razaoSocial;
   private Date horarioFuncionamento;
   private int temperaturaPadrao;
   private Date horarioArCondicionado;
   
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
   public String setRazaoSocial()
   {
      return this.razaoSocial;
   }
   public Date setHorarioFuncionamento()
   {
      return this.horarioFuncionamento;
   }
   public int setTemperaturaPadrao()
   {
      return this.temperaturaPadrao;
   }
    public Date setHorarioArCondicionado()
   {
      return this.horarioArCondicionado;
   }
}