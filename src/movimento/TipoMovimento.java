package movimento;

public enum TipoMovimento {

	SAQUE("Saque",123)

	,DEPOSITO("Deposito",456),

	TRANSFERENCIA_ENTRADA("Tranferência De entrada",789)

	,TRANSFERENCIA_SAIDA("Transferência de Saída",1012);

	private String movimento;
	private int codigo;

	TipoMovimento(String m,int cod){

		this.movimento = m;
		this.codigo = cod;
	}

	public int getCodigo(){

		return this.codigo;
	}

	public String getMovimento(){

		return this.movimento;
	}

}
