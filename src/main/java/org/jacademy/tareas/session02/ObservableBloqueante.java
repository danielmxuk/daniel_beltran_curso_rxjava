/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: April 30, 2019
 */
package org.jacademy.tareas.session02;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: April 30, 2019
 */
public class ObservableBloqueante {
	
	public static void main(String... args) {
		
		List<String> mensajes = new ArrayList<>();
        mensajes.add("Esto");
        mensajes.add("es");
        mensajes.add("un");
        mensajes.add("ejemplo");
        
        Observable<String> observable = Observable.from(mensajes);
        
        Action1<String> hacerCuando = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("El contenido es: " + s);
            }
        };
        
        observable.toBlocking().forEach( hacerCuando::call );
        
        String primerElemento = observable.toBlocking().first();
        
        System.out.println( "\n\nEl primer elemento es: " + primerElemento );
	}
}
