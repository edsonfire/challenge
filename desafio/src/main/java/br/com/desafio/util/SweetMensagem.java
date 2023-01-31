package br.com.desafio.util;

import org.primefaces.context.RequestContext;

public class SweetMensagem {
	
	
	

	
	public static void mensagemSweetSucesso(String titulo, String mensagem) {
		/*

		PrimeFaces.current().executeScript("Swal.fire(\r\n" + 
				"  '"+titulo+"',\r\n" + 
				"  '"+mensagem+"!',\r\n" + 
				"  'success'\r\n" + 
				")");
		*/
		RequestContext.getCurrentInstance().execute("swal(\r\n" + 
				"  '"+titulo+"',\r\n" + 
				"  '"+mensagem+"!',\r\n" + 
				"  'success'\r\n" + 
				")");
		
		
		
	}
	
	
	

	public static void mensagemSweetInformacao(String titulo, String mensagem) {
		
		RequestContext.getCurrentInstance().execute(("swal(\r\n" + 
				"  '"+titulo+"',\r\n" + 
				"  '"+mensagem+"!',\r\n" + 
				"  'info'\r\n" + 
				")"));
		/*
		PrimeFaces.current().executeScript("swal(\r\n" + 
				"  '"+titulo+"',\r\n" + 
				"  '"+mensagem+"!',\r\n" + 
				"  'info'\r\n" + 
				")");*/
		
	}
	
	
	

	public static void mensagemSweetAtencao(String titulo, String mensagem) {
		/*
		
		PrimeFaces.current().executeScript("swal(\r\n" + 
				"  '"+titulo+"',\r\n" + 
				"  '"+mensagem+"!',\r\n" + 
				"  'warning'\r\n" + 
				")");
		
		
		*/
		RequestContext.getCurrentInstance().execute("swal(\r\n" + 
				"  '"+titulo+"',\r\n" + 
				"  '"+mensagem+"!',\r\n" + 
				"  'warning'\r\n" + 
				")");
		
		
		
		
	}
	
	


	

	public static void mensagemSweetErro(String titulo, String mensagem) {
		
		/*
		PrimeFaces.current().executeScript("swal(\r\n" + 
				"  '"+titulo+"',\r\n" + 
				"  '"+mensagem+"!',\r\n" + 
				"  'error'\r\n" + 
				")");
		
		*/
		RequestContext.getCurrentInstance().execute("swal(\r\n" + 
				"  '"+titulo+"',\r\n" + 
				"  '"+mensagem+"!',\r\n" + 
				"  'error'\r\n" + 
				")");
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
