  package pessoas;

public enum Sexo {
	
	M("Masculino"), F("Feminino");
	
	private String sexo;
	
	Sexo(String sexo){
		
		this.sexo = sexo;
	}
	
	public String getSexo(){
		
		return this.sexo;
	}
	
}
