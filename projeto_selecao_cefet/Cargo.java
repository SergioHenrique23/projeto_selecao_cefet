package projeto_selecao_cefet;

public abstract class Cargo {

	protected int ano_contrat;
	protected int mes_contrat;
	protected String nome;
	
	protected Cargo (int mes_contrat, int ano_contrat, String nome) {
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
	
}
