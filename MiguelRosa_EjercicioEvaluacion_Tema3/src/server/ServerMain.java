package server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;

/*****************************************************************************
 * Nombre de Clase : ServerMain													
 * Autor: Miguel Rosa														
 * Fecha: 12 - Diciembre - 2016												
 * Versión: 1.0																
 * Descripción: Lanza la aplicación servidor publicando el objeto al que se
 * accederá de forma remota y quedando a la escucha de llamadas entrantes a
 * este objeto											
 *****************************************************************************/

public class ServerMain {
	
	// Puerto por defecto de RMI (Remote Methods Invocation)
	public static final int PORT = 1099;
	
	// Método MAIN
	public static void main(String[] args) {

		try {
			
			// Creamos el administrador de seguridad.
			System.setSecurityManager(new RMISecurityManager());
			
			// Registramos el objeto remoto
			LocateRegistry.createRegistry(PORT);
			ConversorMoneda miConversor = new ConversorMoneda();
			Naming.rebind("Conversor", miConversor);
			
			// Publicamos un mensaje en la parte del servidor
			// indicando que el objeto está publicado para su uso.
			System.out.println("Objeto publicado correctamente...\nServidor ya la escucha.");
		
		// En caso de error se lanza imprime la pila de error.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
