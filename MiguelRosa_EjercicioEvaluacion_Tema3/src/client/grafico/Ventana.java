package client.grafico;

import javax.swing.JFrame;

/*****************************************************************************
 * Nombre de Clase : Ventana												
 * Autor: Miguel Rosa														
 * Fecha: 11 - Diciembre - 2016												
 * Versi�n: 1.0																
 * Descripci�n: Crea la ventana que contendr� la aplicaci�n. La clase Ventana
 * hereda de JFrame											
 *****************************************************************************/

public class Ventana extends JFrame {
	
	/*************************************************************************
	 * CONSTRUCTORES
	 *************************************************************************/

	public Ventana() {
		
		// Se a�ade el t�tulo
		setTitle("Conversor de monedas");
		
		// Se crea una instancia de la clase Lamina que hereda de JPanel
		Lamina lamina = new Lamina();
		
		// Se a�ade la instancia de Lamina a la ventana.
		add(lamina);
		
		// Hacemos que la ventana se ajuste a la dimensiones de la
		// instancia de Lamina
		pack();
		
		// Situamos la ventana en el centro de la pantalla
		setLocationRelativeTo(null);
		
		// Impedimos que la ventana sea redimensionable por el usurario
		setResizable(false);
		
		// Al hacer clic sobre el aspa de cierre de la ventana tambi�n
		// se cierra la aplicaci�n.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Hacemos la ventana visible.
		setVisible(true);
		
	}
}
