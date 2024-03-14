import java.util.Scanner;

public class Sorting
{
    public static void arrays(int arr[], int size)
    {
        int aux;
        for(int i = 0; i < size - 1; i++)
        {
            for(int j = 0; j < size - i - 1; j++)
            {
                if(arr[j] > arr[j + 1])
                {
                    aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
        System.out.print("Sorted array: ");
        for(int i = 0; i < size; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type the array size: ");
        int size = scanner.nextInt();
        int array[] = new int[size];
        System.out.println("Type the array values:");
        for(int j = 0; j < size; j++)
        {
            System.out.print("Value " + (j + 1) + ": ");
            array[j] = scanner.nextInt();
        }
        arrays(array, size);
    }
}