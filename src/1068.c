#include <stdio.h>
#include <string.h>

int main(){
	int i, j, tamanho, cont, N = 10000, aux = 0;
	char expression[1000];

     while((scanf("%s", expression) != EOF)){
		tamanho = strlen(expression);
		cont = 0;
		aux = 0;

		for (j = 0; j <= tamanho; j++){
			if((expression[j] == '(')){
                cont++;
                aux++;
			}
			if((expression[j] == ')')){
				if(!cont == 0){
                    cont--;
                    aux++;
				}
				else{
                    cont++;
                    aux++;
				}
			}
		}
		if(cont == 0 && aux > 0){
            printf("correct\n");
		}
		else if(cont != 0 && aux > 0){
            printf("incorrect\n");
		}
	}

	return 0;
}
