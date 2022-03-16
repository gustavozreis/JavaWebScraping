package application;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Program {
	
	public static void main(String[] args) {
		
	final String url = "https://www.pensador.com/frases_de_motivacao/1/";
	
		try {
			Document doc = Jsoup.connect(url).get();
			
			Elements frases = doc.getElementsByClass("frase fr");
			String frasesString = frases.text();
			
			System.out.println(frasesString);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	
	}
}
