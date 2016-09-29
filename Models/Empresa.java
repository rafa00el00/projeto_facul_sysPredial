package Models;
import Interfaces.*;
import java.util.*;
import DAO.*;

public class Empresa extends IEntidade{

   private String cnpj;
   private String razaoSocial;
   private Date horarioAbertura;
   private Date horarioFechamento;
   private int temperaturaPadrao;
   private Date horaIniAr;
   private Date horaFimAr;
   private Conjunto cj;
   
   private EmpresaDao dao;
   
   public Empresa(){
      this("","");
   }
   public Empresa(String cnpj,String razaoSocial){
      this.cnpj = cnpj;
      this.razaoSocial = razaoSocial;
      dao = new EmpresaDao();
   }
   
   //getters e Settes
   public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public Date getHorarioAbertura() {
		return horarioAbertura;
	}
	public void setHorarioAbertura(Date horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}
	public Date getHorarioFechamento() {
		return horarioFechamento;
	}
	public void setHorarioFechamento(Date horarioFechamento) {
		this.horarioFechamento = horarioFechamento;
	}
	public int getTemperaturaPadrao() {
		return temperaturaPadrao;
	}
	public void setTemperaturaPadrao(int temperaturaPadrao) {
		this.temperaturaPadrao = temperaturaPadrao;
	}
	public Date getHoraIniAr() {
		return horaIniAr;
	}
	public void setHoraIniAr(Date horaIniAr) {
		this.horaIniAr = horaIniAr;
	}
	public Date getHoraFimAr() {
		return horaFimAr;
	}
	public void setHoraFimAr(Date horaFimAr) {
		this.horaFimAr = horaFimAr;
	}
	public Conjunto getCj() {
		return cj;
	}
	public void setCj(Conjunto cj) {
		this.cj = cj;
	}
	
   
   public void inserir(){
      dao.incluir(this);
    }
   public void alterar(){ }
   public void consultar(){ }
   public void deletar(){ }
	
	
}