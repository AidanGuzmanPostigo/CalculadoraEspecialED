package calculadora.dominio;
public class Operacion {
	private String operacion;
	private double resultado;
	protected Operacion (String operacion, double resultado) {
		this.operacion = operacion;
		this.resultado = resultado;
	}
	@Override
	public String toString() {
		return String.format("%s = %.2f",operacion, resultado);
	}
}