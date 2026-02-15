package calculadora.app;
import calculadora.dominio.Calculadora;
import calculadora.dominio.ResultadoAnalisis;
import calculadora.dominio.TipoComando;
/**
 * Clase donde se crea y gestiona la calculadora.
 */
public class GestorCalculadora {
	private Consola consola;
	private Calculadora calculadora;
	private Analizador analizador;
	private ResultadoAnalisis resultadoAnalisis;
	private String operacion;
	/**
	 * Constructor de la clase, crea una consola, calculadora y un analizador.
	 */
	public GestorCalculadora() {
		consola = new Consola();
		calculadora = new Calculadora();
		analizador = new Analizador();
	}
	/**
	 * 	Gestión principal de la calculadora, aquí se leen los datos y, tras los resultados del análisis se llaman a diferentes métodos de la calculadora.
	 */
	public void gestionCalculadora() {
		do {
			operacion = consola.leerTexto(">");
			resultadoAnalisis = analizador.analizar(operacion, calculadora.getResultadoActual());
			switch(resultadoAnalisis.comando()) {
			case LIST -> {
				consola.escribirLinea(calculadora.list());
			}
			case RESET -> {
				calculadora.reset();
				consola.escribirLinea("Calculadora reseteada con éxito");
			}
			case RESULT -> {
				if (!(calculadora.getOperacionesGuardadas().isEmpty())) {
					consola.escribirLinea(String.format("%.2f", calculadora.getResultadoActual()));
				} else {
					consola.escribirLinea("No hay ningún resultado almacenado");
				}
			}
			case CALCULO -> {
				calculadora.realizarOperacion(resultadoAnalisis.numeros(), resultadoAnalisis.operadores(), operacion);
				consola.escribirLinea(String.format("%.2f", calculadora.getResultadoActual()));
			}
			case ERROR -> consola.escribirLinea(resultadoAnalisis.mensajeError());
			case QUIT -> consola.escribirLinea("Programa terminado con éxito");
			}
			
		} while (resultadoAnalisis.comando() != TipoComando.QUIT);
		consola.cerrar();
	}
}