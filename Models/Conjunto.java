package Models;
import Interfaces.*;
import java.util.*;

public class Conjunto extends IEntidade{
   
   private String nrConjunto;
   private String Andar;
   private String Alugel;
   private int tamanho;
   private boolean ocupado;
   private Empresa empresa;
   
   //Getters and Setters
   public String getNrConjunto() {
		return nrConjunto;
	}
	public void setNrConjunto(String nrConjunto) {
		this.nrConjunto = nrConjunto;
	}
	public String getAndar() {
		return Andar;
	}
	public void setAndar(String andar) {
		Andar = andar;
	}
	public String getAlugel() {
		return Alugel;
	}
	public void setAlugel(String alugel) {
		Alugel = alugel;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	

}