/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jun 4, 2019
 */
package org.jacademy.tareas.session03;

/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jun 4, 2019
 */
public enum NewsSubscriber01ClaseTipoNoticias {

	NEWS_TYPE_SPORTS("Noticia Deportiva"),

	NEWS_TYPE_FANCY("Noticia Espectaculos"),
	
	NEWS_TYPE_POLITIC("Noticia Politica");

	
	private String value;

	private NewsSubscriber01ClaseTipoNoticias(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
