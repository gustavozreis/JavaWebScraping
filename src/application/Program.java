package application;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Program {
	
	public static void main(String[] args) {
		
	final String url = "https://www.pensador.com/frases_de_motivacao/1/";
	
	ArrayList<String> listaDeFrases = new ArrayList<String>();
	
		try {
			Document doc = Jsoup.connect(url).get();
			
			Elements frases = doc.getElementsByClass("frase fr");
			
			for (Element frase : frases) {
				listaDeFrases.add(frase.text());
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println(listaDeFrases);
	
	}
}
