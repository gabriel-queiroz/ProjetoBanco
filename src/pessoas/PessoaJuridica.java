package pessoas;

import endereco.Endereco;

public class PessoaJuridica  extends Pessoa{

	private String cnpj;

	
	
	public PessoaJuridica(String nome, float rendaPessoa, boolean ativo, Sexo sexo, Endereco endereco, String cnpj) {
		super(nome, rendaPessoa, ativo, sexo, endereco);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	
	@Override
	public String toString() {
		return "PessoaJuridica [cnpj=" + cnpj + "]";
	}
	
	
	
}
