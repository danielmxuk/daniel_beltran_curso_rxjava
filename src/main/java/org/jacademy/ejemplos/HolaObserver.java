package org.jacademy.ejemplos;

import rx.Observable;
import rx.Observer;

import java.util.ArrayList;
import java.util.List;

public class HolaObserver {
    // OORP Object Oriented Reactive Programming
    public static void main(String... args) {
        List<String> mensajes = new ArrayList<String>();
        mensajes.add("Hola");
        mensajes.add("Mundo");
        mensajes.add("!!!");

        Observer<String> observador = new Observer<String>() {
            public void onCompleted() {
                System.out.println("Terminado!\n");
            }

            public void onError(Throwable throwable) {
                System.out.println("Terminado! con Error :( " + throwable.getMessage() + "\n");
            }

            public void onNext(String s) {
                System.out.println(s);
            }
        };

        Observable<String> observableMensajes = Observable.from(mensajes);
        observableMensajes.subscribe(observador);
        
        System.out.println("--------------------------------");
        
        Observable<String> observableMensaje = Observable.just("Hello World!");
        observableMensaje.subscribe(observador);
        
        System.out.println("--------------EMPTY------------------");
        
        Observable<String> observableVacio = Observable.empty();
        observableVacio.subscribe(observador);
        
        System.out.println("--------------NEVER------------------");
        
        Observable<String> observableNunca = Observable.never();
        observableNunca.subscribe(observador);
        
        System.out.println("--------------ERROR------------------");
        
        Observable<String> observableError = Observable.error(new Throwable("Errorsisismo..."));
        observableError.subscribe(observador);
    }

}
