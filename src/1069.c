#include <stdio.h>
#include <string.h>

int main(){
	int i, j, N, tamanho, cont, aux;
	char diamante[1000];

	scanf("%d", &N);

	for (i = 0; i < N; i++){
		scanf("%s", diamante);
		tamanho = strlen(diamante);
		cont = 0;
		aux = 0;

		for (j = 0; j < tamanho; j++){
			if(diamante[j] == '<'){
                aux++;
			}
			if (diamante[j] == '>' && aux > 0){
				cont++;
				aux--;
			}
		}
        printf("%d\n", cont);
	}

	return 0;
}
