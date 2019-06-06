/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jun 4, 2019
 */
package org.jacademy.tareas.codeChallengeOptionA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
        
        //Usando Observable simple: Observable<String> observable = Observable.from(mensajes);
        //Usando ConnectableObservable simple: ConnectableObservable<String> observable = ConnectableObservable.from(mensajes).publish();
        
        //Usando lectura desde el teclado
        ConnectableObservable<String> observable = ConnectableObservable.<String>create(s -> {
        		
        		while (!s.isUnsubscribed()){
        			String captura = leerDesdeTeclado();
        			if(captura.matches("Salir")) {
        				s.unsubscribe();
        			}else {
        				s.onNext(captura);
        			}
        		}
        	
        	}).publish();
        
        
        // Subscription subscriptionImprime
        observable.subscribe(
                s -> {
                	if (s.startsWith("Imprime ")) {
                		imprimeEnConsola(s, s.replaceAll("^Imprime ", ""));
                	}
                },
                t -> System.out.println("ERROR: " + t),
                () -> System.out.println("Esto se termino bien")
        );
        
        
        // Subscription subscriptionSuma 
        observable.subscribe(
                s -> {
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
        
        //Subscription subscriptionResta 
        observable.subscribe(
                s -> {
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
        
        //Subscription subscriptionMultiplica
        observable.subscribe(
                s -> {
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
        
     // Subscription subscriptionNoConozcoLaOpcion
        observable.subscribe(
                s -> {
                	if (!s.matches("(Imprime |Suma |Resta |Multiplica ).*")) {
                		imprimeEnConsola(s, "No conozco ese comando!");
                	}
                }
        );
        
        System.out.println("\n\nEmpezando. (NOTA: escribe  \"Salir\" para terminar la ejecucion)\n");
        
        observable.connect();
        
        System.out.println("\n\nTermino. \n");
    }
    
    private static void imprimeEnConsola(String entrada, String salida) {
    	
    	System.out.println("     -> Entrada: " + entrada);
        System.out.println("     -> Salida:  " + salida);
        System.out.println("\n-------------------------------------\n");
    }
    
    private static String leerDesdeTeclado() {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Escribe comando: ");
        String s = "";
        try{
        	s = br.readLine();
        }catch(IOException e){
            System.err.println("Hubo un problema!!!!");
        }
        return s;
    }
}
