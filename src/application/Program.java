package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Program {
	
	public static void main(String[] args) {
		
	final String url = "https://www.pensador.com/frases_de_motivacao/";
	
	// instancia da lista de frases a ser preenchida
	ArrayList<String> listaDeFrases = new ArrayList<String>();
	
	
	for (Integer i=1; i<3000; i++ ) {
	
		try {
			// conecta o programa ao website
			Document doc = Jsoup.connect("https://www.pensador.com/frases_de_motivacao/" + i.toString()).get();
			// encontra as frases pelo id da classe no html
			Elements frases = doc.getElementsByClass("frase fr");
			// adiciona a frase na lista de frases
			for (Element frase : frases) {		
				
				if(!frase.text().toUpperCase().contains("JESUS") 
						&& !frase.text().toUpperCase().contains("DEUS")
						&& !frase.text().toUpperCase().contains("IGREJA")
						&& !frase.text().toUpperCase().contains("CRISTO")
						&& frase.text().length() < 65) {
						
					 	String aspas = "\"";
					 	String fraseComAspas = aspas + frase.text() + aspas;
						listaDeFrases.add(fraseComAspas);	
						}
			}		
			
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}	
				
			}
	
		String path = "D:\\APRENDERJAVA\\gzr-eclipse\\_ARQUIVOS\\FrasesCoachorro.txt";
	
		for (int i=0; i<listaDeFrases.size(); i++) {
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
				for (String line : listaDeFrases) {
					bw.write(line);
					bw.write(",");
					bw.newLine();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
			//System.out.println(listaDeFrases.get(i));
		}
		//System.out.println("Quantidade de Frases Recuperadas: " + listaDeFrases.size());
	}
}
