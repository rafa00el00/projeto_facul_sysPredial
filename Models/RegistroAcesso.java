package Models;
import Interfaces.*;
import java.util.*;

public class RegistroAcesso extends IEntidade{
   
   private Date dataAcesso;
   private String tipo;

   
   //Settes
   public void setDataEntrada(Date dataEntrada)
   {
      this.dataEntrada = dataEntrada;
   }
   public void setHoraEntrada(Date horaEntrada)
   {
      this.horaEntrada = horaEntrada;
   }
   public void setHoraSaida(Date horaSaida)
   {
      this.horaSaida = horaSaida;
   }
   
   //Getters
   public Date getDataEntrada()
   {
      return this.dataEntrada;
   }
   public Date getHoraEntrada()
   {
      return this.horaEntrada;
   }
   public Date getHoraSaida()
   {
      return this.horaSaida;
   }

   //Metodos
   public void enviarArquivo(){
   
   }

}