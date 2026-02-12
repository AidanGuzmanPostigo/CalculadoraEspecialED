package calculadora.app;
import calculadora.dominio.Calculadora;
import calculadora.dominio.Operacion;
import calculadora.dominio.ResultadoAnalisis;
import calculadora.dominio.TipoComando;
public class GestorCalculadora {
	private Consola consola;
	private Calculadora calculadora;
	private Analizador analizador;
	private ResultadoAnalisis resultadoAnalisis;
	private String operacion;
	public GestorCalculadora() {
		consola = new Consola();
		calculadora = new Calculadora();
		analizador = new Analizador();
	}
	public void gestionCalculadora() {
		do {
			operacion = consola.leerTexto("Introduce una operación");
			resultadoAnalisis = analizador.analizar(operacion, calculadora.getResultadoActual());
			switch(resultadoAnalisis.comando()) {
			case LIST -> {
				for (Operacion o: calculadora.getOperacionesGuardadas()) {
					consola.escribirLinea(o.toString());
				}
				if (calculadora.getOperacionesGuardadas().isEmpty()) {
					consola.escribirLinea("No hay operaciones registradas.");
				}else {
					consola.escribirLinea("Resultado actual: " + calculadora.getResultadoActual());
				}
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
	}
}