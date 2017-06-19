package teste;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import conta.Conta;
import endereco.Endereco;
import endereco.Estado;
import movimento.Movimento;
import movimento.TipoMovimento;
import pessoas.Pessoa;
import pessoas.PessoaFisica;
import pessoas.Sexo;

public class Teste01 {

	public static void main(String[] args) {

		
			
		
		Conta c1 = new Conta(
				123455,
				LocalDate.of(2001, Month.APRIL, 23),
				true,
				"12344",
				1000,
				new PessoaFisica("Gabriel",1200f,true,Sexo.M,
				new Endereco("São Luis","58220-00","centro",120,"João Pessoa",Estado.GO),"1223","1343"));

		Conta c2 = new Conta(
					123455,
					LocalDate.of(2002, Month.DECEMBER, 12),
					true,
					"ffs",
					100,
					new PessoaFisica("Luis",300,true,Sexo.M,
					new Endereco("São Douglas","58220-86","Manaíra",120,"Natal",Estado.BA),"12222","1343222"));

			
		
		try{
			
			
			
			c1.transferir(c2,100,LocalDate.of(2010, Month.AUGUST, 23),LocalTime.of(12,35));
			
			c1.transferir(c2, 100,LocalDate.of(2011, Month.JANUARY,1),LocalTime.of(22, 10));
		
			c1.sacar(200,LocalDate.of(2012, Month.AUGUST,2),LocalTime.of(9, 45));
			
			c1.depositar(500,LocalDate.of(2012, Month.JANUARY,10),LocalTime.of(13, 20));
			
			c1.sacar(300,LocalDate.of(2010, Month.AUGUST,10),LocalTime.of(14, 55));
			
			c1.sacar(20,LocalDate.of(2011, Month.JANUARY,23),LocalTime.of(17, 20));
			
			c2.transferir(c1, 200, LocalDate.of(2010, Month.DECEMBER, 12), LocalTime.of(20, 30));
			
			
		}catch(IllegalArgumentException c){


			System.out.println(c.getMessage());
		}
		
		 // a conta c1 não existe movimento do ano 2018 e mes 8 então lançara uma exception
		
		try{
		
			System.out.println("====== EXTRATO CONTA ===========");

			System.out.println("Transações feita entre no mês de 08/2018");
			
			
			
			c1.consultarMovimento(2018, 8).forEach(System.out::println);;


		}catch(IllegalArgumentException e){

			System.out.println(e.getMessage());
		}

		try{
		
			
		
		System.out.println("====== EXTRATO CONTA ===========");
		
		System.out.println("Transações feita entre no mês de 08/2012");
		
		c1.consultarMovimento(2012, 8).forEach(System.out::println);
		
		
		
		
		
		System.out.println("===== EXTRATO CONTA =========");
		System.out.println("Transações feita entre : 10/08/2010  á  02/08/2012");
		
		c1.consultarMovimento(LocalDate.of(2010, Month.AUGUST, 10),
            	 LocalDate.of(2012, Month.AUGUST, 2)).forEach(System.out::println);
			
		}catch(IllegalArgumentException e){
			
			System.out.println(e.getMessage());
		}
	
		
	
	}
	
	
	
	
}
