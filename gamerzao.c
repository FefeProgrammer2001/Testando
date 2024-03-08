#include <stdio.h>

void inverterVetor(int vetor[], int tamanho) {
        printf("Vetor invertido: ");
        for(int i = tamanho - 1; i >= 0; i--) {
                printf("%d ", vetor[i]);
        }
        printf("\n");
}

int main() {
        int vetor[] = {1, 2, 3, 4, 5, 6};
        int size = 6;
        inverterVetor(vetor, size);
        return 0;
}
