package calculadora.dominio;
import java.util.ArrayList;
import java.util.List;
public class Calculadora {
	private double resultadoActual;
	private List<Operacion> operacionesGuardadas;
	public Calculadora () {
		operacionesGuardadas = new ArrayList<>();
		resultadoActual = 0;
	}
	public double getResultadoActual() {
		return resultadoActual;
	}
	public List<Operacion> getOperacionesGuardadas() {
		return operacionesGuardadas;
	}
	private void crearOperacion(String operacion) {
		this.operacionesGuardadas.add(new Operacion(operacion,resultadoActual));
	}
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
	private void suma(Double numeroActual) {
		resultadoActual+=numeroActual;
	}
	private void resta(Double numeroActual) {
		resultadoActual-=numeroActual;
	}
	private void division(Double numeroActual) {
		resultadoActual/=numeroActual;
	}
	private void multiplicacion(Double numeroActual) {
		resultadoActual*=numeroActual;
	}
	public void reset() {
		operacionesGuardadas.clear();
		resultadoActual = 0;
	}
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