package projeto_selecao_cefet;

import java.util.HashMap;
import java.util.Map;

public class Registro {
	
	private static double [][]regist ={ {5200,4000,4200,5850,7000}, {3400,7700,5000,5900,6500} };
	
	public static double obterValor(String nome, int mes, int ano) {
		Map<String, Integer> map = new HashMap<String, Integer>();//Map que associa a data ao indice da matriz de registro
		
		map.put("12/2021", 0);
		map.put("1/2022", 1);
		map.put("2/2022", 2);
		map.put("3/2022", 3);
		map.put("3/2022", 4);
		
		String m = Integer.toString(mes);
		String year = Integer.toString(ano);
		
		String data = m.concat("/").concat(year);
		System.out.println("data" + data);
		
		Integer indice = map.get(data);
		double valor = 0;
		if(nome.equals("Ana Silva")) {
			valor = regist[0][indice];
		}else if(nome.equals("João Mendes")) {
			valor = regist[1][indice];
		}
		double result = valor;
		return result;
	}
}
