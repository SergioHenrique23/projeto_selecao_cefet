package projeto_selecao_cefet;

public class Secretario extends Funcionario {// Classe filha da Principal
	final double SALARIO = 7000.00;// O salario base e constante

	public Secretario(int mes_contrat, int ano_contrat, String nome) {
		super(mes_contrat, ano_contrat, nome);
	}

	@Override
	public double getSalario(int mes, int ano) {// calculo do salario
		double salario = SALARIO;
		if(ano > super.getAno_contrat() ) {// se tiver mais de um ano de emprego realiza o calculo do bonus
			if(mes >= super.getMes_contrat() ) {
				salario = salario + 1000*(ano - super.getAno_contrat());
			}else if((ano - super.getAno_contrat()) > 1 ) {
				salario = salario + 1000*(ano - (super.getAno_contrat() + 1));
			}
		}
		if (ano < super.getAno_contrat() || (ano == super.getAno_contrat() && mes < super.getMes_contrat()) ) {// no caso da data o funcionario nao 
			salario = 0; //tiver sido contratado na data
		}
		return salario;
	}

	@Override
	public double getBonus(int mes, int ano) {
		double bonus = getSalario(mes,ano)/5;
		return bonus;
	}
	
	
}
