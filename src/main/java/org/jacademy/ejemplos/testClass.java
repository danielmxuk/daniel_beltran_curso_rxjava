/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jun 11, 2019
 */
package org.jacademy.ejemplos;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jun 11, 2019
 */
public class testClass {

	public static void main(String... a) {
		
		System.out.println("Current thread name: " + Thread.currentThread().getName() );
		
		System.out.println("CADENA: \\\\d{3}\\\\.\\\\d{3}\\\\.\\\\d{4} - \\d{3}\\.\\d{3}\\.\\d{4}");
		
		/*Observable.just("long", "longer", "longest")
			.flatMap( s -> Observable.just(s.length()).subscribeOn( Schedulers.newThread() ) )
			//.
			//.map(String::length)
			 //  Schedulers.computation()
			.subscribe(s -> {
				
				System.out.println("-> Item length: " + s + " - " + Thread.currentThread().getName() );
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("Termine!!");
	}
	
}
