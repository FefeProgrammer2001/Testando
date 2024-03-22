import java.util.Scanner;

public class Hadix
{
    public static void hadixSort(int array[], int size)
    {
        int gap = size/2;

        while(gap > 0)
        {
            for(int i = gap; i < size; i++)
            {
                int temp = array[i];
                int j = i;

                while(j >= gap && array[j - gap] > temp)
                {
                    int temp2 = array[j];
                    array[j] = array[j - gap];
                    array[j - gap] = temp2;

                    j -= gap;
                }
                array[j] = temp;
            }
            gap /= 2;
        }
        System.out.print("Sorted array: ");
        for(int i = 0; i < size; i++)
        {
            System.out.printf("%d ", array[i]);
        }
    }
    
    public static int search(int array[], int size, int value)
    {
		int ini = 0;
		int end = size - 1;
		while(ini <= end)
		{
			int middle = (ini + end) / 2;
			if(value == array[middle])
			{
				return middle;
			} else if(value < array[middle])
			{
				end = middle - 1;
			} else
			{
				ini = middle + 1;
			}
		}
		return -1;
	}

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type the array size: ");
        int size = scanner.nextInt();
        int array[] = new int[size];
        System.out.println("Type the array values:");
        for(int i = 0; i < size; i++)
        {
			System.out.printf("Element %d: ", i+1);
			array[i] = scanner.nextInt();
		}
		hadixSort(array, size);
		System.out.print("\nType a value to be search: ");
		int value = scanner.nextInt();
		int test = search(array, size, value);
		if(test == -1)
		{
			System.out.print("The value was not found\n");
		} else
		{
			System.out.printf("The value was found on index %d\n", test);
		}
    }
}
