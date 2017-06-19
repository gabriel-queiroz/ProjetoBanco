package movimento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Movimento {

	private TipoMovimento tipoMovimento;
	private LocalDate dataMovimento;
	private LocalTime horaMovimento;
	private double valorMovimento;

	public Movimento() {

	}


	public Movimento(TipoMovimento tipoMovimento, 
			
			
			LocalDate dataMovimento, 
			LocalTime horaMovimento,
			double valorMovimento) {

		this.tipoMovimento = tipoMovimento;
		this.dataMovimento = dataMovimento;
		this.horaMovimento = horaMovimento;
		this.valorMovimento = valorMovimento;

	}


	public TipoMovimento getTipoMovimento() {

		return tipoMovimento;
	}

	public void setTipoMovimento(TipoMovimento tipoMovimento) {

		this.tipoMovimento = tipoMovimento;
	}

	public LocalDate getDataMovimento() {

		return dataMovimento ;
	}

	public void setDataMovimento(LocalDate dataMovimento) {

		this.dataMovimento = dataMovimento;
	}

	public String getHoraMovimento() {
		
		return formatarHora(this.horaMovimento);
		
		
	}

	public void setHoraMovimento(LocalTime horaMovimento) {

		this.horaMovimento = horaMovimento;
	}

	public double getValorMovimento() {

		return valorMovimento;
	}

	public void setValorMovimento(double valorMovimento) {

		this.valorMovimento = valorMovimento;
	}


	public String toString(){

		return	String.format("\n Tipo Do Movimento........%s "
						+ "\n Código Do Movimento..... %d"
						+ "\n Data Do Movimento........%s "
						+ "\n Hora Do Movimento........%s  "
						+ "\n Valor Do Movimento.......%.2f",

						tipoMovimento.getMovimento(), 
						tipoMovimento.getCodigo(),
						formatarData(this.getDataMovimento()),
						this.getHoraMovimento(),
						valorMovimento);

	}
	
	// formatadores
	
	protected String formatarData(LocalDate data){

		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	protected String formatarHora(LocalTime hora){

		return hora.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
	}


}
