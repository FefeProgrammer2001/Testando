using System;

public class Progrma
{
    public static void sorting(int[] array, int size)
    {
        int aux;
        for(int i = 0; i < size - 1; i++)
        {
            for(int j = 0; j < size - i - 1; j++)
            {
                if(array[j] > array[j + 1])
                {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
        Console.Write("Sorted array: ");
        for(int i = 0; i < size; i++)
        {
            Console.Write(array[i] + " ");
        }
    }

    public static void Main()
    {
        char option;
        do
        {
            int size;
            Console.Write("Type the array size: ");
            size = Convert.ToInt32(Console.ReadLine());
            int[] array = new int[size];
            Console.WriteLine("Type the array values:");
            for(int k = 0; k < size; k++)
            {
                Console.Write("Value " + (k + 1) + ": ");
                array[k] = Convert.ToInt32(Console.ReadLine());
            }
            sorting(array, size);
            Console.Write("\nType r to return, or e to exit: ");
            option = Convert.ToChar(Console.ReadLine());
        } while(option == 'r');
    }
}