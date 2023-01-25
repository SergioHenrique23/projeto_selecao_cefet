package projeto_selecao_cefet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	static double salarioTotal(List<Funcionario> lista, int mes, int ano) {
		double valor = 0;
		for(int i = 0; i < lista.size(); i++ ) {
			Funcionario funcionario = lista.get(i);
			valor = valor + funcionario.getSalarioTotal(mes, ano);
		}
		return valor;
	}
	
	static double salarioSemBonus(List<Funcionario> lista, int mes, int ano) {
		double valor = 0;
		for(int i = 0; i < lista.size(); i++ ) {
			Funcionario funcionario = lista.get(i);
			valor = valor + funcionario.getSalario(mes, ano);
		}
		return valor;
	}
	
	static double somenteBonus(List<Funcionario> lista, int mes, int ano) {
		double valor = 0;
		for(int i = 0; i < lista.size(); i++ ) {
			Funcionario funcionario = lista.get(i);
			if( !(funcionario instanceof Gerente) ) {
				valor = valor + funcionario.getBonus(mes, ano);
			}
		}
		return valor;
	}
	
	static Funcionario maiorSalario(List<Funcionario> lista, int mes, int ano) {
		Funcionario maior = lista.get(0);
		for(int i = 1; i < lista.size(); i++ ) {
				Funcionario funcionario = lista.get(i);
				if(funcionario.getSalarioTotal(mes, ano) > maior.getSalarioTotal(mes, ano)) {
					maior = funcionario;
				}
		}
		return maior;
	}
	
	static Funcionario maiorBonus(List<Funcionario> lista, int mes, int ano) {
		Funcionario maior = lista.get(0);
		for(int j = 1; j < lista.size(); j++ ) {
			if( !(lista.get(j) instanceof Gerente) ) {
				maior = lista.get(j);
				break;
			}
		}
		for(int i = 1; i < lista.size(); i++ ) {
			
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
		for(int j = 1; j < lista.size(); j++ ) {
			if( !(lista.get(j) instanceof Vendedor) ) {
				maior = lista.get(j);
				break;
			}
		}
		for(int i = 1; i < lista.size(); i++ ) {
			
				Funcionario funcionario = lista.get(i);
				if(!(funcionario instanceof Vendedor)) {
					if(funcionario.getBonus(mes, ano) > maior.getBonus(mes, ano)) {
						maior = funcionario;
					}
				}
				
		}
		return maior;
	}
	
	public static void main ( String [] args){
		System.out.println("\n");
		Funcionario jorge_Carvalho = new Secretario(1,2018,"Jorge Carvalho");
		Funcionario maria_Souza = new Secretario(12,2015,"Maria Souza");
		Funcionario ana_Silva = new Vendedor(12,2021,"Ana Silva");
		Funcionario joao_Mendes = new Vendedor(12,2021,"João Mendes");
		Funcionario juliana_Alves = new Gerente(7,2017,"Juliana Alves");
		Funcionario bento_Albino = new Gerente(3,2014,"Bento Albino");
		
		
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
		
		Scanner input = new Scanner(System.in);
		
		
		
		while(true) {
			int op = 0;
			System.out.println("Escolha a opção de teste:");
			System.out.println("1 - Soma de todos os salarios completos em um mês");
			System.out.println("2 - Soma de todos os salarios sem os bonus em um mês");
			System.out.println("3 - Soma de somento que foi gasto em bonus completos em um mês");
			System.out.println("4 - Funcionario que recebeu maior salario em determinado mês");
			System.out.println("5 - Funcionario que recebeu maior bonus em determinado mês");
			System.out.println("6 - Vendedor que mais vendeu em determinado mes");
			System.out.println("Digite o numero");
			op = input.nextInt();
			input.nextLine();
			switch (op) {
			case 1:			
				System.out.println("Digite o numero do mês (Sem o 0 a frente, como '2' para fevereiro).");
				int mes = input.nextInt();
				input.nextLine();
				System.out.println("Digite o ano");
				int ano = input.nextInt();
				input.nextLine();
				double valorTotal = salarioTotal(lista_Completa,mes,ano);
				System.out.println("O valor da soma de todos os salarios na data " + mes + "/" + ano + " é: " + valorTotal);
				break;
			case 2:
				System.out.println("Digite o numero do mês (Sem o 0 a frente, como '2' para fevereiro).");
				mes = input.nextInt();
				input.nextLine();
				System.out.println("Digite o ano");
				ano = input.nextInt();
				input.nextLine();
				double valor_SBonus = salarioSemBonus(lista_Completa,mes,ano);
				System.out.println("O valor da soma de todos os salarios sem os bonus na data " + mes + "/" + ano + " é: " + valor_SBonus);
				break;
			case 3:
				System.out.println("Digite o numero do mês (Sem o 0 a frente, como '2' para fevereiro).");
				mes = input.nextInt();
				input.nextLine();
				System.out.println("Digite o ano");
				ano = input.nextInt();
				input.nextLine();
				double valor_Bonus = somenteBonus(lista_Beneficios,mes,ano);
				System.out.println("O valor da soma dos bonus na data " + mes + "/" + ano + " é: " + valor_Bonus);
				break;
			case 4:
				System.out.println("Digite o numero do mês (Sem o 0 a frente, como '2' para fevereiro).");
				mes = input.nextInt();
				input.nextLine();
				System.out.println("Digite o ano");
				ano = input.nextInt();
				input.nextLine();
				Funcionario ganha_mais = maiorSalario(lista_Completa,mes,ano);
				System.out.println("Na data " + mes + "/" + ano + " quem mais recebeu foi " + ganha_mais.getNome() + " o valor foi: " + ganha_mais.getSalarioTotal(mes, ano));
				break;
			case 5:
				System.out.println("Digite o numero do mês (Sem o 0 a frente, como '2' para fevereiro).");
				mes = input.nextInt();
				input.nextLine();
				System.out.println("Digite o ano");
				ano = input.nextInt();
				input.nextLine();
				Funcionario maior_bonus = maiorBonus(lista_Beneficios,mes,ano);
				System.out.println("Na data " + mes + "/" + ano + " quem mais recebeu bonificações foi " + maior_bonus.getNome() + " o valor foi: " + maior_bonus.getBonus(mes, ano));
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
				System.out.println("Na data " + mes + "/" + ano + " quem mais vendeu foi " + mais_vendeu.getNome() + " o valor foi: " + valor_vendido);
				break;
			}
			
		}
		
	}

}
