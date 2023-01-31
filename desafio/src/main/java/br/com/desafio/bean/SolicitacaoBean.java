package br.com.desafio.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;

import br.com.adesafio.modelo.Atividade;
import br.com.adesafio.modelo.Celula;
import br.com.adesafio.modelo.Coordenacao;
import br.com.adesafio.modelo.Macrocelula;
import br.com.adesafio.modelo.MesAno;
import br.com.adesafio.modelo.Solicitacao;
import br.com.desafio.dao.AtividadeDAO;
import br.com.desafio.dao.CelulaDAO;
import br.com.desafio.dao.CoordenacaoDAO;
import br.com.desafio.dao.MacrocelulaDAO;
import br.com.desafio.dao.MesAnoDAO;
import br.com.desafio.dao.SolicitacaoDAO;
import br.com.desafio.util.SweetMensagem;

@ManagedBean(name = "soliciacaoBean")
@ViewScoped
public class SolicitacaoBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<MesAno> mesAnos  = new ArrayList<MesAno>();
	private List<Coordenacao> coords = new ArrayList<Coordenacao>();
	private List<Macrocelula> macros = new ArrayList<Macrocelula>();
	private List<Celula> celulas = new ArrayList<Celula>();
	private List<Atividade> atividades = new ArrayList<Atividade>();
	
	private MesAno mesanoSelected = new MesAno();
	private Coordenacao coordenacaoSelected = new Coordenacao();
	private Macrocelula macrocelula = new Macrocelula();
	private Celula celula = new Celula();
	private Atividade atividadeSelected = new Atividade();
	private Solicitacao solicitacao = new Solicitacao();
	private List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
	private double totalust=0;
	
	
	public SolicitacaoBean() {

		HttpSession sessions = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		mesAnos = new MesAnoDAO().findOrder();
		coords = new CoordenacaoDAO().getAll(Coordenacao.class);
		
		System.out.println(mesAnos.size());

	}
	
	
   public void buscaMacrocelulas(AjaxBehaviorEvent ae){		
		
		macros = new MacrocelulaDAO().findByCoordenacao(coordenacaoSelected);
		
		System.out.println("macros encontradas: "+macros.size());
	}
	
   
   public void buscaCelulas(AjaxBehaviorEvent ae){		
		
		celulas = new CelulaDAO().findByMacroCelula(macrocelula);
		
		
	}
   
   
   public void buscaAtividades(AjaxBehaviorEvent ae){		
		
 		atividades = new AtividadeDAO().findByCelula(celula);
 		
 		
 	}
   
   
   
   public void selecionaAtividade(AjaxBehaviorEvent ae) {
	   
	   if(atividadeSelected!=null) {
		   
		   solicitacao.setAtividade(atividadeSelected);
		   solicitacao.setComplexidade(atividadeSelected.getComplexidade());
		   solicitacao.setEsforco(atividadeSelected.getEsforco());
		   solicitacao.setFatorPonderacao(atividadeSelected.getFatorPonderacao());
		   solicitacao.setSimultaneidade(atividadeSelected.getSimultaneidade());
	   }else {
		   solicitacao.setAtividade(null);
		   solicitacao.setComplexidade("");
		   solicitacao.setEsforco(0);
		   solicitacao.setFatorPonderacao(0);
		   solicitacao.setSimultaneidade(0);
		   
		   
	   }
   }
   
   
   
   public void selecionaMesAno(AjaxBehaviorEvent ae) {
	   
	   if(mesanoSelected!=null) {
		   
		   solicitacao.setMesano(mesanoSelected);
		   solicitacao.setDiaNuteis(mesanoSelected.getDiasNuteis());
		   solicitacao.setDiasUteis(mesanoSelected.getDiasUteis());
		   zeraAllSelecionados();
		   
	   }else {
		   zeraAllSelecionados(); 
	   }
   }


private void zeraAllSelecionados() {
	coordenacaoSelected=new Coordenacao();
	   macrocelula= new Macrocelula();
	   celula = new Celula();
	   atividadeSelected= new Atividade();
	   
	   macros = new ArrayList<Macrocelula>();
	   celulas = new ArrayList<Celula>();
	   atividades = new ArrayList<Atividade>();
	   
}




public void addSolicitacao() {
	
	
	solicitacoes.add(solicitacao);
	totalust+=solicitacao.getUsts();
	solicitacao = new Solicitacao();
	zeraAllSelecionados();
	mesanoSelected = new MesAno();
	
}



public void salvaSolicitacao() {
	
	if(new SolicitacaoDAO().saveAll(solicitacoes)) {
		
		SweetMensagem.mensagemSweetSucesso("Solicitação","Operação realizada com sucesso");
		
		solicitacoes = new ArrayList<Solicitacao>();
		totalust=0;
	}
}

	public List<MesAno> getMesAnos() {
		return mesAnos;
	}


	public List<Coordenacao> getCoords() {
		return coords;
	}


	public MesAno getMesanoSelected() {
		return mesanoSelected;
	}


	public void setMesanoSelected(MesAno mesanoSelected) {
		this.mesanoSelected = mesanoSelected;
	}


	public Coordenacao getCoordenacaoSelected() {
		return coordenacaoSelected;
	}


	public void setCoordenacaoSelected(Coordenacao coordenacaoSelected) {
		this.coordenacaoSelected = coordenacaoSelected;
	}


	public Macrocelula getMacrocelula() {
		return macrocelula;
	}


	public void setMacrocelula(Macrocelula macrocelula) {
		this.macrocelula = macrocelula;
	}


	public Celula getCelula() {
		return celula;
	}


	public void setCelula(Celula celula) {
		this.celula = celula;
	}


	public Atividade getAtividadeSelected() {
		return atividadeSelected;
	}


	public void setAtividadeSelected(Atividade atividadeSelected) {
		this.atividadeSelected = atividadeSelected;
	}


	public Solicitacao getSolicitacao() {
		return solicitacao;
	}


	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}


	public void setMesAnos(List<MesAno> mesAnos) {
		this.mesAnos = mesAnos;
	}


	public void setCoords(List<Coordenacao> coords) {
		this.coords = coords;
	}


	public List<Macrocelula> getMacros() {
		return macros;
	}


	public void setMacros(List<Macrocelula> macros) {
		this.macros = macros;
	}


	public List<Celula> getCelulas() {
		return celulas;
	}


	public void setCelulas(List<Celula> celulas) {
		this.celulas = celulas;
	}


	public List<Atividade> getAtividades() {
		return atividades;
	}


	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}


	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}


	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}


	public double getTotalust() {
		return totalust;
	}
	
	
	
	

}
