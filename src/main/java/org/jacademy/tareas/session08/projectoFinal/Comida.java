/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jun 25, 2019
 */
package org.jacademy.tareas.session08.projectoFinal;

/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jun 25, 2019
 */
public class Comida {
	String entrada;
	String platoFuerte;
	
	Comida(Long id){
		entrada     = "Ensalada " + id;
		platoFuerte = "Carne asada " + id;
	}

	/**
	 * @return the entrada
	 */
	public String getEntrada() {
		return entrada;
	}

	/**
	 * @param entrada the entrada to set
	 */
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	/**
	 * @return the platoFuerte
	 */
	public String getPlatoFuerte() {
		return platoFuerte;
	}

	/**
	 * @param platoFuerte the platoFuerte to set
	 */
	public void setPlatoFuerte(String platoFuerte) {
		this.platoFuerte = platoFuerte;
	}
	
	
}
