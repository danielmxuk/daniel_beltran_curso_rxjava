/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jun 4, 2019
 */
package org.jacademy.tareas.session05.codeChallengeOptionA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import rx.Observable;

import rx.observables.ConnectableObservable;

/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jun 4, 2019
 */
public class TaskOptionAFancy {
	
	private static final String REGEX_EXP_DIGIT = "-{0,1}\\d+";
	
    public static void main(String... a) {
    	
    	//TODO: implementar .onError* en los stream
    	
    	//TODO: se podra hacer un una funcion que reciba un stream y regrese un stream ya filtrado y mapeado?
    	
    	
        //Usando lectura desde el teclado
        ConnectableObservable<String> observable = ConnectableObservable.<String>create(s -> {
        		
        		while (!s.isUnsubscribed()){
        			String captura = leerDesdeTeclado();
        			if(captura.matches("Adios")) {
        				s.unsubscribe();
        			}else {
        				s.onNext(captura);
        			}
        		}
        	
        	}).publish();
        
        
        // IMPRIME MENSAJE
        observable.filter( s -> s.startsWith("Imprime ")).subscribe( s -> imprimeEnConsola(s.replaceAll("^Imprime ", "")) );
        
        // SUMA | RESTA | MULTIPLICA
        observable.filter( s -> s.matches("(Suma |Resta |Multiplica ).*") )
					.map( s -> s.split(" ") )
					.filter( s -> s.length == 3 && s[1].matches(REGEX_EXP_DIGIT) && s[2].matches(REGEX_EXP_DIGIT) )
					.subscribe( s -> imprimeEnConsola("" + realizaOperacion(s) ) );
        
        // HORA 12 | 24
        observable.filter( s -> s.startsWith("Hora ") )
					.map( s -> s.split(" ") )
					.filter( s -> s.length == 2 && s[1].matches("12|24") )
					.subscribe( s -> imprimeEnConsola( LocalTime.now().format( s[1].matches("24") ? DateTimeFormatter.ofPattern("HH:mm") : DateTimeFormatter.ofPattern("hh:mm") ) ) );
        
        // FECHA
        observable.filter( s -> s.startsWith("Fecha") ).subscribe( s -> imprimeEnConsola( LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))) ) ;
        
        // Cuando no conoce la opcion!
        observable.filter(s -> !s.matches("(Imprime |Suma |Resta |Multiplica |Hora |Fecha).*") ).subscribe( s -> imprimeEnConsola("No conozco ese comando!") );
        
        
        System.out.println("\n\nEmpezando. (NOTA: escribe  \"Adios\" para terminar la ejecucion)\n");
        
        observable.connect();
        
        System.out.println("\n\nBye!, que te vaya bien :) \n");
    }
    
    private static void imprimeEnConsola(String salida) {
    	
        Observable<String> observable = Observable.just(salida);
        
        observable.subscribe(s -> {
        	System.out.println("     -> Salida:  " + s);
            System.out.println("\n-------------------------------------\n");
        });
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
    
    private static int realizaOperacion(String[] comando) {
    	int num1 = Integer.parseInt(comando[1]);
		int num2 = Integer.parseInt(comando[2]);
		if(comando[0].equals("Suma")) {
			return num1 + num2;
		}else if(comando[0].equals("Resta")) {
			return num1 - num2;
		}else if(comando[0].equals("Multiplica")) {
			return num1 * num2;
		}else {
			return 0;
		}
    }
}
