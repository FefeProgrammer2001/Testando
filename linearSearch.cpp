#include <iostream>
using namespace std;

int linearSearch(int array[], int size, int value) {
    for(int i = 0; i < value; i++)
    {
        if(array[i] == value) {
            return i;
        }
    }
    return -1;
}

int main() {
    int size;
    cout << "Type the array size: ";
    cin >> size;
    int *array = new int[size];
    cout << "Type the array values:\n";
    for(int l = 0; l < size; l++) {
        cin >> array[l];
    }
    int value;
    cout << "Type a value to be search: ";
    cin >> value;
    int program = linearSearch(array, size, value);
    if(program == -1) {
        cout << "The value was not founded";
    } else {
        cout << "The value was founded in index " << program;
    }
    return 0;
}