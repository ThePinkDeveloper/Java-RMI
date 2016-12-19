package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*****************************************************************************
 * Nombre de interfaz : InterfazConversorMoneda													
 * Autor: Miguel Rosa														
 * Fecha: 12 - Diciembre - 2016												
 * Versión: 1.0																
 * Descripción: Declara los métodos que se encargan de realizar los cambios
 * de moneda. Hereda de la interfaz Remote para permitir que estos métodos
 * sean accesibles desde otras clases remotas, por consiguiente todos los
 * métodos deben lanzar la excepción RemoteException.											
 *****************************************************************************/

public interface InterfazConversorMoneda extends Remote{
	
	// Convierte de Peseta a Euro
	public double conversorPesetaEuro(double peseta) throws RemoteException;
	
	// Convierte de Peseta a Libra
	public double conversorPesetaLibra(double peseta) throws RemoteException;
	
	// Convierte de Peseta a Dolar
	public double conversorPesetaDolar(double peseta) throws RemoteException;
	
	// Convierte de Euro a Peseta
	public double conversorEuroPeseta(double euro) throws RemoteException;
	
	// Convierte de Euro a Libra
	public double conversorEuroLibra(double euro) throws RemoteException;
	
	// Convierte de Euro a Dolar
	public double conversorEuroDolar(double euro) throws RemoteException;
	
	// Convierte de Libra a Peseta
	public double conversorLibraPeseta(double libra) throws RemoteException;
	
	// Convierte de Libra a Euro
	public double conversorLibraEuro(double libra) throws RemoteException;
	
	// Convierte de Libra a Dolar
	public double conversorLibraDolar(double libra) throws RemoteException;
	
	// Convierte de Dolar a Peseta
	public double conversorDolarPeseta(double dolar) throws RemoteException;
	
	// Convierte de Dolar a Euro
	public double conversorDolarEuro(double dolar) throws RemoteException;
	
	// Convierte de Dolar a Libra
	public double conversorDolarLibra(double dolar) throws RemoteException;
	
}
