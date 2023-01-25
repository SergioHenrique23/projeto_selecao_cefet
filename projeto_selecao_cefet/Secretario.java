package projeto_selecao_cefet;

public class Secretario extends Funcionario {
	final double SALARIO = 7000.00;

	public Secretario(int mes_contrat, int ano_contrat, String nome) {
		super(mes_contrat, ano_contrat, nome);
	}

	@Override
	public double getSalario(int mes, int ano) {
		double salario = SALARIO;
		if(ano > super.getAno_contrat() ) {
			if(mes >= super.getMes_contrat() ) {
				salario = salario + 1000*(ano - super.getAno_contrat());
			}else if((ano - super.getAno_contrat()) > 1 ) {
				salario = salario + 1000*(ano - super.getAno_contrat() - 1);
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
