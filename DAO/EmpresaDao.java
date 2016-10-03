package DAO;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Models.*;
import Interfaces.*;
import Funcoes.*;

public class EmpresaDao extends AbstractDao {

	public EmpresaDao() {
		super();
	}

	// incluir
	public void incluir(Empresa empresa) {

		String sqlInsert = "INSERT INTO Empresa(" + "CNPJ" + ",RAZAOSOCIAL" + ",TemperaturaAr" + ",horaAbertura"
				+ ",horaFechamento" + ",horaIniAr" + ",horaFimAr" + ")" + " VALUES (?, ?, ?, ?, ?,?,?)";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, empresa.getCnpj());
			stm.setString(2, empresa.getRazaoSocial());
			stm.setInt(3, empresa.getTemperaturaPadrao());
			stm.setTime(4, empresa.getHorarioAbertura());
			stm.setTime(5, empresa.getHorarioFechamento());
			stm.setTime(6, empresa.getHoraIniAr());
			stm.setTime(7, empresa.getHoraFimAr());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			} finally {
				if (stm != null) {
					try {
						stm.close();
					} catch (SQLException e1) {
						System.out.print(e1.getStackTrace());
					}
				}
			}
		}
	}

	// alterar
	public void alterar(Empresa empresa) {

		String sqlInsert = "Update Empresa set " + "CNPJ = ?" + ",RAZAOSOCIAL = ?" + ",TemperaturaAr = ?"
				+ ",horaAbertura = ?" + ",horaFechamento = ?" + ",horaIniAr = ?" + ",horaFimAr = ?" + ""
				+ " where id = ?";

		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, empresa.getCnpj());
			stm.setString(2, empresa.getRazaoSocial());
			stm.setInt(3, empresa.getTemperaturaPadrao());
			stm.setTime(4, empresa.getHorarioAbertura());
			stm.setTime(5, empresa.getHorarioFechamento());
			stm.setTime(6, empresa.getHoraIniAr());
			stm.setTime(7, empresa.getHoraFimAr());
			stm.setInt(8, empresa.getTemperaturaPadrao());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			} finally {
				if (stm != null) {
					try {
						stm.close();
					} catch (SQLException e1) {
						System.out.print(e1.getStackTrace());
					}
				}
			}
		}
	}

	// Consultar
	public Empresa consultar(Empresa empresa) {
		String sqlSelect = "SELECT * FROM Empresa";
		if (empresa instanceof Empresa) {
			sqlSelect += " where id = ?";
		}

		PreparedStatement stm = null;
		ResultSet rs = null;
      UsuarioDao usrDao = new UsuarioDao();
		
		try {
			stm = conn.prepareStatement(sqlSelect);
			
				stm.setInt(1, empresa.getId());
			
			rs = stm.executeQuery();
			while (rs.next()) {

				empresa.setId(rs.getInt("id"));
				empresa.setCnpj(rs.getString("cnpj"));
				empresa.setRazaoSocial(rs.getString("razaosocial"));
				empresa.setTemperaturaPadrao(rs.getInt("TemperaturaAr"));
				empresa.setHorarioAbertura(rs.getTime("horaAbertura"));
				empresa.setHorarioFechamento(rs.getTime("horaFechamento"));
				empresa.setHoraIniAr(rs.getTime("horaIniAr"));
				empresa.setHoraFimAr(rs.getTime("horaFimAr"));
				//empresa.setFuncionarios(usrDao.consultarTodos(empresa));
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return (empresa);
	}

	// Consultar
	public MyList<Empresa> consultarTodos(IEntidade entidade) {
		String sqlSelect = "SELECT * FROM Empresa";
		MyList<Empresa> empresas = new MyList<Empresa>();

		/*
		 * if (entidade instanceof Empresa){ sqlSelect += " where id = ?"; }
		 */

		PreparedStatement stm = null;
		ResultSet rs = null;
		Empresa empresa = new Empresa();
      UsuarioDao usrDao = new UsuarioDao();
		try {
			stm = conn.prepareStatement(sqlSelect);
			/*
			 * if (entidade instanceof Usuario){ //traz todos }else if (entidade
			 * instanceof Empresa){ stm.setInt(1,((Empresa)entidade).getId()); }
			 */
			rs = stm.executeQuery();
			while (rs.next()) {
				empresa = new Empresa();
				empresa.setId(rs.getInt("id"));
				empresa.setCnpj(rs.getString("cnpj"));
				empresa.setRazaoSocial(rs.getString("razaosocial"));
				empresa.setTemperaturaPadrao(rs.getInt("TemperaturaAr"));
				empresa.setHorarioAbertura(rs.getTime("horaAbertura"));
				empresa.setHorarioFechamento(rs.getTime("horaFechamento"));
				empresa.setHoraIniAr(rs.getTime("horaIniAr"));
				empresa.setHoraFimAr(rs.getTime("horaFimAr"));
				//empresa.setFuncionarios(usrDao.consultarTodos(empresa));
				empresas.add(empresa);

			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return empresas;
	}
	
	
	public void deletar(Empresa empresa) {
		String sqlInsert = "Delete from Empresa"
				+ " where id = ?";

		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1, empresa.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
	

}
