package br.com.adesafio.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.desafio.dao.UsuarioDAO;

@Entity
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String usuario;
	private String senha;
	private String perfil;

	private Date ultimo_login;

	private Date login_atual;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) object;
		if ((this.id == 0 && other.id > 0) || (this.id > 0 && !(this.id == other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}

	public Date getUltimo_login() {
		return ultimo_login;
	}

	public void setUltimo_login(Date ultimo_login) {
		this.ultimo_login = ultimo_login;
	}

	public Date getLogin_atual() {
		return login_atual;
	}

	public void setLogin_atual(Date login_atual) {
		this.login_atual = login_atual;
	}

	public void registraUltimoAcesso() {

		if (this.id > 0) {
			Date dt = new Date();

			if (this.login_atual == null) {

				ultimo_login = dt;
				login_atual = dt;

			} else {

				ultimo_login = login_atual;
				login_atual = dt;
			}

			new UsuarioDAO().save(this);

		}
	}

}
