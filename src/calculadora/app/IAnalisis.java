package calculadora.app;
import calculadora.dominio.ResultadoAnalisis;
public interface IAnalisis {
	public ResultadoAnalisis analizar(String entrada, double resultadoActual);
}
