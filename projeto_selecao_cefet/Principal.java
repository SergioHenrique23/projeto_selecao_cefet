package projeto_selecao_cefet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Sergio Henrique Mendes de Assis
 *
 */

public class Principal {
	
	static double salarioTotal(List<Funcionario> lista, int mes, int ano) {// metodo da soma de salarios, recebe a lista de funcionarios mes e o ano
		double valor = 0;
		for(int i = 0; i < lista.size(); i++ ) { // percorre a lista
			Funcionario funcionario = lista.get(i); //
			valor = valor + funcionario.getSalarioTotal(mes, ano);// soma o valor do salario total utilizando a fucao da classe funcionarios
		}
		return valor;
	}
	
	static double salarioSemBonus(List<Funcionario> lista, int mes, int ano) {// metodo do valor do salario sem bonus
		double valor = 0;// utiliza da mesma forma do metodo acima
		for(int i = 0; i < lista.size(); i++ ) {// Porem udtiliza a funcao getSalario
			Funcionario funcionario = lista.get(i);
			valor = valor + funcionario.getSalario(mes, ano);
		}
		return valor;
	}
	
	static double somenteBonus(List<Funcionario> lista, int mes, int ano) {
		double valor = 0;// mesmo formato dos metodos acima porem utiliza o metodo getBonus da classe funcionarios
		for(int i = 0; i < lista.size(); i++ ) {
			Funcionario funcionario = lista.get(i);
			if( !(funcionario instanceof Gerente) ) {
				valor = valor + funcionario.getBonus(mes, ano);
			}
		}
		return valor;
	}
	
	static Funcionario maiorSalario(List<Funcionario> lista, int mes, int ano) { // nesse metodo ja retorna um funcionario
		Funcionario maior = lista.get(0); 
		for(int i = 1; i < lista.size(); i++ ) { // sendo o de maior salario a ser retornado, para isso percorre a lista
				Funcionario funcionario = lista.get(i);
				if(funcionario.getSalarioTotal(mes, ano) > maior.getSalarioTotal(mes, ano)) { // compara os salarios totais
					maior = funcionario; // se for maior que o maior encontrado o substitui nessa posicao
				}
		}
		return maior;
	}
	
	static Funcionario maiorBonus(List<Funcionario> lista, int mes, int ano) { // o maior bonus no mes
		Funcionario maior = lista.get(0);
		for(int i = 1; i < lista.size(); i++ ) {// percorre a lista de funcionarios verificando os bonus
			
				Funcionario funcionario = lista.get(i);
				if(!(funcionario instanceof Gerente)) {
					if(funcionario.getBonus(mes, ano) > maior.getBonus(mes, ano)) {
						maior = funcionario;
					}
				}
				
		}
		return maior;
	}
	
	static Funcionario maiorVendas(List<Funcionario> lista, int mes, int ano) {
		Funcionario maior = lista.get(0);
		for(int j = 0; j < lista.size(); j++ ) {// coloca o vendedor em primeiro
			if( !(lista.get(j) instanceof Vendedor) ) {
				maior = lista.get(j);
				break;
			}
		}
		for(int i = 1; i < lista.size(); i++ ) { // utiliza do metodo getNome e do ObterValor para comparar as vendas 	
				Funcionario funcionario = lista.get(i);
				if((funcionario instanceof Vendedor)) {
					if(Registro.obterValor(funcionario.getNome(), mes, ano) > Registro.obterValor(maior.getNome(), mes, ano)) {
						maior = funcionario;
					}
				}
				
		}
		return maior;
	}
	
	public static void main ( String [] args){
		
		// cria os funcionarios
		Funcionario jorge_Carvalho = new Secretario(1,2018,"Jorge Carvalho");
		Funcionario maria_Souza = new Secretario(12,2015,"Maria Souza");
		Funcionario ana_Silva = new Vendedor(12,2021,"Ana Silva");
		Funcionario joao_Mendes = new Vendedor(12,2021,"João Mendes");
		Funcionario juliana_Alves = new Gerente(7,2017,"Juliana Alves");
		Funcionario bento_Albino = new Gerente(3,2014,"Bento Albino");
		
		// cria as listas necessarias para os testes
		List<Funcionario> lista_Completa = new ArrayList<Funcionario>();
		List<Funcionario> lista_Beneficios = new ArrayList<Funcionario>();
		List<Funcionario> lista_Vendedores = new ArrayList<Funcionario>();
		
		lista_Completa.add(jorge_Carvalho);
		lista_Completa.add(maria_Souza);
		lista_Completa.add(ana_Silva);
		lista_Completa.add(joao_Mendes);
		lista_Completa.add(juliana_Alves);
		lista_Completa.add(bento_Albino);
		
		lista_Beneficios.add(jorge_Carvalho);
		lista_Beneficios.add(maria_Souza);
		lista_Beneficios.add(ana_Silva);
		lista_Beneficios.add(joao_Mendes);
		
		lista_Vendedores.add(ana_Silva);
		lista_Vendedores.add(joao_Mendes);
		
		// scannser para ler do teclado
		Scanner input = new Scanner(System.in);
		
		// menu de interacao
		while(true) {
			System.out.println("\n\n");
			int op = 0;
			System.out.println("Escolha a opção de teste:");
			System.out.println("1 - Soma de todos os salarios completos em um mês");
			System.out.println("2 - Soma de todos os salarios sem os bonus em um mês");
			System.out.println("3 - Soma de somento que foi gasto em bonus completos em um mês");
			System.out.println("4 - Funcionario que recebeu maior salario em determinado mês");
			System.out.println("5 - Funcionario que recebeu maior bonus em determinado mês");
			System.out.println("6 - Vendedor que mais vendeu em determinado mes");
			System.out.println("7 - Todos as funções anteriores de 12/2021 a 04/2022");
			System.out.println("(Qualque outro numero) - Sair");
			System.out.println("Digite o numero");
			op = input.nextInt();
			input.nextLine();
			switch (op) {// com a interacao com o usuario, realiza as operacoes de cada metodo
			case 1:// realiza e imprime a operacao do primeiro metodo			
				System.out.println("Digite o numero do mês (Sem o 0 a frente, como '2' para fevereiro).");
				int mes = input.nextInt();
				input.nextLine();
				System.out.println("Digite o ano");
				int ano = input.nextInt();
				input.nextLine();
				double valorTotal = salarioTotal(lista_Completa,mes,ano);
				System.out.printf("O valor da soma de todos os salarios na data %d/%d é: R$ %.2f \n", mes, ano, valorTotal);
				break;
			case 2:// realiza
				System.out.println("Digite o numero do mês (Sem o 0 a frente, como '2' para fevereiro).");
				mes = input.nextInt();
				input.nextLine();
				System.out.println("Digite o ano");
				ano = input.nextInt();
				input.nextLine();
				double valor_SBonus = salarioSemBonus(lista_Completa,mes,ano);
				System.out.printf("O valor da soma de todos os salarios sem os bonus na data %d/%d é: R$ %.2f \n ", mes, ano, valor_SBonus);
				break;
			case 3:
				System.out.println("Digite o numero do mês (Sem o 0 a frente, como '2' para fevereiro).");
				mes = input.nextInt();
				input.nextLine();
				System.out.println("Digite o ano");
				ano = input.nextInt();
				input.nextLine();
				double valor_Bonus = somenteBonus(lista_Beneficios,mes,ano);
				System.out.printf("O valor da soma dos bonus na data %d/%d é: R$ %.2f \n ", mes, ano, valor_Bonus);
				break;
			case 4:
				System.out.println("Digite o numero do mês (Sem o 0 a frente, como '2' para fevereiro).");
				mes = input.nextInt();
				input.nextLine();
				System.out.println("Digite o ano");
				ano = input.nextInt();
				input.nextLine();
				Funcionario ganha_mais = maiorSalario(lista_Completa,mes,ano);
				System.out.printf("Na data %d/%d quem mais recebeu foi o(a) %s o valor foi: R$ %.2f \n", mes, ano, ganha_mais.getNome(), ganha_mais.getSalarioTotal(mes, ano));
				break;
			case 5:
				System.out.println("Digite o numero do mês (Sem o 0 a frente, como '2' para fevereiro).");
				mes = input.nextInt();
				input.nextLine();
				System.out.println("Digite o ano");
				ano = input.nextInt();
				input.nextLine();
				Funcionario maior_bonus = maiorBonus(lista_Beneficios,mes,ano);
				System.out.printf("Na data %d/%d quem recebeu o maior bonus foi o(a) %s o valor foi: R$ %.2f \n", mes, ano, maior_bonus.getNome(), maior_bonus.getBonus(mes, ano));
				break;
			case 6:
				System.out.println("Digite o numero do mês (Sem o 0 a frente, como '2' para fevereiro).");
				mes = input.nextInt();
				input.nextLine();
				System.out.println("Digite o ano");
				ano = input.nextInt();
				input.nextLine();
				Funcionario mais_vendeu = maiorVendas(lista_Vendedores,mes,ano);
				double valor_vendido = Registro.obterValor(mais_vendeu.getNome(), mes, ano);
				System.out.printf("Na data %d/%d quem mais vendeu foi o(a) %s o valor foi: R$ %.2f \n", mes, ano, mais_vendeu.getNome(), valor_vendido);
				break;
			case 7:
				int mo = 12;
				ano = 2021;
				while (mo != 5) {
					System.out.printf("%d/%d \n", mo, ano);
					valorTotal = salarioTotal(lista_Completa,mo ,ano);
					System.out.printf("O valor da soma de todos os salarios nessa data (%d/%d) é: R$ %.2f \n",mo, ano, valorTotal);
					valor_SBonus = salarioSemBonus(lista_Completa,mo,ano);
					System.out.printf("O valor da soma de todos os salarios sem os bonus nessa data (%d/%d) é: R$ %.2f \n ",mo, ano, valor_SBonus);
					valor_Bonus = somenteBonus(lista_Beneficios,mo,ano);
					System.out.printf("O valor da soma dos bonus nessa data (%d/%d) é: R$ %.2f \n",mo, ano, valor_Bonus);
					ganha_mais = maiorSalario(lista_Completa,mo,ano);
					System.out.printf("Na data %d/%d quem mais recebeu foi o(a) %s o valor foi: R$ %.2f \n",mo, ano, ganha_mais.getNome(), ganha_mais.getSalarioTotal(mo,ano));
					maior_bonus = maiorBonus(lista_Beneficios,mo,ano);
					System.out.printf("Na data %d/%d quem recebeu o maior bonus foi o(a) %s o valor foi: R$ %.2f \n",mo, ano, maior_bonus.getNome(), maior_bonus.getBonus(mo, ano));
					mais_vendeu = maiorVendas(lista_Vendedores,mo,ano);
					valor_vendido = Registro.obterValor(mais_vendeu.getNome(), mo, ano);
					System.out.printf("Na data %d/%d quem mais vendeu foi o(a) %s o valor foi: R$ %.2f \n",mo, ano, mais_vendeu.getNome(), valor_vendido);
					System.out.println("---------------------------------------------------------------");
					mo++;
					if(mo == 13) {
						mo = 1;
						ano++;
					}
				}
				break;
			default:
				System.exit(0);
				break;
			}
			
		}
		
	}

}
