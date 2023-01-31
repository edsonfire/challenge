package br.com.adesafio.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MesAno implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private int mes;
	private int ano;
	private int diasUteis;

	private int diasNuteis;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "" + id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MesAno other = (MesAno) obj;
		return id == other.id;
	}

	public int getDiasUteis() {
		return diasUteis;
	}

	public void setDiasUteis(int diasUteis) {
		this.diasUteis = diasUteis;
	}

	public int getDiasNuteis() {
		return diasNuteis;
	}

	public void setDiasNuteis(int diasNuteis) {
		this.diasNuteis = diasNuteis;
	}

	
}
