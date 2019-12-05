package fp.daw.examen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2 {

	/*
	 * 3 puntos
	 * 
	 * Escribir en el método main un programa que lea del teclado dos números enteros y calcule
	 * la suma de todos los números impares comprendidos entre ellos, ambos incluidos.
	 * 
	 * El programa deberá calcular el resultado sin importar el orden en que se introduzcan los dos números
	 * (primero el mayor o primero el menor).
	 * 
	 * Si es posible, minimizar el número de iteraciones que se ejecutarán para obener el resultado.
	 * 
	 * No se permite el uso de la clase Scanner para leer del teclado.
	 * 
	 * Sólo se permite el uso de recursos del lenguaje Java vistos en las unidades 2 y 3.
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Escribe un número: ");
		int n1 = Integer.parseInt(in.readLine());
		System.out.print("Escribe otro número: ");
		int n2 = Integer.parseInt(in.readLine());
		if (n1 > n2) {
			int aux = n1;
			n1 = n2;
			n2 = aux;
		}
		if (n1 % 2 == 0)
			n1++;
		int suma = 0;
		for (int i=n1; i<=n2; i+=2)
			suma = suma + i;
		System.out.println("Suma: " + suma);
	}

}
