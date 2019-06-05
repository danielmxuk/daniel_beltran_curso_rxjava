/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jun 4, 2019
 */
package org.jacademy.tareas.session03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jun 4, 2019
 */
public class NewsSubscriber01GeneradorDeNoticias {
	
	public List<NewsSubscriber01ClaseNoticias> NewsSubscriber01GeneradorDeNoticias() {
		
		List<NewsSubscriber01ClaseNoticias> listaNoticias = new ArrayList<>();

		listaNoticias.add(new NewsSubscriber01ClaseNoticias(NewsSubscriber01ClaseTipoNoticias.NEWS_TYPE_FANCY, "holaa") );
		
		
		return listaNoticias;
	}
}
