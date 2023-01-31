package br.com.desafio.bean;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import br.com.adesafio.modelo.Coordenacao;
import br.com.adesafio.modelo.Solicitacao;
import br.com.desafio.dao.CoordenacaoDAO;
import br.com.desafio.dao.SolicitacaoDAO;
import br.com.desafio.modelo.relatorios.Relatorio;

@ManagedBean(name = "dash")
@ViewScoped
public class DashBoardBean {

	private String graficoPizza = "";
	private List<Solicitacao> solicitacaos = new ArrayList<Solicitacao>();
	private List<Relatorio> relatorios = new ArrayList<Relatorio>();

	public DashBoardBean() {

		HttpSession sessions = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
		solicitacaos = new SolicitacaoDAO().getAll(Solicitacao.class);
		
		initRelatorios();

		fillRelatorios();
		
		
		montaGrafico();

	}
	
	
	private void initRelatorios() {
		
		List<Coordenacao> coords = new CoordenacaoDAO().getAll(Coordenacao.class);
		
		for(Coordenacao c: coords) {
			Relatorio r = new Relatorio();
			r.setCoordenacao(c);
			relatorios.add(r);
		}
		
		
		
		
	}
	
	private void fillRelatorios() {
		
		for(Relatorio r: relatorios) {
				for(Solicitacao s: solicitacaos) {
					if(s.getAtividade().getCelula().getMacrocelula().getCoordenacao().equals(r.getCoordenacao())) {
						switch (s.getMesano().getMes()) {
						case 1:
							r.setJan(r.getJan()+s.getUsts());
							r.setTotal(r.getTotal()+s.getUsts());						
							break;
						case 2:
							r.setFev(r.getFev()+s.getUsts());
							r.setTotal(r.getTotal()+s.getUsts());
							break;
						case 3:
							r.setMar(r.getMar()+s.getUsts());
							r.setTotal(r.getTotal()+s.getUsts());
							break;
						case 4:
							r.setAbr(r.getAbr()+s.getUsts());
							r.setTotal(r.getTotal()+s.getUsts());
							break;
						case 5:
							r.setMai(r.getMai()+s.getUsts());
							r.setTotal(r.getTotal()+s.getUsts());
							break;
						case 6:
							r.setJun(r.getJun()+s.getUsts());
							r.setTotal(r.getTotal()+s.getUsts());
							break;
						case 7:
							r.setJul(r.getJul()+s.getUsts());
							r.setTotal(r.getTotal()+s.getUsts());
							break;
						case 8:
							r.setAgo(r.getAgo()+s.getUsts());
							r.setTotal(r.getTotal()+s.getUsts());
							break;
						case 9:
							r.setSet(r.getSet()+s.getUsts());
							r.setTotal(r.getTotal()+s.getUsts());
							break;
						case 10:
							r.setOut(r.getOut()+s.getUsts());
							r.setTotal(r.getTotal()+s.getUsts());
							break;
						case 11:
							r.setNov(r.getNov()+s.getUsts());
							r.setTotal(r.getTotal()+s.getUsts());
							break;
						case 12:
							r.setDez(r.getDez()+s.getUsts());
							r.setTotal(r.getTotal()+s.getUsts());
							break;
						default:
							break;
						}
						
					}
					
					
				}
		}
		
	}
	
	
	
	
	
	
	

	
	  private void montaGrafico() {
	
		   DecimalFormat df = new DecimalFormat("0.00");
	 
	 
	  
	  try {
		  
		  
		  for(Relatorio r: relatorios) {
			  JSONObject obj = new JSONObject();  
			  System.out.println(r.getTotal());
			  obj.put("Cood", r.getCoordenacao().getDescricao());
			  obj.put("Total",(df.format(r.getTotal()).replace(",", ".")));
			 if(graficoPizza.isEmpty()) {
				 graficoPizza=obj.toString();
			 }else {
				 graficoPizza=graficoPizza+","+obj.toString();
			 }
			  
		  }
		  
		  
		  
		  
	  
	  
	  } catch (JSONException e1) { // TODO Auto-generated catch block
	  e1.printStackTrace(); }
	  
	  graficoPizza="["+graficoPizza+"]";
	  
	  }
	  


	public String getGraficoPizza() {
		return graficoPizza;
	}


	public List<Relatorio> getRelatorios() {
		return relatorios;
	}
	
	
	

}
