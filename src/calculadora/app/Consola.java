package calculadora.app;
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
     * Imprime un mensaje y un salto de línea en consola.
     * @param texto Texto a mostrar.
     */
    public void escribirLinea(String texto) {
        System.out.println(texto);
    }
    /**
     * Lee un mensaje introducido por el usuario.
     * @param mensaje Mensaje indicativo al usuario para la entrada de la cadena.
     * @return Cadena introducida por el usuario.
     */
    public String leerTexto(String mensaje) {
    	String value = "";
    	escribirLinea(mensaje);
		value = sc.nextLine();
		return value.trim();
    }
}
