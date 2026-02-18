package calculadora.dominio;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase que realiza las operaciones del programa.
 */
public class Calculadora implements ICalculadora {
	private double resultadoActual;
	private List<Operacion> operacionesGuardadas;
	/**
	 * Constructor de la clase, empieza la lista de operaciones y asigna el valor 0 al resultado actual.
	 */
	public Calculadora () {
		operacionesGuardadas = new ArrayList<>();
		resultadoActual = 0;
	}
	/**
	 * Obtiene el valor del resultado actual.
	 * @return Resultado actual.
	 */
	@Override
	public double getResultadoActual() {
		return resultadoActual;
	}
	/**
	 * Obtiene la lista de operaciones guardadas.
	 * @return Lista de operaciones guardadas.
	 */
	@Override
	public List<Operacion> getOperacionesGuardadas() {
		return operacionesGuardadas;
	}
	/**
	 * Crea y añade una operación a la lista de operaciones guardadas.
	 * @param operacion Cadena con la operación introducida por el usuario.
	 */
	private void crearOperacion(String operacion) {
		this.operacionesGuardadas.add(new Operacion(operacion,resultadoActual));
	}
	/**
	 * Realiza las operaciones en base a los operadores pasados por parámetros.
	 * @param numeros Lista de números usados para las operaciones.
	 * @param operadores Lista de operadores usados para las operaciones.
	 * @param operacion Cadena con la operación introducida por el usuario.
	 */
	@Override
	public void realizarOperacion(List<Double> numeros, List<TipoOperador> operadores, String operacion) {
		resultadoActual = numeros.get(0);
		for (int i = 0; i< operadores.size(); i++) {
			TipoOperador operador = operadores.get(i);
			Double numeroActual = numeros.get(i+1);
			switch (operador) {
			case SUMA -> suma(numeroActual);
			case RESTA -> resta(numeroActual);
			case DIVISION -> division(numeroActual);
			case MULTIPLICACION -> multiplicacion(numeroActual);
			}
		}
		crearOperacion(operacion);
	}
	/**
	 * Realiza una suma.
	 * @param numeroActual Número usado para la operación con el resultado inicial.
	 */
	private void suma(Double numeroActual) {
		resultadoActual+=numeroActual;
	}
	/**
	 * Realiza una resta.
	 * @param numeroActual Número usado para la operación con el resultado inicial.
	 */
	private void resta(Double numeroActual) {
		resultadoActual-=numeroActual;
	}
	/**
	 * Realiza una división.
	 * @param numeroActual Número usado para la operación con el resultado inicial.
	 */
	private void division(Double numeroActual) {
		resultadoActual/=numeroActual;
	}
	/**
	 * Realiza una multiplicación.
	 * @param numeroActual Número usado para la operación con el resultado inicial.
	 */
	private void multiplicacion(Double numeroActual) {
		resultadoActual*=numeroActual;
	}
	/**
	 * Resetea la calculadora, limpia la lista de operaciones y pone el resultado a 0.
	 */
	@Override
	public void reset() {
		operacionesGuardadas.clear();
		resultadoActual = 0;
	}
	/**
	 * Formatea la lista de operaciones guardadas en formato cadena.
	 * @return Lista de operaciones guardadas formateada como cadena.
	 */
	@Override
	public String list() {
		StringBuilder s = new StringBuilder("");
		List<Operacion> resultados = getOperacionesGuardadas();
		for (int i=0;i< resultados.size();i++) {
			s.append(String.format("%d\t%s\n", i+1,resultados.get(i).toString()));
		}
		if (getOperacionesGuardadas().isEmpty()) {
			s.append(String.format("No hay operaciones registradas."));
		}else {
			s.append(String.format("Resultado actual: %.2f",getResultadoActual()));
		}
		return s.toString();
	}
}