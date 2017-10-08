package br.usjt.arqdsis.sisPredial.Models;

import java.io.IOException;
import java.sql.Time;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Empresa extends IEntidade {

	private String cnpj;
	private String razaoSocial;
	private Time horarioAbertura;
	private Time horarioFechamento;
	private int temperaturaPadrao;
	private Time horaIniAr;
	private Time horaFimAr;
	private Conjunto cj;

	private List<Usuario> funcionarios;

	public Empresa() {
		this("", "");
	}

	public Empresa(String cnpj, String razaoSocial) {
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;

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

	public Conjunto getConjunto() {
		return cj;
	}

	public void setConjunto(Conjunto cj) {
		this.cj = cj;
	}

	public List<Usuario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Usuario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public String toString() {
		return getCnpj() + " - " + getRazaoSocial();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (!(obj instanceof Empresa))
			return false;

		if (!cnpj.equals(((Empresa) obj).cnpj))
			return false;

		if (!razaoSocial.equals(((Empresa) obj).razaoSocial))
			return false;

		return true;

	}

	public String toJson() {
		JSONObject object = new JSONObject();
		try {
			object.put("id", getId());
			object.put("HorarioAbertura", getHorarioAbertura());
			object.put("HorarioFechamento", getHorarioFechamento());
			object.put("TemperaturaPadrao", getTemperaturaPadrao());
			object.put("HoraIniAr", getHoraIniAr());
			object.put("HoraFimAr", getHoraFimAr());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}
	
	public Empresa fromJson(String Json) throws IOException{
		try {
			JSONObject object = new JSONObject(Json);
			setId(object.getInt("id"));
			setHorarioAbertura( new Time(object.getLong("HorarioAbertura")));
			setHorarioFechamento( new Time(Long.parseLong(object.getString("HorarioFechamento"))));
			setTemperaturaPadrao(object.getInt("TemperaturaPadrao"));
			setHoraIniAr( new Time(Long.parseLong(object.getString("HoraIniAr"))));
			setHoraFimAr( new Time(Long.parseLong(object.getString("HoraFimAr"))));
		} catch (JSONException jsone){
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
		
		
		return this;
	}

}