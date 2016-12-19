package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*****************************************************************************
 * Nombre de Clase : ConversorMoneda											
 * Autor: Miguel Rosa														
 * Fecha: 11 - Diciembre - 2016												
 * Versión: 1.0																
 * Descripción: Es la clase que define los objetos remotos que publicará el
 * servidor. Hereda de la clase InicastRemoteObject para permitir su
 * publicación e implementa InterfazConversorMoneda ya que el cliente
 * accederá a los métodos de esta clase a través de la interfaz. 										
 *****************************************************************************/

public class ConversorMoneda extends UnicastRemoteObject implements InterfazConversorMoneda {
	
	/*************************************************************************
	 * CONSTRUCTORES
	 *************************************************************************/
	
	// Para que la publicación sea posible el constructor de esta clase tiene
	// que llamar al constructor de UnicastRemoteObject y por consiguinete
	// tiene que lanzar la excepción RemoteException.
	public ConversorMoneda() throws RemoteException {
		
		super(); // Llamada al constructor de UnicastRemoteObject
	}
	
	/*************************************************************************
	 * MÉTODOS IMPLEMENTADOS DE LA INTERFAZ InterfazConversorMoneda
	 *************************************************************************/
	
	/*
	 * Nombre: conversorPesetaEuro() 
	 * Argumentos: Double
	 * Devuelve: Double
	 * Lanza la Excepción: RemoteException
	 * Descripción: 
	 * Devuelve en EUROS el valor en PESETAS que se pasa como argumento.
	 */
	
	@Override
	public double conversorPesetaEuro(double peseta) throws RemoteException {
		double unaPesetaAEuro = 1 / Moneda.getUneuroapeseta();
		return peseta * unaPesetaAEuro;
	}
	
	/*
	 * Nombre: conversorPesetaLibra() 
	 * Argumentos: Double
	 * Devuelve: Double
	 * Lanza la Excepción: RemoteException
	 * Descripción: 
	 * Devuelve en LIBRAS el valor en PESETAS que se pasa como argumento.
	 */
	
	@Override
	public double conversorPesetaLibra(double peseta) throws RemoteException {
		double unaPesetaALibra = 1 / (Moneda.getUneuroapeseta() / Moneda.getUneuroalibra());
		return peseta * unaPesetaALibra;
	}
	
	/*
	 * Nombre: conversorPesetaDolar() 
	 * Argumentos: Double
	 * Devuelve: Double
	 * Lanza la Excepción: RemoteException
	 * Descripción: 
	 * Devuelve en DOLARES el valor en PESETAS que se pasa como argumento.
	 */
	
	@Override
	public double conversorPesetaDolar(double peseta) throws RemoteException {
		double unaPesetaADolar = 1 / (Moneda.getUneuroapeseta() / Moneda.getUneuroadolar());
		return peseta * unaPesetaADolar;
	}
	
	/*
	 * Nombre: conversorEuroPeseta() 
	 * Argumentos: Double
	 * Devuelve: Double
	 * Lanza la Excepción: RemoteException
	 * Descripción: 
	 * Devuelve en PESETAS el valor en EUROS que se pasa como argumento.
	 */
	
	@Override
	public double conversorEuroPeseta(double euro) throws RemoteException {
		return euro * Moneda.getUneuroapeseta();
	}
	
	/*
	 * Nombre: conversorEuroLibra() 
	 * Argumentos: Double
	 * Devuelve: Double
	 * Lanza la Excepción: RemoteException
	 * Descripción: 
	 * Devuelve en LIBRAS el valor en EUROS que se pasa como argumento.
	 */

	@Override
	public double conversorEuroLibra(double euro) throws RemoteException {
		return euro * Moneda.getUneuroalibra();
	}

	/*
	 * Nombre: conversorEuroDolar() 
	 * Argumentos: Double
	 * Devuelve: Double
	 * Lanza la Excepción: RemoteException
	 * Descripción: 
	 * Devuelve en DOLARES el valor en EUROS que se pasa como argumento.
	 */
	
	@Override
	public double conversorEuroDolar(double euro) throws RemoteException {
		return euro * Moneda.getUneuroadolar();
	}
	
	/*
	 * Nombre: conversorLibraPeseta() 
	 * Argumentos: Double
	 * Devuelve: Double
	 * Lanza la Excepción: RemoteException
	 * Descripción: 
	 * Devuelve en PESETAS el valor en LIBRAS que se pasa como argumento.
	 */
	
	@Override
	public double conversorLibraPeseta(double libra) throws RemoteException {
		double unaLibraAPeseta = 1 / (Moneda.getUneuroalibra() / Moneda.getUneuroapeseta());
		return libra * unaLibraAPeseta;
	}
	
	/*
	 * Nombre: conversorLibraEuro() 
	 * Argumentos: Double
	 * Devuelve: Double
	 * Lanza la Excepción: RemoteException
	 * Descripción: 
	 * Devuelve en EUROS el valor en LIBRAS que se pasa como argumento.
	 */
	
	@Override
	public double conversorLibraEuro(double libra) throws RemoteException {
		double unaLibraAEuro = 1 / Moneda.getUneuroalibra();
		return libra * unaLibraAEuro;
	}
	
	/*
	 * Nombre: conversorLibraDolar() 
	 * Argumentos: Double
	 * Devuelve: Double
	 * Lanza la Excepción: RemoteException
	 * Descripción: 
	 * Devuelve en DOLARES el valor en LIBRAS que se pasa como argumento.
	 */
	
	@Override
	public double conversorLibraDolar(double libra) throws RemoteException {
		double unaLibraADolar = 1 / (Moneda.getUneuroalibra() / Moneda.getUneuroadolar());
		return libra * unaLibraADolar;
	}
	
	/*
	 * Nombre: conversorDolarPeseta() 
	 * Argumentos: Double
	 * Devuelve: Double
	 * Lanza la Excepción: RemoteException
	 * Descripción: 
	 * Devuelve en PESETAS el valor en DOLARES que se pasa como argumento.
	 */
	
	@Override
	public double conversorDolarPeseta(double dolar) throws RemoteException {
		double unDolarAPeseta = 1 / (Moneda.getUneuroadolar() / Moneda.getUneuroapeseta());
		return dolar * unDolarAPeseta;
	}
	
	/*
	 * Nombre: conversorDolarEuro() 
	 * Argumentos: Double
	 * Devuelve: Double
	 * Lanza la Excepción: RemoteException
	 * Descripción: 
	 * Devuelve en EUROS el valor en DOLARES que se pasa como argumento.
	 */
	
	@Override
	public double conversorDolarEuro(double dolar) throws RemoteException {
		double unDolarAEuro = 1 / Moneda.getUneuroadolar();
		return dolar * unDolarAEuro;
	}
	
	/*
	 * Nombre: conversorDolarLibra() 
	 * Argumentos: Double
	 * Devuelve: Double
	 * Lanza la Excepción: RemoteException
	 * Descripción: 
	 * Devuelve en LIBRAS el valor en DOLARES que se pasa como argumento.
	 */
	
	@Override
	public double conversorDolarLibra(double dolar) throws RemoteException {
		double unDolarALibra = 1 / (Moneda.getUneuroadolar() / Moneda.getUneuroalibra());
		return dolar * unDolarALibra;
	}
	

	
	
	
	
}
