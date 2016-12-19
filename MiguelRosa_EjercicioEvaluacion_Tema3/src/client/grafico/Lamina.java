package client.grafico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

/*****************************************************************************
 * Nombre de Clase : Lamina												
 * Autor: Miguel Rosa														
 * Fecha: 11 - Diciembre - 2016												
 * Versi�n: 1.0																
 * Descripci�n: Crea la l�mina que contine el interfaz de la aplicaci�n. La 
 * clase Lamina hereda de JPanel											
 *****************************************************************************/

public class Lamina extends JPanel implements ActionListener{
	
	/*************************************************************************
	 * ATRIBUTOS
	 *************************************************************************/
	
	// Se define el ancho y alto de la l�mina
	private static final int ANCHO = 600;
	private static final int ALTO = 200;
	
	// Se declaran y definen los Strings que servir�n para el JSpinner
	// eligeMoneda. Posteriormente usaremos estos Strings en una instrucci�n
	// switch/case dentro del m�todo ActionPerformed, por eso estamos
	// obligados a que sean final.
	private static final String PESETAS = "Pesetas";
	private static final String EUROS = "Euros";
	private static final String LIBRAS = "Libras";
	private static final String DOLARES = "Dolares";
	
	// Creamos una instancia de la clase ConversorMonedaCliente. Esta clase 
	// es la que se encarga de conectar con el servidor y llamar a los
	// m�todos remotos.
	ConversorMonedaCliente conversor = new ConversorMonedaCliente();
	
	// Se declara y define el JTextField que se usa para que el usuario
	// introduzca la cantidad de monedas.
	JTextField convertir = new JTextField(10);
	
	// Se declara y define el JSpinner que se usa para que el usuario
	// introduzca el tipo de moneda. El JSpinner necesita un SpinnerListModel
	// con un Array como par�metro con los valores que contendr�.
	String[] monedas = {PESETAS,EUROS,LIBRAS,DOLARES};
	JSpinner eligeMoneda = new JSpinner(new SpinnerListModel(monedas));

	// Se declaran y definen los JTextField que servir�n como la salida
	// de resultados del programa
	JTextField pesetas = new JTextField(10);
	JTextField euros = new JTextField(10);
	JTextField libras = new JTextField(10);
	JTextField dolares = new JTextField(10);
	
	// Se declara y define el JButton que activar� la conversi�n
	JButton boton = new JButton("Convertir");
	
	/*************************************************************************
	 * CONSTRUCTORES
	 *************************************************************************/
	
	public Lamina() {
		
		// Se define el tama�o de la l�mina
		setPreferredSize(new Dimension(ANCHO, ALTO));
		// No se le asigna ning�n Layout para que poder posicionar las
		// distintos elementos por sus coordenadas X e Y
		setLayout(null);

		// Se a�aden a la l�mina todos los elementos de la interfaz 
		// definidos con antelaci�n
		add(convertir);
		add(eligeMoneda);
		add(pesetas);
		add(euros);
		add(libras);
		add(dolares);
		add(boton);
		
		// Se sit�an y dimensionan todos los elementos de la interfaz 
		// definidos con antelaci�n 
		convertir.setBounds(40, 60, 100, 20);
		eligeMoneda.setBounds(150, 60, 75, 20);
		pesetas.setBounds(40, 150, 100, 20);
		euros.setBounds(180, 150, 100, 20);
		libras.setBounds(320, 150, 100, 20);
		dolares.setBounds(460, 150, 100, 20);
		boton.setBounds(460, 60, 100, 40);
		
		// Se pone el JButton a la escucha para que desate el m�todo
		// ActionPerformed cuando se hace clic sobre �l.
		boton.addActionListener(this);
			
	}
	
	/*************************************************************************
	 * M�TODOS SOBREESCRITOS DE JPANEL
	 *************************************************************************/
	
	/*
	 * Nombre: paintComponent() 
	 * Argumentos: Graphics 
	 * Devuelve: Nada
	 * Descripci�n: 
	 * Esta clase se encarga de dibujar en la l�mina los textos que sirven
	 * como carteles informativos.
	 */
	
	public void paintComponent(Graphics g) {
		
		// Se llama al m�todo paintComponent de la clase JPanel para no
		// perder su contenido
		super.paintComponent(g);
		// Casteamos la instancia "g" de Graphics a Graphics2D.
		// g2 es como si fuera el pincel que se encarga de pintar en la l�mina
		Graphics2D g2 = (Graphics2D) g;
		
		// Coloreamos el fondo d ela l�mina de color rojo pastel.
		setBackground(new Color (233, 125, 125));
		// Definimos como negro el color d elos textos.
		setForeground(Color.black);
		
		// Definimos la fuente de texto para el t�tulo
		Font fuente = new Font("Arial", 3, 24);
		// Definimos la fuente de texto para el resto de elementos
		Font fuente2 = new Font("Arial", 1, 12);
		
		// Dibujamos y situamos el t�tulo de la l�mina
		g2.setFont(fuente);
		g2.drawString("PROGRAMA CONVERSOR DE MONEDAS", 60, 30);
		
		// Dibujamos y situamos los textos del resto de elementos.
		g2.setFont(fuente2);
		g2.drawString("Pesetas", 40, 140);
		g2.drawString("Euros", 180, 140);
		g2.drawString("Libras", 320, 140);
		g2.drawString("D�lares", 460, 140);

	}
	
	/*************************************************************************
	 * M�TODOS
	 *************************************************************************/
	
	/*
	 * Nombre: getValor() 
	 * Argumentos: Ninguno
	 * Devuelve: Double
	 * Descripci�n: 
	 * Se encarga de recoger el valor del JtextField como un String y
	 * convertirlo a double. Tambi�n se encarga de avisar al usuario si la
	 * conversi�n no es posible.
	 */
	
	public double getValor() {
		
		// Obtenemos el String que se ha introducido en el JTextField
		// convertir y lo asignamos a valorString
		String valorString = convertir.getText();
		// Declaramos e iniciamos a 0 el Double valorDouble
		double valorDouble = 0;
		
		// Procedemos a intentar convertir el String valorString a
		// Double y lo asignamos a la variable valorDouble
		try {
			valorDouble = Double.parseDouble(valorString);
			// Si el valor de valorDouble sigue siendo 0 quiere decir
			// que no se ha introducido ning�n valor en el JTextField y por
			// lo tanto se avisa al usuario para que introduzca un valor.
			if (valorDouble == 0) {
				JOptionPane.showMessageDialog(null, "No se ha introducido ning�n valor.");
			}
		// Si no se puede realizar la conversi�n avisamos al usuario.
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "El valor introducido no es correcto.");
		}
		
		// Finalmente devolvemos el String convertido a Double.
		return valorDouble;	
	}
	
	/*
	 * Nombre: getMoneda() 
	 * Argumentos: Ninguno
	 * Devuelve: String
	 * Descripci�n: 
	 * Este m�todo se encarga de capturar y devolver la opci�n seleccionada
	 * en el JTextField eligeMoneda.
	 */
	
	public String getMoneda() {
		// Capturamos el valor del JTextField eligeMoneda y los alamacenamos
		// en el String moneda. Como el m�todo getValue() devuelve un objeto
		// gen�rico hay que castearlo a String.
		String moneda = (String) eligeMoneda.getValue();
		
		// Devolvemos el contenido del String moneda.
		return moneda;		
	}
	
	/*************************************************************************
	 * M�TODOS SOBREESCRITOS DE LA INTERFAZ ActionListener
	 *************************************************************************/
	
	/*
	 * Nombre: actionPerformed() 
	 * Argumentos: ActionEvent
	 * Devuelve: Nada
	 * Descripci�n: 
	 * Captura el evento lanzado por el JButton boton. Recopila los datos
	 * que hay en el JtextField convertir y JSpinner eligeMoneda y en funci�n
	 * del tipo de moneda seleccionada en el  JSpinner llama a los m�todos del
	 * objeto conversor de la clase ConversorMonedaCliente para que calculen la
	 * conversi�n a cada una de las monedas. Finalmente, muestra los datos
	 * de la conversi�n en el JTextField correspondiente. 
	 */
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		// Invocamos a la funci�n getValor() y almacenamos el Double que
		// devuelve en el Double valor.
		double valor = getValor();
		// Invocamos a la funci�n getMoneda() y almacenamos el String que
		// devuelve en el Double valor.
		String moneda = getMoneda();
		
		// Declaramos e iniciamos a 0.0 las variables que almacenar�n los
		// valores resultantes d ela conversi�n.
		double pesetas = 0.0;
		double euros = 0.0;
		double libras = 0.0;
		double dolares = 0.0;	
		
		// Con una instrucci�n switch/case comprobamos el tipo de moneda
		// seleccionada por el usuario. En funci�n de este tipo se llaman a
		// los m�todos correspondientes del objeto conversor de la clase 
		// ConversorMonedaCliente.
		switch (moneda) {
			// En caso el tipo de moneda sea PESETA
			case PESETAS:
				// La conversi�n de peseta a peseta es 1 : 1
				pesetas = valor;
				// Se intenta llamar a los m�todos que convierten las pesetas
				// al resto de monedas
				try {
					euros = conversor.getConversor().conversorPesetaEuro(valor);
					libras = conversor.getConversor().conversorPesetaLibra(valor);
					dolares = conversor.getConversor().conversorPesetaDolar(valor);
				
				// Si se produce un error en las llamadas a los m�todos se avisa
				// al usuario. (los m�todos son remotos y se encuentran en el
				// servidor)
				} catch (RemoteException e) {
					JOptionPane.showMessageDialog(null, "Se ha producido un error durante la conversi�n.");
				}
				break;
			
			// En caso el tipo de moneda sea EURO
			case EUROS:
				// La conversi�n de euro a euro es 1 : 1
				euros = valor;
				// Se intenta llamar a los m�todos que convierten los euros
				// al resto de monedas
				try {
					pesetas = conversor.getConversor().conversorEuroPeseta(valor);
					libras = conversor.getConversor().conversorEuroLibra(valor);
					dolares = conversor.getConversor().conversorEuroDolar(valor);
				// Si se produce un error en las llamadas a los m�todos se avisa
				// al usuario. (los m�todos son remotos y se encuentran en el
				// servidor)
				} catch (RemoteException e) {
					JOptionPane.showMessageDialog(null, "Se ha producido un error durante la conversi�n.");
				}
				break;
			// En caso el tipo de moneda sea LIBRA
			case LIBRAS:
				// La conversi�n de libra a libra es 1 : 1
				libras = valor;
				// Se intenta llamar a los m�todos que convierten las libras
				// al resto de monedas
				try {
					pesetas = conversor.getConversor().conversorLibraPeseta(valor);
					euros = conversor.getConversor().conversorLibraEuro(valor);
					dolares = conversor.getConversor().conversorLibraDolar(valor);
				// Si se produce un error en las llamadas a los m�todos se avisa
				// al usuario. (los m�todos son remotos y se encuentran en el
				// servidor)
				} catch (RemoteException e) {
					JOptionPane.showMessageDialog(null, "Se ha producido un error durante la conversi�n.");
				}
				break;
			// En caso el tipo de moneda sea DOLAR
			case DOLARES:
				// La conversi�n de dolar a dolar es 1 : 1
				dolares = valor;
				// Se intenta llamar a los m�todos que convierten las libras
				// al resto de monedas
				try {
					pesetas = conversor.getConversor().conversorDolarPeseta(valor);
					euros = conversor.getConversor().conversorDolarEuro(valor);
					libras = conversor.getConversor().conversorDolarLibra(valor);
				// Si se produce un error en las llamadas a los m�todos se avisa
				// al usuario. (los m�todos son remotos y se encuentran en el
				// servidor)				
				} catch (RemoteException e) {
					JOptionPane.showMessageDialog(null, "Se ha producido un error durante la conversi�n.");
				}
				break;
			// Como no hay posibilidad de eligir un tipo de moneda diferente ya
			// que el JDSpinner no lo permite, dejamos el default: vac�o
			default:
		}
		
		// Convertimos los valores de las diferente conversiones de Double a
		// String. Formateamos la conversi�n para que s�lo contenga 2 decimales
		// excepto en el caso de las pesetas que se redondean todos los
		// decimales dando un valor entero.
		String pesetasString = String.format("%.0f", pesetas);
		String eurosString = String.format("%.2f", euros);
		String librasString = String.format("%.2f", libras);
		String dolaresString = String.format("%.2f", dolares);
		
		// Se asignan los String del paso anterior al correspondiente JTextField
		// de salida para que se muestren los valores convertidos.
		this.pesetas.setText(pesetasString);
		this.euros.setText(eurosString);
		this.libras.setText(librasString);
		this.dolares.setText(dolaresString);
		
	}
	


}
