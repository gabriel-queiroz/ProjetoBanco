package endereco;

public enum Estado {
	
	RS("Rio Grande do Sul"),PR("Paraná"),SC("Santa Catarina"),
	
	SP("São Paulo"),RJ("Rio de Janeiro"),ES("Espírito Santo "),
	
	MG("MInas Gerais"),MT("Mato Grosso"),MS("Mato Grosso do Sul"),
	
	DF("Discrito Federal"),BA("Bahia"),SE("Sergipe"),PE("Pernambuco"),
	
	PB("Paraíba"),RN("Rio Grande do Norte"),PI("Píaui"),CE("Ceará"),
	
	MA("Maranhão"),TO("Tocantins"),AM("Amazonas"),
	
	AP("Amapá"), AC("Acre"), RR("Roraima"),RO("Rondônia"),PA("Pará"),
	
	GO("Goiás");
	
	private String estado;
	
	Estado(String estado){
		
		this.estado = estado;
	}
	
	public String getEstado(){
		
		
		return this.estado;
	}
}
