package fp.daw.examen;

import java.util.Scanner;

public class Ejercicio3Solucion2 {
	
	/* 3 puntos
	 * 
	 * Decimos que un número entero positivo es guay si puede obtenerse como suma de dos o más números
	 * enteros consecutivos. Por ejemplo, 3 (=1+2), 5 (=2+3), 6(=1+2+3), son números guays.
	 * 
	 * Escribir en el método main un programa que lea un número entero positivo e indique si éste es guay.
	 * 
	 * Esta solución amplia lo que se pide originalmente mostrando qué números son guays desde 0 hasta el
	 * número que introduzca el usuario.
	 * 
	 * También se optimiza algo el código en detrimento de la legibilidad, como suele ser habitual.
	 */
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		do {
			System.out.print("Número entero positivo: ");
			n = in.nextInt();
			if (n < 0)
				System.out.println("Número incorrecto, inténtalo de nuevo.");
		} while (n < 0);
		for (int i=0; i<=n; i++)
			esGuay(i);
		in.close();
	}
	
	static void esGuay(int n) {
		int i = 1, j = 0, n2 = n / 2;
		boolean esGuay = false;
		while (i <= n2 && !esGuay) {
			int suma = j = i;
			while (suma < n && !esGuay) {
				suma += ++j;
				if (suma == n)
					esGuay = true;
			}
			if (suma == n)
				esGuay = true;
			else
				i++;
		}
		System.out.print(String.valueOf(n));
		if (esGuay) {
			System.out.print(" = ");
			for (int k=i; k<=j; k++)
				System.out.print(k + (k < j ? " + " : ""));
		}
		else
			System.out.print(" no");
		System.out.println(" es guay");
	}

}
