package org.jacademy.ejemplos;

import rx.Observable;
import rx.Subscriber;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HolaCreador {

    public static void main(String ... args) {

                                                            // Handler, listener
        Observable<String> observable = Observable.create( new Observable.OnSubscribe<String>() {
            @Override  // on subscribe
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Uno");
                subscriber.onNext("Dos");
                subscriber.onNext("Tres");
                System.out.println("Completado?");
//                subscriber.onError(new Throwable("Observable ERROR"));
                subscriber.onCompleted();
            }
        }); //Cache

        observable.subscribe((s) -> {
            System.out.println(s);
        }, (t)-> {
            System.out.println("Auxilio!");
        });

        observable.subscribe(
                (s)->{System.out.println("Subscripcion 2: " + s);}
                );
//
        //////////////////
        Observable<Integer> observableI = Observable.create((s)->{
            s.onNext(5);
            s.onNext(8);
            s.onNext(10);
            s.onNext(13);
            s.onCompleted();
        });

        Subscriber<Integer> romano = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("TRADUCCION COMPLETADA...");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("TRADUCCION INTERRUMPIDA..." + throwable.getMessage());
            }

            @Override // Called by observable created
            public void onNext(Integer i) {
                switch (i){
                    case 5: System.out.println("V");
                            break;

                    case 8: System.out.println("VIII");
                        break;

                    default: System.out.println("X");
                             this.unsubscribe();
                             break;
                }
            }
        };
//
        observableI.subscribe(romano);
        //////////////////////////
        List<String> mensaje = new ArrayList<String>();
        mensaje.add("Hola");
        mensaje.add("Mundo");
        mensaje.add("!!!");

        Observable<String> observableS = Observable.create((s) ->
        {
           for(String msj : mensaje) {
               if(!s.isUnsubscribed()) {
                   s.onNext(msj);
                   if(msj.equals("Hola"))
                       s.onNext("Hi");
                   if(msj.equals("Mundo")) {
                       s.onNext("World");
                       s.unsubscribe();
                   }
               }
           }
           s.onCompleted();
        });

        observableS.subscribe(System.out::println);
    }

}
