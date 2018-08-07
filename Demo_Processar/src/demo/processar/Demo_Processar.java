package demo.processar;

import java.util.ArrayList;
import java.util.List;

public class Demo_Processar {
	// String linha = "a ou b";
	public static void main(String[] args) {
		Demo_Processar dp = new Demo_Processar();
		List<String> resp = new ArrayList<String>();
		String linha = "A, B";
		linha = linha.toLowerCase();
		System.out.println(linha);
		dp.processarLinha(linha, resp);
		boolean gab = dp.verificarQuestaoCorreta("c", resp, linha);
		dp.apresentarQuestaoErrada(resp, gab);
	}
	
	public void apresentarQuestaoErrada(List<String> resp, boolean gab){
		if(!gab){
			System.out.println("Errado! Resposta correta: "+resp);
		}else{
			System.out.println("Correto! ");
		}
	}
	
	public boolean verificarQuestaoCorreta(String respUI, List<String> resp, String linha){
		int aux = 0;
		boolean gab = false;
		//String gab="";
		if(linha.contains(" ou "))
			aux = 1;
		else if(linha.contains(", "))
			aux = 2;		
		switch (aux) {
		case 1:			
			System.out.println("posicao 0: " + resp.get(0));
			System.out.println("posicao 1: " + resp.get(1));
			System.out.println("posicao 2: " + resp.get(2));
			for (int i = 0; i < resp.size(); i++) {
				if (respUI.contains(resp.get(i)))
					gab = true;
			}

			if (gab)
				System.out.println("ok");
			break;

		case 2:
			for(int i=0;i<resp.size();i++){
				if(respUI.contains(resp.get(i)))
					gab = true;
				else{
					gab = false;
					break;
				}
					
			}			
			break;

		default:
			if(respUI.contains(resp.get(0)))
				gab = true;
			break;
		}
		return gab;
	}

	public void processarLinha(String linha, List<String> resp) {
		

		if (linha.contains(" ou ") || linha.contains(", ")) { // verifica se a
																// linha tem os
																// caracteres
																// desejados

			int position = linha.indexOf(" ou "); // captura a 1ª posicao dos
													// caracteres desejados
			if (position == -1) {

				position = linha.indexOf(", ");
				resp.add(linha.substring(0, position));
				System.out.println(resp.get(0));
				linha = linha.substring(position + 2, linha.length());
				System.out.println(linha);
				processarLinha(linha, resp);
				

			} else {

				resp.add(linha.substring(0, position)); // adiciona a 1ª
														// resposta
				System.out.println(resp.get(0));
				linha = linha.substring(position + 4, linha.length());
				System.out.println(linha);
				processarLinha(linha, resp);
				
			}
		} else {
			resp.add(linha);
		}		
	}
}
