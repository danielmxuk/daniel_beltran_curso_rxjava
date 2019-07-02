# RXjava

###Resumen
En mi opinion RXJava es es de gran utilidad en escenarios con la multitarea es un factor importante, o tareas donde se require el uso de hilos, o procesos que requiren estar al pendiente de reaccionar a ciertos eventos.

#### Functional Programming Performance:
 
- Ventajas de inmutabilidad: Permite trabajar en datos (objetos) sin tener que preocuparse de lo que otros procesos (paralelos) hagan con esos mismos datos.
 
- Ventajas de mutabilidad definida: Por lo que lei, es minimizar el impacto de los objetos mutables, restringiendo aquellas propiedades criticas.
 
- Porque usar paralelismo: principalmente para crear soluciones mas rapidas o mejorar los tiempos actuales de procesamiento; pero siempre se tiene que asegurar que la ganancia en performance/tiempos sea mayor al “costo” de ejecutar el codigo en paralelo.

