package client.grafico;

import java.rmi.Naming;
import java.rmi.Remote;

import server.InterfazConversorMoneda;

/*****************************************************************************
 * Nombre de Clase : ConversorMonedaCliente													
 * Autor: Miguel Rosa														
 * Fecha: 12 - Diciembre - 2016												
 * Versión: 1.0																
 * Descripción: La clase ConversorMonedaCliente se encarga de establecer
 * 				con el servidor remoto y de crear la instancia de la
 * 				interfaz InterfazConversorMoneda la cual incluye los 
 * 				métodos que se encargan de realizar las conversiones entre
 * 				las distintas monedas.											
 *****************************************************************************/

public class ConversorMonedaCliente {
	
	/*************************************************************************
	 * ATRIBUTOS
	 *************************************************************************/
	
	// Instancia de la interfaz InterfazConversorMoneda
	private InterfazConversorMoneda conversor = null;
	
	// Datos del servidor
	private String server = "127.0.0.1";
	private String port = "1099";
	private String nombreClase = "Conversor";

	/*************************************************************************
	 * CONSTRUCTORES
	 *************************************************************************/
	
	public ConversorMonedaCliente() {
		// Se intenta conectar con el servidor para obtener la
		// instancia de la interfaz remota.
		try {
		
			// Se localiza el objeto remoto
			Remote objeto = Naming.lookup("rmi://" + server + ":" + port +
					"/" + nombreClase);
			
			// Se convierte al tipo de la interfaz InterfazConversorMoneda
			conversor = (InterfazConversorMoneda) objeto;
		
		// En caso de producirse un error en la conexión se imprime la
		// la pila de error por consola.
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	/*************************************************************************
	 * GETTERS y SETTERS
	 *************************************************************************/

	public InterfazConversorMoneda getConversor() {
		return conversor;
	}

	public void setConversor(InterfazConversorMoneda conversor) {
		this.conversor = conversor;
	}
		
}
