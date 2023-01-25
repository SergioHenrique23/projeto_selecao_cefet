package projeto_selecao_cefet;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	
	public double salarioTotal(List<Funcionario> lista, int mes, int ano) {
		double valor = 0;
		for(int i = 0; i < lista.size(); i++ ) {
			Funcionario funcionario = lista.get(i);
			valor = valor + funcionario.getSalarioTotal(mes, ano);
		}
		return valor;
	}
	
	public double salarioSemBonus(List<Funcionario> lista, int mes, int ano) {
		double valor = 0;
		for(int i = 0; i < lista.size(); i++ ) {
			Funcionario funcionario = lista.get(i);
			valor = valor + funcionario.getSalario(mes, ano);
		}
		return valor;
	}
	
	public double somenteBonus(List<Funcionario> lista, int mes, int ano) {
		double valor = 0;
		for(int i = 0; i < lista.size(); i++ ) {
			Funcionario funcionario = lista.get(i);
			if( !(funcionario instanceof Gerente) ) {
				valor = valor + funcionario.getBonus(mes, ano);
			}
		}
		return valor;
	}
	
	public Funcionario maiorSalario(List<Funcionario> lista, int mes, int ano) {
		Funcionario maior = lista.get(0);
		for(int i = 1; i < lista.size(); i++ ) {
				Funcionario funcionario = lista.get(i);
				if(funcionario.getSalarioTotal(mes, ano) > maior.getSalarioTotal(mes, ano)) {
					maior = funcionario;
				}
		}
		return maior;
	}
	
	public Funcionario maiorBonus(List<Funcionario> lista, int mes, int ano) {
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
	
	public Funcionario maiorVendas(List<Funcionario> lista, int mes, int ano) {
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
		
		
		
		
	}

}
