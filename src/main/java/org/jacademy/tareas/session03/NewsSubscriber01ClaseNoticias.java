/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: May 14, 2019
 */
package org.jacademy.tareas.session03;

/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: May 14, 2019
 */
public class NewsSubscriber01ClaseNoticias {

	NewsSubscriber01ClaseTipoNoticias newsType;
	String newsContent;
	
	public NewsSubscriber01ClaseNoticias(NewsSubscriber01ClaseTipoNoticias newsType, String newsContent){
		this.newsType = newsType;
		this.newsContent = newsContent;
	}

	/**
	 * @return the newsType
	 */
	public NewsSubscriber01ClaseTipoNoticias getNewsType() {
		return newsType;
	}

	/**
	 * @param newsType the newsType to set
	 */
	public void setNewsType(NewsSubscriber01ClaseTipoNoticias newsType) {
		this.newsType = newsType;
	}

	/**
	 * @return the newsContent
	 */
	public String getNewsContent() {
		return newsContent;
	}

	/**
	 * @param newsContent the newsContent to set
	 */
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	
	
}
