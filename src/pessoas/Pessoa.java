package pessoas;

import endereco.Endereco;

public class Pessoa {

	private String nome;
	private float rendaPessoa;
	private boolean ativo;
	private Endereco endereco;
	private Sexo sexo;
	
	public Pessoa(String nome, float rendaPessoa, boolean ativo, Sexo sexo, Endereco endereco) {
	
		this.nome = nome;
		this.rendaPessoa = rendaPessoa;
		this.ativo = ativo;
		this.endereco = endereco;
		this.sexo = sexo;
	}
	
	public Pessoa(){
		
	}
	
	
	public String getNome() {
		return nome;
	
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	
	}
	
	public float getRendaPessoa() {
		return rendaPessoa;
	
	}
	
	public void setRendaPessoa(float rendaPessoa) {
		this.rendaPessoa = rendaPessoa;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	

	public String getSexo() {
		return sexo.getSexo();
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", rendaPessoa=" + rendaPessoa + ", ativo=" + ativo + ", endereco=" + endereco
				+ ", sexo=" + sexo.getSexo() + "]";
	}

	
	
	
	
	
}
