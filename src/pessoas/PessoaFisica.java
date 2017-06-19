package pessoas;

import endereco.Endereco;

public class PessoaFisica  extends Pessoa{
	
	
	private String cpf;
	private String rg;
	

	
	public PessoaFisica(String nome, float rendaPessoa, boolean ativo, Sexo sexo, Endereco endereco, String cpf,
			String rg) {
		super(nome, rendaPessoa, ativo, sexo, endereco);
		this.cpf = cpf;
		this.rg = rg;
	}


	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public String toString() {
		return "PessoaFisica [cpf=" + cpf + ", rg=" + rg + "]";
	}
	
	
	
	
	
}
