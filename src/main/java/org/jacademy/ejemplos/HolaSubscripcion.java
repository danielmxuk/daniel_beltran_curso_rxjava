package org.jacademy.ejemplos;

import rx.Observable;
import rx.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HolaSubscripcion {

    public static void main(String... a) throws InterruptedException {
        List<String> mensajes = new ArrayList<String>();
        mensajes.add("Hola");
        mensajes.add("Mundo");
        mensajes.add("!!!");

        System.out.println("\n\nEmpezando. \n");
        
        Observable<String> observable = Observable.from(mensajes);

        observable.subscribe(System.out::println);

        Subscription subscription = observable.subscribe(
                (s) -> {
                    if (s.equals("Hola")) {
                        System.out.println("hi");
                    } else if (s.equals("Mundo")) {
                        System.out.println("World");
                    } else System.out.print(s);
                },
                (t) -> System.out.println("ERROR"),
                () -> System.out.println("Esto se termino")
        );

        if (subscription.isUnsubscribed()){
            subscription.unsubscribe();
            System.out.println("La subscripcion seguia");
        }

        // Warn Streams
        //Observable<Long> observable2 = Observable.timer(1, TimeUnit.SECONDS);
        //observable2.subscribe(System.out::println);
        //Thread.sleep(2000);
        
        
        // Warn Streams
        //Observable<Long> observable3 = Observable.interval(300, TimeUnit.MILLISECONDS).take(10);
        //observable3.subscribe(System.out::println);
        //Thread.sleep(3000);
        
        System.out.println("\n\nTermino. \n");
    }

}
