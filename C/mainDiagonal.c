#include <stdio.h>
#define SIZE 3

int mainDiagonal(int m[SIZE][SIZE]) {
	int add = 0;
	for(int i = 0; i < SIZE; i++) {
		add += m[i][i];
	}
	return add;
}

int main() {
	int m[SIZE][SIZE];
	printf("Type the matrix values:\n");
	for(int i = 0; i < SIZE; i++) {
		for(int j = 0; j < SIZE; j++) {
			printf("Element [%d][%d]: ", i+1, j+1);
			scanf("%d", &m[i][j]);
		}
	}
	printf("\nMatrix values:");
	for(int i = 0; i < SIZE; i++) {
		printf("\n");
		for(int j = 0; j < SIZE; j++) {
			printf("%d ", m[i][j]);
		}
	}
	int result = mainDiagonal(m);
	printf("\n\nThe sum of the main diagonal is %d\n", result);
	return 0;
}
