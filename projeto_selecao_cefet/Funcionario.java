package projeto_selecao_cefet;

public abstract class Funcionario {

	private int ano_contrat;
	private int mes_contrat;
	private String nome;
	
	protected Funcionario (int mes_contrat, int ano_contrat, String nome) {
		this.mes_contrat = mes_contrat;
		this.ano_contrat = ano_contrat;
		this.nome = nome;	
	}
	
	public abstract double getSalario(int mes, int ano);
	public abstract double getBonus(int mes, int ano);
	
	public double getSalarioTotal(int mes, int ano) {
		double total = getBonus(mes,ano) + getSalario(mes,ano);
		return total;
	}
	public String getNome() {
		return this.nome;
	}
	public int getAno_contrat() {
		return this.ano_contrat;
	}
	public int getMes_contrat() {
		return this.mes_contrat;
	}
	
}
