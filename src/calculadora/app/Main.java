package calculadora.app;
/**
 * Clase donde se inicia la aplicación.
 */
public class Main {
	/**
	 * Se usa para empezar la aplicación.
	 */
	public void show() {
		GestorCalculadora gestorCalculadora = new GestorCalculadora();
		gestorCalculadora.gestionCalculadora();
	}
	public static void main(String[] args) {
		new Main().show();
	}
}