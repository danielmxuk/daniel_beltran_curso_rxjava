package org.jacademy.ejemplos;

import rx.Observable;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class HolaSubscriptor {

    public static void main(String ... args){
        List<String> mensajes = new ArrayList<String>();
        mensajes.add("Hola");
        mensajes.add("Mundo");
        mensajes.add("!!!");

        Subscriber<String> subscriptor = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("That's all folks!");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error:" + throwable.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
                if(s.equals("Mundo")){
                    this.unsubscribe();
                }
            }
        };

        Observable<String> observable = Observable.from(mensajes);
        observable.subscribe(subscriptor);
    }
}
