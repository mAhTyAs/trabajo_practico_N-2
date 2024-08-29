package ar.edu.unju.fi.ejercicio1.main.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Integer> lista = new ArrayList<>();
		Random rand = new Random();
		int N = 10;
		while (lista.size() < N) {
			int num = rand.nextInt(101);
			if (!lista.contains(num)) {
				lista.add(num);
			}
		}
		char op;
		System.out.println("Lista original: " + lista);
		do {

			mostrarMenu();
			op = sc.nextLine().charAt(0);
			switch (op) {
			case 'a':
				System.out.print("Ingrese valor de X: ");
				int X = sc.nextInt();
				sc.nextLine();
				lista.removeIf(n -> n % X == 0);

				break;
			case 'b':
				lista.replaceAll(n -> n.equals(Collections.max(lista)) ? n * n : n);
				break;
			case 'c':
				//Si el resultado es muy grande no lo va a calcular o pondra un valor incorrecto
				lista.replaceAll(n -> n > 10 ? n + factorial(n) : n);
				break;
			case 'd':
				Map<Integer, Long> frecuencia = lista.stream()
						.collect(Collectors.groupingBy(n -> n, Collectors.counting()));

				Optional<Map.Entry<Integer, Long>> menorFrecuencia = frecuencia.entrySet().stream()
						.min(Map.Entry.comparingByValue());

				if (menorFrecuencia.isPresent() && menorFrecuencia.get().getValue() == 1) {
					System.out.println("No hay números repetidos.");
				} else {
					System.out.println("Número que se repite menos veces: " + menorFrecuencia.get().getKey());
				}
				break;
			case 'e':
				List<Integer> pares = lista.stream()
				        .filter(n -> n % 2 == 0)
				        .collect(Collectors.toList());
				List<Integer> impares = lista.stream()
						.filter(n -> n % 2 != 0)
						.collect(Collectors.toList());
				System.out.println("Pares: " + pares);
				System.out.println("Impares: " + impares);
				break;
			case 'f':
				System.out.println("Lista final: " + lista);

			}

		} while (op != 'g');

	}

	private static void mostrarMenu() {
		System.out.println("a) Eliminar múltiplos de X.");
		System.out.println("b) Elevar el numero mayor al cuadrado.");
		System.out.println("c) A todos los valores mayores a 10 sumarle su factorial.");
		System.out.println("d) Encontrar número que se repite menos veces.");
		System.out.println("e) Particionar la lista en pares e impares.");
		System.out.println("f) Mostrar la collection.");
		System.out.println("g) Salir.");
		System.out.println("Ingrese opcion: ");
	}

	private static int factorial(int n) {
		int resultado = 1;
		for (int i = 2; i <= n; i++) {
			resultado *= i;
		}
		return resultado;
	}

}
