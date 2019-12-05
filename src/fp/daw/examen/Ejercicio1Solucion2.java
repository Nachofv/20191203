package fp.daw.examen;

import java.util.Scanner;

public class Ejercicio1Solucion2 {

	/*
	 * 4 puntos
	 * 
	 * Escribir en el método main un programa que pida por teclado un número decimal
	 * menor o igual que 3000 y muestre por pantalla el resultado de convertirlo a
	 * un número romanos.
	 * 
	 * La conversión se realizará transformando individualmente cada dígito,
	 * empezando por el correspondiente a las unidades de millar, seguido de las
	 * centenas, decenas y unidades de la forma siguiente:
	 * 
	 * Dígito decimal | Transformación
	 * --------------------|--------------------------------------------------------
	 * -------------------- 1, 2 o 3 | Escribir C1 de una a tres veces 4 | Escribir
	 * C1 seguido de C2 5, 6, 7 o 8 | Escribir una vez C2 seguido de C1 de cero a
	 * tres veces 9 | Escribir C1 seguido de C3
	 * 
	 * donde C1, C2 y C3 son los caracteres de numeración romana que corresponda
	 * según la tabla siguiente:
	 * 
	 * | C1 | C2 | C3 | --------------------|--------|--------|--------| unidades |
	 * I | V | X | decenas | X | L | C | centenas | C | D | M | unidades de millar |
	 * M | | |
	 * 
	 * Sólo se permite el uso de recursos del lenguaje Java vistos en las unidades 2
	 * y 3.
	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		do {
			System.out.print("Número entero entre 1 y 3000: ");
			n = in.nextInt();
			if (n <= 0 || n > 3000)
				System.out.println("Número incorrecto, inténtalo de nuevo.");
		} while (n <= 0 || n > 3000);
		int digito;
		int divisor = 1000;
		do {
			if ((digito = n / divisor) > 0)
				convertirDigito(digito, divisor);
			if ((n %= divisor) > 0)
				divisor /= 10;
		} while (n > 0);
		in.close();
	}

	static void convertirDigito(int digito, int peso) {
		if (digito < 4)
			for (int i = 0; i < digito; i++)
				System.out.print(getC1(peso));
		else if (digito == 4)
			System.out.print(getC1(peso) + getC2(peso));
		else if (digito < 9) {
			System.out.print(getC2(peso));
			for (int i = 0; i < digito - 5; i++)
				System.out.print(getC1(peso));
		} else
			System.out.printf(getC1(peso) + getC3(peso));
	}

	static String getC1(int peso) {
		return peso == 1000 ? "M" : peso == 100 ? "C" : peso == 10 ? "X" : "I";
	}

	static String getC2(int peso) {
		return peso == 100 ? "D" : peso == 10 ? "L" : "V";
	}

	static String getC3(int peso) {
		return peso == 100 ? "M" : peso == 10 ? "C" : "X";
	}

}
