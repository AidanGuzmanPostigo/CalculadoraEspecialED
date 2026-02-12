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
	public int getId() {
		return id;
	}
	public String getOperacion() {
		return operacion;
	}
	public double getResultado() {
		return resultado;
	}
	@Override
	public String toString() {
		return String.format("%d.\t%s = %.2f", getId(),getOperacion(), getResultado());
	}
}
