function grava_cookie(nome, valor)
{
	$.cookie(nome, valor, { expires: 50 });
}


function ler_cookie(nome)
{
	
	if(procuraCookie(nome)==true){
	
	var vcookie =$.cookie(nome);
	}else{
	var vcookie='0';	
		
	}
	
	return vcookie;
}