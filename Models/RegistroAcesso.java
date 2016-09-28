package Models;
import Interfaces.*;
import java.util.*;

public class RegistroAcesso extends IEntidade{
   
   private Date dataAcesso;
   private String tipo;
   

   public Date getDataAcesso() {
		return dataAcesso;
	}
	public void setDataAcesso(Date dataAcesso) {
		this.dataAcesso = dataAcesso;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
   
   //Metodos
   public void enviarArquivo(){
   
   }
      public void controlarAcesso(){ }
   public void consultar(){ }

   


}