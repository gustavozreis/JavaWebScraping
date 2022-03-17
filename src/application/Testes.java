package application;

public class Testes {

	public static void main(String[] args) {
		String fraseConvertida = "Remov\"\"a caracteres";
		StringBuilder sbuild = new StringBuilder(fraseConvertida);
		
		fraseConvertida = fraseConvertida.replace("\"", "");
		
		System.out.println(fraseConvertida);
	}
}
