package br.com.megasena.vnw;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Megasena {

	public static void main(String[] args) throws InterruptedException {
//		1 - MEGA-SENA EM JAVA
//
//		→ O usuário precisa escolher 7 números de 0 a 100. 
//
//		→ Precisa ser obrigatoriamente um numero inteiro. 
//        Caso o usuário digite outro tipo de dado, o programa não pode parar
//
//		→ Os números escolhidos terão de ser guardados em um vetor
//
//		→ Os 7 números vencedores terão de ser sorteado pela classe Random do java. 
//
//		→ Após o final, percorrer o vetor com as respostas e comparar com os 7 
//		números sorteados
//		→ Se o usuário acertar 5 números → Premio de 10 mil reais
//
//		→ Se o usuário acertar 6 números → Premio de 50 mil reais
//
//		→ Se o usuário acertar 7 números → Premio de 200 mil reais

		Scanner sc = new Scanner(System.in);
		Integer[] opt = new Integer[7];
		int[] numbers = new int[7];
		boolean isNumber = true;
		byte acertos = 0;

		Random rd = new Random();

		System.out.println("Bem Vindo a Mega Sena VNW - Patrocinada por Leno e Samuca!");
		TimeUnit.SECONDS.sleep(2);
		System.out.println("Escolha seus numeros da sorte:");
		System.out.println("Ah, lembre-se que são 7 numeros ao todo, entre 0 e 100!");

		while (isNumber) {
			try {
				for (int i = 0; i < numbers.length; i++) {
					System.out.println((i + 1) + "° numero:");
					numbers[i] = sc.nextInt();
					for (int j = 0; j < i; j++) {
						if (numbers[i] == numbers[j]) {
							System.out.println("Escolha um numero diferente do que você "
									+ "já escolheu!");
							System.out.println((i + 1) + "° numero:");
							numbers[i] = sc.nextInt();
							j= -1;
						}
					}
					if (numbers[i] > 100 || numbers[i] < 0) {
						System.out.println("Escolha um numero valido entre 0 e 100");
						i--;
					}
				}
				isNumber = false;
			} catch (InputMismatchException e) {
				System.out.println("Erro! Escolha apenas numeros (e INTEIROS)!");
				System.out.println("Estamos gerando uma nova cartela.");
				TimeUnit.SECONDS.sleep(3);
			}
			sc.nextLine();
		}

		System.out.println("Vamos começar o sorteio!");
		System.out.println("Os numeros da sorte são:");

		for (int i = 0; i < opt.length; i++) {
			TimeUnit.SECONDS.sleep(1);
			opt[i] = rd.nextInt(101);
			for (int j = 0; j < i; j++) {
				if (opt[i] == opt[j]) {
					opt[i] = rd.nextInt(101);
					j= -1;
				}
			}
			System.out.println(opt[i]);
		}

		System.out.println("Checando se você ganhou...");
		TimeUnit.SECONDS.sleep(2);

		List<Integer> checkResult = Arrays.asList(opt);
		// <diamond Tipagem>
		for (int i = 0; i < opt.length; i++) {
			TimeUnit.SECONDS.sleep(1);
			if (checkResult.contains(numbers[i])) {
				System.out.println("Você acertou o seu " + (i + 1) + "° número!");
				acertos++;
			} else {
				System.out.println("Você errou o seu " + (i + 1) + "° número!");
			}
		}
		switch (acertos) {
		case 5 -> System.out.println("Parabéns! Você acaba de ganhar 10 mil Reais!");
		case 6 -> System.out.println("Parabéns! Você acaba de ganhar 50 mil Reais!");
		case 7 -> System.out.println("Uau! Você acaba de ganhar o premio maximo "
				+ "de 200 mil Reais!");
		default -> System.out.println("Infelizmente você não leva nenhum premio hoje :(");
		}

		sc.close();
	}

}