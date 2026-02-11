package calculadora.dominio;
/**
 * Enum que lista los posibles comandos del programa.
 * LIST: Enumera las operaciones realizadas por el usuario desde el inicio del programa o desde el último RESET.
 * RESET: Limpia el historial del programa.
 * QUIT: Finaliza la ejecución del programa.
 * RESULT: Actua como el resultado de la operación anterior.
 * CALCULO: Estado de verificación usado en caso de que no se usen otras palabras reservadas en la entrada.
 * ERROR: Estado de verificación usado en caso de que ocurra algún error.
 */
public enum TipoComando {
	LIST,RESET,QUIT,RESULT,CALCULO,ERROR;
}
