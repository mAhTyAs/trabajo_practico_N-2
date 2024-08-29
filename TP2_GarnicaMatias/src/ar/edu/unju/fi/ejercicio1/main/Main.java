package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

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
				Iterator<Integer> iterator = lista.iterator();
				while (iterator.hasNext()) {
					int n = iterator.next();
					if (n % X == 0) {
						iterator.remove();
					}
				}
				
				break;
			case 'b':
				int max = Collections.max(lista);
				int maxIndex = lista.indexOf(max);
				lista.set(maxIndex, max * max);
				break;
			case 'c':
				//Si el resultado es muy grande no lo va a calcular o pondra un valor incorrecto
				for (int i = 0; i < lista.size(); i++) {
					int n = lista.get(i);
					if (n > 10) {
						lista.set(i, n + factorial(n));
					}
				}
				break;
			case 'd':
				Map<Integer, Long> frecuencia = new HashMap<>();
				for (Integer numero : lista) {
					if (frecuencia.containsKey(numero)) {
						frecuencia.put(numero, frecuencia.get(numero) + 1);
					} else {
						frecuencia.put(numero, 1L);
					}
				}
				Map.Entry<Integer, Long> menorFrecuencia = null;
				for (Map.Entry<Integer, Long> entry : frecuencia.entrySet()) {
					if (menorFrecuencia == null || entry.getValue() < menorFrecuencia.getValue()) {
						menorFrecuencia = entry;
					}
				}
				if (menorFrecuencia != null && menorFrecuencia.getValue() == 1) {
		            System.out.println("No hay números repetidos.");
		        } else if (menorFrecuencia != null) {
		            System.out.println("Número que se repite menos veces: " + menorFrecuencia.getKey());
		        } else {
		            System.out.println("La lista está vacía.");
		        }
		    
				break;
			case 'e':
				List<Integer> pares = new ArrayList<>();
				List<Integer> impares = new ArrayList<>();
				for (int n : lista) {
					if (n % 2 == 0) {
						pares.add(n);
					} else {
						impares.add(n);
					}
				}
				System.out.println("Pares: " + pares);
		        System.out.println("Impares: " + impares);
				break;
			case 'f':
				System.out.println("Lista final: " + lista);

			}

		}while(op!='g');

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
