package calculadora.dominio;
import java.util.List;
public interface ICalculadora {
	public double getResultadoActual();
	public List<Operacion> getOperacionesGuardadas();
	public void realizarOperacion(List<Double> numeros, List<TipoOperador> operadores, String operacion);
	public void reset();
	public String list();
}
