package fp.daw.examen;

import java.util.Scanner;

public class Ejercicio1 {

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
		int divisor = 1000;
		do {
			int digito = n / divisor;
			if (digito > 0) {
				char c1, c2, c3;
				switch (divisor) {
				case 1000:
					c1 = 'M';
					c2 = ' ';
					c3 = ' ';
					break;
				case 100:
					c1 = 'C';
					c2 = 'D';
					c3 = 'M';
					break;
				case 10:
					c1 = 'X';
					c2 = 'L';
					c3 = 'C';
					break;
				default:
					c1 = 'I';
					c2 = 'V';
					c3 = 'X';
				}
				if (digito < 4)
					for (int i = 0; i < digito; i++)
						System.out.print(c1);
				else if (digito == 4)
					System.out.printf("%c%c", c1, c2);
				else if (digito < 9) {
					System.out.print(c2);
					for (int i = 0; i < digito - 5; i++)
						System.out.print(c1);
				} else
					System.out.printf("%c%c", c1, c3);
			}
			n %= divisor;
			if (n > 0)
				divisor = divisor / 10;
		} while (n > 0);
		in.close();
	}

}
