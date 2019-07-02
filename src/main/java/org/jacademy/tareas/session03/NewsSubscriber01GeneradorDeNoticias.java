/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: May 14, 2019
 */
package org.jacademy.tareas.session03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: May 14, 2019
 */
public class NewsSubscriber01GeneradorDeNoticias {
	
	public static List<NewsSubscriber01ClaseNoticias> CreaNoticias() {
		
		List<NewsSubscriber01ClaseNoticias> listaNoticias = new ArrayList<>();

		listaNoticias.add(new NewsSubscriber01ClaseNoticias(NewsSubscriber01ClaseTipoNoticias.NEWS_TYPE_POLITIC, 
				"Personas que le digan 'six' a las cervezas obtendrán su nacionalidad gringa") );
		
		listaNoticias.add(new NewsSubscriber01ClaseNoticias(NewsSubscriber01ClaseTipoNoticias.NEWS_TYPE_SPORTS, 
				"José José y Felipe Calderón inauguran el torneo Hígado de Acero para que demuestres de qué estás hecho") );
		
		listaNoticias.add(new NewsSubscriber01ClaseNoticias(NewsSubscriber01ClaseTipoNoticias.NEWS_TYPE_FANCY, 
				"Luego de ver 'Un extraño enemigo' Masiosare demanda a Amazon por difamación") );
		
		listaNoticias.add(new NewsSubscriber01ClaseNoticias(NewsSubscriber01ClaseTipoNoticias.NEWS_TYPE_POLITIC, 
				"Confirman que hay más gente afiliada al Blockbuster que al PRI") );
		
		return listaNoticias;
	}
}
