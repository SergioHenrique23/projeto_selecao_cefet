package projeto_selecao_cefet;

public abstract class Funcionario {
	//Atributos de todos os funcionarios
	private int ano_contrat;
	private int mes_contrat;
	private String nome;
	
	protected Funcionario (int mes_contrat, int ano_contrat, String nome) {// Construtor 
		this.mes_contrat = mes_contrat;
		this.ano_contrat = ano_contrat;
		this.nome = nome;	
	}
	
	public abstract double getSalario(int mes, int ano); // Método abstrato que obtem o salario, depende do cargo
	public abstract double getBonus(int mes, int ano);// Metodo abstrato que obtem o bonus, depende do cargo
	
	public double getSalarioTotal(int mes, int ano) {
		double total = getBonus(mes,ano) + getSalario(mes,ano);
		return total;
	}// Metodos getter para obter o dado quando necessario
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
