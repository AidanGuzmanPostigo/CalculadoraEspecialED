package calculadora.dominio;
import java.util.ArrayList;
import java.util.List;
public class Calculadora {
	private double resultadoActual;
	private List<Operacion> operacionesGuardadas;
	private int idOperacion=0;
	public Calculadora () {
		operacionesGuardadas = new ArrayList<>();
		resultadoActual = 0;
	}
	public double getResultadoActual() {
		return resultadoActual;
	}
	public void setResultadoActual(double resultadoActual) {
		this.resultadoActual = resultadoActual;
	}
	public List<Operacion> getOperacionesGuardadas() {
		return operacionesGuardadas;
	}
	public void crearOperacion(String operacion) {
		this.operacionesGuardadas.add(new Operacion(operacion, ++idOperacion, resultadoActual));
	}
	public void realizarOperacion(List<Double> numeros, List<TipoOperador> operadores, String operacion) {
		resultadoActual = numeros.get(0);
		for (int i = 0; i< operadores.size(); i++) {
			TipoOperador operador = operadores.get(i);
			Double numeroActual = numeros.get(i+1);
			switch (operador) {
			case SUMA -> resultadoActual+=numeroActual;
			case RESTA -> resultadoActual-=numeroActual;
			case DIVISION -> resultadoActual/= numeroActual;
			case MULTIPLICACION -> resultadoActual *= numeroActual;
			}
		}
		crearOperacion(operacion);
	}
	public void reset() {
		operacionesGuardadas.clear();
		resultadoActual = 0;
		idOperacion = 0;
	}
}