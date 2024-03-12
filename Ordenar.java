import java.util.Scanner;

public class Ordenar
{
    
    public static void ordena(int[] vetor, int size)
    {
        int aux;
        for(int i = 0; i < size - 1; i++)
        {
            for(int j = 0; j < size - i - 1; j++)
            {
                if(vetor[j] > vetor[j + 1])
                {
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }
        System.out.print("Vetor ordenado: ");
        for(int i = 0; i < size; i++)
        {
            System.out.print(vetor[i] + " ");
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o tamanho do array: ");
        int n = scanner.nextInt();
        int array[] = new int[n];
        System.out.println("Digite os valores do array:");
        for(int k = 0; k < n; k++)
        {
            System.out.print("Índice ["+ k +"]: ");
            array[k] = scanner.nextInt();
        }
        ordena(array, n);
        
    }
}