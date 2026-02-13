package calculadora.dominio;
public class Operacion {
	private int id;
	private String operacion;
	private double resultado;
	protected Operacion (String operacion, int id, double resultado) {
		this.id = id;
		this.operacion = operacion;
		this.resultado = resultado;
	}
	@Override
	public String toString() {
		return String.format("%d.\t%s = %.2f", id,operacion, resultado);
	}
}
