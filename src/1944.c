#include <stdio.h>

char v[99999] = { 'F', 'A', 'C', 'E' };

int main(){
	int N, i, p = 0, c = 4;
	char L1[2], L2[2], L3[2], L4[2];
    scanf("%d", &N);
	while(N != 0){
		scanf("%s %s %s %s", L1, L2, L3, L4);
		if (L1[0] == v[c-1] && L2[0] == v[c-2] && L3[0] == v[c-3] && L4[0] == v[c-4]){
			c -= 4;
			if (c == 0)
				v[0] = 'F', v[1] = 'A', v[2] = 'C', v[3] = 'E', c = 4;
			p++;
		}
		else {
			v[c] = L1[0], c++, v[c] = L2[0], c++, v[c] = L3[0], c++, v[c] = L4[0], c++;
		}
		N--;
	}
	printf("%d\n", p);

	return 0;
}
