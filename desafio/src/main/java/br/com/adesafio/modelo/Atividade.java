package br.com.adesafio.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Atividade implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descricao;
	@ManyToOne
	@JoinColumn(name = "celula")
	private Celula celula;

	private String complexidade;

	private float fatorPonderacao;

	private int simultaneidade;

	private int esforco;

	private String detalhamento;

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

	public Celula getCelula() {
		return celula;
	}

	public void setCelula(Celula celula) {
		this.celula = celula;
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
		Atividade other = (Atividade) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "" + id;
	}

	public String getDetalhamento() {
		return detalhamento;
	}

	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
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

	public int getEsforco() {
		return esforco;
	}

	public void setEsforco(int esforco) {
		this.esforco = esforco;
	}

}
