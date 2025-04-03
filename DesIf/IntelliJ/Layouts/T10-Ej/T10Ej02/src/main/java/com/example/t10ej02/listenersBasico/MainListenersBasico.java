package com.example.t10ej02.listenersBasico;
	
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class MainListenersBasico{
	public static void main(String[] args) {
IntegerProperty age = new SimpleIntegerProperty();
		
		// Definimos listener
		age.addListener((Observable observable) -> {
			// Si se accede a la variable observable entonces se llama siempre
			System.out.println("Cambio de propiedad");
		});
		
		// Cambiamos el valor varias veces seguidas pero solo notifica una
		// CUIDADO. Si desde el listener se accede a observable s� que se notifica
		// Se a�ade un println antes de cada get o set para facilitar las pruebas y ver cuando se llama a los listeners
		System.out.println(100);
		age.set(100);
		System.out.println(101);
		age.set(101);
		System.out.println(102);
		age.set(102);
		
		// Sin embargo, si preguntamos por la propiedad s� que se notifica
		System.out.println(100);
		age.set(100);

		System.out.println("get");
		age.get(); 
		System.out.println(100);
		age.set(101);

		System.out.println("get");
		age.get();
		System.out.println(102);
		age.set(102);
		
		age.addListener((observable, oldValue, newValue) -> {
			System.out.print("Propiedad cambiada: ");
	        System.out.println("old = " + oldValue + ", new = " + newValue);
		});
				
		// Prueba de notificaci�n de ChangeListener
		System.out.println(101);
		age.set(101);
		System.out.println(102);
		age.set(102);
        
		System.out.println(103);
        age.setValue(103);
        System.out.println(104);        
        age.setValue(104);
    }
}
