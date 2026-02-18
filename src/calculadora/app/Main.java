package calculadora.app;

import calculadora.dominio.Calculadora;

/**
 * Clase donde se inicia la aplicación.
 */
public class Main {
	/**
	 * Se usa para empezar la aplicación.
	 */
	public void show() {
		Consola consola = new Consola();
		Calculadora calculadora = new Calculadora();
		Analizador analizador = new Analizador();
		GestorCalculadora gestorCalculadora = new GestorCalculadora(consola, calculadora, analizador);
		gestorCalculadora.gestionCalculadora();
	}
	public static void main(String[] args) {
		new Main().show();
	}
}