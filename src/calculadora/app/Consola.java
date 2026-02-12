package calculadora.app;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Clase encargada de la entrada y la salida por consola.
 */
public class Consola {
	private Scanner sc;
	/**
     * Constructor por defecto de la clase que inicializa el atributo del Scanner.
     */
	public Consola() {
        this.sc = new Scanner(System.in);
    }
    /**
     * Cierra el recurso del escáner.
     */
    public void cerrar() {
        this.sc.close();
    }
    /**
     * Limpia el búfer.
     */
    private void cleanInput() {
		sc.nextLine();
	}
    /**
     * Imprime un mensaje y un salto de línea en consola.
     * @param texto Texto a mostrar.
     */
    public void escribirLinea(String texto) {
        System.out.println(texto);
    }
    /**
     * Imprime un mensaje en consola.
     * @param texto Texto a mostrar.
     */
    public void escribir(String texto) {
        System.out.print(texto);
    }
    /**
     * Lee un mensaje introducido por el usuario.
     * @param mensaje Mensaje indicativo al usuario para la entrada de la cadena.
     */
    public String leerTexto(String mensaje) {
    	String value = "";
    	escribirLinea(mensaje);
		value = sc.nextLine();
		return value.trim();
    }
    /**
     * Lee un mensaje introducido por el usuario, sin admitir cadenas vacías.
     * @param mensaje Mensaje indicativo al usuario para la entrada de la cadena.
     */
    public String leerTextoNoVacio(String mensaje) {
    	String value = "";
    	escribirLinea(mensaje);
		do {
			value = sc.nextLine();
			if (value.trim().isEmpty()) {
				System.out.printf("%sNo puedes introducir una cadena vacía, debe contener al menos un caracter.%s\n", "\u001B[31m", "\u001B[0m");
			}
		} while (value.trim().isEmpty());
		return value.trim();
    }
    /**
     * Lee un número entero introducido por el usuario.
     * @param mensaje Mensaje indicativo al usuario para la entrada del entero.
     */
    public int leerEntero(String mensaje) {
        escribirLinea(mensaje);
        int value=0;
		boolean error;
		do {
			try {
				value = sc.nextInt();
				error = false;
			} catch (InputMismatchException e) {
				System.out.printf("%sEl valor del integer debe ser de tipo númerico entero y comprendido entre el rango %d - %d.%s\n", "\u001B[31m", Integer.MIN_VALUE, Integer.MAX_VALUE, "\u001B[0m");
				error = true;
			} finally {
				cleanInput();
			}
		} while (error);
		return value;
        
    }
    /**
     * Lee un número entero introducido por el usuario en un rango determinado.
     * @param mensaje Mensaje indicativo al usuario para la entrada del entero.
     * @param min valor mínimo del entero a introducir, debe ser mayor o igual a este número.
     * @param min valor máximo del entero a introducir, debe ser menor o igual a este número.
     */
    public int leerEnteroRango(String mensaje, int min, int max) {
    	int value = 0;
		do {
			value = leerEntero(mensaje);
			if (value < min || value > max) {
				System.out.printf("%sEl valor del integer debe estar comprendido entre %d y %d (ambos incluidos).%s\n", "\u001B[31m",min, max, "\u001B[0m");
			}
		} while (value < min|| value > max);
		return value;
    }
}
