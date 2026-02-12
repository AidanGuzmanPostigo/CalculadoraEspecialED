package calculadora.app;
public class Main {
	public void show() {
		GestorCalculadora gestorCalculadora = new GestorCalculadora();
		gestorCalculadora.gestionCalculadora();
	}
	public static void main(String[] args) {
		new Main().show();
	}
}