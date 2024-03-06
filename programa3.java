import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.print("Escolha entre 1 para potência ou 2 para multiplicação: ");
            int escolha = scanner.nextInt();
            long a, b, resultado;
            switch (escolha) {
                case 1:
                    System.out.print("Digite o valor de A: ");
                    a = scanner.nextLong();
                    System.out.print("Digite o valor de B: ");
                    b = scanner.nextLong();
                    resultado = teste1(a, b);
                    System.out.println(a + " ^ " + b + " = " + resultado);
                    break;
                case 2:
                    System.out.print("Digite o valor de A: ");
                    a = scanner.nextLong();
                    System.out.print("Digite o valor de B: ");
                    b = scanner.nextLong();
                    resultado = teste2(a, b);
                    System.out.println(a + " * " + b + " = " + resultado);
                    break;
                default:
                    System.out.println("Opção inválida! Escolha novamente!");
                    continue;
            }
            String resposta;
            System.out.print("\nDeseja continuar? (s/n): ");
            resposta = scanner.next();
            if (!resposta.equals("s")) {
                continuar = false;
            }
        }
    }

    public static long teste1(long a, long b) {
        long[][] memoria = new long[(int) a + 1][(int) b + 1];
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if (j == 0) {
                    memoria[i][j] = 1;
                } else if (j == 1) {
                    memoria[i][j] = i;
                } else {
                    memoria[i][j] = i * memoria[i][j - 1];
                }
            }
        }
        return memoria[(int) a][(int) b];
    }

    public static long teste2(long a, long b) {
        long[][] memo = new long[(int) a + 1][(int) b + 1];
        for (int j = 0; j <= a; j++) {
            for (int k = 0; k <= b; k++) {
                if (k <= 0) {
                    memo[j][k] = 0;
                } else {
                    memo[j][k] = j + memo[j][k - 1];
                }
            }
        }
        return memo[(int) a][(int) b];
    }
}