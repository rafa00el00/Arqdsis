package br.usjt.arqdsis.sisPredial.Models;

import java.io.IOException;
import java.sql.Time;

import org.json.JSONException;
import org.json.JSONObject;

public class Usuario extends IEntidade {

	private String login;
	private String senha;
	private TipoPerfil perfil;
	private String CPF;
	private String nome;
	private Empresa empresa;
	private Time horaAcesso;
	private Time horaSaida;

	public Usuario(String login, String senha, TipoPerfil perfil) {
		setLogin(login);
		setSenha(senha);
		setPerfil(perfil);

	}

	public Usuario() {
		this("", "", TipoPerfil.comum);
	}

	public enum TipoPerfil {
		Admin, comum, comumComPrivilegio
	}

	// Settes
	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setPerfil(TipoPerfil perfil) {
		this.perfil = perfil;
	}

	// Getters
	public String getLogin() {
		return this.login;
	}

	public String getSenha() {
		return this.senha;
	}

	public TipoPerfil getPerfil() {
		return this.perfil;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Time getHoraAcesso() {
		return horaAcesso;
	}

	public void setHoraAcesso(Time horaAcesso) {
		this.horaAcesso = horaAcesso;
	}

	public Time getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Time horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Usuario fromJson(String json) throws IOException {
		try {
			JSONObject object = new JSONObject(json);
			setId(object.getInt("Id"));
			setNome(object.getString("Nome"));
			setLogin(object.getString("Login"));
			setPerfil(TipoPerfil.valueOf(object.getString("Perfil")));
			setEmpresa((new Empresa()).fromJson(object.getString("Empresa")));
			setHoraAcesso( new Time(Long.parseLong(object.getString("HoraAcesso"))));
			setHoraSaida( new Time(Long.parseLong(object.getString("HoraSaida"))));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return this;
	}

	public String toJson() {
		JSONObject object = new JSONObject();
		try {
			object.put("Id", getId());
			object.put("Nome", getNome());
			object.put("Login", getLogin());
			object.put("Perfil", getPerfil());
			object.put("Empresa", getEmpresa().toJson());
			object.put("HoraAcesso", getHoraAcesso());
			object.put("HoraSaida", getHoraSaida());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}

}