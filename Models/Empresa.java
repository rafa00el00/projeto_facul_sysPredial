package Models;

import Interfaces.*;

import java.sql.Time;
import java.util.*;
import DAO.*;
import Funcoes.MyList;

public class Empresa extends IEntidade {

	private String cnpj;
	private String razaoSocial;
	private Time horarioAbertura;
	private Time horarioFechamento;
	private int temperaturaPadrao;
	private Time horaIniAr;
	private Time horaFimAr;
	private Conjunto cj;

	private MyList<Usuario> funcionarios;

	private EmpresaDao dao;

	public Empresa() {
		this("", "");
	}

	public Empresa(String cnpj, String razaoSocial) {
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		dao = new EmpresaDao();
	}

	// getters e Settes
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

	public int getTemperaturaPadrao() {
		return temperaturaPadrao;
	}

	public void setTemperaturaPadrao(int temperaturaPadrao) {
		this.temperaturaPadrao = temperaturaPadrao;
	}

	public Time getHorarioAbertura() {
		return horarioAbertura;
	}

	public void setHorarioAbertura(Time horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public Time getHorarioFechamento() {
		return horarioFechamento;
	}

	public void setHorarioFechamento(Time horarioFechamento) {
		this.horarioFechamento = horarioFechamento;
	}

	public Time getHoraIniAr() {
		return horaIniAr;
	}

	public void setHoraIniAr(Time horaIniAr) {
		this.horaIniAr = horaIniAr;
	}

	public Time getHoraFimAr() {
		return horaFimAr;
	}

	public void setHoraFimAr(Time horaFimAr) {
		this.horaFimAr = horaFimAr;
	}

	public Conjunto getCj() {
		return cj;
	}

	public void setCj(Conjunto cj) {
		this.cj = cj;
	}
	public MyList<Usuario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(MyList<Usuario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public void incluir() {
		dao.incluir(this);
	}

	public void alterar() {
		dao.alterar(this);
	}

	public void consultar() {
		dao.consultar(this);
	}

	public void deletar() {
		dao.deletar(this);
		for (Usuario fn : funcionarios) {
			fn.deletar();
		}
	}

	@Override
	public String toString() {
		return getId() + " - " + getRazaoSocial();
	}

}