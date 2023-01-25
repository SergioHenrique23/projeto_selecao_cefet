package projeto_selecao_cefet;

public class Vendedor extends Funcionario {
	final double SALARIO = 12000.00;
	
	protected Vendedor(int mes_contrat, int ano_contrat, String nome) {
		super(mes_contrat, ano_contrat, nome);
	}
	
	

	@Override
	public double getSalario(int mes, int ano) {
		double salario = SALARIO;
		if(ano > super.getAno_contrat() ) {
			if(mes >= super.getMes_contrat() ) {
				salario = salario + 1800*(ano - super.getAno_contrat());
			}else if((ano - super.getAno_contrat()) > 1 ) {
				salario = salario + 1800*(ano - super.getAno_contrat() - 1);
			}
		}
		if (ano < super.getAno_contrat() || (ano == super.getAno_contrat() && mes < super.getMes_contrat()) ) {// no caso da data o funcionario nao 
			return 0; //tiver sido contratado na data
		}
		return salario;
	}

	@Override
	public double getBonus(int mes, int ano) {
		if (ano < super.getAno_contrat() || (ano == super.getAno_contrat() && mes < super.getMes_contrat()) ) {// no caso da data o funcionario nao 
			return 0; //tiver sido contratado na data
		}
		double bonus = 0;
		try {
			bonus = (Registro.obterValor(super.getNome(),mes,ano) * 3)/10;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bonus;
	}

}
