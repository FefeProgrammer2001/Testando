#include <iostream>
#include <fstream>
using namespace std;

#define TAMANHO 100

int main() {
    char vetor[TAMANHO];

    cout << "Digite os caracteres do vetor: ";
    cin.getline(vetor, TAMANHO);

    ofstream arquivo("teste.txt");
    if(arquivo.is_open()) {
        arquivo << vetor;
        arquivo.close();

        cout << "Os caracteres foram salvos.\n";
    } else {
        cerr << "Erro ao abrir o arquivo.\n";
    }
    return 0;
}
