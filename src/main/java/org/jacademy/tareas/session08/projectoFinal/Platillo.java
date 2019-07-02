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
public class Platillo {

	Comida comida;
	String bebida;
	String postre;
	
	Platillo(Long id){
		comida = new Comida(id);
		bebida = "Mojito " + id;
		postre = "Pastel " + id;
	}

	/**
	 * @return the comida
	 */
	public Comida getComida() {
		return comida;
	}

	/**
	 * @param comida the comida to set
	 */
	public void setComida(Comida comida) {
		this.comida = comida;
	}

	/**
	 * @return the bebida
	 */
	public String getBebida() {
		return bebida;
	}

	/**
	 * @param bebida the bebida to set
	 */
	public void setBebida(String bebida) {
		this.bebida = bebida;
	}

	/**
	 * @return the postre
	 */
	public String getPostre() {
		return postre;
	}

	/**
	 * @param postre the postre to set
	 */
	public void setPostre(String postre) {
		this.postre = postre;
	}
	
	
}
