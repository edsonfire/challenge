package br.com.adesafio.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Solicitacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "mesano")
	private MesAno mesano;
	
	@ManyToOne
	@JoinColumn(name = "atividade")
	private Atividade atividade;
	
	private String complexidade;
	
	private float fatorPonderacao;
	
	private int simultaneidade;
	
	private int diasUteis;
	
	private int diaNuteis;
	
	private int esforco;
	
	
	@Transient
	private float usts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public MesAno getMesano() {
		return mesano;
	}

	public void setMesano(MesAno mesano) {
		this.mesano = mesano;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public String getComplexidade() {
		return complexidade;
	}

	public void setComplexidade(String complexidade) {
		this.complexidade = complexidade;
	}

	public float getFatorPonderacao() {
		return fatorPonderacao;
	}

	public void setFatorPonderacao(float fatorPonderacao) {
		this.fatorPonderacao = fatorPonderacao;
	}

	public int getSimultaneidade() {
		return simultaneidade;
	}

	public void setSimultaneidade(int simultaneidade) {
		this.simultaneidade = simultaneidade;
	}

	public int getDiasUteis() {
		return diasUteis;
	}

	public void setDiasUteis(int diasUteis) {
		this.diasUteis = diasUteis;
	}

	public int getDiaNuteis() {
		return diaNuteis;
	}

	public void setDiaNuteis(int diaNuteis) {
		this.diaNuteis = diaNuteis;
	}
	@Override
	public String toString() {
		return  ""+id;
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
		Solicitacao other = (Solicitacao) obj;
		return id == other.id;
	}

	public int getEsforco() {
		return esforco;
	}

	public void setEsforco(int esforco) {
		this.esforco = esforco;
	}

	public float getUsts() {
		try {
			usts = this.fatorPonderacao*this.esforco*this.simultaneidade*(this.diaNuteis+this.diasUteis);
		}catch (Exception e) {
			return 0;
		}
		
		return usts;
	}
	
	
	
	
	

}
