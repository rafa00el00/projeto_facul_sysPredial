package Controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;

import DAO.EmpresaDao;
import DAO.UsuarioDao;
import Funcoes.Login;
import Funcoes.MyList;
import Models.RegistroAcesso;
import Models.Usuario;
import Views.GuiCadUsuarios;
import Views.GuiConsultar;
import Views.GuiLogin;
import Views.GuiMenu;
import Views.GuiRegistroAcesso;
import Views.GuiUsuario;

public abstract class UsuarioController {

	private static MyList<Usuario> usuarios;
	private static MyList<RegistroAcesso> acessos;
	private static Login lg;
	private static final String ArquivoRegistro = "C:/Users/rafael/Desktop/sistemaPredial/projeto_facul_sysPredial/registros.txt";

	public static void init() {
		usuarios = (new UsuarioDao()).consultarTodos(new Usuario());
		lg = new Login();
		lg.carregarLogins();
		acessos = new MyList<RegistroAcesso>();
		carregarAcessos();
	}

	public static void consultar() {
		GuiUsuario usr = new GuiUsuario(usuarios);
		usr.setVisible(true);
	}

	public static void consultar(String pesquisa, GuiConsultar gui) {
		gui.atualizarTabela(usuarios.find(e -> e.getNome().toUpperCase().contains(pesquisa.toUpperCase())));
	}

	public static boolean incluir(JFrame fm) {
		GuiCadUsuarios cad = new GuiCadUsuarios(fm, false);
		cad.setLstEmpresas((new EmpresaDao()).consultarTodos(new Usuario()));
		cad.setVisible(true);
		return true;
	}

	public static boolean incluir(Usuario usr) {
		try {
			lg.addLogin(usr);
			lg.salvarAlteracoes();
			usr.incluir();
			usuarios.add(usr);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void alterar(JFrame fr, Usuario usr) {
		GuiCadUsuarios cad = new GuiCadUsuarios(fr, true, usr, (new EmpresaDao()).consultarTodos(new Usuario()));
		cad.setVisible(true);
	}

	public static void alterar(Usuario usr) {
		usr.alterar();
		lg.alterarLogin(usr);
		lg.salvarAlteracoes();
	}

	public static void deletar(Usuario usr) {
		usr.deletar();
		lg.removeLogin(usr);
		lg.salvarAlteracoes();
		usuarios.remove(usr);
	}

	public static void logar() {
		GuiLogin lg = new GuiLogin(null);
		lg.setVisible(true);
	}

	public static boolean logar(String usuario, String senha) {
		Usuario usr = lg.logar(usuario, senha);
		if (usr != null) {
			if (!usr.getPerfil().equals("CM")) {
				GuiMenu lg = new GuiMenu(usr);
				lg.setVisible(true);
			}
			addAcesso(usr);
			return true;
		}
		return false;

	}

	public static void carregarAcessos() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ArquivoRegistro));
			String sRegistros = (String) ois.readObject();// Objeto retorna
															// byte[]
			ois.close();
			String[] regs = sRegistros.split(";");

			String[] sAcesso2;

			RegistroAcesso acesso;
			for (String reg : regs) {
				sAcesso2 = reg.split(":");
				String ur = sAcesso2[1];
				acesso = new RegistroAcesso();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

				acesso.setDataAcesso(new Date(format.parse(sAcesso2[0]).getTime()));
				Usuario us = usuarios.find(u -> u.getLogin().equals(ur)).get(0);
				acesso.setUsuario(us);
				acesso.setTipo(sAcesso2[2]);
				acessos.add(acesso);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addAcesso(Usuario usr) {
		RegistroAcesso acesso = new RegistroAcesso();
		acesso.setDataAcesso(new java.util.Date());
		acesso.setUsuario(usr);
		MyList<RegistroAcesso> registros = acessos.find(a -> a.getUsuario().getLogin().equals(usr.getLogin()));

		if (registros.size() > 0) {
			if (registros.get(registros.size() - 1).getTipo().equals("SAIDA")) {
				acesso.setTipo("ENTRADA");
			} else {
				acesso.setTipo("SAIDA");
			}
		} else {
			acesso.setTipo("ENTRADA");
		}
		acessos.add(acesso);
		salvarAcesso();
	}

	public static void salvarAcesso() {
		String sArq = "";
		for (RegistroAcesso acesso : acessos) {
			sArq += acesso.toString();
		}
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(ArquivoRegistro));
			oos.writeObject(sArq);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void consultarAcesso() {
		GuiRegistroAcesso acessoGui = new GuiRegistroAcesso(acessos);
		acessoGui.setVisible(true);
	}

	public static void consultarAcesso(String pesquisa, GuiConsultar gui) {
		gui.atualizarTabela(acessos.find(e -> e.getUsuario().getLogin().toUpperCase().contains(pesquisa.toUpperCase())));
	}

}
