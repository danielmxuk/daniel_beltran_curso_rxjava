/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jun 25, 2019
 */
package org.jacademy.tareas.session08.projectoFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jun 25, 2019
 */
public class Principal {
	
	
	public static void main(String... a) throws InterruptedException {
		

		
		System.out.println("Empezando la aplicacion!");
		Observable<Platillo> ordenes = Observable.interval(3, TimeUnit.SECONDS).take(20).subscribeOn(Schedulers.newThread()).map(Platillo::new);
		
		PublishSubject<String> barman   = PublishSubject.create();
		PublishSubject<Comida> chef     = PublishSubject.create();
		PublishSubject<String> repostero= PublishSubject.create();
		
		PublishSubject<String> pinche1  = PublishSubject.create();
		PublishSubject<String> pinche2  = PublishSubject.create();
		
		ordenes.map( Platillo::getBebida ).subscribe(barman);
		ordenes.map( Platillo::getComida ).subscribe(chef);
		ordenes.map( Platillo::getPostre ).subscribe(repostero);
		
		chef.map( Comida::getEntrada ).subscribe(pinche1);
		chef.map( Comida::getPlatoFuerte ).subscribe(pinche2);
		
		barman.map(b -> Observable.from(getPreparaciones(b + " (Barman)")) ).subscribe(o -> o.subscribe(Principal::log));
		
		repostero.map( r -> Observable.from(getPreparaciones(r + " (Repostero)"))).subscribe(o -> o.subscribe(Principal::log));
		
		pinche1.map( p -> Observable.from(getPreparaciones(p + " (Pinche 1)"))).subscribe(o -> o.subscribe(Principal::log));
		
		pinche2.map( p -> Observable.from(getPreparaciones(p + " (Pinche 2)"))).subscribe(o -> o.subscribe(Principal::log));
		
		Thread.sleep(60000);
		
		System.out.println("Aqui acabamos!");
	}
	
	
	private static void log(String cadena) {
		System.out.println("{ "+ Thread.currentThread().getName()+"} "+ cadena);
	}
	
	private static List<String> getPreparaciones(String nombre) {
		List<String> preparacion = new ArrayList<String>();
        preparacion.add("Preparar " + nombre);
        preparacion.add("Emplatar " + nombre);
        return preparacion;
	}
}
