using System;

public class Program
{
     public static void inverter(int[] vetor, int n)
     {
          Console.Write("\nVetor invertido: ");
          for(int i = n - 1; i >= 0; i--)
          {
               Console.Write(vetor[i] + " ");
          }
     }

     public static void Main()
     {
          int[] vetor = {1, 2, 3, 4, 5};
          int n = 5;
          Console.Write("Vetor original: ");
          for(int i = 0; i < n; i++)
          {
              Console.Write(vetor[i] + " ");
          }
          inverter(vetor, n);
     }
}
