package conta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import movimento.Movimento;
import movimento.MovimentoTranferir;
import movimento.TipoMovimento;
import pessoas.Pessoa;


public   class  Conta {

	private long NumeroConta;
	private LocalDate dataAbertura;
	private LocalDate dataEncerramento;
	private boolean ativa;
	private String 	senha;
	private double saldo;
	private List<Movimento> movimentos;
	private Pessoa pessoa;

	public Conta(){

		
	

	}
	
	public Conta(long numeroConta, LocalDate dataAbertura, boolean ativa, String senha,
			double saldo,  Pessoa pessoa) {

		NumeroConta = numeroConta;
		this.dataAbertura = dataAbertura;

		this.ativa = ativa;
		this.senha = senha;
		this.saldo = saldo;
		this.pessoa = pessoa;
		this.ativa = true;
		this.movimentos = new ArrayList<>();
	}
	// metodos especiais 


	public void desativarConta(){

		if(this.ativa){


			if(this.saldo > 0){

				lancadorDeIllegalArgumentException(
						"Você precisa sacar todo o saldo para desativar suas conta");

			}

			this.ativa = false;
			System.out.println("Conta desativa");
		}
		else{

			lancadorDeIllegalArgumentException("A conta já está desativada");

		}
	}

	public void ativarConta(){

		if(this.ativa){
			lancadorDeIllegalArgumentException("A conta já está ativada");
		}
		
		else{
			
			this.ativa = true;
			
		}
	}


	public  void sacar(double valor,LocalDate data, LocalTime hora) {
		
		
		
		validarValores(valor);

		validarSaldoConta(this, valor);

		
		this.saldo-= valor;

		movimentos.add(new Movimento(
				TipoMovimento.SAQUE
				,data
				,hora
				,valor));


	}

	public void  depositar(double valor,LocalDate data, LocalTime hora) {

		validarValores(valor);

		this.saldo+=valor;
		movimentos.add(new Movimento(
				TipoMovimento.DEPOSITO
				,data
				,hora
				,valor));


	}

	public void transferir(Conta conta, double valor,LocalDate data, LocalTime hora) {


		
		validarValores(valor);

		validarSaldoConta(this, valor);


		if(conta == this){

			lancadorDeIllegalArgumentException(("você não pode tranferir para você"));
		}
		else{

			this.saldo-=valor;

			conta.setSaldo(conta.getSaldo()+valor);

			this.movimentos.add(new MovimentoTranferir(
					TipoMovimento.TRANSFERENCIA_SAIDA
					,data
					,hora
					,valor,conta.dadosContaThis()));

			conta.movimentos.add(new MovimentoTranferir(
					TipoMovimento.TRANSFERENCIA_ENTRADA
					,data
					,hora
					,valor,conta.dadosContaOutro()));
		}

	}
	
	
	public List<Movimento> consultarMovimento(LocalDate dataInicial, LocalDate dataFinal){




		List<Movimento> listaConsulta =	this.movimentos.stream()
				
				.filter(
						f -> (f.getDataMovimento().isAfter(dataInicial) || f.getDataMovimento().equals(dataInicial))

						&& 

						(f.getDataMovimento().isBefore(dataFinal) || f.getDataMovimento().equals(dataFinal))
						
						).collect(Collectors.toList());
		
		
		return listaConsulta;

	}

	
	public List<Movimento> consultarMovimento(int ano, int mes){



		List<Movimento> movimentosConsulta = this.movimentos.stream()

				.filter(
						f -> f.getDataMovimento().getYear() == ano 
						
						&& 

						f.getDataMovimento().getMonth().getValue() == mes)

				.collect(Collectors.toList());
		
		if(movimentosConsulta.isEmpty()){
			
			lancadorDeIllegalArgumentException("Não existem Movimentos nessa Mês e Ano");
			
		}
		
		return movimentosConsulta;

	}


	// getters e setters


	public long getNumeroConta() {return NumeroConta;}

	public void setNumeroConta(long numeroConta) {NumeroConta = numeroConta;}

	
	public String getDataAbertura() {return formatarData(this.dataAbertura);}

	public String getDataEncerramento() {
		
		if(this.ativa){
			
			lancadorDeIllegalArgumentException("a Conta Ainda está ativa");
		}

		return formatarData(this.dataEncerramento);

	}

	public void setDataEncerramento(LocalDate dataEncerramento) {

		if(this.ativa == false){

			this.dataEncerramento = dataEncerramento;

		}
		else{


			lancadorDeIllegalArgumentException("a está conta ativa");
		}
	}

	
	public boolean isAtiva() {return ativa;}

	public void setAtiva(boolean ativa) {this.ativa = ativa;}

	
	public String getSenha() {return senha;}

	public void setSenha(String senha) {this.senha = senha;}

	
	public double getSaldo() {return saldo;}

	public void setSaldo(double saldo) {this.saldo = saldo;}

	
	public void getMovimentos() {movimentos.forEach(System.out::println);}

	public void addMovimentos(Movimento movimentos) {this.movimentos.add(movimentos);}

	
	public Pessoa getPessoa() {	return pessoa;}

	public void setPessoa(Pessoa pessoa) {this.pessoa = pessoa;}

	// formatador de datas

	private String formatarData(LocalDate data){

		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	// toString Para o Dono da conta
	
	

	@Override
	public String toString() {
		
		return "Conta [NumeroConta=" + NumeroConta + ", "

				+ "dataAbertura=" + formatarData(dataAbertura) + 
				", ativa = " + ativa + 
				", senha = " + senha + " "+ 
				", saldo = " + saldo + 
				", movimentos = " + movimentos + 
				", Pessoa = " + pessoa + " " +
				"]";
	}
	
	
	
	
	

	// informacoes da conta

	private String dadosContaThis(){

		return String.format(
								"Número da Conta......... %d  " +
								"\n destinátario............. %s ",

				this.getNumeroConta(),this.getPessoa().getNome());

	}

	private String dadosContaOutro(){
		
		return String.format(
				"Número da Conta......... %d  " +
				"\n Remetente................%s ",

this.getNumeroConta(),this.getPessoa().getNome());

	}
	

	// validadores

	private void validarValores(double valor){

		if(valor <= 0){

			lancadorDeIllegalArgumentException(("Valor negativo ou zero, impossível continuar operação"));

		}
	}

	private void validarSaldoConta(Conta c, double valor){

		if(c.getSaldo() < valor){

			lancadorDeIllegalArgumentException("Saldo da Conta insuficiente");

		}
	}

	private void lancadorDeIllegalArgumentException(String mensagem){

		throw new IllegalArgumentException(mensagem);

	}




}
