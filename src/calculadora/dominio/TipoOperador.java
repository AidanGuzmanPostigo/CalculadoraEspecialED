package calculadora.dominio;
public enum TipoOperador {
	SUMA("+"),RESTA("-"),DIVISION("/"),MULTIPLICACION("*");
	public final String simbol;
	public String getSimbol() {
		return simbol;
	}
	TipoOperador(String simbol){
		this.simbol = simbol;
	}
}