package calculadora.dominio;
/**
 * Enum que lista los posibles comandos del programa.<br>
 * LIST: Enumera las operaciones realizadas por el usuario desde el inicio del programa o desde el último RESET.<br>
 * RESET: Limpia el historial del programa.<br>
 * QUIT: Finaliza la ejecución del programa.<br>
 * RESULT: Actua como el resultado de la operación anterior.<br>
 * CALCULO: Estado de verificación usado en caso de que no se usen otras palabras reservadas en la entrada.<br>
 * ERROR: Estado de verificación usado en caso de que ocurra algún error.<br>
 */
public enum TipoComando {
	LIST,RESET,QUIT,RESULT,CALCULO,ERROR;
}
