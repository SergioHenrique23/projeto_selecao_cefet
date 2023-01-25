package projeto_selecao_cefet;

public class Gerente extends Cargo{

	final double SALARIO = 20000.00;
	
	protected Gerente(int mes_contrat, int ano_contrat, String nome) {
		super(mes_contrat, ano_contrat, nome);
	}

	@Override
	public double getSalario(int mes, int ano) {
		double salario = SALARIO;
		if(ano > ano_contrat ) {
			if(mes >= mes_contrat ) {
				salario = salario + 3000.00*(ano - ano_contrat);
			}else if((ano - ano_contrat) > 1 ) {
				salario = salario + 3000.00*(ano - ano_contrat - 1);
			}
		}
		return salario;
	}
	
	@Override
	public double getBonus(int mes, int ano) {
		return 0;
	}

}
