#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {

	int n = 0;
	int box = 0;
	scanf("%d", &n);
	
	while (1) {
		if (n % 5 == 0) {
			box += n / 5;
			printf("%d\n", box);
			break;
		}

		n = n - 3;
		box++;

		if (n < 0) {
			printf("-1\n");
			break;
		}
	}

	return 0;

}