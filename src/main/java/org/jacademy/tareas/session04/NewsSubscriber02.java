/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: May 21, 2019
 */
package org.jacademy.tareas.session04;

import java.text.MessageFormat;
import org.jacademy.tareas.session03.NewsSubscriber01ClaseNoticias;
import org.jacademy.tareas.session03.NewsSubscriber01ClaseTipoNoticias;
import org.jacademy.tareas.session03.NewsSubscriber01GeneradorDeNoticias;

import rx.observables.ConnectableObservable;
import rx.Subscriber;

/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: May 21, 2019
 */
public class NewsSubscriber02 {
	
	private static final String SUSCRIPTOR_1 = "Suscriptor #1";
	private static final String SUSCRIPTOR_2 = "Suscriptor #2";
	private static final String SUSCRIPTOR_3 = "Suscriptor #3";
	private static final String SUSCRIPTOR_4 = "Suscriptor #4";
	private static final String SUSCRIPTOR_5 = "Suscriptor #5";

	public static void main(String... args) {
		
		System.out.println("Empezando clase NewsSubscriber02...\n");
		
		//Observable<NewsSubscriber01ClaseNoticias> observable = Observable.from( NewsSubscriber01GeneradorDeNoticias.CreaNoticias() );
		
		ConnectableObservable<NewsSubscriber01ClaseNoticias> observable = ConnectableObservable
																			.<NewsSubscriber01ClaseNoticias>from( 
																					NewsSubscriber01GeneradorDeNoticias.CreaNoticias() )
																			.publish();
		
		Subscriber<NewsSubscriber01ClaseNoticias> subscriptor01 = getSuscriptor(SUSCRIPTOR_1);
		Subscriber<NewsSubscriber01ClaseNoticias> subscriptor02 = getSuscriptor(SUSCRIPTOR_2);
		Subscriber<NewsSubscriber01ClaseNoticias> subscriptor03 = getSuscriptor(SUSCRIPTOR_3);
		Subscriber<NewsSubscriber01ClaseNoticias> subscriptor04 = getSuscriptor(SUSCRIPTOR_4);
		Subscriber<NewsSubscriber01ClaseNoticias> subscriptor05 = getSuscriptor(SUSCRIPTOR_5);
		
		observable.subscribe(subscriptor01);
		observable.subscribe(subscriptor02);
		observable.subscribe(subscriptor03);
		observable.subscribe(subscriptor04);
		observable.subscribe(subscriptor05);
		
		observable.connect();
		
		System.out.println("\nClase NewsSubscriber02 terminada.");
	}
	
	private static Subscriber<NewsSubscriber01ClaseNoticias> getSuscriptor(String id){
		return new Subscriber<NewsSubscriber01ClaseNoticias>() {
            @Override
            public void onCompleted() {
                System.out.println(id + ") Yo ya termine! \n");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(id + ") Error: " + throwable.getMessage());
            }

            @Override
            public void onNext(NewsSubscriber01ClaseNoticias s) {
                
                Boolean imprimeNoticia = false;
                switch(id) {
                case SUSCRIPTOR_1:
                	imprimeNoticia= s.getNewsType().equals(NewsSubscriber01ClaseTipoNoticias.NEWS_TYPE_SPORTS);
                	
                  break;
                case SUSCRIPTOR_2:
                	imprimeNoticia= s.getNewsType().equals(NewsSubscriber01ClaseTipoNoticias.NEWS_TYPE_FANCY);
                    break;
                case SUSCRIPTOR_3:
                	imprimeNoticia= s.getNewsType().equals(NewsSubscriber01ClaseTipoNoticias.NEWS_TYPE_POLITIC);
                	
                	if(s.getNewsType().equals(NewsSubscriber01ClaseTipoNoticias.NEWS_TYPE_SPORTS) ){
                    	 System.out.println(id + ") Me salgo!!, recibi algo de deportes!! :( \n");
                        this.unsubscribe();
                    }
                    break;
                case SUSCRIPTOR_4:
                	imprimeNoticia= (s.getNewsType().equals(NewsSubscriber01ClaseTipoNoticias.NEWS_TYPE_FANCY)
                					|| s.getNewsType().equals(NewsSubscriber01ClaseTipoNoticias.NEWS_TYPE_SPORTS) );
                    break;
                case SUSCRIPTOR_5:
                	imprimeNoticia= (s.getNewsType().equals(NewsSubscriber01ClaseTipoNoticias.NEWS_TYPE_SPORTS)
                					|| s.getNewsType().equals(NewsSubscriber01ClaseTipoNoticias.NEWS_TYPE_FANCY)
                					|| s.getNewsType().equals(NewsSubscriber01ClaseTipoNoticias.NEWS_TYPE_POLITIC) );
                    break;
                default:
                  // ignorar
                }
                if(imprimeNoticia) {
                	System.out.println(MessageFormat.format("{0}) Noticia: [{1}] {2}", id, s.getNewsType(), s.getNewsContent()) );
                }
            }
        };
	}
	
}
