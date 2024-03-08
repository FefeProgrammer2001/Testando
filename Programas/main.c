#include <stdio.h>

int main() {
	int a = 10;
	int *b = &a;
	printf("A variavel %d esta no endereco %p\n", a, b);
	return 0;
}
