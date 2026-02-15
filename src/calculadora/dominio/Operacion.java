package calculadora.dominio;
/**
 * Clase que guarda las operaciones del programa y su resultado
 */
public class Operacion {
	private String operacion;
	private double resultado;
	/**
	 * Constructor de la clase.
	 * @param operacion Cadena con la operación introducida por el usuario.
	 * @param resultado Resultado de la operación introducida por el usuario.
	 */
	public Operacion (String operacion, double resultado) {
		this.operacion = operacion;
		this.resultado = resultado;
	}
	@Override
	public String toString() {
		return String.format("%s = %.2f",operacion, resultado);
	}
}