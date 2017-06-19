package movimento;

import java.time.LocalDate;
import java.time.LocalTime;

import pessoas.Pessoa;

public class MovimentoTranferir extends Movimento {
	
	
	private String distinatario;
	
	public MovimentoTranferir(TipoMovimento tipoMovimento, LocalDate dataMovimento, LocalTime horaMovimento,
			double valorMovimento, String destinatario) {
			super(tipoMovimento, dataMovimento, horaMovimento, valorMovimento);
		
		this.distinatario = destinatario;	
			
	}

	public String getDistinatario() {
		return distinatario;
	}

	public void setDistinatario(String distinatario) {
		this.distinatario = distinatario;
	}
		
	public String toString(){
			
		
		
		return	String.format("\n Tipo Do Movimento........%s "
						+ "\n Código Do Movimento..... %d"
						+ "\n Data Do Movimento........%s "
						+ "\n Hora Do Movimento........%s  "
						+ "\n Valor Do Movimento.......%.2f"
						+ "\n %s", 

						this.getTipoMovimento().getMovimento(), 
						this.getTipoMovimento().getCodigo(),
						(this.formatarData(getDataMovimento())),
						(this.getHoraMovimento()),
						 this.getValorMovimento(),
						 this.getDistinatario());
		}
		
	
	
}	
