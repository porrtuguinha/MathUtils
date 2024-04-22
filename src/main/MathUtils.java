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
	            System.out.println("4. calculo de erlang");
	            System.out.println("5. Sair");
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
	                   calcularErlangC();
	                    break;
	                case 5:
	                    System.out.println("Programa fechado");
	                    break;
	                default:
	                    System.out.println("Número inválido");
	                    break;
	            }
	        }
	        scanner.close();
	    }

// Autor: Gabriel Cerqueira Pires
    public static void calculaDerivada() {
    	Scanner scanner = new Scanner(System.in);

        System.out.println("Qual função você quer derivar?");
        System.out.println("1: Primeiro grau");
        System.out.println("2: Segundo grau");
        System.out.println("3: Terceiro grau");
        System.out.println("4: Seno");
        System.out.println("5: Cosseno");

        int entrada = scanner.nextInt();

        switch (entrada) {
            case 1:
                System.out.println("Coloque o parâmetro a:");
                double a = scanner.nextDouble();
                System.out.println("A derivada da função = " + a);
                break;
            case 2:
                System.out.println("Coloque o parâmetro a:");
                double a2 = scanner.nextDouble();
                System.out.println("Coloque o parâmetro b:");
                double b2 = scanner.nextDouble();
                System.out.println("Coloque o parâmetro c:");
                double c2 = scanner.nextDouble();
                double delta = (b2 * b2) - (4 * a2 * c2);
                if (delta >= 0) {
                    System.out.println("Coloque o ponto que você deseja a derivada:");
                    double xi = scanner.nextDouble();
                    double yi = (a2 * (xi * xi)) + (b2 * xi) + c2;
                    double x_i = xi - 0.01;
                    double y_i = (a2 * (x_i * x_i)) + (b2 * x_i) + c2;
                    double derivada = (yi - y_i) / (xi - x_i);
                    System.out.printf("A derivada é = %.2f%n", derivada);
                } else {
                    System.out.println("Coloque outros valores de a, b e c");
                }
                break;
            case 3:
                System.out.println("Coloque o parâmetro a:");
                double a3 = scanner.nextDouble();
                System.out.println("Coloque o parâmetro b:");
                double b3 = scanner.nextDouble();
                System.out.println("Coloque o parâmetro c:");
                double c3 = scanner.nextDouble();
                System.out.println("Coloque o parâmetro d:");
                double d3 = scanner.nextDouble();
                System.out.println("Coloque o ponto que você deseja a derivada:");
                double xi3 = scanner.nextDouble();
                double yi3 = (a3 * (xi3 * xi3 * xi3)) + (b3 * xi3 * xi3) + (c3 * xi3) + d3;
                double x_i3 = xi3 - 0.01;
                double y_i3 = (a3 * (x_i3 * x_i3 * x_i3)) + (b3 * x_i3 * x_i3) + (c3 * x_i3) + d3;
                double derivada3 = (yi3 - y_i3) / (xi3 - x_i3);
                System.out.printf("A derivada é = %.2f%n", derivada3);
                break;
            case 4:
                System.out.println("Coloque o ponto da função em graus:");
                double x4 = scanner.nextDouble();
                if (x4 == 90 || x4 == 270) {
                    System.out.println("O valor da derivada é = 0.0");
                } else {
                    double x_radians4 = Math.toRadians(x4);
                    double y4 = Math.cos(x_radians4);
                    System.out.println("O valor da derivada é = " + y4);
                }
                break;
            case 5:
                System.out.println("Coloque o ponto da função em graus:");
                double x5 = scanner.nextDouble();
                if (x5 == 0 || x5 == 360 || x5 == 180) {
                    System.out.println("O valor da derivada é = 0.0");
                } else {
                    double x_radians5 = Math.toRadians(x5);
                    double y5 = Math.sin(x_radians5) * (-1);
                    System.out.println("O valor da derivada é = " + y5);
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }

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
    
// Autor: Gabriel Cerqueira Pires
    public static void calculaIntegral() {
    	Scanner scanner = new Scanner(System.in);

        System.out.println("Qual função você quer integrar?");
        System.out.println("1: Primeiro grau");
        System.out.println("2: Segundo grau");
        System.out.println("3: Terceiro grau");
        System.out.println("4: Seno");
        System.out.println("5: Cosseno");

        int entrada = scanner.nextInt();

        switch (entrada) {
            case 1:
                System.out.println("Coloque o parâmetro a:");
                double a = scanner.nextDouble();
                System.out.println("Coloque o parâmetro b:");
                double b = scanner.nextDouble();
                System.out.println("Coloque o parâmetro b da integral:");
                double i_2 = scanner.nextDouble();
                System.out.println("Coloque o parâmetro a da integral:");
                double i = scanner.nextDouble();
                double f = i;
                double y = 0.0;
                double n = 0.0;
                while (i_2 > f) {
                    f = f + 0.000001;
                    y = y + (2 * ((a * f) + (b)));
                    n = n + 1;
                }
                double h = (i_2 - i) / (n);
                double integral_1 = ((h / 2) * (((a * i) + b) + y + ((a * i_2) + b)));
                System.out.printf("A integral da função = %.2f%n", integral_1);
                break;
            case 2:
                System.out.println("Coloque o parâmetro a:");
                double a2 = scanner.nextDouble();
                System.out.println("Coloque o parâmetro b:");
                double b2 = scanner.nextDouble();
                System.out.println("Coloque o parâmetro c:");
                double c2 = scanner.nextDouble();
                System.out.println("Coloque o parâmetro b da integral:");
                double i_22 = scanner.nextDouble();
                System.out.println("Coloque o parâmetro a da integral:");
                double i2 = scanner.nextDouble();
                double f2 = i2;
                double y2 = 0.0;
                double n2 = 0.0;
                while (i_22 > f2) {
                    f2 = f2 + 0.000001;
                    y2 = y2 + (2 * ((a2 * f2 * f2) + (b2 * f2) + c2));
                    n2 = n2 + 1;
                }
                double h2 = (i_22 - i2) / (n2);
                double integral_12 = ((h2 / 2) * (((a2 * i2 * i2) + (b2 * i2) + c2) + y2 + ((a2 * i_22 * i_22) + (b2 * i_22) + c2)));
                System.out.printf("A integral da função = %.2f%n", integral_12);
                break;
            case 3:
                System.out.println("Coloque o parâmetro a:");
                double a3 = scanner.nextDouble();
                System.out.println("Coloque o parâmetro b:");
                double b3 = scanner.nextDouble();
                System.out.println("Coloque o parâmetro c:");
                double c3 = scanner.nextDouble();
                System.out.println("Coloque o parâmetro d:");
                double d3 = scanner.nextDouble();
                System.out.println("Coloque o parâmetro b da integral:");
                double i_23 = scanner.nextDouble();
                System.out.println("Coloque o parâmetro a da integral:");
                double i3 = scanner.nextDouble();
                double f3 = i3;
                double y3 = 0.0;
                double n3 = 0.0;
                while (i_23 > f3) {
                    f3 = f3 + 0.000001;
                    y3 = y3 + (2 * ((a3 * f3 * f3 * f3) + (b3 * f3 * f3) + (c3 * f3) + d3));
                    n3 = n3 + 1;
                }
                double h3 = (i_23 - i3) / (n3);
                double integral_13 = ((h3 / 2) * (((a3 * i3 * i3 * i3) + (b3 * i3 * i3) + (c3 * i3) + d3) + y3 + ((a3 * i_23 * i_23 * i_23) + (b3 * i_23 * i_23) + (c3 * i_23) + d3)));
                System.out.printf("A integral da função = %.2f%n", integral_13);
                break;
            case 4:
                System.out.println("Coloque o ponto da função em graus:");
                double x4 = scanner.nextDouble();
                if (x4 == 90 || x4 == 270) {
                    System.out.println("O valor da integral é = 0.0");
                } else {
                    double x_radians4 = Math.toRadians(x4);
                    double y4 = Math.sin(x_radians4);
                    System.out.println("O valor da integral é = " + y4);
                }
                break;
            case 5:
                System.out.println("Coloque o ponto da função em graus:");
                double x5 = scanner.nextDouble();
                if (x5 == 0 || x5 == 360 || x5 == 180) {
                    System.out.println("O valor da integral é = 0.0");
                } else {
                    double x_radians5 = Math.toRadians(x5);
                    double y5 = Math.cos(x_radians5);
                    System.out.println("O valor da integral é = " + y5);
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }

        scanner.nextLine();
    }
    public static void calcularErlangC() {
    	 Scanner scanner = new Scanner(System.in);
    	    
    	   
    	    System.out.print("Digite o número de canais disponíveis: ");
    	    int numChannels = scanner.nextInt();
    	    
    	    
    	    System.out.print("Digite o tráfego em Erlang: ");
    	    double traffic = scanner.nextDouble();
    	    
    
    	    if (numChannels <= 0 || traffic < 0) {
                throw new IllegalArgumentException("O número de canais deve ser maior que zero e o tráfego não pode ser negativo.");
            }
            
            
            int maxIterations = 1000;
            
          
            double epsilon = 0.000001; 
            
           
            double prevC = 0.0;
            double currC = 0.0;
            double lambda = numChannels * traffic;
            
           
            for (int i = 0; i < maxIterations; i++) {
                double numerator = Math.pow(lambda, numChannels) / fatorial(numChannels);
                double denominator = 0.0;
                for (int n = 0; n < numChannels; n++) {
                    denominator += Math.pow(lambda, n) / fatorial(n);
                }
                denominator += numerator / (fatorial(numChannels) * (numChannels - lambda));
                currC = numerator / denominator;
                
               
                if (Math.abs(currC - prevC) < epsilon) {
                    break;
                }
                
                prevC = currC;
            }
            System.out.println("Número médio de canais necessários : " + currC);
            scanner.nextLine();
            
            
        }
        
       
        public static int fatorial(int n) {
            if (n == 0) {
                return 1;
            }
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        }
      
}
   