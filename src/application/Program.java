package application;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Program {
	
	public static void main(String[] args) {
		
	final String url = "https://www.pensador.com/frases_de_motivacao/";
	
	// instancia da lista de frases a ser preenchida
	ArrayList<String> listaDeFrases = new ArrayList<String>();
	
	for (Integer i=1; i<50; i++ ) {
	
		try {
			// conecta o programa ao website
			Document doc = Jsoup.connect("https://www.pensador.com/frases_de_motivacao/" + i.toString()).get();
			// encontra as frases pelo id da classe no html
			Elements frases = doc.getElementsByClass("frase fr");
			// adiciona a frase na lista de frases
			for (Element frase : frases) {
				listaDeFrases.add(frase.text());
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}	
			
		}
	for (int i=0; i<listaDeFrases.size(); i++) {
		System.out.println(listaDeFrases.get(i));
	}
	System.out.println("Quantidade de Frases Recuperadas: " + listaDeFrases.size());
	}
}
