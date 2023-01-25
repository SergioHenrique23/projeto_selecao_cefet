package projeto_selecao_cefet;

public class Gerente extends Funcionario{

	final double SALARIO = 20000.00;
	
	protected Gerente(int mes_contrat, int ano_contrat, String nome) {
		super(mes_contrat, ano_contrat, nome);
	}

	@Override
	public double getSalario(int mes, int ano) {
		double salario = SALARIO;
		if(ano > super.getAno_contrat() ) {
			if(mes >= super.getMes_contrat() ) {
				salario = salario + 3000.00*(ano - super.getAno_contrat());
			}else if((ano - super.getAno_contrat()) > 1 ) {
				salario = salario + 3000.00*(ano - super.getAno_contrat() - 1);
			}
		}
		if (ano < super.getAno_contrat() || (ano == super.getAno_contrat() && mes < super.getMes_contrat()) ) {// no caso da data o funcionario nao 
			return 0; //tiver sido contratado na data
		}
		return salario;
	}
	
	@Override
	public double getBonus(int mes, int ano) {
		return 0;
	}

}
