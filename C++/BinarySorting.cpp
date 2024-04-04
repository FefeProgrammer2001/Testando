#include <iostream>
using namespace std;

class QuickSort {
public:
    static void quickSort(int arr[], int low, int high) {
        if(low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

private:
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int aux = arr[i+1];
        arr[i + 1] = arr[high];
        arr[high] = aux;

        return i + 1;
    }
};

class BinarySearch {
public:
    static int busca(int arr[], int n, int value) {
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(value == arr[mid])
                return mid;
            else if(value < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
};

int main() {
    int size;
    cout << "Type the array size: ";
    cin >> size;
    int array[size];
    cout << "Type the array values" << endl;
    for (int j = 0; j < size; j++) {
        cout << "Element " << (j + 1) << ": ";
        cin >> array[j];
    }
    QuickSort::quickSort(array, 0, size - 1);
    cout << "Sorted array: ";
    for (int i = 0; i < size; i++) {
        cout << array[i] << " ";
    }
    int value;
    cout << "\nEnter a value to search for in the array: ";
    cin >> value;
    int buscando = BinarySearch::busca(array, size, value);
    if (buscando == -1)
        cout << "The value was not found" << endl;
    else
        cout << "The value was found on index " << buscando << endl;
    return 0;
}
