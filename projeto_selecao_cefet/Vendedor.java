package projeto_selecao_cefet;

public class Vendedor extends Funcionario {
	final double SALARIO = 12000.00;
	
	protected Vendedor(int mes_contrat, int ano_contrat, String nome) {
		super(mes_contrat, ano_contrat, nome);
	}
	
	

	@Override
	public double getSalario(int mes, int ano) {
		double salario = SALARIO;
		if(ano > ano_contrat ) {
			if(mes >= mes_contrat ) {
				salario = salario + 1200*(ano - ano_contrat);
			}else if((ano - ano_contrat) > 1 ) {
				salario = salario + 1200*(ano - ano_contrat - 1);
			}
		}
		return salario;
	}

	@Override
	public double getBonus(int mes, int ano) {
		double bonus = 0;
		try {
			bonus = (Registro.obterValor(getNome(),mes,ano) * 3)/10;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bonus;
	}

}
