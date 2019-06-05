/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jun 4, 2019
 */
package org.jacademy.tareas.codeChallengeOptionA;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscription;
import rx.observables.ConnectableObservable;

/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jun 4, 2019
 */
public class TaskOptionA {
	
    public static void main(String... a) {
    	List<String> mensajes = new ArrayList<String>();
        mensajes.add("Imprime Saludo");
        mensajes.add("Suma 3 5");
        mensajes.add("Resta 3 5");
        mensajes.add("Resta 3");
        mensajes.add("Multiplica 3 5");
        mensajes.add("Otra cosa");
        
        //ConnectableObservable<String> observable = ConnectableObservable.from(mensajes).publish(); // connectableObservable
        ConnectableObservable<String> observable = ConnectableObservable.from(mensajes).publish(); // connectableObservable
        
        
        Subscription subscriptionImprime = observable.subscribe(
                s -> {
                   System.out.println("lll");
                },
                (t) -> System.out.println("ERROR: " + t),
                () -> System.out.println("Esto se termino bien")
        );
        
        if (!subscriptionImprime.isUnsubscribed()){
        	subscriptionImprime.unsubscribe();
            System.out.println("La subscripcion seguia");
        }
        
        /*
        Subscription subscriptionSuma = observable.subscribe(
                (s) -> {
                    if (s.startsWith("Suma ")) {
                    	String[] tempArray = s.split(" ");
                    	String salida = "Parametros invalidos";
                    	
                    	if(tempArray.length == 3
                    			&& tempArray[1].matches("\\d+")
                    			 && tempArray[2].matches("\\d+") ) {
                    		int num1 = Integer.parseInt(tempArray[1]);
                    		int num2 = Integer.parseInt(tempArray[2]);
                    		int resulta = num1 + num2;
                    		salida = "" + resulta;
                    	}
                    	
                    	imprimeEnConsola(s, salida);
                    }
                }
        );
        
        Subscription subscriptionResta = observable.subscribe(
                (s) -> {
                    if (s.startsWith("Resta ")) {
                    	String[] tempArray = s.split(" ");
                    	String salida = "Parametros invalidos";
                    	
                    	if(tempArray.length == 3
                    			&& tempArray[1].matches("\\d+")
                    			 && tempArray[2].matches("\\d+") ) {
                    		int num1 = Integer.parseInt(tempArray[1]);
                    		int num2 = Integer.parseInt(tempArray[2]);
                    		int resulta = num1 - num2;
                    		salida = "" + resulta;
                    	}
                    	
                    	imprimeEnConsola(s, salida);
                    }
                }
        );
        
        Subscription subscriptionMultiplica = observable.subscribe(
                (s) -> {
                    if (s.startsWith("Multiplica ")) {
                    	String[] tempArray = s.split(" ");
                    	String salida = "Parametros invalidos";
                    	
                    	if(tempArray.length == 3
                    			&& tempArray[1].matches("\\d+")
                    			 && tempArray[2].matches("\\d+") ) {
                    		int num1 = Integer.parseInt(tempArray[1]);
                    		int num2 = Integer.parseInt(tempArray[2]);
                    		int resulta = num1 * num2;
                    		salida = "" + resulta;
                    	}
                    	
                    	imprimeEnConsola(s, salida);
                    }
                }
        );
        */
        System.out.println("\n\nEmpezando. \n");
        
        //observable.connect();
        
        System.out.println("\n\nTermino. \n");
    }
    
    private static void imprimeEnConsola(String entrada, String salida) {
    	
    	System.out.println("Entrada: " + entrada);
        System.out.println("Salida:  " + salida);
        System.out.println("\n-------------------------------------\n");
    }
}
