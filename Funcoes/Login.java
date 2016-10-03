package Funcoes;

import java.util.ArrayList;
import javax.swing.*;
import java.io.*;

import Models.*;

public class Login {

	private String txtArquivo;
	private MyList<Usuario> usuarios;
	private final String ArquivoLogin = "users.txt";
	private final String Chave = "chave.simetrica";

	public Login() {
		usuarios = new MyList<Usuario>();
		carregarLogins();
	}

	// Carrega o Arquivo de login
	public void carregarLogins() {
		String[] linhas, user;// Variaveis auxiliares

		// Le o arquivo Criptografado
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ArquivoLogin)); // Abre
																								// o
																								// arquivo
			byte[] bArq = (byte[]) ois.readObject();// Objeto retorna byte[]
			ois.close();// Fecha o arquivo para não ocupar memoria;

			// Descriptografia
			Cryptografia crypt = new Cryptografia();
			txtArquivo = (new String(crypt.desCriptografar(bArq, Chave), "ISO-8859-1"));
		} catch (Exception e) {
			// Por causa dos Throws
			e.printStackTrace();
		}
		// ; é o separador dos usuarios;
		linhas = txtArquivo.split(";");
		usuarios.clear();
		// Cria um array de Usuarios;
		for (int i = 0; i < linhas.length; i++) {
			user = linhas[i].split(":");// : separador do campo
			usuarios.add(new Usuario(user[0], user[1], user[2]));
		}

	}

	// Para adicionar login
	public void addLogin(String userName, String senha, String privilegio) {
		addLogin(new Usuario(userName.replace(":", "").replace(";", ""), senha.replace(":", "").replace(";", ""),
				privilegio.replace(":", "").replace(";", "")));
	}

	public void addLogin(Usuario usr) {
		usuarios.add(usr);
	}

	// Fazer Login
	public Usuario logar(String userName, String senha) {
		Usuario[] us = usuarios.toArray(new Usuario[usuarios.size()]);
		ordernarusuarios(us);// ordena para busca binaria;
		Usuario u = new Usuario(userName, senha, "");// Usuario a ser buscado
		return LoginBinario(us, u);
	}

	// Ordena com selection Sort
	public void ordernarusuarios(Usuario[] usrs) {
		// Ordena com selection Sort
		Usuario aux;
		for (int i = 0; i < usrs.length; i++) {
			for (int r = i + 1; r < usrs.length; r++) {
				if (usrs[i].getLogin().compareTo(usrs[r].getLogin()) > 0) {
					aux = usrs[i];
					usrs[i] = usrs[r];
					usrs[r] = aux;
				}
			}
		}

	}

	// busca binaria do Login
	public Usuario LoginBinario(Usuario[] usrs, Usuario uBusca) {
		int ini = 0;
		int fim = usrs.length;
		int meio;

		while (ini <= fim) {
			meio = (fim + ini) / 2;
			if (usrs[meio].getLogin().equals(uBusca.getLogin())) {
				if (usrs[meio].getSenha().equals(uBusca.getSenha())) {
					return usrs[meio];
				}
				return null;
			} else if (usrs[meio].getLogin().compareTo(uBusca.getLogin()) > 0) {
				fim = meio - 1;
			} else {
				ini = meio + 1;
			}
		}
		return null;

	}

	// Para salvar o arquivo alterado
	public boolean salvarAlteracoes() {
		String sUsuarios = "";
		Cryptografia crypt = new Cryptografia();
		try {
			// Monta a string do arquivo
			for (Usuario u : usuarios) {
				sUsuarios += u.getLogin() + ":" + u.getSenha() + ":" + u.getPerfil() + ";";
			}

			// Criptografa e Salva
			crypt.gerarChave(Chave);
			byte[] bArq = crypt.criptografar(sUsuarios, Chave);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ArquivoLogin));// Cria
																								// um
																								// arquivo
																								// fisico
																								// na
																								// maquina
			oos.writeObject(bArq);// passa o texto da chave
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void getLogin(Usuario usr) {
		MyList<Usuario> uus = usuarios.find(u -> u.getLogin().equals(usr.getLogin()));
		if (uus.size() > 0) {
			Usuario us = uus.get(0);
			usr.setSenha(us.getSenha());
			usr.setPerfil(us.getPerfil());
		}
	}

	public void alterarLogin(Usuario usr) {
		MyList<Usuario> uus = usuarios.find(u -> u.getLogin().equals(usr.getLogin()));
		if (uus.size() > 0) {
			Usuario us = uus.get(0);
			us.setSenha(usr.getSenha());
			us.setPerfil(usr.getPerfil());
		}
		
	}

	public void removeLogin(Usuario usr) {
		MyList<Usuario> uus = usuarios.find(u -> u.getLogin().equals(usr.getLogin()));
		if (uus.size() > 0) {
			usuarios.remove(uus.get(0));
		}
		
	}

}