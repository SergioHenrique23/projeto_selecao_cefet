package projeto_selecao_cefet;

public class Secretario extends Cargo {
	final double SALARIO = 7000.00;

	private Secretario(int mes_contrat, int ano_contrat, String nome) {
		super(mes_contrat, ano_contrat, nome);
	}

	@Override
	public double getSalario(int mes, int ano) {
		double salario = SALARIO;
		if(ano > ano_contrat ) {
			if(mes >= mes_contrat ) {
				salario = salario + 1000*(ano - ano_contrat);
			}else if((ano - ano_contrat) > 1 ) {
				salario = salario + 1000*(ano - ano_contrat - 1);
			}
		}
		return salario;
	}

	@Override
	public double getBonus(int mes, int ano) {
		double bonus = getSalario(mes,ano)/ 5;
		return bonus;
	}
	
	
}
