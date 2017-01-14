#include <stdio.h>

main(){
    int i, j, N, M, aux;

    scanf("%d", &N); //Test case
    do{
        scanf("%d", &M); //Number of students
        int P[M]; //Vector of P of students
        int a[M];
        P[0] = 0;

        for(i = 1; i <= M; i++){//Reading P of students
            scanf("%d", &P[i]);
        }
        for(i = 1; i <= M; i++){//Copying for comparison
            a[i] = P[i];
        }

        for(i = 1; i <= M; i++){
            for(j = (i+1); j <= M; j++){
                aux = 0;
                if (P[i] < P[j])
                {
                    aux = P[i];
                    P[i] = P[j];
                    P[j] = aux;
                }
            }
        }
        for(i = 1; i <= M; i++){
            if(a[i] != P[i]){
                P[0] += 1;
            }
        }
        P[0] = (M - P[0]);
        printf("%d\n", P[0]);
        N--;
    }while(N != 0);
}
