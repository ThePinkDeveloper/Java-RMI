package server;

/*****************************************************************************
 * Nombre de Clase : Moneda												
 * Autor: Miguel Rosa														
 * Fecha: 12 - Diciembre - 2016												
 * Versión: 1.0																
 * Descripción: Clase que almacena los datos de las diferentes monedas con
 * respecto al Euro, ya que el valor de cada moneda es global, obteniendo el
 * valor con respecto a una moneda es posible obtener el valor entre todas
 * ellas, es decir, obteniendo el valor de pesetas y libras en euros es posible
 * obtener el valor entre libras en pesetas y pesetas en libras. Como los
 * valores son únicos en un periodo de tiempo determinado todas la propiedades
 * se hacen estáticas ya que todos las instancias de esta clase tendrían
 * siempre el mismo valor.
 * 
 * Los valores dados están tomados de la página www.xe.com el 12-DIC-2016 a las
 * 11:44 h.
 * 
 * POSIBLE MEJORA A FUTURO:
 * El servidor previo a la publicación del objeto se conectará a la página
 * www.xe.com y tomará los valores de las diferentes monedas en tiempo real.
 * Estos datos además quedarán persistido en una BDD para poder seguir la
 * evolución historica de los valores. 						
 *****************************************************************************/

public class Moneda {

	/*************************************************************************
	 * ATRIBUTOS
	 *************************************************************************/
	
	private static final double unEuroAPeseta = 166.386; 	// 1 euro = 166.386 pesetas
	private static final double unEuroAEuro = 1.000;		// 1 euro = 1 euro
	private static final double unEuroALibra = 0.84196;		// 1 euro = 0.84196 libras
	private static final double unEuroADolar = 	1.05963;	// 1 euro = 1.05963 dolares
	
	/*************************************************************************
	 * GETTERS
	 *************************************************************************/
	
	public static double getUneuroapeseta() {
		return unEuroAPeseta;
	}
	public static double getUneuroaeuro() {
		return unEuroAEuro;
	}
	public static double getUneuroalibra() {
		return unEuroALibra;
	}
	public static double getUneuroadolar() {
		return unEuroADolar;
	}
	
}
