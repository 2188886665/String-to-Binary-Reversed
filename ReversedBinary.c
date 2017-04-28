#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() 
{
	FILE *fp;
	char buffer[1024];

	fp = fopen("/home/sha/Documents/test.txt", "r");
	fscanf(fp, "%s", buffer);
	//printf("%s\n", buffer);

	char* stringToBinary(char* s) {
		if(s == NULL) return 0;

		int len = strlen(s), i;
		char *binary = malloc(len*8 + 1);
		int j; 
	
		binary[0] = '\0';

		for(i = len-1; i >= 0; i--) {
			char ch = s[i];
			for(j = 7; j >= 0; --j){
				if(ch & (1 << j)) {
                			strcat(binary,"1");
            			} else {
                			strcat(binary,"0");
            			}
        		}
			strcat(binary, " ");
		}
		strcat(binary, "\n");
		return binary;
	}
	//printf(stringToBinary(buffer));
	
	fp = fopen("/home/sha/Documents/result.bin", "wb");
	fprintf(fp, stringToBinary(buffer));
	fclose(fp);
}

