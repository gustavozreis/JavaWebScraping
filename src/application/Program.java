package application;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Program {
	
	public static void main(String[] args) {
		
	final String url = "https://www.pensador.com/frases_de_motivacao/1/";
	
		try {
			Document doc = Jsoup.connect(url).get();
			
			String fullHtml = doc.outerHtml();
			
			System.out.println(fullHtml);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	
	}
}
