#include <stdio.h>
#include <unistd.h>
#include <pthread.h>

char band[10] = {'*','*','*','1','2','1','1','*','*','*'};
char state = 'i';

int main() {
    char states[2] = {'i','1','2'};
    char move[3] = {'<','-','>'};

    int start = 4;

    turing1(start - 1);

    printf("\n Estado: ");
    printf("%c",state);
    printf("\n");
    printf("Fin del Programa\n");
    return 0;
}

void clearScreen(){
  const char *CLEAR_SCREEN_ANSI = "\e[1;1H\e[2J";
  write(STDOUT_FILENO, CLEAR_SCREEN_ANSI, 12);
}

void printBand(void){
    for(int i = 0; i < sizeof(band); i++){
        printf("--");
    }
    printf("-\n");
    for(int i = 0; i < sizeof(band); i++){
        printf("|");
        printf("%c",band[i]);
    }
    printf("|\n");
    for(int i = 0; i < sizeof(band); i++){
        printf("--");
    }
    printf("-\n");
}

void printArrow(int n){
    for(int i = 0; i < n;i++){
        printf("  ");
    }
    printf(" ");
    printf("%c",state);
    printf("\n");
    for(int i = 0; i < n;i++){
        printf("  ");
    }
    printf(" ⌄\n");
}

void turing1(int n){
    char end = 0;
    int cont = 0;
    while(!end){
        printInfo(cont, n);
        cont++;
        if(band[n] == '*' && state == 'i'){
            n++;
            printInfo(cont,n);
        }
        else if(band[n] == '*' && (state == '1' || state == '2')){
            printInfo(cont,n);
            end = 1;
            state = '2';
        }
        else if(band[n] == '1'){
            //mover a la derecha >
            n++;
            printInfo(cont,n);
            state = '1';
        }
        else if(band[n] == '2'){
            //mover a la derecha >
            n--;
            printInfo(cont,n);
            state = '2';
        }
    }
    printInfo(cont,n);
}

void printInfo(int cont, int n){
    clearScreen();
    printf("Paso ");
    printf("%d",cont);
    printf("\n Estado: ");
    printf("%c",state);
    printf("\n");
    printArrow(n);
    printBand();
    sleep(1);
}