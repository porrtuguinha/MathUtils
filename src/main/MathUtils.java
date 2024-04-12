package main;

import java.util.Scanner;

import java.util.function.Function;

public class MathUtils {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int escolha = 0;
	        while (escolha != 4) {
	            System.out.println("Boas vindas ao MathUtils");
	            System.out.println("Selecione qual operação deseja realizar:");
	            System.out.println("1. Equação de segundo grau");
	            System.out.println("2. Cálculo de integral");
	            System.out.println("3. Cálculo de derivada");
	            System.out.println("4. Sair");
	                escolha = scanner.nextInt();
	              
	            switch (escolha) {
	                case 1:
	                    calculaEquacaoSegundoGrau();
	                    break;
	                case 2:
	                    calculaIntegral();
	                    break;
	                case 3:
	                    calculaDerivada();
	                    break;
	                case 4:
	                    System.out.println("Programa fechado");
	                    break;
	                default:
	                    System.out.println("Número inválido");
	                    break;
	            }
	        }
	        scanner.close();
	    }


    public static void calculaDerivada() {
        Scanner scanner = new Scanner(System.in);

        // Solicitar ao usuário que escolha a função
        System.out.println("Escolha a função para a qual deseja calcular a derivada:");
        System.out.println("1. Seno");
        System.out.println("2. Cosseno");
        System.out.println("3. Tangente");
        System.out.print("Digite o número correspondente à função: ");
        int escolha = scanner.nextInt();

        Function<Double, Double> f = null;
        String nomeFuncao = "";

        // Definir a função escolhida pelo usuário
        switch (escolha) {
            case 1:
                f = x -> Math.sin(x);
                nomeFuncao = "seno";
                break;
            case 2:
                f = x -> Math.cos(x);
                nomeFuncao = "cosseno";
                break;
            case 3:
                f = x -> Math.tan(x);
                nomeFuncao = "tangente";
                break;
            default:
                System.out.println("Escolha inválida. Saindo do programa.");
                scanner.close();
                return;
        }

        // Solicitar ao usuário o ponto onde deseja calcular a derivada
        System.out.print("Digite o ponto no qual deseja calcular a derivada: ");
        double x = scanner.nextDouble();

        // Precisão da diferenciação numérica (tamanho do h)
        double h = 0.0001;

        // Calculando a derivada usando a fórmula da diferenciação numérica (aproximação de derivada)
        double derivada = (f.apply(x + h) - f.apply(x)) / h;

        // Imprimindo o resultado
        System.out.println("O valor da derivada de " + nomeFuncao + "(x) em x = " + x + " é: " + derivada);

        scanner.nextLine();
    }

    public static void calculaEquacaoSegundoGrau() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os coeficientes da equação de segundo grau ax^2 + bx + c:");
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();
        System.out.print("c: ");
        double c = scanner.nextDouble();

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("As raízes da equação são: x1 = " + x1 + " e x2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("A equação possui uma raiz real: x = " + x);
        } else {
            System.out.println("A equação não possui raízes reais.");
        }

        scanner.nextLine();
    }

    public static void calculaIntegral() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os limites de integração (a e b) e o número de intervalos (n):");
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();
        System.out.print("n: ");
        int n = scanner.nextInt();

        Function<Double, Double> f = x -> x * x;

        double h = (b - a) / n;

        double area = 0;

        for (int i = 0; i < n; i++) {
            double x0 = a + i * h;
            double x1 = a + (i + 1) * h;
            area += (f.apply(x0) + f.apply(x1)) * h / 2;
        }

        System.out.println("O valor da integral definida é: " + area);

        scanner.nextLine();
    }
}